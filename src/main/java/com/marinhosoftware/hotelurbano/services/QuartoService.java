package com.marinhosoftware.hotelurbano.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.repositories.QuartoRepository;
import com.marinhosoftware.hotelurbano.serivces.exceptions.DataIntegrityException;
import com.marinhosoftware.hotelurbano.serivces.exceptions.ObjectNotFoundException;

@Service
public class QuartoService {
	
	@Autowired
	private QuartoRepository repo;
	
	public Quarto find(Integer id) {
		Optional<Quarto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Quarto.class.getName()));
	}
	
	public Quarto insert(Quarto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Quarto update(Quarto obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("NÃO É POSSÍVEL EXCLUIR UM QUARTO QUE POSSUI RESERVAS E/OU MANUTENÇÕES REGISTRADAS");
		}
	}
	
	public List<Quarto> findAll() {
		return repo.findAll();
	}

}
