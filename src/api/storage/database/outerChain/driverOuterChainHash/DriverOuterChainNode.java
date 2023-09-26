package api.storage.database.outerChain.driverOuterChainHash;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;

public class DriverOuterChainNode {

    public Integer key;
    public Drivers value;
    public DriverOuterChainNode next;

    public DriverOuterChainNode(int key) {
        this.key = key;
        this.next = null;
    }
}
