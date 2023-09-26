package api.storage.database.outerChain.driverOuterChainHash;

import api.storage.models.Drivers;
public class DriverOuterChainHash<T> {
    Integer outerChainHashSize;
    DriverOuterChainNode[] table;

    public DriverOuterChainHash(int size) {
        this.outerChainHashSize = size;
        this.table = new DriverOuterChainNode[size];
    }

    public int hash(int keyValue) {
        return keyValue % this.outerChainHashSize;
    }

    public void insert(int keyValueDriverCpf, Drivers value) {
        int hashPosition = this.hash(keyValueDriverCpf);
        DriverOuterChainNode node = this.table[hashPosition];

        while(node != null) {
            if(node.key == keyValueDriverCpf) {
                break;
            }
            node = node.next;
        }

        if(node == null) {
            node = new DriverOuterChainNode(keyValueDriverCpf);
            node.value = value;
            node.next = this.table[hashPosition];
            this.table[hashPosition] = node;
        }
    }

    public void updateOuterChainNode(int keyToSearch, Drivers value) {
        DriverOuterChainNode outerChainNode = this.search(keyToSearch);

        if (outerChainNode != null) {
            outerChainNode.value = value;
        }
    }

    public void deleteOuterChainNode(int keyToSearch) {
        int c = this.hash(keyToSearch);
        DriverOuterChainNode no = this.table[c];

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

    public DriverOuterChainNode search(int k) {
        int c = this.hash(k);
        DriverOuterChainNode no = this.table[c];

        while(no != null) {
            if(no.key == k)
                return no;

            no = no.next;
        }
        return null;
    }


    public void print() {
        DriverOuterChainNode no;

        for (int i = 0; i < this.outerChainHashSize; i++) {

            no = this.table[i];
            System.out.print(i);

            while(no != null && no.key != null && no.value != null) {
                System.out.print(" --> { key: " + no.key + " driver " + no.value.toString() + " }");
                no = no.next;
            }

            System.out.println();
        }

    }
}
