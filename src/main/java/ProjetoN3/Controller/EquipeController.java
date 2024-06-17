package ProjetoN3.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ajuda")
public class EquipeController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAjuda() {
        Map<String, Object> response = new HashMap<>();
        response.put("estudantes", new String[]{"Diego Hahn Fração", "João Vitor Brogni"});
        response.put("projeto", "EduRepo");
        response.put("tema", "Repositórios Educacionais");

        return ResponseEntity.ok(response);
    }
}
