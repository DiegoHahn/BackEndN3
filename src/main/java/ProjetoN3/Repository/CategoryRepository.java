package ProjetoN3.Repository;

import ProjetoN3.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Todos os repositorios estendem JpaRepository, e usam a interface Pageable para fazer a paginação
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);
}
