package com.nationwide.keyboards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.keyboards.entities.Sizes;
import com.nationwide.keyboards.repositories.SizeRepository;

@RestController
public class SizeController {

	@Autowired
	private SizeRepository sizeRepo;
	
	@GetMapping("/sizes")
	public ArrayList<Sizes> showAll(){
		return sizeRepo.findAll(); 
	}
	
	@GetMapping("sizeByName/{N}")
	public ArrayList<Sizes> findByName(@PathVariable String N){
		return sizeRepo.findByName(N); 
	}
	
	@PostMapping("/addNewSize")
	public void SaveData(@RequestBody Sizes ref) {
		
		sizeRepo.save(ref);
	}
	
}
