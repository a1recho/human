package com.service.impl;
import com.domain.R2r;
import com.dao.R2rDao;
import com.service.R2rService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class R2rServiceImpl implements R2rService {

    @Autowired
    private R2rDao r2rDao;

    @Override
    public List<R2r> selectR2r(R2r r2r){
        return r2rDao.selectR2r(r2r);
    }

    @Override
    public int insertR2r(R2r r2r){
        int rows = r2rDao.insertR2r(r2r);
        return rows;
    }

    @Override
    public int updateR2r(R2r r2r){
        int rows = r2rDao.updateR2r(r2r);
        return rows;
    }

    @Override
    public int deleteR2rById(int id){
        return r2rDao.deleteR2rById(id);
    }
}
