package com.example.demo.controller;

import com.example.demo.model.FilterBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeanFiledFilterController {

    // get filters
    @GetMapping("/filters")
    public FilterBean returnFilterBean(){
        FilterBean filter=new FilterBean("Sanajit", "sanajit@gmail.com", "8372876775", "Kolkata", "Pass@123");
        return filter;
    }

    // get all the details
    // excluding password by using MappingJacksonValue

    @GetMapping("/filter-password")
    public MappingJacksonValue returnFilterBeanExcludingPassword(){
        FilterBean filterBean= new FilterBean("Sanajit", "sanajit@gmail.com", "8372876775", "Kolkata", "Pass@123");

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(filterBean);

        SimpleBeanPropertyFilter simpleFilter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "email", "phone", "address");
        FilterProvider filters=new SimpleFilterProvider().addFilter("FilterBean", simpleFilter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    // get all the details except email and phone

}
