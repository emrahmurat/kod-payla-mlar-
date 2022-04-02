package com.digivet.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digivet.ws.entities.Vet;



@Repository
public interface VetRepository extends JpaRepository<Vet, Integer > {
	Vet findByEmail(String email);
	Vet findByPassword(String Password);

	
}
