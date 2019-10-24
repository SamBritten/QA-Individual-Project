package com.nationwide.keyboards.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nationwide.keyboards.entities.Layouts;

@Repository
public interface LayoutRepository extends JpaRepository<Layouts, Long> {

	public ArrayList<Layouts> findAll();
	public ArrayList<Layouts> findByName(String Sname);
	
}