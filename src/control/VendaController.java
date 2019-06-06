package control;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.ItemVendaDAO;
import dao.VendaDAO;
import java.util.List;
import model.Cliente;
import model.Funcionario;
import model.ItemVenda;
import model.Venda;

public class VendaController {

    private static VendaController vendaController;

    public static VendaController getInstance() {
        if (vendaController == null) {
            vendaController = new VendaController();
        }
        return vendaController;
    }

    public List<Venda> buscarTodos() {
        return VendaDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return VendaDAO.getInstance().deletar(id);

    }

    public boolean persistir(Venda itemVenda) {
        return VendaDAO.getInstance().persistir(itemVenda);
    }

    public Venda buscarID(Long id) {

        return VendaDAO.getInstance().buscarID(id);
    }

    public List<Venda> buscar(int indice, String texto) {

        return VendaDAO.getInstance().buscar(indice, texto);
    }

    public List<Cliente> buscarTodosClientes() {
        return ClienteDAO.getInstance().buscarTodos();
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return FuncionarioDAO.getInstance().buscarTodos();
    }

    public List<Venda> pesquisar(String texto) {
        return VendaDAO.getInstance().pesquisar(texto);
    }
}
