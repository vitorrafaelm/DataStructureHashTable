package api.exposed.outerChainExposed;

import api.storage.operations.OuterChainOperations.OuterChainOperationsDriver.OuterChainDriverOperations;
import api.storage.operations.OuterChainOperations.OuterChainOperationsVehicles.OuterChainVehiclesOperations;

public class OuterChainExposed {
    public OuterChainDriverOperations getOperationsDrivers() {
        return new OuterChainDriverOperations();
    }

    public OuterChainVehiclesOperations getOperationsVehicles() {
        return new OuterChainVehiclesOperations();
    }
}
