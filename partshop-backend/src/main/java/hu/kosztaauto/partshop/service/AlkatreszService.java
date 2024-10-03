package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.database.Alkatresz;
import hu.kosztaauto.partshop.repository.AlkatreszRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlkatreszService {

    @Autowired
    private AlkatreszRepository alkatreszRepository;

    public List<Alkatresz> getAllParts() {
        return alkatreszRepository.findAll();
    }
}
