package com.service.impl;

import com.dao.RecruitmentDao;
import com.domain.Recruitment;
import com.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentDao recruitmentDao;

    @Override
    public List<Recruitment> selectRecruitment(Recruitment recruitment){
        return recruitmentDao.selectRecruitment(recruitment);
    }

    @Override
    public int insertRecruitment(Recruitment recruitment){
        int rows = recruitmentDao.insertRecruitment(recruitment);
        return rows;
    }

    @Override
    public int updateRecruitment(Recruitment recruitment){
        int rows = recruitmentDao.updateRecruitment(recruitment);
        return rows;
    }

    @Override
    public int deleteRecruitmentById(int id){
        return recruitmentDao.deleteRecruitmentById(id);
    }
}
