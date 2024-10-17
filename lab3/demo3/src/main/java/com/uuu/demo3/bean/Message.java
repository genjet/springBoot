package com.uuu.demo3.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Value("55")
    private int id = -987;
    @Value("default  user")
    private String name;
    private float cost;
    private boolean isValid;
    private Date date;
    private String detail;
    private String[] referral = {"John","Mark","Ken"};
    private Appendix appendix = new Appendix();
}