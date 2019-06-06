package Daos;

import dao.CompraDAO;
import dao.ContaPagarDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import dao.ItemCompraDAO;
import java.util.Date;
import java.util.List;
import model.Compra;
import model.ContaPagar;
import model.ItemCompra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompraDAOTest {
    
    public CompraDAOTest() {
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

    //------------------------------------------------
    @Test
    public void inserir() {
       Compra i = new Compra();
        i.setData(new Date("31/08/1977"));
        i.setFornecedor(FornecedorDAO.getInstance().buscarID(FornecedorDAO.getInstance().getLastID()));
        i.setFuncionario(FuncionarioDAO.getInstance().buscarID(FuncionarioDAO.getInstance().getLastID()));
        
        
        assertEquals(true, CompraDAO.getInstance().persistir(i));
    }

    @Test
    public void update() {
       Compra i = new Compra();
        i.setData(new Date("31/08/1977"));
        i.setFornecedor(FornecedorDAO.getInstance().buscarID(FornecedorDAO.getInstance().getLastID()));
        i.setFuncionario(FuncionarioDAO.getInstance().buscarID(FuncionarioDAO.getInstance().getLastID()));
        
       
        
        assertEquals(true, CompraDAO.getInstance().persistir(i));
    }

    @Test
    public void buscarTodos() {
        List<Compra> compras = CompraDAO.getInstance().buscarTodos();
        assertEquals(true, compras.size() > 0);
    }

    @Test
    public void pesquisar() {
        List<Compra> compra = CompraDAO.getInstance().pesquisar("1");
        assertEquals(true, compra.size() > 0);
    }

    @Test
    public void buscarID() {
        Compra compra = CompraDAO.getInstance().buscarID(
               CompraDAO.getInstance().getLastID());
        assertNotNull(compra);
    }

   
    @Test
    public void deletar() {
        assertEquals(true, CompraDAO.getInstance().deletar(
                CompraDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
       Compra i = CompraDAO.getInstance().buscarID(
                CompraDAO.getInstance().getLastID());
        
        assertEquals(true, CompraDAO.getInstance().deletar(i));
    }
  
}

    
    
    
  
    
    
    
    
    
    
    
    

