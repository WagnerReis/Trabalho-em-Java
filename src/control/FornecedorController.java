package control;

import dao.FornecedorDAO;
import java.util.List;
import model.Fornecedor;

public class FornecedorController {

    private static FornecedorController fornecedorController;

    public static FornecedorController getInstance() {
        if (fornecedorController == null) {
            fornecedorController = new FornecedorController();
        }
        return fornecedorController;
    }

    public List<Fornecedor> buscarTodos() {
        return FornecedorDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return FornecedorDAO.getInstance().deletar(id);

    }

    public boolean persistir(Fornecedor fornecedor) {
        return FornecedorDAO.getInstance().persistir(fornecedor);
    }

    public Fornecedor buscarID(Long id) {

        return FornecedorDAO.getInstance().buscarID(id);
    }

    public List<Fornecedor> pesquisar(String texto) {
        return FornecedorDAO.getInstance().pesquisar(texto);
    }

}
