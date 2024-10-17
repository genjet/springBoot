package com.uuu.demo3.counter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Counter5 {
    private Integer value = 50;
}