package controllers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<TitleConstraint, String>{

	@Override
	public boolean isValid(String title, ConstraintValidatorContext context) {
		// REGEX
		String regex="([a-zA-Z]{3})\\.(\\d{2})\\.@A+";
		return true;
	}

}
