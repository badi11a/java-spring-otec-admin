package cl.talento.vinilo.demo.repositorio;

import cl.talento.vinilo.demo.modelo.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViniloRepository extends JpaRepository<Vinilo, Integer> {
}
