package com.uuu.demo5.controller;

import com.uuu.demo5.entity.Beverage;
import com.uuu.demo5.form.BeverageForm;
import com.uuu.demo5.repository.BeverageCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class BeverageController {

    private static final String LIST_KEY = "beverages";
    private static final String ADD_KEY = "beverageForm";

    @Autowired
    private BeverageCrudRepository repository;

    @GetMapping("/beverages/all")
    public String getAllBeverage(Model model) {
        model.addAttribute(LIST_KEY, repository.findAll());
        return "beverage/list";
    }

    @GetMapping("/beverages/add")
    public String showAddBeverage(Model model) {
        BeverageForm bf = new BeverageForm();
        bf.setTitle("this is title");
        model.addAttribute(ADD_KEY, bf);
        return "beverage/add";
    }

    @PostMapping("/beverages/add")
    public String storeAddBeverage(BeverageForm form) {
//        Beverage beverage = new Beverage();
//        BeanUtils.copyProperties(form, beverage);
        Beverage beverage = getEntityFromForm(form);
        repository.save(beverage);
        log.info("form:{}", form);
        log.info("beverage:{}", beverage);
        return "redirect:/beverages/all";
    }

    @GetMapping("/beverages/delete")
    public String delBeverage(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/beverages/all";
    }

    @GetMapping("/beverages/modify")
    public String showModify(@RequestParam Long id, Model model) {
        Beverage beverage = repository.findById(id).get();
//        BeverageForm beverageForm = new BeverageForm();
//        BeanUtils.copyProperties(beverage, beverageForm);
        BeverageForm bf = getFormFromEntity(beverage);
        model.addAttribute("beverageForm", bf);
        return "beverage/modify";
    }

    @PostMapping("/beverages/modify")
    public String storeModifyBeverage(BeverageForm form) {
//        Beverage beverage = new Beverage();
//        BeanUtils.copyProperties(form, beverage);
        Beverage modifiedBeverage = getEntityFromForm(form);
        repository.save(modifiedBeverage);
        return "redirect:/beverages/all";
    }


    private BeverageForm getFormFromEntity(Beverage beverage) {
        BeverageForm form = new BeverageForm();
        BeanUtils.copyProperties(beverage, form);
        return form;
    }

    private Beverage getEntityFromForm(BeverageForm form) {
        Beverage beverage = new Beverage();
        BeanUtils.copyProperties(form, beverage);
        return beverage;
    }
}

