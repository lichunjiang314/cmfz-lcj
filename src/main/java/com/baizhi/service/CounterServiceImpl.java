package com.baizhi.service;

import com.baizhi.dao.CounterDAO;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterDAO counterDAO;

    @Override
    public void motify(Counter counter) {
        counterDAO.update(counter);
    }
}
