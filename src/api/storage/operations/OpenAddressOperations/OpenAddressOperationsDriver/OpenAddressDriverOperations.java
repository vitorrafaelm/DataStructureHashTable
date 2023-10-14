package api.storage.operations.OpenAddressOperations.OpenAddressOperationsDriver;

import api.storage.database.openAddress.DriverOpenAddressHash.DriversOpenAddressHash;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.OperationsInterfaceDrivers;
import utils.exposed.CompressionExposedMethods;
import utils.implementation.CompressionImplementation;

public class OpenAddressDriverOperations implements OperationsInterfaceDrivers<Drivers> {
    DriversOpenAddressHash<Drivers> driversOpenAddressHash = new DriversOpenAddressHash<>(7);
    CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();

    @Override
    public void insert(String document, String name) {
        String decodedDocument = compressionExposedMethods.decode(document);
        String decodedName = compressionExposedMethods.decode(name);

        Drivers driver = new Drivers();
        driver.setCPF(decodedDocument);
        driver.setName(decodedName);
        driversOpenAddressHash.insert(Integer.parseInt(driver.getCPF()), driver);
    }

    @Override
    public void list() {
        driversOpenAddressHash.print();
    }
}
