package control;

import dao.CompraDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import java.util.List;
import model.Compra;
import model.Fornecedor;
import model.Funcionario;

public class CompraController {

    private static CompraController compraController;

    public static CompraController getInstance() {
        if (compraController == null) {
            compraController = new CompraController();
        }
        return compraController;
    }

    public List<Compra> buscarTodos() {
        return CompraDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return CompraDAO.getInstance().deletar(id);

    }

    public boolean persistir(Compra compra) {
        return CompraDAO.getInstance().persistir(compra);
    }

    public Compra buscarID(Long id) {

        return CompraDAO.getInstance().buscarID(id);
    }

    public List<Compra> pesquisar(String texto) {
        return CompraDAO.getInstance().pesquisar(texto);
    }

    public List<Fornecedor> buscarTodasFornecedor() {
        return FornecedorDAO.getInstance().buscarTodos();
    }

    public List<Funcionario> buscarTodasFuncionario() {
        return FuncionarioDAO.getInstance().buscarTodos();
    }

}
