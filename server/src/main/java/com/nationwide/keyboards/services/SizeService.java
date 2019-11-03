package com.nationwide.keyboards.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nationwide.keyboards.entities.Sizes;
import com.nationwide.keyboards.repositories.SizeRepository;

@Service
public class SizeService {

	@Autowired
	private SizeRepository sizeRepo;
	
	public ArrayList<Sizes> findAll(){
		return sizeRepo.findAll(); 
	}
	
	public ArrayList<Sizes> findByName(@PathVariable String N){
		return sizeRepo.findByName(N); 
	}
	
	public void save(@RequestBody Sizes ref) {
		sizeRepo.save(ref);
	}
	
}
