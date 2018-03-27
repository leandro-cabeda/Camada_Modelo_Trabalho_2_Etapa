/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name="sinistro")
public class Sinistro implements Serializable {
    
    @Id
    @SequenceGenerator(name="seq_sinistro",sequenceName="seq_sinistro_id",allocationSize=1)
    @GeneratedValue(generator="seq_sinistro",strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    
    
    @Column(name="descricao",nullable=false,columnDefinition = "text")
    @NotNull(message="A descrição não pode ser nulo")
    @NotBlank(message="A descrição deve ser informada")
    private String descricao;
    
    
    
    @Temporal(TemporalType.DATE)
    @NotNull(message="A data do sinistro deve ser informado")
    @Column(name="data",nullable=false)
    private Calendar data;
    
    
    @NotNull(message="A cidade deve ser informado")
    @NotBlank(message="A cidade não pode ser em branco")
    @Length(max=25,message="A cidade não pode ter mais que {max} caracteres")
    @Column(name="cidade",length=25,nullable=false,unique=true)
    private String cidade;
    
    
    
    @NotNull(message="O estado deve ser informado")
    @NotBlank(message="O estado não pode ser em branco")
    @Length(max=2,message="O estado não pode ter mais que {max} caracteres")
    @Column(name="estado",length=2,nullable=false,unique=true)
    private String estado;
    
    
    
    @NotNull(message="O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name="seguro",referencedColumnName="id",nullable=false)
    @ForeignKey(name="fk_sinistro_seguro")
    private Seguro seguro;
    
    
    
    public Sinistro()
    {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    
}
