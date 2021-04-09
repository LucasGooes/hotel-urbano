package com.marinhosoftware.hotelurbano.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.hotelurbano.domain.Manutencao;
import com.marinhosoftware.hotelurbano.repositories.ManutencaoRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.ObjectNotFoundException;

@Service
public class ManutencaoService {
	
	@Autowired
	private ManutencaoRepository repo;
	@Autowired
	private QuartoService quartoService;
	
	public Manutencao find(Integer id) {
		Optional<Manutencao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Manutencao.class.getName()));
	}
	
	@Transactional
	public Manutencao insert(Manutencao obj) {
		obj.setId(null);
		obj.setQuarto(quartoService.find(obj.getQuarto().getId()));
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Manutencao> findAll() {
		return repo.findAll();
	}
	/*
	public Manutencao fromDTO(ManutencaoDTO objDto) {
		return new Manutencao(null, objDto.getNome(), objDto.getRg(), objDto.getCpf(), objDto.getEmail(), Sexo.toEnum(objDto.getSexo()));
	}
	*/
}
