package com.example.ibex.ibexmockdata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibex.ibexmockdata.contracts.WidgetsContract;
import com.example.ibex.ibexmockdata.exception.ResourceNotFoundException;
import com.example.ibex.ibexmockdata.model.Widgets;
import com.example.ibex.ibexmockdata.repository.WidgetsRepository;
@RestController
public class WidgetsController implements WidgetsContract {
	
	@Autowired
	private  WidgetsRepository widgetsRepository;

	@Override
	public List<Widgets> getWidgets(){
		
		return widgetsRepository.findAll();
	}

	@Override
	public Widgets createWidgets(@Valid Widgets widgets) {
		
		widgets.setBasicSettings(widgets.getBasicSettingsPojo().toString());
		
		Widgets widgetsdata = widgetsRepository.save(widgets);
		System.out.println(widgetsdata.toString());
		return widgetsdata;
	}

	@Override
	public Map<String, Boolean> deleteWidget(@PathVariable(value ="id") Long id) throws ResourceNotFoundException{
		Widgets widget = widgetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Widgets not found for this id :: " +id));;
		widgetsRepository.delete(widget);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("deleted", true);
        return map;
	}

	@Override
	public ResponseEntity<Widgets> updateWidgetById(Long widgetId, @Valid Widgets widgetsDetails) throws ResourceNotFoundException{
		Widgets widget = widgetsRepository.findById(widgetId)
				.orElseThrow(() -> new ResourceNotFoundException("Widgets not found for this id :: " +widgetId));
		widget.setId(widgetsDetails.getId());
		widget.setName(widgetsDetails.getName());
		widget.setBasicSettings(widgetsDetails.getBasicSettingsPojo().toString());
		
		final Widgets widgetsUpdate = widgetsRepository.save(widget);
		
		return ResponseEntity.ok(widgetsUpdate);
	}

}
