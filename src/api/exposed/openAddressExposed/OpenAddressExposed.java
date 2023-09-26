package api.exposed.openAddressExposed;

import api.storage.operations.OpenAddressOperations.OpenAddressOperationsDriver.OpenAddressDriverOperations;
import api.storage.operations.OpenAddressOperations.OpenAddressOperationsVehicles.OpenAddressOperationsVehicles;

public class OpenAddressExposed {
    public OpenAddressDriverOperations getOperationsDrivers() {
        return new OpenAddressDriverOperations();
    }

    public OpenAddressOperationsVehicles getOperationsVehicles() {
        return new OpenAddressOperationsVehicles();
    }
}
