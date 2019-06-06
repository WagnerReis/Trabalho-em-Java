package Daos;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDaoTest {

    public ClienteDaoTest() {
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
        Cliente c = new Cliente();
        c.setNome("A");
        c.setTelefone("316463");
        c.setCelular("16543122");
        c.setTipo(1);
        c.setCpf("1111111");
        c.setCnpj("4654354");
        c.setEstado("mg");
        c.setCidade("jf");
        c.setBairro("centro");
        c.setRua("rua a");
        c.setNumero(20);

        assertEquals(true, ClienteDAO.getInstance().persistir(c));
    }
    
    @Test
    public void update() {
        Cliente c = new Cliente();
        c.setId(ClienteDAO.getInstance().getLastID());
        c.setNome("b");
        c.setTelefone("351541321");
        c.setCelular("3165435135165");
        c.setTipo(0);
        c.setCpf("222222");
        c.setCnpj("21354534354");
        c.setEstado("rj");
        c.setCidade("rj");
        c.setBairro("qualquer");
        c.setRua("rua b");
        c.setNumero(234);

        assertEquals(true, ClienteDAO.getInstance().persistir(c));
    }
    
    @Test
    public void buscarTodos() {
       List<Cliente> clientes = ClienteDAO.getInstance().buscarTodos();
       assertEquals(true, clientes.size() > 0);
    }
  
    @Test
    public void pesquisar() {
       List<Cliente> clientes = ClienteDAO.getInstance().pesquisar("A");
       assertEquals(true, clientes.size() > 0);
    }
  
    
    @Test
    public void buscarID() {
       Cliente c = ClienteDAO.getInstance().buscarID(
               ClienteDAO.getInstance().getLastID());
        assertNotNull(c);
    }
  
    @Test
    public void deletar() {
        assertEquals(true, ClienteDAO.getInstance().deletar(
                ClienteDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Cliente c = ClienteDAO.getInstance().buscarID(
                ClienteDAO.getInstance().getLastID());
        
        assertEquals(true, ClienteDAO.getInstance().deletar(c));
    }

}
