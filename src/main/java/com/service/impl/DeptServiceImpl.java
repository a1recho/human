package com.service.impl;
import com.dao.DeptDao;
import com.domain.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> selectDept(Dept dept){
        return deptDao.selectDept(dept);
    }

    @Override
    public Dept selectDeptByDeptName(String deptName){
        return deptDao.selectDeptByDeptName(deptName);
    }

    @Override
    public int insertDept(Dept dept){
        int rows = deptDao.insertDept(dept);
        return rows;
    }

    @Override
    public int updateDept(Dept dept){
        int rows = deptDao.updateDept(dept);
        return rows;
    }

    @Override
    public int deleteDeptById(int id){
        return deptDao.deleteDeptById(id);
    }


}
