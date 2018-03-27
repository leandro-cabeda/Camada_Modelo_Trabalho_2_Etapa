/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
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
@Table(name="cobertura")
public class Cobertura implements Serializable {
    
    @Id
    @SequenceGenerator(name="seq_cobertura",sequenceName="seq_cobertura_id",allocationSize=1)
    @GeneratedValue(generator="seq_cobertura",strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    
    @Column(name="descricao",length=40,nullable=false)
    @NotNull(message="A descrição não pode ser nulo")
    @NotBlank(message="A descrição deve ser informada")
    @Length(max=40,message="A descrição não pode ter mais que {max} caracteres")
    private String descricao;
    
    
    @NotNull(message="O valor não pode ser nulo")
    @Min(value = 0,message="O valor não poder ser abaixo de zero")
    @Column(name="valor",columnDefinition ="numeric(10,2)",nullable=false)
    private Double valor;
    
    
    @NotNull(message="O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name="seguro",referencedColumnName="id",nullable=false)
    @ForeignKey(name="fk_cobertura_seguro")
    private Seguro seguro;
    
    
    
    public Cobertura()
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
        final Cobertura other = (Cobertura) obj;
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


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
}
