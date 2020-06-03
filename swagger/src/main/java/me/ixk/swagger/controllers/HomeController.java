package me.ixk.swagger.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class HomeController {

    @ApiIgnore
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @ApiOperation(value = "获取单个用户", notes = "获取单个用户")
    @GetMapping("/get")
    @ResponseBody
    public Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "name1");
        map.put("age", "20");
        return map;
    }

    @ApiOperation(value = "查找用户", notes = "根据用户名查找用户")
    @ApiImplicitParam(
        name = "s",
        value = "查询用户名",
        required = true,
        dataType = "String",
        paramType = "query"
    )
    @GetMapping("/search")
    @ResponseBody
    public Map<String, String> search(String s) {
        if (s.startsWith("name")) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "name1");
            map.put("age", "20");
            return map;
        }
        return null;
    }
}
