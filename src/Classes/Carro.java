/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name="carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_carro",sequenceName="seq_carro_id",allocationSize=1)
    @GeneratedValue(generator="seq_carro",strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message="A placa não pode ser nulo")
    @NotBlank(message="A placa não pode ser em branco")
    @Length(max=8,message="A placa não pode ter mais que {max} caracteres")
    @Column(name="placa",length=8,nullable=false,unique = true)
    private String placa;
    
    
    @NotNull(message="O renavam não pode ser nulo")
    @NotBlank(message="O renavam não pode ser em branco")
    @Length(max=9,message="O renavam não pode ter mais que {max} caracteres")
    @Column(name="renavam",length=9,nullable=false,unique = true)
    private String renavam;
    
    
    
    @NotNull(message="O modelo não pode ser nulo")
    @NotBlank(message="O modelo não pode ser em branco")
    @Length(max=30,message="O modelo não pode ter mais que {max} caracteres")
    @Column(name="modelo",length=30,nullable=false)
    private String modelo;
    
    
    
    @NotNull(message="O fabricante não pode ser nulo")
    @NotBlank(message="O fabricante não pode ser em branco")
    @Length(max=30,message="O fabricante não pode ter mais que {max} caracteres")
    @Column(name="fabricante",length=30,nullable=false)
    private String fabricante;
    
    
    
    @NotNull(message="O ano da fabricação não pode ser nulo")
    @Min(value = 1930,message="O ano da fabricação não poder ser abaixo de {value}")
    @Column(name="anofabricacao",nullable=false)
    private Integer anofabricacao;
    
    @NotNull(message="O  ano modelo não pode ser nulo")
    @Min(value = 1990,message="O ano modelo não poder ser abaixo de {value}")
    @Column(name="anomodelo",nullable=false)
    private Integer anomodelo;
    
    
    
    
    @NotNull(message="A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name="pessoa",referencedColumnName="id",nullable=false)
    @ForeignKey(name="fk_carro_pessoa")
    private Pessoa pessoa;
    
    
    
    @ManyToMany
    @JoinTable(name="conjuntos",joinColumns=@JoinColumn(name="carro",referencedColumnName="id",
            nullable=false),inverseJoinColumns=@JoinColumn(name="acessorios",referencedColumnName="id",
            nullable=false),uniqueConstraints=
                    {@UniqueConstraint(columnNames={"acessorios","carro"})})
    private List<Acessorios> acessorios=new ArrayList<>();
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
    public Carro()
    {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(Integer anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public Integer getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(Integer anomodelo) {
        this.anomodelo = anomodelo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }
    
     public void addAcessorios(Acessorios acessorios) {
        this.acessorios.add(acessorios);
    }
     
     public void removeAcessorios(Acessorios acessorios) {
        this.acessorios.remove(acessorios);
    }

    
}
