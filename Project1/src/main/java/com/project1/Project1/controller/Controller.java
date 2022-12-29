package com.project1.Project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project1.Project1.entity.Staff;
import com.project1.Project1.service.Service;

@RestController
public class Controller {
	
	@Autowired
	Service se;
	
	@GetMapping("/getAll")
	public List<Staff> getAll() {
	List<Staff> l1=	se.getAll();
		return l1;
		
	}@GetMapping("/get3")
	public Staff get3() {
		Staff e1 = se.get3();
		 return e1;
	}
	@PostMapping("/insert")
	public String insertMem(@RequestBody Staff mem) {
		String b= se.insertMem(mem);
		return b ;
	}
	@GetMapping("/getmore20000")
	public List<Staff> getmore20000(){
		List<Staff> l1= se.getmore20000();
		return l1;
	}
	@GetMapping("/getexp")
	public List<Staff> getexp() {
	List<Staff> l2=	se.getexp();
	return l2;
	}
	@GetMapping("/getmaxsal")
	public List<Staff> getmaxsal() {
	List<Staff> l3=	se.getmaxsal();
	return l3;
	}
	@GetMapping("/getmaxsal2")
	public List<Staff> getmaxsal2() {
		List<Staff> l4 = se.getmaxsal2();
		return l4;	
	}
	@PutMapping("/updatesal/{staffid}")
	public Staff updateSal(@RequestBody Staff sal) {
	Staff s1=	se.updateSal(sal);
		return s1;
	}
	@GetMapping("/getName")
	public String getName() {
		String name=	se.getName();
		return name;
	}@GetMapping("/getTrainer")
	public List<Staff> getTrainer() {
		return se.getTrainer();
	}
	@GetMapping("/getxTrainer")
	public List<Staff> getxTrainer() {
		return se.getxTrainer();
	}
}
