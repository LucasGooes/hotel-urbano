package com.marinhosoftware.hotelurbano.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinhosoftware.hotelurbano.domain.Servico;
import com.marinhosoftware.hotelurbano.repositories.ServicoRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
}
