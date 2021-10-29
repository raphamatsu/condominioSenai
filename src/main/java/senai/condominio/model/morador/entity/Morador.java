package senai.condominio.model.morador.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import senai.condominio.model.animal.Animal;
import senai.condominio.model.unidade.Unidade;
import senai.condominio.model.veiculo.Veiculo;

@Entity
@Table(name = "morador")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Morador {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMorador;
    
    private int cpfMorador;

    @Column(name = "data_nascimento")
    private Date nascimentoMorador;

    private String telefoneMorador;
    
    private String emailMorador;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @OneToMany(mappedBy = "morador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Veiculo> veiculo;

    @OneToMany(mappedBy = "morador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animal;

    private String observacoes;

    public Morador() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMorador() {
        return this.nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public int getCpfMorador() {
        return this.cpfMorador;
    }

    public void setCpfMorador(int cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public Date getNascimentoMorador() {
        return this.nascimentoMorador;
    }

    public void setNascimentoMorador(Date nascimentoMorador) {
        this.nascimentoMorador = nascimentoMorador;
    }

    public String getTelefoneMorador() {
        return this.telefoneMorador;
    }

    public void setTelefoneMorador(String telefoneMorador) {
        this.telefoneMorador = telefoneMorador;
    }

    public String getEmailMorador() {
        return this.emailMorador;
    }

    public void setEmailMorador(String emailMorador) {
        this.emailMorador = emailMorador;
    }

    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Veiculo> getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    public List<Animal> getAnimal() {
        return this.animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
