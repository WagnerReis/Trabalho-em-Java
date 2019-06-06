package Daos;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioDaoTest {
    
    public UsuarioDaoTest() {
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
        Usuario u = new Usuario();
        u.setLogin("login1");
        u.setSenha("senha1");
        
        assertEquals(true, UsuarioDAO.getInstance().persistir(u));
    }
    
    @Test
    public void update() {
        Usuario u = new Usuario();
        u.setId(UsuarioDAO.getInstance().getLastID());
        u.setLogin("login2");
        u.setSenha("senha2");
        
        assertEquals(true, UsuarioDAO.getInstance().persistir(u));
    }
    
    @Test
    public void buscarTodos() {
       List<Usuario> usuarios = UsuarioDAO.getInstance().buscarTodos();
       assertEquals(true, usuarios.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Usuario> usuarios = UsuarioDAO.getInstance().pesquisar("login1");
       assertEquals(true, usuarios.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Usuario u = UsuarioDAO.getInstance().buscarID(
               UsuarioDAO.getInstance().getLastID());
        assertNotNull(u);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, UsuarioDAO.getInstance().deletar(
                UsuarioDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Usuario u = UsuarioDAO.getInstance().buscarID(
                UsuarioDAO.getInstance().getLastID());
        
        assertEquals(true, UsuarioDAO.getInstance().deletar(u));
    }
}
