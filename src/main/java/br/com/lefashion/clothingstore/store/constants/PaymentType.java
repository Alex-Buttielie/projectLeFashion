package br.com.lefashion.clothingstore.store.constants;

public enum PaymentType {

    PIX (1, "PIX"),
    CREDIT_CARD (2, "Cartão de crédito"),
    DEBITO_CARD (3, "Cartão de débido"),
    MONEY (4, "Dinheiro");

    private String description;
    private Number code;

    PaymentType(Number code, String description) {
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
