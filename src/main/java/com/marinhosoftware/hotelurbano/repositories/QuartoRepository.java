package com.marinhosoftware.hotelurbano.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marinhosoftware.hotelurbano.domain.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
	
	List<Quarto> findByStatus(int status);

}
