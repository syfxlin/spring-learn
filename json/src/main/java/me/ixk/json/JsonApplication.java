package me.ixk.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.ixk.json.utils.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonApplication.class, args);
    }

    @GetMapping("/index")
    public String index() {
        return "123";
    }

    @Autowired
    JSON json;

    @GetMapping("/json")
    public String json() throws JsonProcessingException {
        String jsonString = "{\"name\": \"syfxlin\", \"password\": \"123456\"}";
        Object obj = json.parse(jsonString, Object.class);
        return json.stringify(obj);
    }

    @Autowired
    Gson gson;

    @GetMapping("/gson")
    public String gson() {
        String jsonString = "{\"name\": \"syfxlin\", \"password\": \"123456\"}";
        JsonObject object = gson.fromJson(jsonString, JsonObject.class);
        return gson.toJson(object);
    }
}
