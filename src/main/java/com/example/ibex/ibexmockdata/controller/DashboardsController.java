package com.example.ibex.ibexmockdata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibex.ibexmockdata.contracts.DashboardsContract;
import com.example.ibex.ibexmockdata.exception.ResourceNotFoundException;
import com.example.ibex.ibexmockdata.model.Dashboards;
import com.example.ibex.ibexmockdata.repository.DashboardsRepository;

@RestController
public class DashboardsController implements DashboardsContract {
	
	@Autowired
	private DashboardsRepository dashboardRepo;

	@Override
	public List<Dashboards> getAllDashboards() {
		return dashboardRepo.findAll();
	}

	@Override
	public Dashboards createDashboard(@Valid Dashboards dashboards) {
		Dashboards dashboard = dashboardRepo.save(dashboards);
		return dashboard;
	}

	@Override
	public Map<String, Boolean> deleteDashboard(Long dashboardId) throws ResourceNotFoundException {
		Dashboards dashboards = dashboardRepo.findById(dashboardId)
				.orElseThrow(() -> new ResourceNotFoundException("Dashboards not found for this id :: " +dashboardId));;
				dashboardRepo.delete(dashboards);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("deleted", true);
        return map;
	}

	@Override
	public ResponseEntity<Dashboards> updateDashboardsById(Long dashboardId, @Valid Dashboards dashboardsDetails)
			throws ResourceNotFoundException {
		Dashboards dashboards = dashboardRepo.findById(dashboardId)
				.orElseThrow(() -> new ResourceNotFoundException("Widgets not found for this id :: " +dashboardId));
		dashboards.setId(dashboardsDetails.getId());
		dashboards.setName(dashboardsDetails.getName());
	
		
		final Dashboards dashboardsUpdate = dashboardRepo.save(dashboards);
		
		return ResponseEntity.ok(dashboardsUpdate);
	}

}
