package Physical.Position;

public enum RelativePos {
    ABOVE("над"), UNDER("под"), BEHIND("сзади"),
    INFRONT("перед"), NAILED("прибит к"), UNKNOWN("UNKNOWN");

    private final String phrase;

    RelativePos(String phrase) {
        this.phrase = phrase;
    }

    public RelativePos getOpposite(){
        switch (this){
            case ABOVE:
                return UNDER;
            case BEHIND:
                return INFRONT;
            case INFRONT:
                return BEHIND;
            case NAILED:
                return NAILED;
            case UNDER:
                return ABOVE;
            default:
                return UNKNOWN;
        }
    }

    public String getPhrase() {
        return phrase;
    }
}
