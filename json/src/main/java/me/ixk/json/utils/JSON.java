package me.ixk.json.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

@Component
public class JSON extends ObjectMapper {
    public ObjectNode parseObject(String json) throws JsonProcessingException {
        return this.readValue(json, ObjectNode.class);
    }

    public ArrayNode parseArray(String json) throws JsonProcessingException {
        return this.readValue(json, ArrayNode.class);
    }

    public <T> T parse(String json, Class<T> valueType) throws JsonProcessingException {
        return this.readValue(json, valueType);
    }

    public String stringify(Object object) throws JsonProcessingException {
        return this.writeValueAsString(object);
    }
}
