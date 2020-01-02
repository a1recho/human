package com.dao;
import com.domain.Resume;
import java.util.List;

public interface ResumeDao {

    List<Resume> selectResume(Resume resume);

    int insertResume(Resume resume);

    int updateResume(Resume resume);

    int deleteResumeById(int id);
}
