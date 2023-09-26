package api.storage.database.outerChain.vehicleOuterChainHash;

import api.storage.models.Vehicles;

public class VehicleOuterChainNode {

    public Integer key;
    public Vehicles value;
    public VehicleOuterChainNode next;

    public VehicleOuterChainNode(int key) {
        this.key = key;
        this.next = null;
    }
}
