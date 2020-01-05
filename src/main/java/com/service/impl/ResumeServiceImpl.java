package com.service.impl;

import com.dao.ResumeDao;
import com.domain.Resume;
import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeDao resumeDao;

    @Override
    public List<Resume> selectResume(Resume resume){
        return resumeDao.selectResume(resume);
    }

    @Override
    public List<Resume> getPushedResume(){
        return resumeDao.getPushedResume();
    }

    @Override
    public int insertResume(Resume resume){
        int rows = resumeDao.insertResume(resume);
        return rows;
    }

    @Override
    public int updateResume(Resume resume){
        int rows = resumeDao.updateResume(resume);
        return rows;
    }

    @Override
    public int deleteResumeById(int id){
        return resumeDao.deleteResumeById(id);
    }
}
