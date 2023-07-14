package Main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Main.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface WalletRepository extends JpaRepository <wallet,Integer> {
    @Query("select w from wallet w join User u where u.UserID = :userId")
    Optional<wallet> findWalletByUserId(@Param("userId") int userId);
}
