package protocol.facades.OpenAddress;

import api.exposed.openAddressExposed.OpenAddressExposed;
import api.storage.models.Vehicles;
import api.storage.operations.OpenAddressOperations.OpenAddressOperationsVehicles.OpenAddressOperationsVehicles;
import protocol.interfaces.ProtocolFacade;

public class OpenAddressFacadeVehicles implements ProtocolFacade<Vehicles> {

    OpenAddressOperationsVehicles vehicleOperations = new OpenAddressExposed().getOperationsVehicles();

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
