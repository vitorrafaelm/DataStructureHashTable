package api.storage.database.openAddress.DriverOpenAddressHash;

import api.storage.models.Drivers;
public class DriversOpenAddressHash<T> {

    Integer tableSize;
    DriversOpenAddressNode[] table;

    public DriversOpenAddressHash(int tableSize) {
        this.tableSize = tableSize;
        this.table = new DriversOpenAddressNode[tableSize];
    }

    public int hash(int key) {
        return key % this.tableSize;
    }

    public int hash(int tablePosition, int probeValue) {
        return (tablePosition + probeValue) % this.tableSize;
    }

    public void insert(int insertionKey, Drivers value) {
        int tablePosition = this.hash(insertionKey);

        while (this.table[tablePosition] != null) {
            if (table[tablePosition].key == insertionKey) {
                break;
            }

            tablePosition = this.hash(tablePosition, 1);
        }

        if (table[tablePosition] == null) {
            table[tablePosition] = new DriversOpenAddressNode(insertionKey, value);
        }
    }

    public DriversOpenAddressNode search(int keyToSearch) {
        int itemPosition = this.hash(keyToSearch);

        while (table[itemPosition] != null) {
            if (table[itemPosition].key == keyToSearch) {
                System.out.println(" --> { key: " + table[itemPosition].key + " driver " + table[itemPosition].value.toString() + " }");
                return table[itemPosition];
            }

            itemPosition = this.hash(itemPosition, 1);;
        }

        return null;
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            DriversOpenAddressNode node = table[i];
            if (node != null) {
                System.out.println(i + " --> { key: " + node.key + ", driver " + node.value.toString() + " }");
            } else {
                System.out.println(i);
            }
        }

    }

}
