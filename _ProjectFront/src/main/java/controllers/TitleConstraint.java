package controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TitleValidator.class)

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface TitleConstraint {
	
	public String message() default "TITLE INVALID....";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
