package com.baizhi.test;

import com.baizhi.entity.Lessons;
import com.baizhi.service.LessonsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LessonsTest extends BasicTest {
    @Autowired
    private LessonsService lessonsService;
    @Test
    public void testQuery(){
        List<Lessons> all = lessonsService.findByPage(1,2);
        System.out.println(all);
    }
}
