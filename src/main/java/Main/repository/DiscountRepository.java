package Main.repository;

import Main.model.DiscountDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscountRepository extends JpaRepository<DiscountDB , Long> {
    @Query("SELECT d from DiscountDB d ")
    public List<DiscountDB> findAllDiscounts();
}
