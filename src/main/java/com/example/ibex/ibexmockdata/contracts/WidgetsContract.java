package com.example.ibex.ibexmockdata.contracts;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibex.ibexmockdata.exception.ResourceNotFoundException;
import com.example.ibex.ibexmockdata.model.Widgets;


@RequestMapping("/api/ibex")
//@CrossOrigin(origins = "http://localhost:9090", maxAge = 3600)
public interface WidgetsContract {
	
	@GetMapping("/widgets")
	public List<Widgets> getWidgets();
	
	@PostMapping("/widgets")
	public Widgets createWidgets(@Valid @RequestBody Widgets widgets);
	
	@DeleteMapping("/widgets/{id}")
    public Map<String, Boolean> deleteWidget(@PathVariable(value ="id") Long id) throws ResourceNotFoundException;
	
	@PutMapping("/widgets/{id}")
	public ResponseEntity<Widgets> updateWidgetById(@PathVariable(value = "id") Long widgetId, @Valid @RequestBody Widgets widgetsDetails) throws ResourceNotFoundException;
	
}
