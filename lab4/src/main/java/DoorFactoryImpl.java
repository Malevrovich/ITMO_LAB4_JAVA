public class DoorFactoryImpl implements DoorFactory {

    @Override
    public Door createDoor(Place lhs, Place rhs) {
        return new Door(lhs, rhs);
    }
}
