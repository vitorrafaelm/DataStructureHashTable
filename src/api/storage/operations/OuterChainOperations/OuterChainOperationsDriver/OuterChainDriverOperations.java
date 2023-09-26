package api.storage.operations.OuterChainOperations.OuterChainOperationsDriver;

import api.storage.database.outerChain.driverOuterChainHash.DriverOuterChainHash;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.OperationsInterfaceDrivers;

public class OuterChainDriverOperations implements OperationsInterfaceDrivers<Drivers> {
    DriverOuterChainHash<Drivers> driverOuterChainHash = new DriverOuterChainHash<>(2);

    @Override
    public void insert(Drivers node) {
        driverOuterChainHash.insert(Integer.parseInt(node.getCPF()), node);
    }

    @Override
    public void list() {
        driverOuterChainHash.print();
    }
}
