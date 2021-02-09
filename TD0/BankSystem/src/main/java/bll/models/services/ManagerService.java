package bll.models.services;

import bll.models.entities.Manager;
import dal.IDAO;
import dal.inmemory.ManagerDAO;
import fel.App;

import java.util.List;

public class ManagerService {
    private final IDAO<Manager> managers;

    public ManagerService(){
        this.managers = new ManagerDAO();
    }

    public List<Manager> getAll() {
        return managers.getAll();
    }

    public Manager get(int id) {
        return managers.get(id);
    }


    public void create(Manager manager) {
        managers.create(manager);
    }

    public Manager findAccountByLogin(String username, String password){
        return managers.getAll()
                .stream()
                .filter(m -> m.getUsername().equals(username) && m.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
