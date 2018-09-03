package com.mywork.dataTransfer.entity;

import java.util.Date;

public class Emp {
	/**主键id*/
	private Integer id;
	/**员工号*/
	private Integer empno;
	/**员工名称*/
	private String ename;
	/**职位*/
	private String job;
	/**管理员*/
	private Integer mgr;
	/**入职日期*/
	private Date hiredate;
	/**薪水*/
	private double sal;
	/**奖金*/
	private double comm;
	/**部门号*/
	private Integer deptno;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "id:" +id+ ",empno:" +empno+ ",ename:" +ename+ ",job:" +job
				+ ",mgr:" +mgr+ ",hiredate:" +hiredate+ ",sal:" +sal+ ",comm:" +comm+ ",deptno:" + deptno;
	}
}
