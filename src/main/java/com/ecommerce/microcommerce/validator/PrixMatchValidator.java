package com.ecommerce.microcommerce.validator;

import com.ecommerce.microcommerce.annotation.PrixSuperieurAuPrixAchat;
import com.ecommerce.microcommerce.model.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrixMatchValidator implements ConstraintValidator<PrixSuperieurAuPrixAchat, Product> {
    @Override
    public void initialize(PrixSuperieurAuPrixAchat prixSuperieurAuPrixAchat) {

    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context) {
        if (product.getPrix() < product.getPrixAchat()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Le prix d'achat ("
                    + product.getPrixAchat() + ") doit être moins élevé que le prix de vente (" + product.getPrix() + ")")
            .addConstraintViolation();
        }
        return false;
    }
}
