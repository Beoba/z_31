package com.spc.mapper;

import java.util.List;

import com.spc.bean.Dept;

public interface DeptMapper {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
