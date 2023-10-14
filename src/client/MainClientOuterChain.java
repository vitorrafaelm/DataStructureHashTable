package client;

import protocol.facades.OuterChain.OuterChainFacadeDriver;
import protocol.facades.OuterChain.OuterChainFacadeVehicles;
import utils.exposed.CompressionExposedMethods;

import java.util.Random;
import java.util.UUID;

public class MainClientOuterChain {
    public static void main(String[] args) {

        CompressionExposedMethods compressionExposedMethods = new CompressionExposedMethods();

        Random gerador = new Random();
        OuterChainFacadeDriver OuterChainFacadeDriver = new OuterChainFacadeDriver();
        OuterChainFacadeVehicles OuterChainFacadeVehicles = new OuterChainFacadeVehicles();

        String documentEncoded = compressionExposedMethods.encode("704634");
        String nameEncoded = compressionExposedMethods.encode("Victor");

        System.out.println(documentEncoded);

        OuterChainFacadeDriver.insert(documentEncoded, nameEncoded);
        OuterChainFacadeDriver.list();

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

            OuterChainFacadeVehicles.insert(
                    licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
            );
        }

        System.out.println("First list of items -------------------------------------");
        OuterChainFacadeVehicles.list();

        System.out.println("2 searches --------------------------------- " + uuid1 + " and " + uuid2);
        OuterChainFacadeVehicles.findBy(compressionExposedMethods.encode(uuid1));
        OuterChainFacadeVehicles.findBy(compressionExposedMethods.encode(uuid2));

        System.out.println("Insert first register and get Quantity and List -------------------------------------");
        Integer randomNumber = Math.abs(gerador.nextInt());
        UUID idOne = UUID.randomUUID();

        String licensePlate = compressionExposedMethods.encode((idOne.toString()).substring(0, 3) + "2432");
        String reindeer = compressionExposedMethods.encode(randomNumber.toString());
        String carModel = compressionExposedMethods.encode("celta 10 " + randomNumber);
        String created = compressionExposedMethods.encode("2022-06-18");

        OuterChainFacadeVehicles.insert(
                licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
        );

        System.out.println("Search for the register inserted ------------------------------------- " + randomNumber.toString());
        OuterChainFacadeVehicles.findBy(reindeer);


        System.out.println("Update register ------------------------------------- " + randomNumber.toString());
        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
        UUID idOneToUpdate = UUID.randomUUID();

        licensePlate = compressionExposedMethods.encode((idOneToUpdate.toString()).substring(0, 3) + "2432");
        carModel = compressionExposedMethods.encode("celta 10 " + randomNumberToUpdate.toString());
        created = compressionExposedMethods.encode("2022-06-30");

        OuterChainFacadeVehicles.update(
                licensePlate, reindeer, carModel, created, nameEncoded, documentEncoded
        );

        System.out.println("Search for the register UPDATED ------------------------------------- " + randomNumber.toString());
        OuterChainFacadeVehicles.findBy(reindeer);

        System.out.println("Two deletes ------------------------------------- chassi " + uuid1 + " " + compressionExposedMethods.decode(reindeer));
        OuterChainFacadeVehicles.findBy(compressionExposedMethods.encode(uuid1));
        OuterChainFacadeVehicles.findBy(reindeer);

        OuterChainFacadeVehicles.delete(reindeer);
        OuterChainFacadeVehicles.delete(compressionExposedMethods.encode(uuid1));

        System.out.println("Last listing");
        OuterChainFacadeVehicles.list();
    }
}
