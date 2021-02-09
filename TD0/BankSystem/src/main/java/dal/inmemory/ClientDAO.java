package dal.inmemory;

import bll.models.entities.Client;
import dal.IDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IDAO<Client> {
    private final List<Client> clients;

    public ClientDAO(){
        this.clients = new ArrayList<>();
    }
    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client get(int id) {
        return clients.stream()
                .filter(c -> c.getClientId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create(Client client) {
        clients.add(client);
    }
}
