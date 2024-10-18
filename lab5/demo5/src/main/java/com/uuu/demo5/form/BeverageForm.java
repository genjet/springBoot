package com.uuu.demo5.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeverageForm {
    private  Long id;
    private String title;
    private String detail;
    private int price;
    private float sugar;
}
