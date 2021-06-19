package com.psiber.tax.controller;

import com.psiber.tax.model.TaxQuery;
import com.psiber.tax.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxDataController {

    private final TaxService service;

    @Autowired
    public TaxDataController(TaxService service) {
        this.service = service;
    }


    public ResponseEntity<?> taxCalculation(TaxQuery query){
        return ResponseEntity.ok(service.calculate(query));
    }

    public ResponseEntity<?> allTaxTables(){
        return ResponseEntity.ok(service.allTaxData());
    }

    public ResponseEntity<?> taxTablePerYear(int year){
        return ResponseEntity.ok(service.taxData(year));
    }

}
