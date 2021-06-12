package com.psiber.tax.service;

import com.psiber.tax.model.TaxData;
import com.psiber.tax.model.TaxQuery;
import com.psiber.tax.model.TaxResponse;


public interface TaxService {

    TaxResponse calculate(TaxQuery query);
    TaxData allTaxData();
    TaxData taxData(Integer year);

}
