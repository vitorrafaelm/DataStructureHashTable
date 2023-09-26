package api.storage.database.outerChain.vehicleOuterChainHash;

import api.storage.models.Vehicles;

public class VehicleOuterChainHash<T> {
    Integer outerChainHashSize;
    VehicleOuterChainNode[] table;

    public VehicleOuterChainHash(int size) {
        this.outerChainHashSize = size;
        this.table = new VehicleOuterChainNode[size];
    }

    public int hash(int keyValue) {
        return keyValue % this.outerChainHashSize;
    }

    public void insert(int keyValueVehiclePlate, Vehicles value) {
        int hashPosition = this.hash(keyValueVehiclePlate);
        VehicleOuterChainNode node = this.table[hashPosition];

        while(node != null) {
            if(node.key == keyValueVehiclePlate) {
                break;
            }
            node = node.next;
        }

        if(node == null) {
            node = new VehicleOuterChainNode(keyValueVehiclePlate);
            node.value = value;
            node.next = this.table[hashPosition];
            this.table[hashPosition] = node;
        }
    }

    public void updateOuterChainNode(int keyToSearch, Vehicles vehicle) {
        VehicleOuterChainNode outerChainNode = this.search(keyToSearch);

        if (outerChainNode != null) {
            outerChainNode.value = vehicle;
        }
    }

    public void deleteOuterChainNode(int keyToSearch) {
        int c = this.hash(keyToSearch);
        VehicleOuterChainNode no = this.table[c];

        while (no != null) {
            if (no.key == keyToSearch) {
                if(no.next != null) {
                    no.key = no.next.key;
                    no.value = no.next.value;
                    no.next = no.next.next;
                } else {
                    no.key = null;
                    no.value = null;
                    break;
                }
            }

            no = no.next;
        }
    }

    public VehicleOuterChainNode search(int k) {
        int c = this.hash(k);
        VehicleOuterChainNode no = this.table[c];

        while(no != null) {
            if(no.key == k) {
                System.out.println(" --> { key: " + no.key + " vehicle " + no.value.toString() + " }");
                return no;
            }


            no = no.next;
        }
        return null;
    }


    public void print() {

        VehicleOuterChainNode no;

        for (int i = 0; i < this.outerChainHashSize; i++) {

            no = this.table[i];
            System.out.print(i);

            while(no != null && no.key != null && no.value != null) {
                System.out.print(" --> { key: " + no.key + " vehicle " + no.value.toString() + " }");
                no = no.next;
            }

            System.out.println();
        }

    }
}
