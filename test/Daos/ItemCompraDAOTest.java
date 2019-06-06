package Daos;

import dao.ItemCompraDAO;
import dao.ProdutoDAO;
import java.util.List;
import model.ItemCompra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemCompraDAOTest {
    
    public ItemCompraDAOTest() {
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
        ItemCompra i = new  ItemCompra();
        i.setValor(10f);
        i.setQuantidade(25);
        i.setProduto(ProdutoDAO.getInstance().buscarID(ProdutoDAO.getInstance().getLastID()));
        
        assertEquals(true, ItemCompraDAO.getInstance().persistir(i));
    }

    @Test
    public void update() {
            ItemCompra i = new  ItemCompra();
         i.setValor(10f);
        i.setQuantidade(25);
        i.setProduto(ProdutoDAO.getInstance().buscarID(ProdutoDAO.getInstance().getLastID()));
       
        assertEquals(true, ItemCompraDAO.getInstance().persistir(i));
    }

    @Test
    public void buscarTodos() {
        List<ItemCompra> itemCompra = ItemCompraDAO.getInstance().buscarTodos();
        assertEquals(true, itemCompra.size() > 0);
    }

    @Test
    public void pesquisar() {
        List<ItemCompra> itemCompra = ItemCompraDAO.getInstance().pesquisar("2");
        assertEquals(true, itemCompra.size() > 0);
    }

    @Test
    public void buscarID() {
       ItemCompra itemCompra = ItemCompraDAO.getInstance().buscarID(
                ItemCompraDAO.getInstance().getLastID());
        assertNotNull(itemCompra);
    }

   
    @Test
    public void deletar() {
        assertEquals(true,ItemCompraDAO.getInstance().deletar(
                ItemCompraDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
       ItemCompra i = ItemCompraDAO.getInstance().buscarID(
                ItemCompraDAO.getInstance().getLastID());
        
        assertEquals(true, ItemCompraDAO.getInstance().deletar(i));
    }
  


    
    
    
    
    
    
    
    
}
