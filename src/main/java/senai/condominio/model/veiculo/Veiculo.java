package senai.condominio.model.veiculo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import senai.condominio.model.morador.entity.Morador;

@Entity
@Table(name = "veiculo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Veiculo {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "morador_id")
	@JsonIgnore
	private Morador morador;

    public Morador getMorador() {
        return this.morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Veiculo() {
    }

    public Long getid() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
