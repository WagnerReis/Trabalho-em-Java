package Daos;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.VendaDAO;
import java.util.Date;
import java.util.List;
import model.Venda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaDaoTest {
    
    public VendaDaoTest() {
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
        Venda v = new Venda();
        v.setData( new Date(2018/31/10));
        
        v.setCliente(ClienteDAO.getInstance().buscarID(ClienteDAO.getInstance().getLastID()));
        v.setFuncionario(FuncionarioDAO.getInstance().buscarID(FuncionarioDAO.getInstance().getLastID()));
        
        assertEquals(true, VendaDAO.getInstance().persistir(v));
    }
    
    @Test
    public void update() {
        Venda v = new Venda();
        v.setId(VendaDAO.getInstance().getLastID());
        v.setData( new Date(2018/01/10));

        v.setCliente(ClienteDAO.getInstance().buscarID(ClienteDAO.getInstance().getLastID()));
        v.setFuncionario(FuncionarioDAO.getInstance().buscarID(FuncionarioDAO.getInstance().getLastID()));
        
        assertEquals(true, VendaDAO.getInstance().persistir(v));
    }
    
    @Test
    public void buscarTodos() {
       List<Venda> vendas = VendaDAO.getInstance().buscarTodos();
       assertEquals(true, vendas.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Venda> vendas = VendaDAO.getInstance().pesquisar("185");
       assertEquals(true, vendas.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Venda v = VendaDAO.getInstance().buscarID(
               VendaDAO.getInstance().getLastID());
        assertNotNull(v);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, VendaDAO.getInstance().deletar(
                VendaDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Venda iv = VendaDAO.getInstance().buscarID(
                VendaDAO.getInstance().getLastID());
        
        assertEquals(true, VendaDAO.getInstance().deletar(iv));
    }
}
