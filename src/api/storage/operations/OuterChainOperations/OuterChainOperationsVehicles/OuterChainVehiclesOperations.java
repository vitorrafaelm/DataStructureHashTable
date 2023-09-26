package api.storage.operations.OuterChainOperations.OuterChainOperationsVehicles;

import api.storage.database.outerChain.vehicleOuterChainHash.VehicleOuterChainHash;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.OperationsInterfaceVehicles;

public class OuterChainVehiclesOperations implements OperationsInterfaceVehicles<Vehicles> {
    VehicleOuterChainHash<Vehicles> vehicleOuterChainHash = new VehicleOuterChainHash<>(60);

    @Override
    public void list() {
        vehicleOuterChainHash.print();
    }

    @Override
    public void delete(Vehicles node) {
        vehicleOuterChainHash.deleteOuterChainNode(Integer.parseInt(node.getReindeer()));
    }

    @Override
    public Vehicles update(Vehicles node) {
        vehicleOuterChainHash.updateOuterChainNode(Integer.parseInt(node.getReindeer()), node);
        return node;
    }

    @Override
    public void insert(Vehicles node) {
        vehicleOuterChainHash.insert(Integer.parseInt(node.getReindeer()), node);
    }

    @Override
    public void findBy(int value) {
        vehicleOuterChainHash.search(value);
    }
}
