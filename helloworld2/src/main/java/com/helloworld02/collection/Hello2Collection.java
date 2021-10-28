
             /*Autor: Letícia Ferreira da Silva
	                 Data: 27.10.2021*/


    /*Atividade  2 Spring-boot (minha segunda aplicação): Crie uma aplicação spring de hello world.

A aplicação deverá conter um end-point que retorna uma string com os seus objetivos
               de aprendizagem para essa semana.*/


package com.helloworld02.collection;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")

public class Hello2Collection {
	@GetMapping
	public String hello2() {
		return " espero essa semana finalmente entender banco de dados";
	}
}
