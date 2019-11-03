package com.nationwide.keyboards.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nationwide.keyboards.entities.Switches;

@Repository
public interface SwitchRepository extends JpaRepository<Switches, Long> {

	public ArrayList<Switches> findAll();
	public Switches findByid(Long ID);
	public ArrayList<Switches> findByManufacturer(String Mname);
	public ArrayList<Switches> findByType(String Tname);
	public ArrayList<Switches> findByActuation(int AFname);
	public ArrayList<Switches> findByTactile(int TFname);
	public ArrayList<Switches> findByManufacturerAndType(String Mname, String Tname);
	public ArrayList<Switches> findByActuationGreaterThanEqual(int AFname);
	public ArrayList<Switches> findByActuationLessThanEqual(int AFname);
	public ArrayList<Switches> findByActuationBetween(int AF1, int AF2);
	public ArrayList<Switches> findByTactileGreaterThanEqual(int TFname);
	public ArrayList<Switches> findByTactileLessThanEqual(int TFname);
	public ArrayList<Switches> findByTactileBetween(int TF1, int TF2);
	public ArrayList<Switches> save(ArrayList<Switches> switches); 
	
}
