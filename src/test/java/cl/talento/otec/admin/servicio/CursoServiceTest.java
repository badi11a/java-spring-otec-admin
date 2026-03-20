package cl.talento.otec.admin.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.talento.otec.admin.dto.CursoDTO;
import cl.talento.otec.admin.modelo.Curso;
import cl.talento.otec.admin.modelo.Relator;
import cl.talento.otec.admin.repositorio.CursoRepository;
import cl.talento.otec.admin.repositorio.RelatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private RelatorRepository relatorRepository;

    @InjectMocks
    private CursoService cursoService;

    private Relator relatorPrueba;
    private Curso cursoPrueba;
    private CursoDTO cursoDTOPrueba;

    @BeforeEach
    void setUp() {
        // Arrange - Crear datos de prueba
        
        // Crear relator ficticio
        relatorPrueba = new Relator();
        relatorPrueba.setIdRelator(1);
        relatorPrueba.setNombres("Juan");
        relatorPrueba.setApellidos("Pérez");
        relatorPrueba.setEmail("juan.perez@example.com");
        relatorPrueba.setEspecialidad("Programación");
        relatorPrueba.setActivo(true);

        // Crear curso ficticio
        cursoPrueba = new Curso();
        cursoPrueba.setIdCurso(1);
        cursoPrueba.setCanal("Online");
        cursoPrueba.setCodigo("PROG-001");
        cursoPrueba.setNombre("Curso de Java Básico");
        cursoPrueba.setDuracionHoras(40);
        cursoPrueba.setCategoria("Programación");
        cursoPrueba.setActivo(true);
        cursoPrueba.setRelator(relatorPrueba);

        // Crear DTO ficticio
        cursoDTOPrueba = new CursoDTO();
        cursoDTOPrueba.setIdCurso(1);
        cursoDTOPrueba.setCanal("Online");
        cursoDTOPrueba.setCodigo("PROG-001");
        cursoDTOPrueba.setNombre("Curso de Java Básico");
        cursoDTOPrueba.setIdRelator(1);
        cursoDTOPrueba.setNombreRelator("Juan Pérez");
        cursoDTOPrueba.setDuracionHoras(40);
        cursoDTOPrueba.setCategoria("Programación");
        cursoDTOPrueba.setActivo(true);
    }

    @Test
    void testListarActivos() {
        // Arrange
        List<Curso> cursosActivos = new ArrayList<>();
        cursosActivos.add(cursoPrueba);
        
        when(cursoRepository.findByActivoTrue()).thenReturn(cursosActivos);

        // Act
        List<CursoDTO> resultado = cursoService.obtenerTodosCursos();

        // Assert
        assertNotNull(resultado, "La lista no debe ser null");
        assertEquals(1, resultado.size(), "La lista debe contener exactamente 1 curso");
        
        CursoDTO cursoResultado = resultado.get(0);
        assertEquals("PROG-001", cursoResultado.getCodigo(), "El código debe coincidir");
        assertEquals("Curso de Java Básico", cursoResultado.getNombre(), "El nombre debe coincidir");
        assertEquals("Juan Pérez", cursoResultado.getNombreRelator(), "El nombre del relator debe estar concatenado");
        
        // Verificar que se llamó al repositorio
        verify(cursoRepository, times(1)).findByActivoTrue();
    }

    @Test
    void testGuardarCursoNuevo() {
        // Arrange - Crear un DTO sin ID (nuevo curso)
        CursoDTO cursoNuevo = new CursoDTO();
        cursoNuevo.setIdCurso(null); // Sin ID = crear nuevo
        cursoNuevo.setCanal("Online");
        cursoNuevo.setCodigo("PROG-001");
        cursoNuevo.setNombre("Curso de Java Básico");
        cursoNuevo.setIdRelator(1);
        cursoNuevo.setDuracionHoras(40);
        cursoNuevo.setCategoria("Programación");
        cursoNuevo.setActivo(true);

        when(relatorRepository.findById(1)).thenReturn(Optional.of(relatorPrueba));
        when(cursoRepository.save(any(Curso.class))).thenReturn(cursoPrueba);

        // Act
        cursoService.guardarCurso(cursoNuevo);

        // Assert
        verify(relatorRepository, times(1)).findById(1);
        verify(cursoRepository, times(1)).save(any(Curso.class));
        verify(cursoRepository, never()).findById(any()); // No debe buscar el curso porque es nuevo
    }

    @Test
    void testGuardarCursoExistente() {
        // Arrange - Actualizar un curso existente
        CursoDTO cursoExistente = new CursoDTO();
        cursoExistente.setIdCurso(1); // Con ID = actualizar
        cursoExistente.setCanal("Presencial");
        cursoExistente.setCodigo("PROG-001-UPD");
        cursoExistente.setNombre("Curso Java Avanzado");
        cursoExistente.setIdRelator(1);
        cursoExistente.setDuracionHoras(60);
        cursoExistente.setCategoria("Programación");
        cursoExistente.setActivo(true);

        when(cursoRepository.findById(1)).thenReturn(Optional.of(cursoPrueba));
        when(relatorRepository.findById(1)).thenReturn(Optional.of(relatorPrueba));
        when(cursoRepository.save(any(Curso.class))).thenReturn(cursoPrueba);

        // Act
        cursoService.guardarCurso(cursoExistente);

        // Assert
        verify(cursoRepository, times(1)).findById(1); // Debe buscar el curso existente
        verify(relatorRepository, times(1)).findById(1);
        verify(cursoRepository, times(1)).save(any(Curso.class));
    }

    @Test
    void testGuardarCursoSinRelator() {
        // Arrange
        CursoDTO cursoSinRelator = new CursoDTO();
        cursoSinRelator.setIdCurso(null);
        cursoSinRelator.setCodigo("PROG-002");
        cursoSinRelator.setNombre("Curso sin instructor");
        cursoSinRelator.setDuracionHoras(20);
        cursoSinRelator.setIdRelator(null); // Sin relator

        when(cursoRepository.save(any(Curso.class))).thenReturn(new Curso());

        // Act
        cursoService.guardarCurso(cursoSinRelator);

        // Assert
        // Verificar que NO se buscó ningún relator
        verify(relatorRepository, never()).findById(any());
        
        // Verificar que se guardó el curso igualmente
        verify(cursoRepository, times(1)).save(any(Curso.class));
    }

    @Test
    void testEliminarCursoLogico() {
        // Arrange
        Integer cursoId = 1;
        when(cursoRepository.findById(cursoId)).thenReturn(Optional.of(cursoPrueba));
        when(cursoRepository.save(any(Curso.class))).thenReturn(cursoPrueba);

        assertTrue(cursoPrueba.getActivo(), "El curso debe estar activo antes de eliminar");

        // Act
        cursoService.eliminarCurso(cursoId);

        // Assert
        assertFalse(cursoPrueba.getActivo(), "El curso debe estar inactivo después de eliminar");
        
        // Verificar que se buscó el curso
        verify(cursoRepository, times(1)).findById(cursoId);
        
        // Verificar que se guardó el cambio (soft delete, no deleteById)
        verify(cursoRepository, times(1)).save(any(Curso.class));
        
        // Verificar que NO se ejecutó deleteById
        verify(cursoRepository, never()).deleteById(any());
    }

    @Test
    void testObtenerCursoPorId() {
        // Arrange
        Integer cursoId = 1;
        when(cursoRepository.findById(cursoId)).thenReturn(Optional.of(cursoPrueba));

        // Act
        CursoDTO resultado = cursoService.obtenerCursoPorId(cursoId);

        // Assert
        assertNotNull(resultado, "El DTO no debe ser null");
        assertEquals("PROG-001", resultado.getCodigo(), "El código debe coincidir");
        assertEquals("Juan Pérez", resultado.getNombreRelator(), "El nombre del relator debe concatenarse");
        
        verify(cursoRepository, times(1)).findById(cursoId);
    }

    @Test
    void testObtenerCursoPorIdNoExistente() {
        // Arrange
        Integer cursoId = 999;
        when(cursoRepository.findById(cursoId)).thenReturn(Optional.empty());

        // Act
        CursoDTO resultado = cursoService.obtenerCursoPorId(cursoId);

        // Assert
        assertNull(resultado, "El DTO debe ser null cuando el curso no existe");
        
        verify(cursoRepository, times(1)).findById(cursoId);
    }

}
