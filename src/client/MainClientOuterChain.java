package client;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;
import protocol.facades.OuterChain.OuterChainFacadeDriver;
import protocol.facades.OuterChain.OuterChainFacadeVehicles;

import java.util.Random;
import java.util.UUID;

public class MainClientOuterChain {

    public static void main(String[] args) {
        Random gerador = new Random();
        OuterChainFacadeDriver OuterChainFacadeDriver = new OuterChainFacadeDriver();
        OuterChainFacadeVehicles OuterChainFacadeVehicles = new OuterChainFacadeVehicles();

        Drivers driver1 = new Drivers();
        driver1.setCPF("704634");
        driver1.setName("Vitor");

        OuterChainFacadeDriver.insert(driver1);
        OuterChainFacadeDriver.list();

        Integer uuid1 = null;
        Integer uuid2 = null;

        Vehicles vehicles;

        for (Integer i = 1; i <= 50; i++) {
            Integer randomNumber = Math.abs(gerador.nextInt());
            UUID idOne = UUID.randomUUID();

            if(i == 2) uuid1 = randomNumber;
            if(i == 3) uuid2 = randomNumber;
            vehicles = new Vehicles();
            vehicles.setDrivername(driver1.getName());
            vehicles.setDriverCPF(driver1.getCPF());
            vehicles.setCreatedVehicleDate("2022-06-18");

            vehicles.setReindeer(randomNumber.toString());
            vehicles.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
            vehicles.setModelName("celta 1.0 " + randomNumber);

            OuterChainFacadeVehicles.insert(vehicles);
        }

        System.out.println("First list of items -------------------------------------");
        OuterChainFacadeVehicles.list();

        System.out.println("2 searches --------------------------------- " + uuid1 + " and " + uuid2);
        OuterChainFacadeVehicles.findBy(uuid1);
        OuterChainFacadeVehicles.findBy(uuid2);

        System.out.println("Insert first register and get Quantity and List -------------------------------------");
        Integer randomNumber = Math.abs(gerador.nextInt());
        UUID idOne = UUID.randomUUID();

        Vehicles vehicles1 = new Vehicles();
        vehicles1.setCreatedVehicleDate("2022-06-18");

        vehicles1.setReindeer(randomNumber.toString());
        vehicles1.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
        vehicles1.setModelName("celta 1.0 " + randomNumber);

        OuterChainFacadeVehicles.insert(vehicles1);

        System.out.println("Insert second register and get Quantity and List -------------------------------------");
        randomNumber = Math.abs(gerador.nextInt());
        idOne = UUID.randomUUID();

        Vehicles vehicles2 = new Vehicles();
        vehicles2.setDrivername(driver1.getName());
        vehicles2.setDriverCPF(driver1.getCPF());
        vehicles2.setCreatedVehicleDate("2022-06-18");

        vehicles2.setReindeer(randomNumber.toString());
        vehicles2.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
        vehicles2.setModelName("celta 1.0 " + randomNumber);

        OuterChainFacadeVehicles.insert(vehicles2);

        System.out.println("Search for the two registers inserted -------------------------------------");
        OuterChainFacadeVehicles.findBy(Integer.parseInt(vehicles1.getReindeer()));
        OuterChainFacadeVehicles.findBy(Integer.parseInt(vehicles2.getReindeer()));


        System.out.println("Update register -------------------------------------");
        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
        UUID idOneToUpdate = UUID.randomUUID();

        vehicles2.setCreatedVehicleDate("2022-06-30");

        vehicles2.setLicensePlate((idOneToUpdate.toString()).substring(0, 3) + "2432");
        vehicles2.setModelName("celta 1.0 " + randomNumberToUpdate);
        OuterChainFacadeVehicles.update(vehicles2);

        System.out.println("Two deletes ------------------------------------- chassi " + vehicles2.getReindeer() + "and " + vehicles1.getReindeer());
        OuterChainFacadeVehicles.delete(vehicles1);
        OuterChainFacadeVehicles.delete(vehicles2);

        System.out.println("Last listing");
        OuterChainFacadeVehicles.list();
    }
}
