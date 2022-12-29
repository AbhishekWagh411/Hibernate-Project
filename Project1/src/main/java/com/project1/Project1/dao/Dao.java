package com.project1.Project1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project1.Project1.entity.Staff;

@Repository
public class Dao {

	@Autowired
	SessionFactory sf;
	 
	
	public List<Staff> getAll() { 
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Staff.class);
		List<Staff> l1= cr.list();
		sf.close();
		return l1;
	}
	public Staff get3() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		Staff e1 = session.get(Staff.class, 3);		
		sf.close();
		return e1;
	}
	public String insertMem(Staff mem) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(mem);
		tr.commit();
		sf.close();
		return "Done";
	}
	public List<Staff> getmore20000() {
		Session session = sf.openSession();
		Criteria criteria= session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", 20000));
		List<Staff> l1= criteria.list();
		sf.close();
		return l1;
	}
	public List<Staff> getexp() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff> l2 = criteria.list();
		sf.close();
		return l2;
	}
	public List<Staff> getmaxsal() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.max("salary"));
		List list = criteria.list();
		Integer maxSalary = (Integer) list.get(0);
		criteria= session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("salary", maxSalary)) ;
		List<Staff> l3 = criteria.list();
		sf.close();
		return l3;
	}
	public List<Staff> getmaxsal2() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.setMaxResults(1);
		List<Staff> l4=criteria.list();
		return l4;
	}
	public Staff  updateSal(Staff sal) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(sal);
		tr.commit();
		sf.close();
		return sal;
	}
	public String getName() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.addOrder(Order.desc("experience"));
		criteria.setMaxResults(1);
		List<Staff> name = criteria.list();
		String str = null;
		for (Staff staff : name) {
			str= staff.getName();
		}
		session.close();
		return str;
	}
	public List<Staff> getTrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", "Trainer")) ;
		List<Staff> trainer = criteria.list();
		sf.close();
		return trainer;
	}
	public List<Staff> getxTrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "Trainer")) ;
		List<Staff> trainer = criteria.list();
		sf.close();
		return trainer;
	}
}
