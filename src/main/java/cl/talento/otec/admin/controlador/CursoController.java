package cl.talento.otec.admin.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.talento.otec.admin.dto.CursoDTO;
import cl.talento.otec.admin.servicio.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.obtenerTodosCursos());
        return "cursos"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("curso", new CursoDTO());
        return "nuevo-curso";
    }

    @PostMapping
    public String guardarCurso(@ModelAttribute("curso") CursoDTO cursoDTO) {
        cursoService.guardarCurso(cursoDTO);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        CursoDTO curso = cursoService.obtenerCursoPorId(id);
        model.addAttribute("curso", curso);
        return "nuevo-curso";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable("id") Integer id) {
        cursoService.eliminarCurso(id);
        return "redirect:/cursos";
    }
}

