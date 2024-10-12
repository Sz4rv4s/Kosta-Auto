package hu.kosztaauto.partshop.repository;

import hu.kosztaauto.partshop.model.Alkatresz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repository interface for performing CRUD operations on car parts (Alkatresz).
 * Extends JpaRepository for standard CRUD functionalities.
 */
public interface AlkatreszRepository extends JpaRepository<Alkatresz, String> {
    /**
     * Finds car parts by name, case-insensitively.
     *
     * @param name The part of the name to search for.
     * @return List of car parts matching the name.
     */
    List<Alkatresz> findByMegnevezesContainingIgnoreCase(String name);
}