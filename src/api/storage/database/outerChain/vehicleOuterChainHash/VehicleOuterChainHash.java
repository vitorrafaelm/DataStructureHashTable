package api.storage.database.outerChain.vehicleOuterChainHash;

import api.storage.database.outerChain.vehicleOuterChainHash.autoadjust.LinkedList;
import api.storage.models.Vehicles;

public class VehicleOuterChainHash<T> {
    Integer outerChainHashSize;
    LinkedList[] table;

    public VehicleOuterChainHash(int size) {
        this.outerChainHashSize = size;
        this.table = new LinkedList[size];
    }

    public int hash(int keyValue) {
        return keyValue % this.outerChainHashSize;
    }

    public void insert(int keyValueVehiclePlate, Vehicles value) {
        int hashPosition = this.hash(keyValueVehiclePlate);

        if (this.table[hashPosition] == null) {
            this.table[hashPosition] = new LinkedList();
        }

        LinkedList node = this.table[hashPosition];
        node.inserir(keyValueVehiclePlate, value);
    }

    public void updateOuterChainNode(int keyToSearch, Vehicles vehicle) {
        int linkedListArrayPosition = this.hash(keyToSearch);
        LinkedList node = this.table[linkedListArrayPosition];

        node.update(keyToSearch, vehicle, linkedListArrayPosition);
    }

    public void deleteOuterChainNode(int keyToSearch) {
        int c = this.hash(keyToSearch);
        LinkedList node = this.table[c];

        if (node != null) {
            node.delete(keyToSearch);
        }
    }

    public VehicleOuterChainNode search(int keyToSearch) {
        int arrayPositionToSearch = this.hash(keyToSearch);
        LinkedList node = this.table[arrayPositionToSearch];

        if (node == null) {
            System.out.println("Value not found");
        } else {
            node.searchMoveForward(keyToSearch, arrayPositionToSearch);
        }

        return null;
    }


    public void print() {
        LinkedList node;
        for (int i = 0; i < this.outerChainHashSize; i++) {

            node = this.table[i];
            if (node == null) {
                System.out.print("Position " + i);
            } else {
                System.out.print("Position " + i);
                node.print();
            }
            System.out.println();
        }
    }
}
