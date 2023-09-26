package api.storage.database.openAddress;

import api.storage.database.openAddress.DriverOpenAddressHash.DriversOpenAddressHash;
import api.storage.database.openAddress.VehicleOpenAddressHash.VehicleOpenAddressHash;
import api.storage.database.openAddress.VehicleOpenAddressHash.VehicleOpenAddressNode;
import api.storage.models.Drivers;
import api.storage.models.Vehicles;

import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Random gerador = new Random();
        VehicleOpenAddressHash<Vehicles> t = new VehicleOpenAddressHash<Vehicles>(50);
        DriversOpenAddressHash<Drivers> d = new DriversOpenAddressHash<>(2);

        Drivers driver1 = new Drivers();
        driver1.setCPF("704634");
        driver1.setName("Vitor");

        d.insert(Integer.parseInt(driver1.getCPF()), driver1);
        d.print();

        Integer randomNumber1 = null;
        Integer randomNumber2 = null;

        for (int i = 1; i <= 50; i++) {
            Integer randomNumber = Math.abs(gerador.nextInt());
            UUID idOne = UUID.randomUUID();

            if(i == 2) randomNumber1 = randomNumber;
            if(i == 3) randomNumber2 = randomNumber;

            Vehicles vehicles = new Vehicles();
            vehicles.setDrivername(driver1.getName());
            vehicles.setDriverCPF(driver1.getCPF());
            vehicles.setCreatedVehicleDate("2022-06-18");

            vehicles.setReindeer(randomNumber.toString());
            vehicles.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
            vehicles.setModelName("celta 1.0 " + randomNumber);

            t.insert(randomNumber, vehicles);
        }

        t.print();

        System.out.println("2 searches ---------------------------------");
        t.search(randomNumber1);
        t.search(randomNumber2);

        System.out.println("Update and list value updated -------------------------------------");
        Vehicles vehicles2 = new Vehicles();
        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
        UUID idOneToUpdate = UUID.randomUUID();

        vehicles2.setCreatedVehicleDate("2022-06-30");
        vehicles2.setReindeer(randomNumber1.toString());

        vehicles2.setLicensePlate((idOneToUpdate.toString()).substring(0, 3) + "2432");
        vehicles2.setModelName("celta 1.0 " + randomNumberToUpdate);

        t.search(randomNumber1);
        t.updateOpenAddressNode(randomNumber1, vehicles2);

        t.search(randomNumber1);

        System.out.println("Deleting + " + randomNumber1);
        t.deleteOpenAddressNode(randomNumber1);

        t.search(randomNumber1);
        t.print();

//        System.out.println("List all values before value deleted " + randomNumber1);
//        t.print();
        //t.deleteOuterChainNode(randomNumber1);

//        System.out.println("List all values after value deleted");
//        t.print();


//        System.out.println("Update and list value updated -------------------------------------");
//        Vehicles vehicles2 = new Vehicles();
//        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
//        UUID idOneToUpdate = UUID.randomUUID();
//
//        vehicles2.setCreatedVehicleDate("2022-06-30");
//        vehicles2.setReindeer(randomNumber1.toString());
//
//        vehicles2.setLicensePlate((idOneToUpdate.toString()).substring(0, 3) + "2432");
//        vehicles2.setModelName("celta 1.0 " + randomNumberToUpdate);
//        item1 = t.search(randomNumber1);
//        System.out.println(item1.value.toString());
//        t.updateOuterChainNode(randomNumber1, vehicles2);
//
//        item1 = t.search(randomNumber1);
//        System.out.println(item1.value.toString());
//
//        System.out.println("List all values before value deleted " + randomNumber1);
//        t.print();
//        t.deleteOuterChainNode(randomNumber1);
//
//        System.out.println("List all values after value deleted");
//        t.print();
    }
}
