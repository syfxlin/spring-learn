package me.ixk.json_inject;

import me.ixk.json_inject.annotation.JsonParam;
import me.ixk.json_inject.annotation.RequestJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JsonInjectApplication {

  public static void main(final String[] args) {
    SpringApplication.run(JsonInjectApplication.class, args);
  }

  @PostMapping("/param")
  public String param(@JsonParam(name = "key") final String key) {
    return key;
  }

  @PostMapping("/method")
  @RequestJson
  public String method(final String key) {
    return key;
  }

  @PostMapping("/no-name")
  public String noName(@JsonParam final String key) {
    return key;
  }

  @PostMapping("/data-get")
  public String dataGet(@JsonParam(name = "key.sub") final String key) {
    return key;
  }

  @PostMapping("/default-value")
  public String defaultValue(
    @JsonParam(name = "value", required = false) final String value
  ) {
    return value;
  }

  @PostMapping("/convert")
  public Integer convert(@JsonParam(name = "key") final Integer key) {
    return key;
  }

  @GetMapping("/get")
  public String get(String key) {
    return key;
  }

  @PostMapping("/post")
  public String post(String key) {
    return key;
  }
}
