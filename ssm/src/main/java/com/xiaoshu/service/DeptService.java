package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeptMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class DeptService {

	@Autowired
	DeptMapper deptMapper;

	public PageInfo<Dept> findPage(Dept dept,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
	//	List<Dept> list = deptMapper.select(dept);
		List<Dept> list = deptMapper.findList(dept);
		return new PageInfo<>(list);
	}
	public Dept findByName(String name){
		Dept dept  = new Dept();
		dept.setName(name);
		return deptMapper.selectOne(dept);
	}
	
	
	public void addDept(Dept dept){
		deptMapper.insert(dept);
		}
	public void updateDept(Dept dept){
		deptMapper.updateByPrimaryKeySelective(dept);
	}
	public void deleteDept(Integer id){
		deptMapper.deleteByPrimaryKey(id);
	}
}
