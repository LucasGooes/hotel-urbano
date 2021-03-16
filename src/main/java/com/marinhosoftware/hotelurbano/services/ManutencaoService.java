package com.marinhosoftware.hotelurbano.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinhosoftware.hotelurbano.domain.Manutencao;
import com.marinhosoftware.hotelurbano.repositories.ManutencaoRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.ObjectNotFoundException;

@Service
public class ManutencaoService {
	
	@Autowired
	private ManutencaoRepository repo;
	
	public Manutencao find(Integer id) {
		Optional<Manutencao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Manutencao.class.getName()));
	}
	
}
