package Daos;

import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.util.List;
import model.ItemVenda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemVendaDaoTest {
    
    public ItemVendaDaoTest() {
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
        ItemVenda iv = new ItemVenda();
        iv.setQuantidade(3);
        iv.setValor(250.0f);
        
        iv.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));
        iv.setProduto(ProdutoDAO.getInstance().buscarID(ProdutoDAO.getInstance().getLastID()));
        
        assertEquals(true, ItemVendaDAO.getInstance().persistir(iv));
    }
    
    @Test
    public void update() {
        ItemVenda iv = new ItemVenda();
        iv.setId(ItemVendaDAO.getInstance().getLastID());
        iv.setQuantidade(5);
        iv.setValor(500.0f);
        
        iv.setVenda(VendaDAO.getInstance().buscarID(VendaDAO.getInstance().getLastID()));
        iv.setProduto(ProdutoDAO.getInstance().buscarID(ProdutoDAO.getInstance().getLastID()));
        
        assertEquals(true, ItemVendaDAO.getInstance().persistir(iv));
    }
    
    @Test
    public void buscarTodos() {
       List<ItemVenda> iVendas = ItemVendaDAO.getInstance().buscarTodos();
       assertEquals(true, iVendas.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<ItemVenda> iVendas = ItemVendaDAO.getInstance().pesquisar("176");
       assertEquals(true, iVendas.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       ItemVenda iv = ItemVendaDAO.getInstance().buscarID(
               ItemVendaDAO.getInstance().getLastID());
        assertNotNull(iv);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, ItemVendaDAO.getInstance().deletar(
                ItemVendaDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        ItemVenda iv = ItemVendaDAO.getInstance().buscarID(
                ItemVendaDAO.getInstance().getLastID());
        
        assertEquals(true, ItemVendaDAO.getInstance().deletar(iv));
    }
}
