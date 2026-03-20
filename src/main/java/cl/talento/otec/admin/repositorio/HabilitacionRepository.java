package cl.talento.otec.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.talento.otec.admin.modelo.Habilitacion;

@Repository
public interface HabilitacionRepository extends JpaRepository<Habilitacion, Integer> {
}
