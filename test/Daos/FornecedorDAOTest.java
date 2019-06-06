package Daos;
import dao.FornecedorDAO;
import java.util.List;
import model.Fornecedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FornecedorDAOTest {

    public FornecedorDAOTest() {
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
        Fornecedor i = new Fornecedor();
        i.setTelefone("32811104");
        i.setCelular("98775689");
        i.setRazaoSocial("Peassaveira");
        i.setCnpj("12345679");
        i.setEstado("MG");
        i.setCidade("Amazonia");
        i.setBairro("Centro");
        i.setRua("Oscar Vidal");
        i.setNumero(22);

        assertEquals(true, FornecedorDAO.getInstance().persistir(i));

    }

    @Test
    public void update() {
         Fornecedor i = new Fornecedor();
        i.setTelefone("32811104");
        i.setCelular("98775689");
        i.setRazaoSocial("mario");
        i.setCnpj("12345679");
        i.setEstado("MG");
        i.setCidade("Amazonia");
        i.setBairro("Centro");
        i.setRua("Oscar Vidal");
        i.setNumero(22);
        assertEquals(true, FornecedorDAO.getInstance().persistir(i));
    }

    @Test
    public void buscarTodos() {
        List<Fornecedor> fornecedores = FornecedorDAO.getInstance().buscarTodos();
        assertEquals(true, fornecedores.size() > 0);
    }

    @Test
    public void pesquisar() {
        List<Fornecedor> fornecedor = FornecedorDAO.getInstance().pesquisar("jairo");
        assertEquals(true, fornecedor.size() > 0);
    }

    @Test
    public void buscarID() {
        Fornecedor fornecedor = FornecedorDAO.getInstance().buscarID(
                FornecedorDAO.getInstance().getLastID());
        assertNotNull(fornecedor);
    }

   
    @Test
    public void deletar() {
        assertEquals(true, FornecedorDAO.getInstance().deletar(
                FornecedorDAO.getInstance().getLastID()));
    }
  
    @Test
    public void deletarObjeto() {
        Fornecedor i = FornecedorDAO.getInstance().buscarID(
                FornecedorDAO.getInstance().getLastID());
        
        assertEquals(true, FornecedorDAO.getInstance().deletar(i));
    }
  
}
