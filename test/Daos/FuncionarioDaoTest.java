package Daos;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioDaoTest {

    public FuncionarioDaoTest() {
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
        Funcionario f = new Funcionario();
        f.setNome("A");
        f.setTipo(1);
        f.setCpf("1111111");
        f.setTelefone("13468461521");
        f.setCelular("1365478");
        f.setEstado("mg");
        f.setCidade("jf");
        f.setBairro("centro");
        f.setRua("rua a");
        f.setNumero(20);
        
        f.setUsuario(UsuarioDAO.getInstance().buscarID(UsuarioDAO.getInstance().getLastID()));

        assertEquals(true, FuncionarioDAO.getInstance().persistir(f));
    }
    
    @Test
    public void update() {
        Funcionario f = new Funcionario();
        f.setId(FuncionarioDAO.getInstance().getLastID());
        f.setNome("b");
        f.setTipo(0);
        f.setCpf("222222222");
        f.setTelefone("684486");
        f.setCelular("313446");
        f.setEstado("rj");
        f.setCidade("rj");
        f.setBairro("qualquer");
        f.setRua("rua b");
        f.setNumero(234);
        
        f.setUsuario(UsuarioDAO.getInstance().buscarID(UsuarioDAO.getInstance().getLastID()));

        assertEquals(true, FuncionarioDAO.getInstance().persistir(f));
    }
    
    @Test
    public void buscarTodos() {
       List<Funcionario> f = FuncionarioDAO.getInstance().buscarTodos();
       assertEquals(true, f.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Funcionario> f = FuncionarioDAO.getInstance().pesquisar("A");
       assertEquals(true, f.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Funcionario f = FuncionarioDAO.getInstance().buscarID(
               FuncionarioDAO.getInstance().getLastID());
        assertNotNull(f);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, FuncionarioDAO.getInstance().deletar(
                FuncionarioDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Funcionario f = FuncionarioDAO.getInstance().buscarID(
                FuncionarioDAO.getInstance().getLastID());
        
        assertEquals(true, FuncionarioDAO.getInstance().deletar(f));
    }

}
