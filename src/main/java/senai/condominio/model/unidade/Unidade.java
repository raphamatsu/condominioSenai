package senai.condominio.model.unidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import senai.condominio.model.morador.entity.Morador;

@Entity
@Table(name = "unidade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Unidade {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloco;
    private String numero;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
    private List<Morador> morador;

    public Unidade() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloco() {
        return this.bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Morador> getMorador() {
		return morador;
	}

	public void setMorador(List<Morador> morador) {
		this.morador = morador;
	}

}
