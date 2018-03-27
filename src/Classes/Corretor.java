/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name="corretor")
public class Corretor extends Pessoa implements Serializable{
    
    
    
    @Min(value=0, message="O percentual comissão não pode ser negativo")
    @NotNull(message="O percentual comissao deve ser informado")
    @Column(name="percentualComissao",columnDefinition="decimal(10,2)",nullable=false)
    private Double percentualComissao;
    
    
    
    @Column(name="nomeUsuario",nullable=false,length = 20,unique=true)
    @NotNull(message="O nome do usuario não pode ser nulo")
    @NotBlank(message="O nome do usuario não pode ser em branco")
    @Length(max=20,message="o nome do usuário não pode ter mais de {max} caracteres")
    private String nomeUsuario;
    
    
    @Column(name="senha",nullable=false,length = 20)
    @NotNull(message="A senha  não pode ser nulo")
    @NotBlank(message="A senha não pode ser em branco")
    @Length(max=20,message="A senha não pode ter mais de {max} caracteres")
    private String senha;
    
    
    
    public Corretor()
    {
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }
    
    
    
    
}
