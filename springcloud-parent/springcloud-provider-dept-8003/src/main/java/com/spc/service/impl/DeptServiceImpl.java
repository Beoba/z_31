package com.spc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.bean.Dept;
import com.spc.mapper.DeptMapper;
import com.spc.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptMapper.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptMapper.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptMapper.findAll();
	}

}
