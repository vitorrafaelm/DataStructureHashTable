package api.storage.database.openAddress.VehicleOpenAddressHash;

import api.storage.database.outerChain.vehicleOuterChainHash.VehicleOuterChainNode;
import api.storage.models.Vehicles;

public class VehicleOpenAddressHash<T> {

    Integer tableSize;
    VehicleOpenAddressNode[] table;

    public VehicleOpenAddressHash(int tableSize) {
        this.tableSize = tableSize;
        this.table = new VehicleOpenAddressNode[tableSize];
    }

    public int hash(int key) {
        return key % this.tableSize;
    }

    public int hash(int tablePosition, int probeValue) {
        return (tablePosition + probeValue) % this.tableSize;
    }

    public void insert(int insertionKey, Vehicles value) {
        int tablePosition = this.hash(insertionKey);

        while (this.table[tablePosition] != null) {
            if (table[tablePosition].key == insertionKey) {
                break;
            }

            tablePosition = this.hash(tablePosition, 1);
        }

        if (table[tablePosition] == null) {
            table[tablePosition] = new VehicleOpenAddressNode(insertionKey, value);
        }
    }

    public void updateOpenAddressNode(int keyToSearch, Vehicles vehicle) {
        VehicleOpenAddressNode openAddressNode = this.search(keyToSearch);

        if (openAddressNode != null) {
            openAddressNode.value = vehicle;
        }
    }

    public void deleteOpenAddressNode(int keyToSearch) {
        int c = this.hash(keyToSearch);
        this.table[c] = null;
    }

    public VehicleOpenAddressNode search(int keyToSearch) {
        int itemPosition = this.hash(keyToSearch);

        while (table[itemPosition] != null) {
            if (table[itemPosition].key == keyToSearch) {
                System.out.println(itemPosition + " --> { key: " + table[itemPosition].key + " vehicle " + table[itemPosition].value.toString() + " }");
                return table[itemPosition];
            }

            itemPosition = this.hash(itemPosition, 1);;
        }

        return null;
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            VehicleOpenAddressNode node = table[i];
            if (node != null) {
                System.out.println(i + " --> { key: " + node.key + ", vehicle " + node.value.toString() + " }");
            } else {
                System.out.println(i);
            }
        }
    }

}
