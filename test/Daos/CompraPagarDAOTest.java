package Daos;
import dao.CompraDAO;
import dao.ContaPagarDAO;
import java.util.Date;
import java.util.List;
import model.ContaPagar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompraPagarDAOTest {
    
    public CompraPagarDAOTest() {
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
        ContaPagar i = new  ContaPagar();
        i.setValor(10f);
        i.setData(new Date("31/08/1977"));
        i.setCompra(CompraDAO.getInstance().buscarID(CompraDAO.getInstance().getLastID()));
        
        assertEquals(true, ContaPagarDAO.getInstance().persistir(i));
    }

    @Test
    public void update() {
            ContaPagar i = new  ContaPagar();
        i.setValor(10f);
        i.setData(new Date("31/08/1977"));
        i.setCompra(CompraDAO.getInstance().buscarID(CompraDAO.getInstance().getLastID()));
        
   
        assertEquals(true, ContaPagarDAO.getInstance().persistir(i));
    }

    @Test
    public void buscarTodos() {
        List<ContaPagar> contaPagar = ContaPagarDAO.getInstance().buscarTodos();
        assertEquals(true, contaPagar.size() > 0);
    }

    @Test
    public void pesquisar() {
        List<ContaPagar> contaPagar = ContaPagarDAO.getInstance().pesquisar("2");
        assertEquals(true, contaPagar.size() > 0);
    }

    @Test
    public void buscarID() {
       ContaPagar contaPagar = ContaPagarDAO.getInstance().buscarID(
                ContaPagarDAO.getInstance().getLastID());
        assertNotNull(contaPagar);
    }

   
    @Test
    public void deletar() {
        assertEquals(true, ContaPagarDAO.getInstance().deletar(
                ContaPagarDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        ContaPagar i = ContaPagarDAO.getInstance().buscarID(
                ContaPagarDAO.getInstance().getLastID());
        
        assertEquals(true, ContaPagarDAO.getInstance().deletar(i));
    }
  
}
