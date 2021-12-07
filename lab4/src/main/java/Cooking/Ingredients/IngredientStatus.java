package Cooking.Ingredients;

public enum IngredientStatus {
    FRIED("жареный"), BOILED("свареный"), RAW("сырой");

    private final String phrase;

    IngredientStatus(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
