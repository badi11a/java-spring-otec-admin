package cl.talento.otec.admin.servicio;

import org.springframework.stereotype.Service;

import cl.talento.otec.admin.dto.CursoDTO;
import cl.talento.otec.admin.modelo.Curso;
import cl.talento.otec.admin.repositorio.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDTO> obtenerTodosCursos() {
        return cursoRepository.findAll().stream()
                .map(c -> new CursoDTO(
                        c.getIdCurso(),
                        c.getCanal(),
                        c.getCodigo(),
                        c.getNombre(),
                        c.getInstructor(),
                        c.getDuracionHoras(),
                        c.getCategoria(),
                        c.getActivo()
                ))
                .toList();
    }

    public void guardarCurso(CursoDTO cursoDTO) {
        Curso curso;
        if (cursoDTO.getIdCurso() != null) {
            // Actualizar curso existente
            Optional<Curso> cursoExistente = cursoRepository.findById(cursoDTO.getIdCurso());
            curso = cursoExistente.orElse(new Curso());
        } else {
            // Crear nuevo curso
            curso = new Curso();
        }
        curso.setCanal(cursoDTO.getCanal());
        curso.setCodigo(cursoDTO.getCodigo());
        curso.setNombre(cursoDTO.getNombre());
        curso.setInstructor(cursoDTO.getInstructor());
        curso.setDuracionHoras(cursoDTO.getDuracionHoras());
        curso.setCategoria(cursoDTO.getCategoria());
        curso.setActivo(cursoDTO.getActivo());
        cursoRepository.save(curso);
    }

    public CursoDTO obtenerCursoPorId(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(c -> new CursoDTO(
                c.getIdCurso(),
                c.getCanal(),
                c.getCodigo(),
                c.getNombre(),
                c.getInstructor(),
                c.getDuracionHoras(),
                c.getCategoria(),
                c.getActivo()
        )).orElse(null);
    }

    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
}

