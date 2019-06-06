package control;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteController {

    private static ClienteController clienteController;

    public static ClienteController getInstance() {
        if (clienteController == null) {
            clienteController = new ClienteController();
        }
        return clienteController;
    }

    public List<Cliente> buscarTodos() {
        return ClienteDAO.getInstance().buscarTodos();
    }

    public ArrayList<Cliente> buscarPorNome(String nome) {
        return ClienteDAO.getInstance().buscarNome(nome);
    }

    public boolean deletar(Long id) {
        return ClienteDAO.getInstance().deletar(id);

    }

    public boolean persistir(Cliente cliente) {
        return ClienteDAO.getInstance().persistir(cliente);
    }

    public Cliente buscarID(Long id) {

        return ClienteDAO.getInstance().buscarID(id);
    }

    public List<Cliente> buscar(int indice, String texto) {

        return ClienteDAO.getInstance().buscar(indice, texto);
    }

    public List<Cliente> pesquisar(String texto) {
        return ClienteDAO.getInstance().pesquisar(texto);
    }
}
