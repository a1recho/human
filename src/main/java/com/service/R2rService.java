package com.service;

import com.domain.R2r;

import java.util.List;

public interface R2rService {

    List<R2r> selectR2r(R2r r2r);

    int insertR2r(R2r r2r);

    int updateR2r(R2r r2r);

    int deleteR2rById(int id);
}
