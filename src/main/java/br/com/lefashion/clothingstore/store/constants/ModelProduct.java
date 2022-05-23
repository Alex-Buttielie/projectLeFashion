package br.com.lefashion.clothingstore.store.constants;

public enum ModelProduct {

    SKIRT (1, "Saia"),
    BLOUSE (2, "Blusa"),
    PANTS (3, "Calça"),
    DREES (4, "Vestido"),
    SHORT (5, "Shorts"),
    JACKET (6, "Jaqueta"),
    TAKE_IT_FALL (7, "Tomara que caia"),
    REGATTA (8, "Regata"),
    TOPE (9, "Top"),
    T_SHIRT (10, "Camiseta"),
    SHIRT (11, "Camisa"),
    BODY (12, "Body");

    private String description;
    private Number code;

    ModelProduct (Number code, String description) {
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
