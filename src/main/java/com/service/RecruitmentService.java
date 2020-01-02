package com.service;

import com.domain.Recruitment;

import java.util.List;

public interface RecruitmentService {

    List<Recruitment> selectRecruitment(Recruitment recruitment);

    int insertRecruitment(Recruitment recruitment);

    int updateRecruitment(Recruitment recruitment);

    int deleteRecruitmentById(int id);
}
