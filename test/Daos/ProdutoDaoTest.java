package Daos;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoDaoTest {
    
    public ProdutoDaoTest() {
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
        Produto p = new Produto();
        p.setNome("A");
        p.setValor(200.0f);
        p.setDescricao("Qualquer descricao");

        assertEquals(true, ProdutoDAO.getInstance().persistir(p));
    }
    
    @Test
    public void update() {
        Produto p = new Produto();
        p.setId(ProdutoDAO.getInstance().getLastID());
        p.setNome("b");
        p.setValor(300.f);
        p.setDescricao("Outra descrição");

        assertEquals(true, ProdutoDAO.getInstance().persistir(p));
    }
    
    @Test
    public void buscarTodos() {
       List<Produto> produtos = ProdutoDAO.getInstance().buscarTodos();
       assertEquals(true, produtos.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Produto> produtos = ProdutoDAO.getInstance().pesquisar("A");
       assertEquals(true, produtos.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Produto p = ProdutoDAO.getInstance().buscarID(
               ProdutoDAO.getInstance().getLastID());
        assertNotNull(p);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, ProdutoDAO.getInstance().deletar(
                ProdutoDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Produto p = ProdutoDAO.getInstance().buscarID(
                ProdutoDAO.getInstance().getLastID());
        
        assertEquals(true, ProdutoDAO.getInstance().deletar(p));
    }
}
