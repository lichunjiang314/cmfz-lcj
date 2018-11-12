package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;

    @RequestMapping("/update")
    public @ResponseBody
    Map<String,Object> motify(Counter counter){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            counterService.motify(counter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
