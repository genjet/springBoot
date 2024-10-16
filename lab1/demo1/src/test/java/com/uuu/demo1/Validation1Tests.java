package com.uuu.demo1;


import com.uuu.demo1.beans.NormalUser1;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;


public class Validation1Tests {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void validatorNotNull() {
        Assertions.assertNotNull(validator);
    }

    @Test
    public void nameWithContentShouldNotNull() {
        NormalUser1 user1 = new NormalUser1();
        user1.setName("abc");
        Set<ConstraintViolation<NormalUser1>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 0);
    }
    @Test
    public void nameWithSpacesShouldNotNull() {
        NormalUser1 user1 = new NormalUser1();
        user1.setName("      ");
        Set<ConstraintViolation<NormalUser1>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 0);
    }
    @Test
    public void nameWithNullShouldTrigger() {
        NormalUser1 user1 = new NormalUser1();
        Set<ConstraintViolation<NormalUser1>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 1);
    }
}