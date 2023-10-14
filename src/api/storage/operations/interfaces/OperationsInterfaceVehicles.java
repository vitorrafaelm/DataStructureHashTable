package api.storage.operations.interfaces;

public interface OperationsInterfaceVehicles<T> {

    void list(); // Method adjusted
    void delete(String keyToDelete); // Method adjusted
    void update(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF);
    void insert(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF);
    void findBy(String value);
}
