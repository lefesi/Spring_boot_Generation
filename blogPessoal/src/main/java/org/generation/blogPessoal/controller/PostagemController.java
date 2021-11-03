package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	/*Busca por id, primeiro especifica o metodo http enviado para a API
	 * assim que a requisição get for feio em postagem/ sera acessado o meto que ira captar a varivael pelo 
	 * path e vai retornar a interface injetada pelo Autowired,vai cahamar o metodo findbyid que pode devolver ok com o objeto 
	 * dentro do corpo da reuisição quanto  um obj caso haja um erro na requisição */
	@GetMapping("/{id}")
 	public ResponseEntity<Postagem>GetById( @PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	/* */
	public ResponseEntity<List<Postagem>>GetByTitulo( @PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
				
}

	/* novo metodo inserido*/
	@PostMapping 
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
		
		@PutMapping 
		public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
			
	}
		@DeleteMapping("/{id}")
			public void delete(@PathVariable long id) {
				repository.deleteById(id);
			}
		
}
	
