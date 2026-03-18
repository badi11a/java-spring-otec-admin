package cl.talento.vinilo.demo.servicio;

import cl.talento.vinilo.demo.dto.ViniloDTO;
import cl.talento.vinilo.demo.repositorio.ViniloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViniloService {

    private final ViniloRepository viniloRepository;

    public ViniloService(ViniloRepository viniloRepository) {
        this.viniloRepository = viniloRepository;
    }

    public List<ViniloDTO> obtenerTodosLosVinilos() {
        return viniloRepository.findAll().stream()
                .map(v -> new ViniloDTO(
                        v.getIdVinilo(), 
                        v.getTitulo(), 
                        v.getArtista(), 
                        v.getAnioLanzamiento(), 
                        v.getGenero(), 
                        v.getDisponible()
                ))
                .toList();
    }
    //TODO agregar mas funciones CRUD
}

