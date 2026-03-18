package cl.talento.vinilo.demo.controlador;

import cl.talento.vinilo.demo.servicio.ViniloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinilos")
public class ViniloController {

    private final ViniloService viniloService;

    public ViniloController(ViniloService viniloService) {
        this.viniloService = viniloService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vinilos", viniloService.obtenerTodosLosVinilos());
        return "vinilos"; 
    }
}

