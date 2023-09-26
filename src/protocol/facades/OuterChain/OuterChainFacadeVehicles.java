package protocol.facades.OuterChain;

import api.exposed.outerChainExposed.OuterChainExposed;
import api.storage.models.Vehicles;
import api.storage.operations.OuterChainOperations.OuterChainOperationsVehicles.OuterChainVehiclesOperations;
import protocol.interfaces.ProtocolFacade;

public class OuterChainFacadeVehicles implements ProtocolFacade<Vehicles> {
    OuterChainVehiclesOperations vehicleOperations = new OuterChainExposed().getOperationsVehicles();

    @Override
    public void list() {
        vehicleOperations.list();
    }

    @Override
    public void delete(Vehicles node) {
        vehicleOperations.delete(node);
    }

    @Override
    public Vehicles update(Vehicles node) {
        vehicleOperations.update(node);
        return node;
    }

    @Override
    public void insert(Vehicles node) {
        vehicleOperations.insert(node);
    }

    @Override
    public void findBy(int value) {
        vehicleOperations.findBy(value);
    }
}
