import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepositoryImpl implements IVehicleRepository {
    List<Vehicle> vehicles;

    @Override
    public void rentVehicle ( int id ) {
        for( Vehicle vehicle : vehicles ){
            if(vehicle.getId().equals(id)){
                if(!vehicle.isRented()){
                    System.out.println("Rented vehicle.");
                    vehicle.setRented(true);
                }
                else {
                    System.out.println("Can not rent vehicle, vehicle is already rented!");
                }
                break;
            }
        }
    }

    @Override
    public Vehicle returnVehicle ( int id ) {
        for( Vehicle vehicle : vehicles ){
            if(vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        System.out.println("Vehicle not found.");
        return null;
    }

    @Override
    public List<Vehicle> getVehicles ( ) {
        List<Vehicle> retVehicles = new ArrayList<>();
        for( Vehicle vehicle : vehicles){
            Vehicle newVehicle;
            if(vehicle.getClass().equals(Car.class)){
                newVehicle = new Car((Car) vehicle);
            }
            else{
                newVehicle = new Motorcycle((Motorcycle) vehicle);
            }
            retVehicles.add(newVehicle);
        }
        return retVehicles;
    }

    @Override
    public void save ( String filename ) {
        String str = "";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for ( Vehicle vehicle : vehicles ){
                str = str + vehicle.toCsv() + "\n";
            }
            writer.write(str);
            System.out.println("Vehicles saved.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    @Override
    public void load ( String filename ) {
        File file = new File(filename);
        try(Scanner myReader = new Scanner(file)){
            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] data = line.split(";");
                if(data[0].equals("CAR")){
                    Car car = new Car(
                            data[1], data[2], data[3], Integer.parseInt(data[4]),
                            Float.parseFloat(data[5]), Boolean.parseBoolean(data[6]));
                    vehicles.add(car);
                }
                else{
                    Motorcycle motorcycle = new Motorcycle(
                            data[1], data[2], data[3], Integer.parseInt(data[4]),
                            Float.parseFloat(data[5]), Boolean.parseBoolean(data[6]), data[7]);
                    vehicles.add(motorcycle);
                }
            }
            System.out.println("Vehicles loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e);
        }
        this.vehicles = vehicles;
    }

    public VehicleRepositoryImpl ( List<Vehicle> vehicles ) {
        this.vehicles = vehicles;
    }

    public VehicleRepositoryImpl ( String filepath ) {
        load(filepath);
    }

    public VehicleRepositoryImpl ( ) {
        vehicles = new ArrayList<>();
        load("C:\\Users\\student\\IdeaProjects\\Car_rental\\src\\vehicles.txt");
    }
}
