package com.uuu.demo3.counter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@RequestScope
public class Counter3 {
    private Integer value = 30;
}