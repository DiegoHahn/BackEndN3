package ProjetoN3.Repository;

import ProjetoN3.Model.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Page<Resource> findAll(Pageable pageable);
    Page<Resource> findByCategoryId(Long categoryId, Pageable pageable);
    Page<Resource> findByCategoryName(String categoryName, Pageable pageable);
}
