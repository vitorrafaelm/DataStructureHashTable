package protocol.facades.OpenAddress;

import api.exposed.openAddressExposed.OpenAddressExposed;
import api.storage.operations.OpenAddressOperations.OpenAddressOperationsDriver.OpenAddressDriverOperations;

public class OpenAddressFacadeDriver {
    OpenAddressDriverOperations openAddressExposedDrivers = new OpenAddressExposed().getOperationsDrivers();

    public void list() {
        openAddressExposedDrivers.list();
    }

    public void insert(String document, String name) {
        openAddressExposedDrivers.insert(document, name);
    }
}
