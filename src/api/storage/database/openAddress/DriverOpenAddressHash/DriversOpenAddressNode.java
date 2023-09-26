package api.storage.database.openAddress.DriverOpenAddressHash;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;

public class DriversOpenAddressNode {
    public Integer key;
    public Drivers value;

    public DriversOpenAddressNode(int key, Drivers value) {
        this.key = key;
        this.value = value;
    }
}
