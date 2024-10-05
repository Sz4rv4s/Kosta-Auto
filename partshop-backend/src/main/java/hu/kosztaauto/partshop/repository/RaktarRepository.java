package hu.kosztaauto.partshop.repository;

import hu.kosztaauto.partshop.model.Raktar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaktarRepository extends JpaRepository<Raktar, Long> {
    List<Raktar> findByNevContainingIgnoreCase(String name);
}