package senai.condominio.model.morador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.condominio.model.morador.entity.Morador;

@Repository
public interface RepositoryMorador extends JpaRepository<Morador, Long> {


}
