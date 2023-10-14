package api.storage.operations.OpenAddressOperations.OpenAddressOperationsVehicles;

import api.storage.database.openAddress.VehicleOpenAddressHash.VehicleOpenAddressHash;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.OperationsInterfaceVehicles;
import utils.exposed.CompressionExposedMethods;
import utils.implementation.CompressionImplementation;

public class OpenAddressOperationsVehicles implements OperationsInterfaceVehicles<Vehicles> {

    VehicleOpenAddressHash<Vehicles> vehiclesVehicleOpenAddressHash = new VehicleOpenAddressHash<>(59);
    CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();

    @Override
    public void list() {
        vehiclesVehicleOpenAddressHash.print();
    }

    public void delete(String keyToDelete) {
        String keyToDeleteDecoded = compressionExposedMethods.decode(keyToDelete);
        vehiclesVehicleOpenAddressHash.deleteOpenAddressNode(Integer.parseInt(keyToDeleteDecoded));
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

        vehiclesVehicleOpenAddressHash.insert(Integer.parseInt(reindeer), vehicles);
    }

    public void update(String licensePlate, String reindeer, String modelName, String createdVehicleDate, String Drivername, String DriverCPF) {

        licensePlate = compressionExposedMethods.decode(licensePlate);
        reindeer = compressionExposedMethods.decode(reindeer);
        modelName = compressionExposedMethods.decode(modelName);
        createdVehicleDate = compressionExposedMethods.decode(createdVehicleDate);
        Drivername = compressionExposedMethods.decode(Drivername);
        DriverCPF = compressionExposedMethods.decode(DriverCPF);

        Vehicles vehicles = new Vehicles();
        vehicles.setLicensePlate(licensePlate);
        vehicles.setModelName(modelName);
        vehicles.setCreatedVehicleDate(createdVehicleDate);
        vehicles.setDrivername(Drivername);
        vehicles.setDriverCPF(DriverCPF);

        vehiclesVehicleOpenAddressHash.updateOpenAddressNode(Integer.parseInt(reindeer), vehicles);
    }

    @Override
    public void findBy(String value) {
        String keyToDeleteDecoded = compressionExposedMethods.decode(value);
        vehiclesVehicleOpenAddressHash.search(Integer.parseInt(keyToDeleteDecoded));
    }
}
