package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Postagens")
@CrossOrigin("*")
/* fala par o spring que a classe é um controller
e definir por quel URI sera acessada e o parametro da URI, sempre que vier uam resquisição
no barra postagens essa requisição vai consumir essa classe
para que a API aceite origens diferentes para isso coloca o crossorigin e * porque vai 
caeiat de qualquer origem */
public class PostagemController {
	/* deixamos a resp de começar a classe para o spring com injeção de dependecia do spring
	 * o autowired */
	@Autowired
	private PostagemRepository repository; 
	@GetMapping /*Tem que falar o metodo*/
	public ResponseEntity<List<Postagem>>GettAll(){
		return ResponseEntity.ok(repository.findAll());
	}
} 	
	
