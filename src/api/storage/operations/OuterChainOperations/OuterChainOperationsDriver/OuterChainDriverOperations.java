package api.storage.operations.OuterChainOperations.OuterChainOperationsDriver;

import api.storage.database.outerChain.driverOuterChainHash.DriverOuterChainHash;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.OperationsInterfaceDrivers;
import utils.exposed.CompressionExposedMethods;
import utils.implementation.CompressionImplementation;

public class OuterChainDriverOperations implements OperationsInterfaceDrivers<Drivers> {
    DriverOuterChainHash<Drivers> driverOuterChainHash = new DriverOuterChainHash<>(7);
    CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();
    @Override
    public void insert(String document, String name) {
        System.out.println(document);
        String decodedDocument = compressionExposedMethods.decode(document);
        String decodedName = compressionExposedMethods.decode(name);
        System.out.println(decodedDocument);

        Drivers driver = new Drivers();
        driver.setCPF(decodedDocument);
        driver.setName(decodedName);

        driverOuterChainHash.insert(Integer.parseInt(driver.getCPF()), driver);
    }

    @Override
    public void list() {
        driverOuterChainHash.print();
    }
}
