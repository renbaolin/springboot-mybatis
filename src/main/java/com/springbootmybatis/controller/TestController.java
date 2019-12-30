package com.springbootmybatis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {
    private static final String LINK_REG = "<a\\s*href\\s*=\\s*[\"|\']?(.*?)\">\\s*</a>";

    @RequestMapping(value = "/parse_link")
    List<String> parseLink(@RequestParam(value = "content") String content) {
        Pattern pattern = Pattern.compile(LINK_REG, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        List<String> urlList = new ArrayList<>();
        while (matcher.find()) {
            urlList.add(matcher.group(1));
        }
        return urlList;
    }
}
