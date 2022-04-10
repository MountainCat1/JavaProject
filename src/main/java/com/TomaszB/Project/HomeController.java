package com.TomaszB.Project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "Hello world!";
    }


    @RequestMapping("/getExample")
    public String getExample(){
        return "example";
    }
}
