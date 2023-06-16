package Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Main.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<servicesDB, Integer> {

    @Query("SELECT s FROM servicesDB s WHERE s.type_of_service = ?1")
    List<servicesDB> findAllMatchingServices(String type_of_service);
}
