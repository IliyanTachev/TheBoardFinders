package com.example.app.Annotations;

import com.example.app.model.RegistrationModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class isPasswordMatchingValidator implements ConstraintValidator<isPasswordMatching, Object> {
   public void initialize(isPasswordMatching constraint) {
   }

   public boolean isValid(Object userClass, ConstraintValidatorContext context) {
      if(userClass instanceof RegistrationModel)
      {
         return ((RegistrationModel) userClass).getPassword().equals(((RegistrationModel) userClass).getConfirmed_password());
      }

      return false;
   }
}
