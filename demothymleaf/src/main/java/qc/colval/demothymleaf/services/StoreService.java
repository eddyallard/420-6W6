package qc.colval.demothymleaf.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Store;
import qc.colval.demothymleaf.repos.IStoreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StoreService {
    private final IStoreRepository storeRepository;

    public List<Store> readAll(){
        return storeRepository.findAll();
    }
}
