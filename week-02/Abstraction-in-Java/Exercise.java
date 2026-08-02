// Interface that defines the machine behavior
interface Machine {
    String start();
}

// Abstract class that provides common properties for all appliances
abstract class Appliance implements Machine {

    String name;

    // Constructor to initialize the appliance name
    public Appliance(String name) {
        this.name = name;
    }
}

// Fan implementation
class Fan extends Appliance {

    public Fan(String name) {
        super(name);
    }

    @Override
    public String start() {
        return "Fan is running";
    }
}

// Washing machine implementation
class WashingMachine extends Appliance {

    public WashingMachine(String name) {
        super(name);
    }

    @Override
    public String start() {
        return "Washing Machine is operating";
    }
}

public class Exercise {

    public static void main(String[] args) {

        // Create objects using interface references
        Machine fan = new Fan("Fan");
        Machine washer = new WashingMachine("Washing Machine");

        // Print the result of starting each machine
        System.out.println(fan.start());
        System.out.println(washer.start());
    }
}