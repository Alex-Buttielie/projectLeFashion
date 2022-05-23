package br.com.lefashion.clothingstore.store.constants;

public enum MonthsOfTheYear {

    JANUARY (1, "Janeiro"),
    FEBRUARY (2, "Fevereiro"),
    MARCH (3, "Março"),
    APRIL (4, "Abril"),
    MAY (5, "Maio"),
    JUNE (6, "Junho"),
    JULY (7, "Julho"),
    AUGUST (8, "Agosto"),
    SEPTEMBER (9, "Setembro"),
    OCTOBER (10, "Outubro"),
    NOVEMBER (11, "Novembro"),
    DECEMBER (12, "Dezembro");

    private String description;
    private Number code;

    MonthsOfTheYear(Number code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription () {
        return description;
    }

    public Number getCode () {
        return code;
    }
}
