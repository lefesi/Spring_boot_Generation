
/* 	para que a classe seja interpretada no banco de dados, como uma entidade deve ter naotaçõe
 * que são arametros que definem o comportamento*/
package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotNull;/* ta diferente do video*/

@Entity
@Table(name="Postagem")

/* entity ela indica a classe que sera uma entidade do jpa enbernate
 * a table indica que a entidade no banco de dados sera uma tabela com o nome de postagens*/
public class Postagem {

	/* colocar que se trata de um id, e vai se comportar como um valor gerado
	 * com a estrategia do parametro strategy to tipo entidade e sera uma chave primaria*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	/* NÃo pode estra vazio então deve por o not null
	  * quantos caracteres podem ter, precisa do parametro main e aquantidade mx de carcteres
	   e o mmesmo para texto*/ 
	@NontNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private String titulo;
	 
	@NotNUll
	@Size(main=5 , max= 100)
	 private String texto;
	 
	 /* importa o date do java util, existe um metodo para saber a hora exata da postagem*/
	 private Date data = new java.sql.Date(System.currentTimeMillis());
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	};
	 
	}


