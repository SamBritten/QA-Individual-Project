package com.nationwide.keyboards.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nationwide.keyboards.entities.Sizes;

@Repository
public interface SizeRepository extends JpaRepository<Sizes, Long> {

	public ArrayList<Sizes> findAll();
	public ArrayList<Sizes> findByName(String Sname);
	
}
