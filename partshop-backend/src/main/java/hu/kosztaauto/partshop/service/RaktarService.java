package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.database.Raktar;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaktarService {

    @Autowired
    private RaktarRepository raktarRepository;

    public List<Raktar> getAllWarehouses() {
        return raktarRepository.findAll();
    }
}
