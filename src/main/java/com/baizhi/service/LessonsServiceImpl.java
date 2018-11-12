package com.baizhi.service;

import com.baizhi.dao.LessonsDAO;
import com.baizhi.entity.Lessons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LessonsServiceImpl implements LessonsService {
    @Autowired
    private LessonsDAO lessonsDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Lessons> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return lessonsDAO.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return lessonsDAO.queryTotals();
    }

    @Override
    public void add(Lessons lessons) {
        lessonsDAO.insert(lessons);
    }

    @Override
    public void motify(Lessons lessons) {
        lessonsDAO.update(lessons);
    }
}
