package protocol.facades.OuterChain;

import api.exposed.outerChainExposed.OuterChainExposed;
import api.storage.models.Drivers;
import api.storage.operations.OuterChainOperations.OuterChainOperationsDriver.OuterChainDriverOperations;
import protocol.interfaces.ProtocolFacade;

public class OuterChainFacadeDriver implements ProtocolFacade<Drivers> {

    OuterChainDriverOperations outerChainExposedDrivers = new OuterChainExposed().getOperationsDrivers();

    @Override
    public void list() {
        outerChainExposedDrivers.list();
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
        outerChainExposedDrivers.insert(node);
    }

    @Override
    public void findBy(int value) {

    }
}
