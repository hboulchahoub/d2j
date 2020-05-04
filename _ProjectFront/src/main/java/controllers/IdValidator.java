package controllers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdConstraint, Integer>{

	@Override
	public boolean isValid(Integer id, ConstraintValidatorContext context) {
		return (""+id).matches("[5-7]");
	}

}
