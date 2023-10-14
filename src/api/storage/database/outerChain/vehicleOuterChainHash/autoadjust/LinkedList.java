package api.storage.database.outerChain.vehicleOuterChainHash.autoadjust;

import api.storage.database.outerChain.vehicleOuterChainHash.VehicleOuterChainNode;
import api.storage.models.Vehicles;

public class LinkedList {
    VehicleOuterChainNode primeiro;

    public LinkedList() {
        this.setPrimeiro(null);
    }

    public VehicleOuterChainNode getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(VehicleOuterChainNode primeiro) {
        this.primeiro = primeiro;
    }

    public void inserir(Integer k, Vehicles vehicle) {
        VehicleOuterChainNode novo = new VehicleOuterChainNode(k);
        novo.value = vehicle;

        if(this.getPrimeiro() == null)
            this.setPrimeiro(novo);
        else {
            VehicleOuterChainNode atual = this.getPrimeiro();
            while(atual.next != null) {
                atual = atual.next;
            }

            atual.next = novo;
        }
    }

    public VehicleOuterChainNode searchMoveForward(Integer k, int position) {
        VehicleOuterChainNode current = null;
        VehicleOuterChainNode before = null;

        for(current = this.getPrimeiro(); current != null; current = current.next) {
            if(current.key.compareTo(k) == 0) {
                if(current != this.getPrimeiro()) {
                    if (before != null) {
                        before.next = current.next;
                    }

                    current.next = this.getPrimeiro();
                    this.setPrimeiro(current);
                }

                System.out.println("Position " + position + "--> { key: " + current.key + " vehicle " + current.value.toString() + " }");
                return current;
            }

            before = current;
        }
        return null;
    }

    public void update(Integer k, Vehicles vehicle, int position) {
        VehicleOuterChainNode nodeFound = this.searchMoveForward(k, position);

        if (nodeFound != null) {
            nodeFound.value = vehicle;
        }
    }

    public void delete(int keyToSearch) {
        VehicleOuterChainNode node = this.getPrimeiro();

        if (node != null) {
            while (node != null) {
                if (node.key.equals(keyToSearch)) {

                    if(node.next != null) {
                        node.key = node.next.key;
                        node.value = node.next.value;
                        node.next = node.next.next;
                    } else {
                        node.key = null;
                        node.value = null;
                        node.next = null;
                        break;
                    }
                }

                node = node.next;
            }
        }
    }

    public void print() {
        this.print(this.getPrimeiro());
    }

    private void print(VehicleOuterChainNode l) {
        VehicleOuterChainNode atual;

        for (atual = l; atual != null; atual = atual.next) {

            if (atual.value != null) {
                System.out.print(" --> { key: " + atual.key + " vehicle " + atual.value.toString() + " }");
            }

        }
    }
}
