package Daos;

import dao.EntregaDAO;
import dao.VendaDAO;
import java.util.Date;
import java.util.List;
import model.Entrega;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntregaDaoTest {

    public EntregaDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void inserir() {
        Entrega et = new Entrega();
        et.setData(new Date(1997/31/10));
        et.setEstado("mg");
        et.setCidade("jf");
        et.setRua("rua a");
        et.setNumero(20);
        et.setBairro("aa");
        et.setReferencia("assdsadad");
        
        et.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));

        assertEquals(true, EntregaDAO.getInstance().persistir(et));
    }
    
    @Test
    public void update() {
        Entrega et = new Entrega();
        et.setId(EntregaDAO.getInstance().getLastID());
        et.setEstado("rj");
        et.setCidade("rj");
        et.setRua("rua b");
        et.setNumero(234);
        et.setBairro("qualquer");
        et.setReferencia("kkasda");
        
        et.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));
        
        assertEquals(true, EntregaDAO.getInstance().persistir(et));
    }
    
    @Test
    public void buscarTodos() {
       List<Entrega> instituicoes = EntregaDAO.getInstance().buscarTodos();
       assertEquals(true, instituicoes.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Entrega> instituicoes = EntregaDAO.getInstance().pesquisar("139");
       assertEquals(true, instituicoes.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Entrega et = EntregaDAO.getInstance().buscarID(
               EntregaDAO.getInstance().getLastID());
        assertNotNull(et);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, EntregaDAO.getInstance().deletar(
                EntregaDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Entrega cf = EntregaDAO.getInstance().buscarID(
                EntregaDAO.getInstance().getLastID());
        
        assertEquals(true, EntregaDAO.getInstance().deletar(cf));
    }

}
