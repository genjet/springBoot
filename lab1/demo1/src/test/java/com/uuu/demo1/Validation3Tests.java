package com.uuu.demo1;


import com.uuu.demo1.beans.NormalUser2;
import com.uuu.demo1.beans.NormalUser3;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Validation3Tests {
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
    public void nameWithContentShouldNotBlank() {
        NormalUser3 user1 = new NormalUser3();
        user1.setName("abc");
        Set<ConstraintViolation<NormalUser3>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 0);
    }
    @Test
    public void nameWithSpacesShouldNotBlank() {
        NormalUser3 user1 = new NormalUser3();
        user1.setName("      ");
        Set<ConstraintViolation<NormalUser3>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 1);
    }
    @Test
    public void nameWithEmptyStringShouldNotBlank() {
        NormalUser3 user1 = new NormalUser3();
        user1.setName("");
        Set<ConstraintViolation<NormalUser3>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        Assertions.assertEquals(validates.size(), 1);
    }
    @Test
    public void nameWithNullShouldBeEmpty() {
        NormalUser3 user1 = new NormalUser3();
        Set<ConstraintViolation<NormalUser3>> validates = validator.validate(user1);
        System.out.println("violation count=" + validates.size());
        for(ConstraintViolation<NormalUser3> v : validates) {
            System.out.println("violation is:" + v);
            System.out.println("this violation message is:" + v.getMessage());
        }
        Assertions.assertEquals(validates.size(), 1);
    }
}