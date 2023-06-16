package Main.repository;
import Main.model.RefundRequestDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@Repository
public interface RefundRequestRepository extends JpaRepository<RefundRequestDB , Integer> {
@Query("SELECT r from  RefundRequestDB r")
    List<RefundRequestDB> GetAllRefundRequests() ;
}
