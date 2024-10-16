package com.uuu.demo1;


import com.uuu.demo1.beans.NormalUser1;
import com.uuu.demo1.beans.NormalUser2;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Validation2Tests {
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
    public void nameWithContentShouldNotEmpty() {
        NormalUser2 user1 = new NormalUser2();
        user1.setName("abc");
        Set<ConstraintViolation<NormalUser2>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 0);
    }
    @Test
    public void nameWithSpacesShouldNotEmpty() {
        NormalUser2 user1 = new NormalUser2();
        user1.setName("      ");
        Set<ConstraintViolation<NormalUser2>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 0);
    }
    @Test
    public void nameWithEmptyStringShouldNotEmpty() {
        NormalUser2 user1 = new NormalUser2();
        user1.setName("");
        Set<ConstraintViolation<NormalUser2>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 1);
    }
    @Test
    public void nameWithNullShouldBeEmpty() {
        NormalUser2 user1 = new NormalUser2();
        Set<ConstraintViolation<NormalUser2>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 1);
    }
}