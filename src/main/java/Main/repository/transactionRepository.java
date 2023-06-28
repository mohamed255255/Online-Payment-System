package Main.repository;
import Main.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface transactionRepository extends JpaRepository<transactionDB , Integer> {
    @Query("select t from transactionDB t ")
    List<transactionDB> GetAllTransactions();
}
