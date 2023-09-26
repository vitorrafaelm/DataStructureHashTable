package api.storage.operations.OpenAddressOperations.OpenAddressOperationsDriver;

import api.storage.database.openAddress.DriverOpenAddressHash.DriversOpenAddressHash;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.OperationsInterfaceDrivers;

public class OpenAddressDriverOperations implements OperationsInterfaceDrivers<Drivers> {

    DriversOpenAddressHash<Drivers> driversOpenAddressHash = new DriversOpenAddressHash<>(2);

    @Override
    public void insert(Drivers node) {
        driversOpenAddressHash.insert(Integer.parseInt(node.getCPF()), node);
    }

    @Override
    public void list() {
        driversOpenAddressHash.print();
    }
}
