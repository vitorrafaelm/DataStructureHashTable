package protocol.facades.OpenAddress;

import api.exposed.openAddressExposed.OpenAddressExposed;
import api.storage.models.Drivers;
import api.storage.operations.OpenAddressOperations.OpenAddressOperationsDriver.OpenAddressDriverOperations;
import protocol.interfaces.ProtocolFacade;

public class OpenAddressFacadeDriver implements ProtocolFacade<Drivers> {

    OpenAddressDriverOperations openAddressExposedDrivers = new OpenAddressExposed().getOperationsDrivers();

    @Override
    public void list() {
        openAddressExposedDrivers.list();
    }

    @Override
    public void delete(Drivers node) {

    }

    @Override
    public Drivers update(Drivers node) {
        return null;
    }

    @Override
    public void insert(Drivers node) {
        openAddressExposedDrivers.insert(node);
    }

    @Override
    public void findBy(int value) {

    }
}
