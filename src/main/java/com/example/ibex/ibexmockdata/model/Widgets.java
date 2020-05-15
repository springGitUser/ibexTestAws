package com.example.ibex.ibexmockdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "widgets")
public class Widgets {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	
	@Column(name="basicsettings")
	private String basicSettings;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	private BasicSettings basicSettingsPojo;

	public Widgets() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasicSettings() {
		return basicSettings;
	}

	public void setBasicSettings(String basicSettings) {
		this.basicSettings = basicSettings;
	}	

	public BasicSettings getBasicSettingsPojo() {
		return basicSettingsPojo;
	}

	public void setBasicSettingsPojo(BasicSettings basicSettingsPojo) {
		this.basicSettingsPojo = basicSettingsPojo;
	}
	
	@Override
	public String toString() {
		return "Widgets [id=" + id + ", name=" + name + ", basicSettings=" + basicSettings + ", basicSettingsPojo="
				+ basicSettingsPojo + "]";
	}
	
}
