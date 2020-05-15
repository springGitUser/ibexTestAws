package com.example.ibex.ibexmockdata.model;

import java.util.List;

import javax.persistence.Embeddable;

@Embeddable
public class BasicSettings {
	
	private String name;
	private List<Integer> data;
	private String type;
		
	public BasicSettings() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "{name:" + name + ", data:" + data + ", type:" + type + "}";
	}
}
