package com.nationwide.keyboards.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nationwide.keyboards.entities.Layouts;
import com.nationwide.keyboards.repositories.LayoutRepository;

@Service
public class LayoutService {

	@Autowired
	private LayoutRepository layoutRepo;
	
	public ArrayList<Layouts> findAll(){
		return layoutRepo.findAll(); 
	}
	
	public ArrayList<Layouts> findByName(@PathVariable String N){
		return layoutRepo.findByName(N); 
	}
	
	public void save(@RequestBody Layouts ref) {
		layoutRepo.save(ref); 
	}
	
}
