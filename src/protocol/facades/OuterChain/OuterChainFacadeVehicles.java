package protocol.facades.OuterChain;

import api.exposed.outerChainExposed.OuterChainExposed;
import api.storage.operations.OuterChainOperations.OuterChainOperationsVehicles.OuterChainVehiclesOperations;

public class OuterChainFacadeVehicles {
    OuterChainVehiclesOperations vehicleOperations = new OuterChainExposed().getOperationsVehicles();

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
