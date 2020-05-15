package com.example.ibex.ibexmockdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibex.ibexmockdata.contracts.DatasourceContract;
import com.example.ibex.ibexmockdata.model.Datasource;
import com.example.ibex.ibexmockdata.repository.DatasourceRepository;

@RestController
public class DatasourceController implements DatasourceContract{
	
	@Autowired
	private DatasourceRepository datasourcerepository;
	
	@Override
	public List<Datasource> getAllDatasources(){
		
		return datasourcerepository.findAll();
	}
}
