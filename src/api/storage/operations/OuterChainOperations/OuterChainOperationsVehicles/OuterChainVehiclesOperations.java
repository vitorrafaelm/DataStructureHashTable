package api.storage.operations.OuterChainOperations.OuterChainOperationsVehicles;

import api.storage.database.outerChain.vehicleOuterChainHash.VehicleOuterChainHash;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.OperationsInterfaceVehicles;
import utils.exposed.CompressionExposedMethods;
import utils.implementation.CompressionImplementation;

public class OuterChainVehiclesOperations implements OperationsInterfaceVehicles<Vehicles> {
    VehicleOuterChainHash<Vehicles> vehicleOuterChainHash = new VehicleOuterChainHash<>(59);
    CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();
    @Override
    public void list() {
        vehicleOuterChainHash.print();
    }

    @Override
    public void delete(String keyToDelete) {
        String keyToDeleteDecoded = compressionExposedMethods.decode(keyToDelete);

        vehicleOuterChainHash.deleteOuterChainNode(Integer.parseInt(keyToDeleteDecoded));
    }

    @Override
    public void update(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF) {
        licensePlate = compressionExposedMethods.decode(licensePlate);
        reindeer = compressionExposedMethods.decode(reindeer);
        modelName = compressionExposedMethods.decode(modelName);
        createdVehicleDate = compressionExposedMethods.decode(createdVehicleDate);
        Drivername = compressionExposedMethods.decode(Drivername);
        DriverCPF = compressionExposedMethods.decode(DriverCPF);

        Vehicles vehicles = new Vehicles();
        vehicles.setLicensePlate(licensePlate);
        vehicles.setReindeer(reindeer);
        vehicles.setModelName(modelName);
        vehicles.setCreatedVehicleDate(createdVehicleDate);
        vehicles.setDrivername(Drivername);
        vehicles.setDriverCPF(DriverCPF);

        vehicleOuterChainHash.updateOuterChainNode(Integer.parseInt(reindeer), vehicles);
    }

    @Override
    public void insert(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF) {
        licensePlate = compressionExposedMethods.decode(licensePlate);
        reindeer = compressionExposedMethods.decode(reindeer);
        modelName = compressionExposedMethods.decode(modelName);
        createdVehicleDate = compressionExposedMethods.decode(createdVehicleDate);
        Drivername = compressionExposedMethods.decode(Drivername);
        DriverCPF = compressionExposedMethods.decode(DriverCPF);

        Vehicles vehicles = new Vehicles();
        vehicles.setReindeer(reindeer);
        vehicles.setLicensePlate(licensePlate);
        vehicles.setModelName(modelName);
        vehicles.setCreatedVehicleDate(createdVehicleDate);
        vehicles.setDrivername(Drivername);
        vehicles.setDriverCPF(DriverCPF);

        vehicleOuterChainHash.insert(Integer.parseInt(reindeer), vehicles);
    }

    @Override
    public void findBy(String value) {
        String keyToDeleteDecoded = compressionExposedMethods.decode(value);
        vehicleOuterChainHash.search(Integer.parseInt(keyToDeleteDecoded));
    }
}
