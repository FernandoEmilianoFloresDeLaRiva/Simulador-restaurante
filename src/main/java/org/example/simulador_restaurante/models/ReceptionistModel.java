package org.example.simulador_restaurante.models;

import org.example.simulador_restaurante.components.ClientComponent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReceptionistModel {
    private final int capacityTables;
    private int buzyTables = 0;
    private final Queue<ClientComponent> queueClients = new LinkedList<>();
    private final CopyOnWriteArrayList<ClientComponent> seatedCustomers = new CopyOnWriteArrayList<>();

    public ReceptionistModel(int capacityTables) {
        this.capacityTables = capacityTables;
    }

    public synchronized boolean tryToSit(ClientComponent client) {
        if (buzyTables < capacityTables) {
            buzyTables++;
            seatedCustomers.add(client);
            System.out.println("Cliente " + client.getId() + " se sienta. Mesas ocupadas: " + buzyTables);
            return true;
        }
        System.out.println("Cliente " + client.getId() + " no encontró mesa y entra a la cola.");
        queueClients.add(client);
        return false;
    }

    public synchronized ClientComponent releaseTable() {
        if (buzyTables > 0) {
            buzyTables--;
            System.out.println("Mesa liberada. Mesas ocupadas: " + buzyTables);
            notifyAll();

            if (!queueClients.isEmpty()) {
                ClientComponent nextClient = queueClients.poll();
                System.out.println("Cliente " + nextClient.getId() + " es llamado desde la cola.");
                tryToSit(nextClient);
                return nextClient;
            }
        }
        return null;
    }

    public CopyOnWriteArrayList<ClientComponent> getSeatedCustomers() {
        return seatedCustomers;
    }

    public synchronized void removeSeatedClient(ClientComponent client) {
        seatedCustomers.remove(client);
    }
}
