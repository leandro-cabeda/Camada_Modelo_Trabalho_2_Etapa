package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name="acessorios")
public class Acessorios implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_acessorios",sequenceName="seq_acessorios_id",allocationSize=1)
    @GeneratedValue(generator="seq_acessorios",strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message="A descricao deve ser informado")
    @NotBlank(message="A descricao não pode ser em branco")
    @Length(max=30,message="A descricao não pode ter mais que {max} caracteres")
    @Column(name="descricao",length=30,nullable=false,unique=true)
    private String descricao;
    
    
    
    @ManyToMany
    @JoinTable(name="conjuntos",joinColumns=@JoinColumn(name="acessorios",referencedColumnName="id",
            nullable=false),inverseJoinColumns=@JoinColumn(name="carro",referencedColumnName="id",
            nullable=false),uniqueConstraints=
                    {@UniqueConstraint(columnNames={"acessorios","carro"})})
    private List<Carro> carros=new ArrayList<>();
    
    
    
    
    public Acessorios()
    {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Acessorios other = (Acessorios) obj;
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

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    
}
