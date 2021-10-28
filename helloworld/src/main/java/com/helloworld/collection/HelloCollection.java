
             /*Autor: Letícia Ferreira da Silva
	                 Data: 27.10.2021*/

/*Atividades Spring-boot 

Atividade  1 Spring-boot (minha primeira aplicação): Crie uma aplicação spring de hello world.

A aplicação deverá conter um end-point que retorna uma string com as habilidades 
e mentalidades que você utilizou para realizar essa atividade.*/


package com.helloworld.collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloCollection {
	@GetMapping
	public String hello() {
		return	"Nsse iniício de Spring eu estou usando muita persistência e atenção aso detalhes";
	}
	
}
