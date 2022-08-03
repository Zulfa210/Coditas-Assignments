package week3.day11.BridgePattern;

/* Implementor interface*/
interface Gear{
    void handleGear();
}

/* Concrete Implementor - 1 */
class ManualGear implements Gear{
    public void handleGear(){
        System.out.println("Manual gear");
    }
}
/* Concrete Implementor - 2 */
class AutoGear implements Gear {
    public void handleGear() {
        System.out.println("Auto gear");
    }
}