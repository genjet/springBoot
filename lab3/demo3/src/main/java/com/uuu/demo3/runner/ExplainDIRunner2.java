package com.uuu.demo3.runner;

import com.uuu.demo3.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class ExplainDIRunner2 implements CommandLineRunner {
    //    //    @Autowired
//    private final Calculator cal1;
//    // 可以使用建構子方式將物件傳入取代 autowired使用
//    public ExplainDIRunner2(Calculator cal1) {
//        this.cal1 = cal1;
//    }
    @Autowired
    @Qualifier("add")
    private Calculator cal1;
    @Autowired
    @Qualifier("sub")
    private Calculator cal2;

    @Override
    public void run(String... args) throws Exception {
        log.info("get bean from field autowired, cal1={}", cal1);
        log.info("[cal1]calculate 3 and 4 is:{}", cal1.calc(3, 4));
        log.info("[cal2]calculate 3 and 4 is:{}", cal2.calc(3, 4));
    }
}
