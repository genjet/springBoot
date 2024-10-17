package com.uuu.demo3.controllers.rest;

import com.uuu.demo3.counter.Counter1;
import com.uuu.demo3.counter.Counter2;
import com.uuu.demo3.counter.Counter3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
public class Rest2Controller {

    @Autowired
    private Counter1 counter1;
    @Autowired
    private Counter2 counter2;
    @Autowired
    private Counter3 counter3;

    @GetMapping("/rest2")
    public ResponseEntity<?> doRest2() {
        Map<String, Integer> result = new TreeMap<>();
        counter1.setValue(counter1.getValue() + 5);
        counter2.setValue(counter2.getValue() + 5);
        counter3.setValue(counter3.getValue() + 5);
        result.put("Counter1", counter1.getValue());
        result.put("Counter2", counter2.getValue());
        result.put("Counter3", counter3.getValue());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
