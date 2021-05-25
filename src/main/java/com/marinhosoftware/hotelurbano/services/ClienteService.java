package com.marinhosoftware.hotelurbano.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinhosoftware.hotelurbano.domain.Cliente;
import com.marinhosoftware.hotelurbano.domain.enums.Sexo;
import com.marinhosoftware.hotelurbano.dto.ClienteDTO;
import com.marinhosoftware.hotelurbano.repositories.ClienteRepository;
import com.marinhosoftware.hotelurbano.services.exceptions.DataIntegrityException;
import com.marinhosoftware.hotelurbano.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("NÃO É POSSÍVEL EXCLUIR UM CLIENTE QUE POSSUI RESERVAS REGISTRADAS");
		}
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getRg(), objDto.getCpf(), objDto.getEmail(), Sexo.toEnum(objDto.getSexo()));
		cli.getTelefones().add(objDto.getTelefone1());
		if ( objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		return cli;
	} 

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
}
