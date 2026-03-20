package cl.talento.otec.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.talento.otec.admin.modelo.Relator;
import java.util.List;

@Repository
public interface RelatorRepository extends JpaRepository<Relator, Integer> {
    List<Relator> findByActivoTrue();
}
