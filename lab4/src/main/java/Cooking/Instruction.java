package Cooking;

public enum Instruction {
    BOIL("варить"), FRY("жарить"),
    ADD_TO_POT("добавлять в кастрюлю"), FILL_POT_WITH_WATER("наполнять кастрюлю водой"),
    FIRE("нагревать место для готовки");

    private final String phrase;

    Instruction(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
