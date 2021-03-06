package com.mywork.demo.entity;

import java.util.Date;

public class Area {

	//地区主键ID
	private Integer areaId;
	//地区名称
	private String areaName;
	//展示顺序
	private Integer priority;
	//创建时间
	private Date createTime;
	//最后修改时间
	private Date lastEditTime;
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	@Override
	public String toString() {
		return "{areaId:"+areaId+",areaName:"+areaName+",priority:"+priority+
				",createTime:"+createTime+",lastEditTime:"+lastEditTime+"}";
	}
}
