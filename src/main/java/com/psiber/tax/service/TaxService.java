package com.psiber.tax.service;

import com.psiber.tax.model.TaxData;
import com.psiber.tax.model.TaxQuery;
import com.psiber.tax.model.TaxResponse;

import java.util.List;


public interface TaxService {

    TaxResponse calculate(TaxQuery query);
    List<TaxData> allTaxData();
    TaxData taxData(Integer year);

}
