package hu.kosztaauto.partshop.repository;

import hu.kosztaauto.partshop.model.Alkatresz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlkatreszRepository extends JpaRepository<Alkatresz, String> {
    List<Alkatresz> findByMegnevezesContainingIgnoreCase(String name);
}