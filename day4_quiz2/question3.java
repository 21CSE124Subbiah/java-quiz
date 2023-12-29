import java.util.Scanner;

class Vehicle 
{
    private double speed;

    public Vehicle(double speed) 
    {
        this.speed = speed;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double calculateSpeed() 
    {
        return speed;
    }
}

class Car extends Vehicle 
{
    private int numPassengers;

    public Car(double speed, int numPassengers) 
    {
        super(speed);
        this.numPassengers = numPassengers;
    }

    @Override
    public double calculateSpeed() 
    {
        return super.getSpeed() * numPassengers;
    }
}

class Motorcycle extends Vehicle 
{
    private int numWheels;

    public Motorcycle(double speed, int numWheels) 
    {
        super(speed);
        this.numWheels = numWheels;
    }

    @Override
    public double calculateSpeed() 
    {
        return super.getSpeed() * numWheels;
    }
}

public class VehicleDemo 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Create a Car instance with user input
        System.out.print("Enter Car's speed: ");
        double carSpeed = scanner.nextDouble();

        System.out.print("Enter the number of passengers in the Car: ");
        int numPassengers = scanner.nextInt();

        Car car = new Car(carSpeed, numPassengers);

        System.out.print("Enter Motorcycle's speed: ");
        double motorcycleSpeed = scanner.nextDouble();

        System.out.print("Enter the number of wheels on the Motorcycle: ");
        int numWheels = scanner.nextInt();

        Motorcycle motorcycle = new Motorcycle(motorcycleSpeed, numWheels);

        scanner.close();

        System.out.println("\nCar Details:");
        displayVehicleDetails(car);
        System.out.println("Calculated Speed: " + car.calculateSpeed());

        System.out.println("\nMotorcycle Details:");
        displayVehicleDetails(motorcycle);
        System.out.println("Calculated Speed: " + motorcycle.calculateSpeed());

        Vehicle fastestVehicle = determineFastestVehicle(car, motorcycle);
        System.out.println("\nThe vehicle with the highest effective speed is:");
        displayVehicleDetails(fastestVehicle);
    }

    private static void displayVehicleDetails(Vehicle vehicle) 
    {
        System.out.println("Speed: " + vehicle.getSpeed());
    }

    private static Vehicle determineFastestVehicle(Vehicle vehicle1, Vehicle vehicle2) 
    {
        double speed1 = vehicle1.calculateSpeed();
        double speed2 = vehicle2.calculateSpeed();

        if (speed1 > speed2) 
        {
            return vehicle1;
        } 
        else if (speed2 > speed1) 
        {
            return vehicle2;
        } 
        else 
        {
            return null; 
        }
    }
}
