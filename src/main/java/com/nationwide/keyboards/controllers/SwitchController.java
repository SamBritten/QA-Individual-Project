package com.nationwide.keyboards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.keyboards.entities.Switches;
import com.nationwide.keyboards.repositories.SwitchRepository;

@RestController
public class SwitchController {

	@Autowired
	private SwitchRepository switchRepo;
	
	@GetMapping("/switches")
	public ArrayList<Switches> showAll() {
		return switchRepo.findAll();
	}
	
	@GetMapping("switchByManufacturer/{M}")
	public ArrayList<Switches> findByManufacturer(@PathVariable String M) {
		return switchRepo.findByManufacturer(M);
	}
	
	@GetMapping("switchByType/{T}")
	public ArrayList<Switches> findByType(@PathVariable String T) {
		return switchRepo.findByType(T);
	} 
	
	@GetMapping("switchByActuationForce/{AF}")
	public ArrayList<Switches> findByActuation(@PathVariable int AF) {
		return switchRepo.findByActuation(AF); 
	}
	
	@GetMapping("switchByTactileForce/{TF}")
	public ArrayList<Switches> findByTactile(@PathVariable int TF) {
		return switchRepo.findByTactile(TF); 
	}
	
	@GetMapping("/findByManufacturerAndType/{M}/{T}")
	public ArrayList<Switches> findByManufacturerAndType(@PathVariable String M, @PathVariable String T) {
		return switchRepo.findByManufacturerAndType(M, T); 
	}
	
	@GetMapping("/findByActuationGreaterThan/{AF}")
	public ArrayList<Switches> findByActuationGreaterThanEqual(@PathVariable int AF) {
		return switchRepo.findByActuationGreaterThanEqual(AF);
	}
	
	@GetMapping("/findByActuationLessThan/{AF}")
	public ArrayList<Switches> findByActuationLessThanEqual(@PathVariable int AF) {
		return switchRepo.findByActuationLessThanEqual(AF);
	}
	
	@GetMapping("/findByActuationBetween/{AF1}/{AF2}")
	public ArrayList<Switches> findByActuationBetween(@PathVariable int AF1, @PathVariable int AF2) {
		return switchRepo.findByActuationBetween(AF1,  AF2); 
	}
	
	@GetMapping("/findByTactileGreaterThan/{TF}")
	public ArrayList<Switches> findByTactileGreaterThanEqual(@PathVariable int TF) {
		return switchRepo.findByTactileGreaterThanEqual(TF);
	}
	
	@GetMapping("/findByTactileLessThan/{TF}")
	public ArrayList<Switches> findByTactileLessThanEqual(@PathVariable int TF) {
		return switchRepo.findByTactileLessThanEqual(TF);
	}
	
	@GetMapping("/findByTactileBetween/{TF1}/{TF2}")
	public ArrayList<Switches> findByTactileBetween(@PathVariable int TF1, @PathVariable int TF2) {
		return switchRepo.findByTactileBetween(TF1,  TF2); 
	}
	
	/*@PostMapping("/addNewSwitch/{M}/{N}/{T}/{AF}/{TF}/{I}/{id}")
	public void SaveData(@PathVariable String M, @PathVariable String N, @PathVariable String T,
	@PathVariable int AF, @PathVariable int TF, @PathVariable String I, @PathVariable Long id) {
		
		Switches ref = new Switches();
		
		ref.setManufacturer(M);
		ref.setName(N);
		ref.setType(T);
		ref.setActuation_force(AF);
		ref.setTactile_force(TF);
		ref.setImage(I);
		ref.setId(id);
		
		switchRepo.save(ref); 
	}*/
	
	@PostMapping("/addNewSwitch")
	public void SaveData(@RequestBody Switches ref) {
		
		switchRepo.save(ref);
	}
	
}
