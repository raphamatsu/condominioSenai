package senai.condominio.model.morador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import senai.condominio.model.morador.entity.Morador;
import senai.condominio.model.morador.repository.RepositoryMorador;

public class ServiceMorador {
    @Autowired
	private RepositoryMorador repositoryMorador;

	public List<Morador> findAllMoradores() {
		return repositoryMorador.findAll();
	}

	public Morador findByMoradorId(@PathVariable Long id) {
		Optional<Morador> optMorador = repositoryMorador.findById(id);
		return optMorador.get();
	}

	public List<Morador> addMorador(@RequestBody Morador morador) {

		morador.getAnimal().forEach(animal -> animal.setMorador(morador));
		morador.getVeiculo().forEach(veiculo -> veiculo.setMorador(morador));

		repositoryMorador.save(morador);
		return repositoryMorador.findAll();

	}

	public void delMorador(@PathVariable Long moradorId) {
		repositoryMorador.deleteById(moradorId);
	}

	public void putMorador(@PathVariable Long moradorId, @RequestBody Morador morador) {

		morador.getAnimal().forEach(animal -> animal.setMorador(morador));
		morador.getVeiculo().forEach(veiculo -> veiculo.setMorador(morador));

		repositoryMorador.save(morador);

	}
}
