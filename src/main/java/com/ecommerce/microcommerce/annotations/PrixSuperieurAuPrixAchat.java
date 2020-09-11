package com.ecommerce.microcommerce.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ecommerce.microcommerce.validator.PrixMatchValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrixMatchValidator.class)
public @interface PrixSuperieurAuPrixAchat {
	String message() default "Le prix d'achat doit être moins élevé que le prix de vente";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
