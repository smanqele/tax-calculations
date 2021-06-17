package com.psiber.tax.repository;

import java.util.*;

import com.psiber.tax.model.TaxTable;
import com.psiber.tax.model.TaxTable.*;

public class TaxRepository {

    public List<TaxTable> taxTables(){
        return Collections.unmodifiableList(Arrays.asList(tax_2021(), tax_2020()));
    }

    public List<TaxTable> addTaxTable(List<TaxTable> taxTables, TaxTable table){
        List<TaxTable> data = new ArrayList<>(taxTables);
        data.add(table);
        return Collections.unmodifiableList(data);
    }

    TaxTable tax_2021(){
        Map<IncomeBracket, IncomeRate> taxLevels = new LinkedHashMap<>();
        taxLevels.put(new IncomeBracket(1, new Money(0), new Money(205900)), new IncomeRate(1, new Money(0), 0.18));
        taxLevels.put(new IncomeBracket(2, new Money(205901), new Money(321600)), new IncomeRate(2, new Money(37062), 0.26));
        taxLevels.put(new IncomeBracket(3, new Money(321601), new Money(445100)), new IncomeRate(3, new Money(67144), 0.31));
        taxLevels.put(new IncomeBracket(4, new Money(445101), new Money(584200)), new IncomeRate(4, new Money(105429), 0.36));
        taxLevels.put(new IncomeBracket(5, new Money(584201), new Money(744800)), new IncomeRate(5, new Money(155505), 0.39));
        taxLevels.put(new IncomeBracket(6, new Money(744801), new Money(1577300)), new IncomeRate(6, new Money(218139), 0.41));
        taxLevels.put(new IncomeBracket(7, new Money(1577300), new Money(0,null)), new IncomeRate(7, new Money(559464), 0.45));

        Map<AgeBracket, Money> rebates = new LinkedHashMap<>();
        rebates.put(AgeBracket.BELOW_65, new Money(14958));
        rebates.put(AgeBracket.BELOW_75, new Money(8199));
        rebates.put(AgeBracket.ABOVE_74, new Money(2736));

        Map<AgeBracket, Money> thresholds = new LinkedHashMap<>();
        thresholds.put(AgeBracket.BELOW_65, new Money(83100));
        thresholds.put(AgeBracket.BELOW_75, new Money(128650));
        thresholds.put(AgeBracket.ABOVE_74, new Money(143850));

        Map<MedAidCredits, Money> medAidCredits = new LinkedHashMap<>();
        medAidCredits.put(MedAidCredits.TAX_PAYER, new Money(319));
        medAidCredits.put(MedAidCredits.FIRST_DEP, new Money(319));
        medAidCredits.put(MedAidCredits.ADD_DEP, new Money(215));
        return new TaxTable(2021, taxLevels, rebates, thresholds, medAidCredits);
    }

    TaxTable tax_2020(){
        Map<IncomeBracket, IncomeRate> taxLevels = new LinkedHashMap<>();
        taxLevels.put(new IncomeBracket(1, new Money(0), new Money(195850)), new IncomeRate(1, new Money(0), 0.18));
        taxLevels.put(new IncomeBracket(2, new Money(195851), new Money(305850)), new IncomeRate(2, new Money(35253), 0.26));
        taxLevels.put(new IncomeBracket(3, new Money(305851), new Money(423300)), new IncomeRate(3, new Money(63853), 0.31));
        taxLevels.put(new IncomeBracket(4, new Money(423301), new Money(555600)), new IncomeRate(4, new Money(100263), 0.36));
        taxLevels.put(new IncomeBracket(5, new Money(555601), new Money(708310)), new IncomeRate(5, new Money(147891), 0.39));
        taxLevels.put(new IncomeBracket(6, new Money(708311), new Money(1500000)), new IncomeRate(6, new Money(207448), 0.41));
        taxLevels.put(new IncomeBracket(7, new Money(1500001), new Money(0, null)), new IncomeRate(7, new Money(532041), 0.45));

        Map<AgeBracket, Money> rebates = new LinkedHashMap<>();
        rebates.put(AgeBracket.BELOW_65, new Money(14220));
        rebates.put(AgeBracket.BELOW_75, new Money(7794));
        rebates.put(AgeBracket.ABOVE_74, new Money(2601));

        Map<AgeBracket, Money> thresholds = new LinkedHashMap<>();
        thresholds.put(AgeBracket.BELOW_65, new Money(79000));
        thresholds.put(AgeBracket.BELOW_75, new Money(122300));
        thresholds.put(AgeBracket.ABOVE_74, new Money(136750));

        Map<MedAidCredits, Money> medAidCredits = new LinkedHashMap<>();
        medAidCredits.put(MedAidCredits.TAX_PAYER, new Money(310));
        medAidCredits.put(MedAidCredits.FIRST_DEP, new Money(310));
        medAidCredits.put(MedAidCredits.ADD_DEP, new Money(209));

        return new TaxTable(2020, taxLevels, rebates, thresholds, medAidCredits);

    }

}
