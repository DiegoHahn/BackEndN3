package ProjetoN3.Controller;

import ProjetoN3.Model.Resource;
import ProjetoN3.Service.ResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public Page<Resource> getAllResources(Pageable pageable) {
        return resourceService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        return resourceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Pode fazer chamada para filtrar a categoria pelo ID
    @GetMapping("/category/{categoryId}")
    public Page<Resource> getResourcesByCategoryId(@PathVariable Long categoryId, Pageable pageable) {
        return resourceService.findByCategoryId(categoryId, pageable);
    }

    //Pode fazer chamada para filtrar a categoria pelo nome
    @GetMapping("/category/name/{categoryName}")
    public Page<Resource> getResourcesByCategoryName(@PathVariable String categoryName, Pageable pageable) {
        return resourceService.findByCategoryName(categoryName, pageable);
    }

    //Post e Put com a validaçao do recurso
    @PostMapping
    public Resource createResource(@RequestBody @Valid Resource resource) {
        return resourceService.saveResource(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody  @Valid Resource resourceDetails) {
        return resourceService.findById(id)
                .map(resource -> {
                    resource.setTitle(resourceDetails.getTitle());
                    resource.setDescription(resourceDetails.getDescription());
                    resource.setUrl(resourceDetails.getUrl());
                    resource.setType(resourceDetails.getType());
                    resource.setCategory(resourceDetails.getCategory());
                    return ResponseEntity.ok(resourceService.save(resource));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResource(@PathVariable Long id) {
        return resourceService.findById(id)
                .map(resource -> {
                    resourceService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
