package com.service;

import com.domain.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> selectResume(Resume resume);

    List<Resume> getPushedResume();

    int insertResume(Resume resume);

    int updateResume(Resume resume);

    int deleteResumeById(int id);
}
