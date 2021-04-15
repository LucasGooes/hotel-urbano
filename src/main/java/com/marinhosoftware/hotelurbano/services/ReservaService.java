package com.marinhosoftware.hotelurbano.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.hotelurbano.domain.Reserva;
import com.marinhosoftware.hotelurbano.repositories.ReservaRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.DataIntegrityException;
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
	
	//QUARTOS E CLIENTE
	@Transactional
	public Reserva insert(Reserva obj) {
		obj.setId(null);
		obj.setDataInicio(LocalDate.now());
		obj.setDataFim(null);
		
		obj = repo.save(obj);
		return obj;
	}
	
	/*
	public Reserva update(Reserva obj) {
		Reserva newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	*/
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("NÃO É POSSÍVEL EXCLUIR UM CLIENTE QUE POSSUI RESERVAS REGISTRADAS");
		}
	}
	
	public List<Reserva> findAll() {
		return repo.findAll();
	}
	/*
	public Reserva fromDTO(ReservaDTO objDto) {
		return new Reserva(null, objDto.getNome(), objDto.getRg(), objDto.getCpf(), objDto.getEmail(), Sexo.toEnum(objDto.getSexo()));
	}

	private void updateData(Reserva newObj, Reserva obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	*/
}
