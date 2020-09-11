package com.ecommerce.microcommerce.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ecommerce.microcommerce.annotations.PrixSuperieurAuPrixAchat;
import com.ecommerce.microcommerce.model.Product;

public class PrixMatchValidator implements ConstraintValidator<PrixSuperieurAuPrixAchat, Product> {

	@Override
	public void initialize(PrixSuperieurAuPrixAchat constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Product value, ConstraintValidatorContext context) {
		if (value.getPrixAchat() > value.getPrix()) {
			// Pour éviter la duplication de messages d'erreurs avec celui par défaut
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Le prix d'achat (" + value.getPrixAchat()
					+ ") doit être moins élevé que le prix de vente (" + value.getPrix() + ")")
					.addConstraintViolation();
			return false;
		}
		return true;
	}

}
