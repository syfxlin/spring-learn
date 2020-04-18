package me.ixk.json.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JSON extends ObjectMapper {
    public <T> T parse(String json, Class<T> valueType) throws JsonProcessingException {
        return this.readValue(json, valueType);
    }

    public String stringify(Object object) throws JsonProcessingException {
        return this.writeValueAsString(object);
    }
}
