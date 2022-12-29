package com.project1.Project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project1.Project1.dao.Dao;
import com.project1.Project1.entity.Staff;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	Dao d;
	
	public List<Staff> getAll() {
		List<Staff> l1= d.getAll();
		return l1;
	}
	public Staff get3() {
		Staff e1 = d.get3();
		 return e1;
	}
	public String insertMem(Staff mem) {
		String b= d.insertMem(mem);
		return b;
	}
	public List<Staff> getmore20000(){
		List<Staff> l1= d.getmore20000();
		return l1;
		
	}
	public List<Staff> getexp() {
		List<Staff> l2 = d.getexp();
		return l2;
	}
	public List<Staff> getmaxsal() {
		List<Staff> l3 = d.getmaxsal();		
		return l3;
	}
	public List<Staff> getmaxsal2() {
		List<Staff> l4 = d.getmaxsal2();
		return l4;	
	}
	public Staff updateSal(Staff sal) {
		Staff s1 = d.updateSal(sal);
		return s1;
	}
	public String getName() {
		String name = d.getName();
		return name;
	}
	public List<Staff> getTrainer() {
		return d.getTrainer();
	}
	public List<Staff> getxTrainer() {
		return d.getxTrainer();
	}
}
