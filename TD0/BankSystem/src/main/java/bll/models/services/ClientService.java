package bll.models.services;

import bll.models.entities.Client;
import dal.IDAO;
import dal.inmemory.ClientDAO;

import java.util.List;

public class ClientService {
    private final IDAO<Client> clients;

    public ClientService(){
        this.clients = new ClientDAO();
    }

    public List<Client> getAll() {
        return clients.getAll();
    }


    public Client get(int id) {
        return clients.get(id);
    }

    public void create(Client client) {
        clients.create(client);
    }

    public boolean isApproved(Client client){
        if ((client.getSex().equals("femme") && client.getAge()<18) ||
                (client.getSex().equals("homme") && client.getAge()<21)||
                (client.getIncome() < 31000d && !client.getMaritalStatus().equals("marié"))||
                (client.getIncome() < 21000d && client.getMaritalStatus().equals("marié"))){
            return false;
        }
        return true;
    }
}
