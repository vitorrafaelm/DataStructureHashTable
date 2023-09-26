package api.storage.operations.OpenAddressOperations.OpenAddressOperationsVehicles;

import api.storage.database.openAddress.VehicleOpenAddressHash.VehicleOpenAddressHash;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.OperationsInterfaceVehicles;

public class OpenAddressOperationsVehicles implements OperationsInterfaceVehicles<Vehicles> {

    VehicleOpenAddressHash<Vehicles> vehiclesVehicleOpenAddressHash = new VehicleOpenAddressHash<>(60);

    @Override
    public void list() {
        vehiclesVehicleOpenAddressHash.print();
    }

    @Override
    public void delete(Vehicles node) {
        vehiclesVehicleOpenAddressHash.deleteOpenAddressNode(Integer.parseInt(node.getReindeer()));
    }

    @Override
    public Vehicles update(Vehicles node) {
        vehiclesVehicleOpenAddressHash.updateOpenAddressNode(Integer.parseInt(node.getReindeer()), node);
        return null;
    }

    @Override
    public void insert(Vehicles node) {
        vehiclesVehicleOpenAddressHash.insert(Integer.parseInt(node.getReindeer()), node);
    }

    @Override
    public void findBy(int value) {
        vehiclesVehicleOpenAddressHash.search(value);
    }
}
