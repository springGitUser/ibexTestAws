package com.example.ibex.ibexmockdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "datasource")
public class Datasource {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="url",nullable = false)
	@JsonIgnore
	private String url;
	
	@Column(name="metadata",nullable = false)
	@JsonIgnore
	private String metadata;

	public Datasource() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "Datasource [id=" + id + ", name=" + name + ", url=" + url + ", metadata=" + metadata + "]";
	}	
	
}
