package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senai.condominio.model.morador.entity.Morador;
import senai.condominio.model.morador.service.ServiceMorador;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/api")
public class ControllerMorador {
	
	@Autowired
	private ServiceMorador moradorService;
	
	@GetMapping("/moradores")
	public List<Morador> listarMoradores() {
		return moradorService.findAllMoradores();
	}
	
	@PostMapping("/moradores")
	public List<Morador> adicionarMorador(@RequestBody Morador morador) {
		return moradorService.addMorador(morador);
	}
	
	@DeleteMapping("/moradores/{moradorId}/")
	public void deletarMorador(@PathVariable Long moradorId) {
		moradorService.delMorador(moradorId);
	}
	
	@PutMapping("/moradores/{moradorId}/") 
	public void atualizarMorador(@PathVariable Long moradorId, @RequestBody Morador morador) {
		moradorService.putMorador(moradorId, morador);
	}
	
	@GetMapping("/moradores/{id}/")
	public Morador buscarMorador(@PathVariable Long id) throws NotFoundException {
		return moradorService.findByMoradorId(id);
	}
	
}

