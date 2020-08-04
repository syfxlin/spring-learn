package me.ixk.json_inject.injector;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import me.ixk.json_inject.annotation.JsonParam;
import me.ixk.json_inject.annotation.RequestJson;
import me.ixk.json_inject.utils.Helper;
import me.ixk.json_inject.utils.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class JsonArgumentResolver implements HandlerMethodArgumentResolver {
  private static final String JSON_REQUEST_ATTRIBUTE_NAME = "JSON_REQUEST_BODY";

  @Override
  public boolean supportsParameter(final MethodParameter methodParameter) {
    return (
      methodParameter.hasParameterAnnotation(JsonParam.class) ||
      methodParameter.hasMethodAnnotation(RequestJson.class)
    );
  }

  @Override
  public Object resolveArgument(
    final MethodParameter methodParameter,
    final ModelAndViewContainer modelAndViewContainer,
    final NativeWebRequest nativeWebRequest,
    final WebDataBinderFactory webDataBinderFactory
  )
    throws Exception {
    final JsonNode body = this.getJsonBody(nativeWebRequest);
    if ("$body".equals(methodParameter.getParameterName())) {
      return JSON.convertToObject(body, methodParameter.getParameterType());
    }
    final JsonParam jsonParam = methodParameter.getParameterAnnotation(
      JsonParam.class
    );
    final RequestJson requestJson = methodParameter.getMethodAnnotation(
      RequestJson.class
    );
    JsonNode node = NullNode.getInstance();
    if (jsonParam != null) {
      node = Helper.dataGet(body, jsonParam.name(), NullNode.getInstance());
    } else if (requestJson != null) {
      node = body.get(methodParameter.getParameterName());
    }
    if (node.isNull()) {
      if (jsonParam != null) {
        if (jsonParam.required()) {
          throw new MissingServletRequestParameterException(
            jsonParam.name(),
            methodParameter.getParameterType().getTypeName()
          );
        } else {
          node = TextNode.valueOf(jsonParam.defaultValue());
        }
      } else {
        return null;
      }
    }
    return JSON.convertToObject(node, methodParameter.getParameterType());
  }

  private JsonNode getJsonBody(final NativeWebRequest nativeWebRequest) {
    final HttpServletRequest servletRequest = nativeWebRequest.getNativeRequest(
      HttpServletRequest.class
    );

    JsonNode body = (JsonNode) nativeWebRequest.getAttribute(
      JSON_REQUEST_ATTRIBUTE_NAME,
      NativeWebRequest.SCOPE_REQUEST
    );

    if (body == null) {
      try {
        if (servletRequest != null) {
          body =
            JSON.parse(
              servletRequest
                .getReader()
                .lines()
                .collect(Collectors.joining("\n"))
            );
        }
      } catch (final IOException e) {
        //
      }
      if (body == null) {
        body = NullNode.getInstance();
      }
      nativeWebRequest.setAttribute(
        JSON_REQUEST_ATTRIBUTE_NAME,
        body,
        NativeWebRequest.SCOPE_REQUEST
      );
    }

    return body;
  }
}
