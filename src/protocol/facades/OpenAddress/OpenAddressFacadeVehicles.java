package protocol.facades.OpenAddress;

import api.exposed.openAddressExposed.OpenAddressExposed;
import api.storage.operations.OpenAddressOperations.OpenAddressOperationsVehicles.OpenAddressOperationsVehicles;

public class OpenAddressFacadeVehicles {

    OpenAddressOperationsVehicles vehicleOperations = new OpenAddressExposed().getOperationsVehicles();

    public void list() {
        vehicleOperations.list();
    }

    public void delete(String valueToDelete) {
        vehicleOperations.delete(valueToDelete);
    }

    public void update(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF) {
        vehicleOperations.update(licensePlate, reindeer, modelName, createdVehicleDate, Drivername, DriverCPF);
    }
    public void insert(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF) {
        vehicleOperations.insert(licensePlate, reindeer, modelName, createdVehicleDate, Drivername, DriverCPF);
    }

    public void findBy(String value) {
        vehicleOperations.findBy(value);
    }
}
