package com.example.ibex.ibexmockdata.contracts;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibex.ibexmockdata.model.Datasource;

@RequestMapping("/api/ibex")
public interface DatasourceContract {
	
	@GetMapping("/datasources")
	public List<Datasource> getAllDatasources();

}
