package ProjetoN3.Repository;

import ProjetoN3.Model.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByCategoryId(Long categoryId);
    Page<Resource> findAll(Pageable pageable);
    Page<Resource> findByCategoryId(Long categoryId, Pageable pageable);
}
