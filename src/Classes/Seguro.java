/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name="seguro")
public class Seguro implements Serializable {
    @Id
    @SequenceGenerator(name="seq_seguro",sequenceName="seq_seguro_id",allocationSize=1)
    @GeneratedValue(generator="seq_seguro",strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    
    @Temporal(TemporalType.DATE)
    @NotNull(message="A data do seguro deve ser informado")
    @Column(name="data",nullable=false)
    private Calendar data;
    
    
    @Temporal(TemporalType.DATE)
    @NotNull(message="O inicio da vigencia deve ser informado")
    @Column(name="iniciovigencia",nullable=false)
    private Calendar iniciovigencia;
    
    
    @Temporal(TemporalType.DATE)
    @NotNull(message="O fim da vigencia deve ser informado")
    @Column(name="fimvigencia",nullable=false)
    private Calendar fimvigencia;
    
    
    @NotNull(message="O valor total não pode ser nulo")
    @Min(value = 0,message="O valor total não poder ser abaixo de zero")
    @Column(name="valortotal",columnDefinition ="numeric(10,2)",nullable=false)
    private Double valorTotal;
    
    
    @NotNull(message="O valor fipe não pode ser nulo")
    @Min(value = 0,message="O valor fipe não poder ser abaixo de zero")
    @Column(name="valorfipe",columnDefinition ="numeric(10,2)",nullable=false)
    private Double valorFipe;
    
    
    
    
    @NotNull(message="O carro deve ser informado")
    @ManyToOne
    @JoinColumn(name="carro",referencedColumnName="id",nullable=false)
    @ForeignKey(name="fk_seguro_carro")
    private Carro carro;
    
    
    
    @NotNull(message="O corretor deve ser informado")
    @ManyToOne
    @JoinColumn(name="corretor",referencedColumnName="id",nullable=false)
    @ForeignKey(name="fk_seguro_corretor")
    private Corretor corretor;
    
    
    
    
    @OneToMany(mappedBy="seguro",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
    private List<Cobertura>cobertura=new ArrayList<>();
    
    
    
    @OneToMany(mappedBy="seguro",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
    private List<Sinistro>sinistro=new ArrayList<>();
    
    
    
    public Seguro()
    {
        
    }
    
    public void adicionarCobertura(Cobertura obj)
    {
        obj.setSeguro(this);
        this.cobertura.add(obj);
    }
    
     public void removerCobertura(int index)
    {
        this.cobertura.remove(index);
    }
     
    public void adicionarSinistro(Sinistro obj)
    {
        obj.setSeguro(this);
        this.sinistro.add(obj);
    }
    
     public void removerSinistro(int index)
    {
        this.sinistro.remove(index);
    }
    
    public Integer calculariniciofimdata()
    {
        Integer i_ano=iniciovigencia.get(Calendar.YEAR);
        Integer i_mes=iniciovigencia.get(Calendar.MONTH);
        Integer f_ano=fimvigencia.get(Calendar.YEAR);
        Integer f_mes=fimvigencia.get(Calendar.MONTH);
        Integer calano,cal2ano,calmes,cal2mes=0;
        
        if(i_ano<=f_ano)
        {
            calano=f_ano-i_ano;
            cal2ano=calano*12;
            
            if(i_mes>=f_mes)
            {
                calmes=i_mes-f_mes;
                cal2mes=cal2ano-calmes;
                
            }
            else if(i_mes<f_mes)
            {
                calmes=f_mes-i_mes;
                cal2mes=calmes+cal2ano;
            }
        }
        
        return cal2mes;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
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

   

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getIniciovigencia() {
        return iniciovigencia;
    }

    public void setIniciovigencia(Calendar iniciovigencia) {
        this.iniciovigencia = iniciovigencia;
    }

    public Calendar getFimvigencia() {
        return fimvigencia;
    }

    public void setFimvigencia(Calendar fimvigencia) {
        this.fimvigencia = fimvigencia;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public List<Cobertura> getCobertura() {
        return cobertura;
    }

    public void setCobertura(List<Cobertura> cobertura) {
        this.cobertura = cobertura;
    }

    public List<Sinistro> getSinistro() {
        return sinistro;
    }

    public void setSinistro(List<Sinistro> sinistro) {
        this.sinistro = sinistro;
    }

    
    
}
