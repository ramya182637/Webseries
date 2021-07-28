package com.Ramya.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ramya.dao.SeriesRepo;
import com.Ramya.model.WebSeries;

@RestController
public class MainController {
	
	@Autowired
	SeriesRepo repo;
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@PostMapping("/addSeries")
	public String addSeries(@RequestBody WebSeries webseries) {
		repo.save(webseries);
		return "added:"+webseries.getName();
	}
	
	@GetMapping("/series")
	public List<WebSeries> getAllSeries(){
		return repo.findAll();
	}
	
	@GetMapping("/series/id/{id}")
	public Optional<WebSeries> getSeriesById(@PathVariable("id") int id){
		return repo.findById(id);
	}
	
	@GetMapping("/series/name/{name}")
	public Optional<WebSeries> getSeriesByName(@PathVariable("name") String name){
		return repo.findByName(name);
	}
	
	@PutMapping("/update")
	public String updateSeries(@RequestBody WebSeries webseries) {
		repo.save(webseries);
		return "updated:"+webseries.getName();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
	
		repo.deleteById(id);
		return "deleted";
	}
	
	

}