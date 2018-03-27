/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Acessorios;
import Classes.Carro;
import Classes.Cobertura;
import Classes.Corretor;
import Classes.Pessoa;
import Classes.Seguro;
import Classes.Sinistro;
import EntityManagerUtil.EntityManagerUtil;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Leandro
 */
public class Teste_Modelo_JPA {
    EntityManager em;
    
    public Teste_Modelo_JPA() {
    }
    
    @Before
    public void setUp() {
        em=EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    
    @Test
    public void teste()
    {
        boolean exception=false;
        
        try{
            Pessoa p1= new Pessoa();
            p1.setNome("Leandro Rigo");
            p1.setCpf("584.646.318-55");
            p1.setEmail("leandro.rigo@hotmail.com");
            p1.setRg("1088898734");
            p1.setTelefone("54-874928230");
            
            
            Pessoa p2= new Pessoa();
            p2.setNome("Leo Cabeda");
            p2.setCpf("576.034.820-54");
            p2.setEmail("leo.cabe@hotmail.com");
            p2.setRg("3283924388");
            p2.setTelefone("54-23764723");
            
            Pessoa p3= new Pessoa();
            p3.setNome("Alexandre");
            p3.setCpf("016.926.980-95");
            p3.setEmail("alex@hotmail.com");
            p3.setRg("9389478457");
            p3.setTelefone("54-28432783");
            
            
            /*Corretor c1= new Corretor();
            c1.setCpf("366.538.562-83");
            c1.setEmail("jo.reg@hotmail.com");
            c1.setNome("Joe Reg");
            c1.setNomeUsuario("joe_reg");
            c1.setPercentualComissao(25.5);
            c1.setRg("93228293");
            c1.setSenha("3837374");
            c1.setTelefone("54-3982738");*/
            
            
            /*Corretor c2= new Corretor();
            c2.setCpf("781.243.978-05");
            c2.setEmail("vini.fed@hotmail.com");
            c2.setNome("Vinicius Fedel");
            c2.setNomeUsuario("vini_def");
            c2.setPercentualComissao(19.3);
            c2.setRg("4357378873");
            c2.setSenha("02910929");
            c2.setTelefone("54-49853998");*/
            
            
            
            Acessorios a1=new Acessorios();
            a1.setDescricao("Chave de Fenda");
            
            
            Acessorios a2=new Acessorios();
            a2.setDescricao("Tapete");
            
            Acessorios a3=new Acessorios();
            a3.setDescricao("AirBag");
            
            Acessorios a4=new Acessorios();
            a4.setDescricao("MP3");
            
            Acessorios a5=new Acessorios();
            a5.setDescricao("Ar Condicionado");
            
            Acessorios a6=new Acessorios();
            a6.setDescricao("Macaco");
            
            
            Carro car1=new Carro();
            car1.setAnofabricacao(1945);
            car1.setAnomodelo(1995);
            car1.setFabricante("Volkswagen");
            car1.setModelo("Audi");
            car1.setPessoa(p1);
            car1.setPlaca("IHG-7865");
            car1.setRenavam("387823883");
            
            
            
            Carro car2=new Carro();
            car2.setAnofabricacao(1950);
            car2.setAnomodelo(1999);
            car2.setFabricante("Toyota");
            car2.setModelo("Lexus");
            car2.setPessoa(p2);
            car2.setPlaca("GHN-4948");
            car2.setRenavam("476564764");
            
            Carro car3=new Carro();
            car3.setAnofabricacao(1959);
            car3.setAnomodelo(2002);
            car3.setFabricante("Ford");
            car3.setModelo("BMW");
            car3.setPessoa(p3);
            car3.setPlaca("NFT-5990");
            car3.setRenavam("249832478");
            
            
            car1.getAcessorios().add(a1);
            car1.getAcessorios().add(a2);
            car1.getAcessorios().add(a3);
            car1.getAcessorios().add(a4);
            car1.getAcessorios().add(a5);
            car1.getAcessorios().add(a6);
            
            car2.getAcessorios().add(a1);
            car2.getAcessorios().add(a2);
            car2.getAcessorios().add(a3);
            car2.getAcessorios().add(a4);
            car2.getAcessorios().add(a5);
            car2.getAcessorios().add(a6);
            
            car3.getAcessorios().add(a1);
            car3.getAcessorios().add(a2);
            car3.getAcessorios().add(a3);
            car3.getAcessorios().add(a4);
            car3.getAcessorios().add(a5);
            car3.getAcessorios().add(a6);
            
            
            
            /*Seguro s1 = new Seguro();
            s1.setCarro(car1);
            s1.setCorretor(c1);
            s1.setData(new GregorianCalendar(2012,3,5));
            s1.setIniciovigencia(new GregorianCalendar(2013,5,10));
            s1.setFimvigencia(new GregorianCalendar(2014,1,20));
            s1.setValorFipe(230.00);
            s1.setValorTotal(s1.getValorFipe()* s1.calculariniciofimdata());*/
            
            
            
            /*Seguro s2 = new Seguro();
            s2.setCarro(car2);
            s2.setCorretor(c2);
            s2.setData(new GregorianCalendar(2011,10,20));
            s2.setIniciovigencia(new GregorianCalendar(2015,7,18));
            s2.setFimvigencia(new GregorianCalendar(2016,1,25));
            s2.setValorFipe(575.00);
            s2.setValorTotal(s2.getValorFipe()* s2.calculariniciofimdata());*/
            
            
            
            
            /*Cobertura co= new Cobertura();
            co.setDescricao("preto");
            co.setValor(350.00);
            co.setSeguro(s1);*/
            
            
            
            /*Cobertura co2= new Cobertura();
            co2.setDescricao("azul");
            co2.setValor(221.00);
            co2.setSeguro(s2);*/
            
            
            /*s1.getCobertura().add(co);
            s2.getCobertura().add(co2);
            
            
            
            Sinistro st1=new Sinistro();
            st1.setCidade("Passo Fundo");
            st1.setData(new GregorianCalendar(2016,9,10));
            st1.setDescricao("Sinistro realizado a direito toritários");
            st1.setEstado("RS");
            st1.setSeguro(s1);
            
            
            
            Sinistro st2=new Sinistro();
            st2.setCidade("Floripa");
            st2.setData(new GregorianCalendar(2017,3,30));
            st2.setDescricao("Sinistro direito totais da cidade");
            st2.setEstado("SC");
            st2.setSeguro(s2);
            
            
            s1.getSinistro().add(st1);
            s2.getSinistro().add(st2);*/
            
            
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            //em.persist(c1);
            //em.persist(c2);
            em.persist(car1);
            em.persist(car2);
            em.persist(car3);
            em.persist(a1);
            em.persist(a2);
            em.persist(a3);
            em.persist(a4);
            em.persist(a5);
            em.persist(a6);
            /*em.persist(s1);
            em.persist(s2);
            em.persist(co);
            em.persist(co2);
            em.persist(st1);
            em.persist(st2);*/
            em.getTransaction().commit();
        }catch(Exception e)
        {
            exception = true;
            e.printStackTrace();
        }
        
        // o método abaixo verifica se o valor  esperado(false)é igual ao valor doa tributo exception 
        // que vai indifcar se ocorreu ou não erro, se não ocorrer erro o teste passa
        
        Assert.assertEquals(false, exception);
    }
    
}
