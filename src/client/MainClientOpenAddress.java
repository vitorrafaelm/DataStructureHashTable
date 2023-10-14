package client;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;
import protocol.facades.OpenAddress.OpenAddressFacadeDriver;
import protocol.facades.OpenAddress.OpenAddressFacadeVehicles;
import protocol.facades.OuterChain.OuterChainFacadeDriver;
import protocol.facades.OuterChain.OuterChainFacadeVehicles;
import utils.exposed.CompressionExposedMethods;
import utils.implementation.CompressionImplementation;

import java.util.Random;
import java.util.UUID;

public class MainClientOpenAddress {

    public static void main(String[] args) {
        CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();

        Random gerador = new Random();
        OpenAddressFacadeDriver openAddressFacadeDriver = new OpenAddressFacadeDriver();
        OpenAddressFacadeVehicles openAddressFacadeVehicles = new OpenAddressFacadeVehicles();

        String documentEncoded = compressionExposedMethods.encode("704634");
        String nameEncoded = compressionExposedMethods.encode("Victor");

        openAddressFacadeDriver.insert(documentEncoded, nameEncoded);
        openAddressFacadeDriver.list();

        String uuid1 = null;
        String uuid2 = null;

        for (Integer i = 1; i <= 50; i++) {
            Integer randomNumber = Math.abs(gerador.nextInt());
            UUID idOne = UUID.randomUUID();

            if(i == 2) uuid1 = randomNumber.toString();
            if(i == 3) uuid2 = randomNumber.toString();

            String licensePlate = compressionExposedMethods.encode((idOne.toString()).substring(0, 3) + "2432");
            String reindeer = compressionExposedMethods.encode(randomNumber.toString());
            String carModel = compressionExposedMethods.encode("celta 10 " + randomNumber);
            String created = compressionExposedMethods.encode("2022-06-18");

            openAddressFacadeVehicles.insert(
                    licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
            );
        }

        System.out.println("First list of items -------------------------------------");
        openAddressFacadeVehicles.list();

        System.out.println("2 searches --------------------------------- " + uuid1 + " and " + uuid2);
        openAddressFacadeVehicles.findBy(compressionExposedMethods.encode(uuid1));
        openAddressFacadeVehicles.findBy(compressionExposedMethods.encode(uuid2));

        System.out.println("Insert first register and get Quantity and List -------------------------------------");
        Integer randomNumber = Math.abs(gerador.nextInt());
        UUID idOne = UUID.randomUUID();

        String licensePlate = compressionExposedMethods.encode((idOne.toString()).substring(0, 3) + "2432");
        String reindeer = compressionExposedMethods.encode(randomNumber.toString());
        String carModel = compressionExposedMethods.encode("celta 10 " + randomNumber);
        String created = compressionExposedMethods.encode("2022-06-18");

        openAddressFacadeVehicles.insert(
                licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
        );

        System.out.println("Search for the register inserted ------------------------------------- " + randomNumber.toString());
        openAddressFacadeVehicles.findBy(reindeer);


        System.out.println("Update register ------------------------------------- " + randomNumber.toString());
        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
        UUID idOneToUpdate = UUID.randomUUID();

        licensePlate = compressionExposedMethods.encode((idOneToUpdate.toString()).substring(0, 3) + "2432");
        carModel = compressionExposedMethods.encode("celta 10 " + randomNumberToUpdate.toString());
        created = compressionExposedMethods.encode("2022-06-18");

        openAddressFacadeVehicles.update(
                licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
        );

        System.out.println("Search for the register UPDATED ------------------------------------- " + randomNumber.toString());
        openAddressFacadeVehicles.findBy(reindeer);

        System.out.println("Two deletes ------------------------------------- chassi ");
        openAddressFacadeVehicles.findBy(compressionExposedMethods.encode(uuid1));
        openAddressFacadeVehicles.findBy(reindeer);

        openAddressFacadeVehicles.delete(reindeer);
        openAddressFacadeVehicles.delete(compressionExposedMethods.encode(uuid1));

        System.out.println("Last listing");
        openAddressFacadeVehicles.list();
    }
}
