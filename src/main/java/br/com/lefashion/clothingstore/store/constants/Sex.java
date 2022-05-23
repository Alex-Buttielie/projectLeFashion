package br.com.lefashion.clothingstore.store.constants;

public enum Sex {

    MASCULINO (1, "Masculino"),
    FEMININO (2, "Feminino");

    private String description;
    private Number code;

    Sex(Number code, String description) {
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
