package com.tom.reflectedxss.service;

/**
 * Created by thongminhle on 7/28/17.
 */
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {


    public String getTitle(String name) {

        if(StringUtils.isEmpty(name)){
            return "No name? Enter something";
        }else{
            return "Hello " + name;
        }

    }

}
