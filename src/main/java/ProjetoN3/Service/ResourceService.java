package ProjetoN3.Service;

import ProjetoN3.Exceptions.CategoryNotFoundException;
import ProjetoN3.Model.Category;
import ProjetoN3.Model.Resource;
import ProjetoN3.Repository.CategoryRepository;
import ProjetoN3.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Resource> findAll(Pageable pageable) {
        return resourceRepository.findAll(pageable);
    }

    public Optional<Resource> findById(Long id) {
        return resourceRepository.findById(id);
    }

    public Resource save(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteById(Long id) {
        resourceRepository.deleteById(id);
    }

    public Page<Resource> findByCategoryId(Long categoryId, Pageable pageable) {
        return resourceRepository.findByCategoryId(categoryId, pageable);
    }

    public Page<Resource> findByCategoryName(String categoryName, Pageable pageable) {
        return resourceRepository.findByCategoryName(categoryName, pageable);
    }

    // Caso não encontre a categoria, lançar a exceção CategoryNotFoundException
    public Resource saveResource(Resource resource) {
        Long categoryId = resource.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada com o ID: " + categoryId));
        resource.setCategory(category);
        return resourceRepository.save(resource);
    }
}
