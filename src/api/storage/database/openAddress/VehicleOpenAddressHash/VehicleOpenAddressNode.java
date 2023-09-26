package api.storage.database.openAddress.VehicleOpenAddressHash;

import api.storage.models.Vehicles;

public class VehicleOpenAddressNode {

    public Integer key;
    public Vehicles value;

    public VehicleOpenAddressNode(int key, Vehicles value) {
        this.key = key;
        this.value = value;
    }
}
