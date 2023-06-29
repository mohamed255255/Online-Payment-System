package Main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Main.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ServicesRepository extends JpaRepository<services, Integer> {

    @Query("SELECT s FROM services s WHERE s.ServiceType = ?1")
    List<services> findAllMatchingServices(String ServiceType);
}
