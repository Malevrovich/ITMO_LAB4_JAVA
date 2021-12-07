package Physical;

abstract public class PhysicalObject{
    private final String name;
    private boolean isLeaned;

    public void forceBy(PhysicalObject src, boolean isReturnable) {
        System.out.println(src.getName() + " толкает " + this.getName());

        if(isReturnable){
            src.forceBy(this, false);
        }
    }

    public void forceBy(PhysicalObject src) {forceBy(src, true);}

    protected PhysicalObject(String name) {
        this.name = name;
    }

    public boolean isLeaned() {
        return isLeaned;
    }

    public void setLeaned(boolean leaned) {
        isLeaned = leaned;
    }

    public String getName() {
        return name;
    }
}
