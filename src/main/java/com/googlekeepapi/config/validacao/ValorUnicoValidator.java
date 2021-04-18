package com.googlekeepapi.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, String> {

	private String campo;
	private Class<?> entidade;
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(ValorUnico parametro) {
		this.campo = parametro.campo();
		this.entidade = parametro.entidade();
	}
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {
		
		String jpql = "select 1 from "+ this.entidade.getName() +" where "+ this.campo +" =:valor";
		
		Query query = em.createQuery(jpql);
		query.setParameter("valor", valor);
		List<?> lista = query.getResultList();
		
		return lista.isEmpty();
	}
	

}
