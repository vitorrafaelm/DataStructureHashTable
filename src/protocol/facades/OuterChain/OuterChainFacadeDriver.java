package protocol.facades.OuterChain;

import api.exposed.outerChainExposed.OuterChainExposed;
import api.storage.operations.OuterChainOperations.OuterChainOperationsDriver.OuterChainDriverOperations;

public class OuterChainFacadeDriver {
    OuterChainDriverOperations outerChainExposedDrivers = new OuterChainExposed().getOperationsDrivers();

    public void list() {
        outerChainExposedDrivers.list();
    }

    public void insert(String document, String name) {
        outerChainExposedDrivers.insert(document, name);
    }
}
