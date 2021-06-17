package com.psiber.tax.model;

import java.util.Map;

public class TaxTable {

    private int year;
    private Map<IncomeBracket, IncomeRate> taxLevels;
    private Map<AgeBracket, Money> rebates;
    private Map<AgeBracket, Money> thresholds;
    private Map<MedAidCredits, Money> medAidCredits;

    public TaxTable(int year, Map<IncomeBracket, IncomeRate> taxLevels,
                    Map<AgeBracket, Money> rebates, Map<AgeBracket, Money> thresholds,
                    Map<MedAidCredits, Money> medAidCredits){
        this.year = year;
        this.taxLevels = taxLevels;
        this.rebates = rebates;
        this.thresholds = thresholds;
        this.medAidCredits = medAidCredits;
    }

    public int getYear() {
        return year;
    }

    public Map<IncomeBracket, IncomeRate> getTaxLevels() {
        return taxLevels;
    }

    public Map<AgeBracket, Money> getRebates() {
        return rebates;
    }

    public Map<AgeBracket, Money> getThresholds() {
        return thresholds;
    }

    public Map<MedAidCredits, Money> getMedAidCredits() { return medAidCredits; }

    public static class IncomeBracket{
        private final int level;
        private final Money min;
        private final Money max;

        public IncomeBracket(int level, Money min, Money max){
            this.level = level;
            this.min = min;
            this.max = max;
        }

        public int getLevel() {
            return level;
        }

        public Money getMin() {
            return min;
        }

        public Money getMax() {
            return max;
        }

    }

    public static class IncomeRate{
        private final int level;
        private final Money baseAmount;
        private final double percent;

        public IncomeRate(int level, Money baseAmount, double percent){
            this.level = level;
            this.baseAmount = baseAmount;;
            this.percent = percent;
        }

        public int getLevel() {
            return level;
        }

        public Money getBaseAmount() {
            return baseAmount;
        }

        public double getPercent() {
            return percent;
        }
    }

    public static class Money{
        private final int amount;
        private String undefined = "";

        public Money(int amount){
            this.amount = amount;
        }

        public Money(int amount, String undefined){
            this.amount = amount;
            this.undefined = undefined ;
        }

        public int getAmount() {
            return amount;
        }

        public String rands(){
            return "R" + amount;
        }
    }

    public static enum AgeBracket{
        BELOW_65("Primary", 1, 64),
        BELOW_75("Secondary", 65, 74),
        ABOVE_74("Tertiary", 75, 120);

        private String type;
        private int min;
        private int max;

        AgeBracket(String type, int min, int max){
            this.type = type;
            this.min = min;
            this.max = max;
        }

        public String getType() {
            return type;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

    public static enum MedAidCredits{
        TAX_PAYER("per month for the taxpayer who paid the medical scheme contributions"),
        FIRST_DEP( "per month for the first dependant"),
        ADD_DEP("per month for each additional dependant(s)");

        private String description;

        MedAidCredits(String description){
            this.description = description;
        }

        String description(){
            return this.description;
        }

    }

}
