package Daos;

import dao.ContaReceberDAO;
import dao.VendaDAO;
import java.util.Date;
import java.util.List;
import model.ContaReceber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ContaReceberDaoTest {
    
    public ContaReceberDaoTest() {
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
    public void persistirNovo() {
        ContaReceber cr = new ContaReceber();
        cr.setValor(200.2f);
        cr.setData( new Date(1997/31/10));
        cr.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));

        assertEquals(true, ContaReceberDAO.getInstance().persistir(cr));
    }

    @Test
    public void persistirAtualizar() {
        ContaReceber cr = new ContaReceber();
        cr.setId(ContaReceberDAO.getInstance().getLastID());
        
        //ContaReceber cr = ContaReceberDAO.getInstance().buscarID(123);
        cr.setValor(300.0f);
        cr.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));
        
        assertEquals(true, ContaReceberDAO.getInstance().persistir(cr));
    }

    @Test
    public void buscarTodos() {

        List<ContaReceber> contas = ContaReceberDAO.getInstance().buscarTodos();

        assertEquals(true, contas.size() > 0);
    }

    @Test
    public void buscarID() {
        ContaReceber cr = ContaReceberDAO.getInstance().buscarID(ContaReceberDAO.getInstance().getLastID());
        assertNotNull(cr);
    }

    @Test
    public void pesquisar() {

        List<ContaReceber> contas = ContaReceberDAO.getInstance().pesquisar("1");

        assertEquals(true, contas.size() > 0);
    }

    @Test
    public void deletarObjeto() {
        ContaReceber cr = ContaReceberDAO.getInstance().buscarID(ContaReceberDAO.getInstance().getLastID());
        assertEquals(true, ContaReceberDAO.getInstance().deletar(cr));
    }

    @Test
    public void deletarLong() {
        assertEquals(true, ContaReceberDAO.getInstance().deletar(ContaReceberDAO.getInstance().getLastID()));
    }
}

