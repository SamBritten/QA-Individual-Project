package com.nationwide.keyboards.services;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nationwide.keyboards.entities.Switches;
import com.nationwide.keyboards.repositories.SwitchRepository;

@Service
public class SwitchService {

	@Autowired
	private SwitchRepository switchRepo;
	
	public ArrayList<Switches> findAll() {
		return switchRepo.findAll(); 
	}
	
	public ArrayList<Switches> findByManufacturer(@PathVariable String M) {
		return switchRepo.findByManufacturer(M);
	}
	
	public ArrayList<Switches> findByType(@PathVariable String T) {
		return switchRepo.findByType(T);
	}
	
	public ArrayList<Switches> findByActuation(@PathVariable int AF) {
		return switchRepo.findByActuation(AF); 
	}
	
	public ArrayList<Switches> findByTactile(@PathVariable int TF) {
		return switchRepo.findByTactile(TF); 
	}
	
	public ArrayList<Switches> findByManufacturerAndType(@PathVariable String M, @PathVariable String T) {
		return switchRepo.findByManufacturerAndType(M, T); 
	}
	
	public ArrayList<Switches> findByActuationGreaterThanEqual(@PathVariable int AF) {
		return switchRepo.findByActuationGreaterThanEqual(AF);
	}
	
	public ArrayList<Switches> findByActuationLessThanEqual(@PathVariable int AF) {
		return switchRepo.findByActuationLessThanEqual(AF);
	}
	
	public ArrayList<Switches> findByActuationBetween(@PathVariable int AF1, @PathVariable int AF2) {
		return switchRepo.findByActuationBetween(AF1,  AF2); 
	}
	
	public ArrayList<Switches> findByTactileGreaterThanEqual(@PathVariable int TF) {
		return switchRepo.findByTactileGreaterThanEqual(TF);
	}
	
	public ArrayList<Switches> findByTactileLessThanEqual(@PathVariable int TF) {
		return switchRepo.findByTactileLessThanEqual(TF);
	}
	
	public ArrayList<Switches> findByTactileBetween(@PathVariable int TF1, @PathVariable int TF2) {
		return switchRepo.findByTactileBetween(TF1,  TF2); 
	}
	
	public void save(@RequestBody Switches ref) {
		switchRepo.save(ref);
	}
	
	public Switches update(@PathVariable Long Id,@Valid @RequestBody Switches ref) {

		Switches switches = switchRepo.findByid(Id);
		
		switches.setManufacturer(ref.getManufacturer());
		switches.setName(ref.getName());
		switches.setType(ref.getType());
		switches.setActuation(ref.getActuation());
		switches.setTactile(ref.getTactile());
		switches.setImage(ref.getImage());
		
		Switches updatedSwitch = switchRepo.save(switches);
		return updatedSwitch; 
	}
	
	public ResponseEntity<?> deleteSwitch(@PathVariable Long Id) {
		
	    Switches switches = switchRepo.findByid(Id);

	    switchRepo.delete(switches);

	    return ResponseEntity.ok().build();
	}
	
}
