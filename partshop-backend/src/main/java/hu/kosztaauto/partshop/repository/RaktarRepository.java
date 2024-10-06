package hu.kosztaauto.partshop.repository;

import hu.kosztaauto.partshop.model.Raktar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repository interface for performing CRUD operations on warehouses (Raktar).
 * Extends JpaRepository for standard CRUD functionalities.
 */
public interface RaktarRepository extends JpaRepository<Raktar, Long> {
    /**
     * Finds warehouses by name, case-insensitively.
     *
     * @param name The part of the name to search for.
     * @return List of warehouses matching the name.
     */
    List<Raktar> findByNevContainingIgnoreCase(String name);
}