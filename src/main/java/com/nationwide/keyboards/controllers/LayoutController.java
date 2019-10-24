package com.nationwide.keyboards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.keyboards.entities.Layouts;
import com.nationwide.keyboards.repositories.LayoutRepository;

@RestController
public class LayoutController {

	@Autowired
	private LayoutRepository layoutRepo;
	
	@GetMapping("/layouts")
	public ArrayList<Layouts> showAll(){
		return layoutRepo.findAll(); 
	}
	
	@GetMapping("layoutByName/{N}")
	public ArrayList<Layouts> findByName(@PathVariable String N){
		return layoutRepo.findByName(N); 
	}
	
	@PostMapping("/addNewLayout")
	public void SaveData(@RequestBody Layouts ref) {
		
		layoutRepo.save(ref); 
	}
	
}