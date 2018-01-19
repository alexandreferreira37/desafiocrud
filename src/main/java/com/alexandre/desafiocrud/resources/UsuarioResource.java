//Classe para mapear as rotas utilizando as funções do spring framework

package com.alexandre.desafiocrud.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexandre.desafiocrud.domain.Usuario;
import com.alexandre.desafiocrud.dto.UsuarioDTO;
import com.alexandre.desafiocrud.services.UsuarioService;

@RestController
@RequestMapping(value="/user")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;		

	@RequestMapping (value="/{id}",method=RequestMethod.GET )
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
				
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
			
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO objDTO){
		Usuario obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();		
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<Void> updatePatch(@Valid @RequestBody UsuarioDTO objDTO, @PathVariable Integer id){
		Usuario obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);		
		return ResponseEntity.noContent().build();
	}		

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}		
	
}
