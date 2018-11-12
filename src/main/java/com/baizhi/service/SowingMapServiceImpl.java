package com.baizhi.service;

import com.baizhi.dao.SowingMapDAO;
import com.baizhi.entity.SowingMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SowingMapServiceImpl implements SowingMapService {
    @Autowired
    private SowingMapDAO sowingMapDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SowingMap> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return sowingMapDAO.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return sowingMapDAO.queryTotals();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SowingMap findById(int id) {
        return sowingMapDAO.queryById(id);
    }

    @Override
    public void add(SowingMap sowingMap) {
        sowingMapDAO.insert(sowingMap);
    }

    @Override
    public void remove(int id) {
        sowingMapDAO.delete(id);
    }

    @Override
    public void motify(SowingMap sowingMap) {
        sowingMapDAO.update(sowingMap);
    }
}
