package com.googlekeepapi.config.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinimoValidator implements ConstraintValidator<Minimo, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.length() < 10) {
			return false;
		}
		return true;
	}

}
