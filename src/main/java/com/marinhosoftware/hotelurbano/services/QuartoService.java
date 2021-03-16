package com.marinhosoftware.hotelurbano.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.repositories.QuartoRepository;

@Service
public class QuartoService {
	
	@Autowired
	private QuartoRepository repo;
	
	public Quarto find(Integer id) {
		Optional<Quarto> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
