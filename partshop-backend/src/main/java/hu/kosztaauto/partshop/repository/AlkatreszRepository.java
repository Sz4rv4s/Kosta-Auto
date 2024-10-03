package hu.kosztaauto.partshop.repository;

import hu.kosztaauto.partshop.model.Alkatresz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlkatreszRepository extends JpaRepository<Alkatresz, String> {
}