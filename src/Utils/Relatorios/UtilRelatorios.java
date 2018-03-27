/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Relatorios;
import Classes.Acessorios;
import Classes.Carro;
import Classes.Cobertura;
import Classes.Corretor;
import Classes.Seguro;
import Classes.Sinistro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class UtilRelatorios {
    
    public static List<Seguro> listaSeguro()
    {
        List<Seguro> lista=new ArrayList<>();
        
        Carro c=new Carro();
        c.setPlaca("MNB-8732");
        
        Carro c2=new Carro();
        c2.setPlaca("SSF-9988");
        
        
        Corretor co=new Corretor();
        co.setNome("LeoCR");
        
        Corretor co2=new Corretor();
        co2.setNome("Le-CR");
        
        Seguro s=new Seguro();
        s.setData(new GregorianCalendar(2018,Calendar.APRIL,5));
        s.setIniciovigencia(new GregorianCalendar(2017,Calendar.JUNE,25));
        s.setFimvigencia(new GregorianCalendar(2018,Calendar.SEPTEMBER,30));
        s.setValorTotal(5500.00);
        s.setValorFipe(475.90);
        s.setCarro(c);
        s.setCorretor(co);
        
        Cobertura cob= new Cobertura();
        cob.setDescricao("Mono");
        cob.setValor(430.00);
        cob.setSeguro(s);
        
        Cobertura cob2= new Cobertura();
        cob2.setDescricao("Multi");
        cob2.setValor(285.00);
        cob2.setSeguro(s);
        
        Sinistro sin=new Sinistro();
        sin.setDescricao("Particular");
        sin.setData(new GregorianCalendar(2018,Calendar.DECEMBER,31));
        sin.setCidade("Passo Fundo");
        sin.setEstado("RS");
        sin.setSeguro(s);
        
        Sinistro sin2=new Sinistro();
        sin2.setDescricao("Privado");
        sin2.setData(new GregorianCalendar(2018,Calendar.MARCH,23));
        sin2.setCidade("Floripa");
        sin2.setEstado("SC");
        sin2.setSeguro(s);
        
        s.getCobertura().add(cob);
        s.getCobertura().add(cob2);
        
        s.getSinistro().add(sin);
        s.getSinistro().add(sin2);
        
        lista.add(s);
        return lista;
    }
    
    public static List<Acessorios> listaAcessorio()
    {
        List<Acessorios> lista=new ArrayList<>();
        
        Acessorios a=new Acessorios();
        a.setDescricao("Rodas");
        
        Acessorios a2=new Acessorios();
        a2.setDescricao("Óleo");
        
        lista.add(a);
        lista.add(a2);
        
        return lista;
    }
    
    
}
