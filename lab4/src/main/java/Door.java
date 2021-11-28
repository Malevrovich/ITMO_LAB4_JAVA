public class Door {
    private final Place lhs;
    private final Place rhs;
    private boolean open = false;

    protected Door(Place lhs, Place rhs){
        this.lhs = lhs;
        this.rhs = rhs;

        lhs.addDoor(this);
        rhs.addDoor(this);
    }

    public boolean isOpen() {
        return open;
    }

    public Place getRhs() {
        return rhs;
    }

    public Place getLhs() {
        return lhs;
    }
}
