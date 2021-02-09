package dal.inmemory;

import bll.models.entities.Manager;
import dal.IDAO;

import java.util.ArrayList;
import java.util.List;

public class ManagerDAO implements IDAO<Manager> {
    private final List<Manager> managers;

    public ManagerDAO(){
        managers = new ArrayList<>();
    }
    @Override
    public List<Manager> getAll() {
        return managers;
    }

    @Override
    public Manager get(int id) {
        return managers.stream()
            .filter(m -> m.getOfficeNumber() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void create(Manager manager) {
        managers.add(manager);
    }
}
