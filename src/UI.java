import java.util.List;
import java.util.Scanner;

public class UI {
    private IVehicleRepository repository;
    private Scanner sc;

    public UI () {
        this.repository = new VehicleRepositoryImpl();
        this.sc = new Scanner(System.in);
    }

    boolean functions(){
        System.out.println("\n=== CAR RENTAL ===");
        System.out.println("1 - Wyświetl pojazdy ");
        System.out.println("2 - Wypożycz pojazd");
        System.out.println("3 - Zwróć pojazd");
        System.out.println("4 - Wyjście");
        System.out.print("Wybierz opcję: ");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i){
            case 1:
                List<Vehicle> list = repository.getVehicles();
                for (Vehicle v : list){
                    System.out.println(v.toString());
                }
                break;
            case 2:
                System.out.print("Podaj ID pojazdu do wypożyczenia: ");
                String rentId = sc.nextLine();
                repository.rentVehicle(rentId);
                break;
            case 3:
                System.out.print("Podaj ID pojazdu zwracanego: ");
                String retId = sc.nextLine();
                repository.returnVehicle(retId);
                break;
            case 4:
                System.out.println("Program ended.");
                return true;
        }
        return false;
    }
}
