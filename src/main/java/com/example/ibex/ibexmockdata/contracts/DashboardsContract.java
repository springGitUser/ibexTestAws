package com.example.ibex.ibexmockdata.contracts;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibex.ibexmockdata.exception.ResourceNotFoundException;
import com.example.ibex.ibexmockdata.model.Dashboards;


@RequestMapping("/api/ibex")
public interface DashboardsContract {
	
	@GetMapping("/dashboards")
	public List<Dashboards> getAllDashboards();
	
	@PostMapping("/dashboards")
	public Dashboards createDashboard(@Valid @RequestBody Dashboards dashboards);
	
	@DeleteMapping("/dashboards/{id}")
	public Map<String, Boolean> deleteDashboard(@PathVariable(value = "id") Long dashboardId) throws ResourceNotFoundException;
	
	@PutMapping("/dashboards/{id}")
	public ResponseEntity<Dashboards> updateDashboardsById(@PathVariable(value = "id") Long dashboardId, @Valid @RequestBody Dashboards dashboardsDetails) throws ResourceNotFoundException;

}
