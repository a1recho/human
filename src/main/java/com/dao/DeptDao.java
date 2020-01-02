package com.dao;
import com.domain.Dept;
import java.util.List;

public interface DeptDao {

    List<Dept> selectDept(Dept dept);

    int insertDept(Dept dept);

    int updateDept(Dept dept);

    int deleteDeptById(int id);
}
