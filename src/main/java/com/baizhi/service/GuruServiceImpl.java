package com.baizhi.service;

import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;

    @Override
    public void add(Guru guru) {
        guruDAO.insert(guru);
    }

    @Override
    public void remove(int id) {
        guruDAO.delete(id);
    }

    @Override
    public void motify(Guru guru) {
        guruDAO.update(guru);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru findById(int id) {
        return guruDAO.queryById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return guruDAO.queryTotals();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return guruDAO.queryByPage(start,rows);
    }
}
