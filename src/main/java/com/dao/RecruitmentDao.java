package com.dao;
import com.domain.Recruitment;
import java.util.List;

public interface RecruitmentDao {

    List<Recruitment> selectRecruitment(Recruitment recruitment);

    int insertRecruitment(Recruitment recruitment);

    int updateRecruitment(Recruitment recruitment);

    int deleteRecruitmentById(int id);
}
