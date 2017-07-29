package com.tom.reflectedxss.web;

/**
 * Created by thongminhle on 7/28/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import com.tom.reflectedxss.service.HelloService;

import java.util.Map;

@Controller
public class HelloController {

    private final HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name, HttpSession session) {
        session.setAttribute("msg", service.getTitle(name));

        return "index";

    }
}
