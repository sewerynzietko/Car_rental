import java.util.List;

public interface IVehicleRepository {
    void rentVehicle(int id);
    Vehicle returnVehicle(int id);
    List<Vehicle> getVehicles();
    void save(String filepath);
    void load(String filepath);
}
