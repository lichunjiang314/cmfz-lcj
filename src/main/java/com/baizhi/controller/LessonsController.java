package com.baizhi.controller;

import com.baizhi.entity.Lessons;
import com.baizhi.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lessons")
public class LessonsController {
    @Autowired
    private LessonsService lessonsService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //总记录数
        Long totals = lessonsService.findTotals();
        //当前页数据rows:
        List<Lessons> all =lessonsService.findByPage(page, rows);
        results.put("total",totals);
        results.put("rows",all);
        return results;
    }

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> save(Lessons lessons){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            lessonsService.add(lessons);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Lessons lessons){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            lessonsService.motify(lessons);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
