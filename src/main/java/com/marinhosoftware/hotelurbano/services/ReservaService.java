package com.marinhosoftware.hotelurbano.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinhosoftware.hotelurbano.domain.Reserva;
import com.marinhosoftware.hotelurbano.repositories.ReservaRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.ObjectNotFoundException;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repo;
	
	public Reserva find(Integer id) {
		Optional<Reserva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Reserva.class.getName()));
	}

}
