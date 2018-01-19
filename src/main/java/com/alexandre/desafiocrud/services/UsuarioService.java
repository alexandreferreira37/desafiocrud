package com.alexandre.desafiocrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.desafiocrud.domain.Usuario;
import com.alexandre.desafiocrud.dto.UsuarioDTO;
import com.alexandre.desafiocrud.repositories.UsuarioRepository;
import com.alexandre.desafiocrud.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {	

	@Autowired
	private UsuarioRepository repo; 
	
	public Usuario find(Integer id) {
		
		Usuario obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo:" + Usuario.class.getName());			
		}
		
		return obj;
	}	
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {		
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {		
		find(id);
		repo.delete(id);
	}
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getName(), objDTO.getLogin(), objDTO.getPass());
				
	}
	
}