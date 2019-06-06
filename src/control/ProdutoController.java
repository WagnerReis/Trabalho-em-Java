package control;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;

public class ProdutoController {

    private static ProdutoController produtoController;

    public static ProdutoController getInstance() {
        if (produtoController == null) {
            produtoController = new ProdutoController();
        }
        return produtoController;
    }

    public List<Produto> buscarTodos() {
        return ProdutoDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return ProdutoDAO.getInstance().deletar(id);

    }

    public boolean persistir(Produto produto) {
        return ProdutoDAO.getInstance().persistir(produto);
    }

    public Produto buscarID(Long id) {

        return ProdutoDAO.getInstance().buscarID(id);
    }

    public List<Produto> pesquisar(String texto) {
        return ProdutoDAO.getInstance().pesquisar(texto);
    }

    public List<Produto> buscarTodosProdutos() {
        return ProdutoDAO.getInstance().buscarTodos();
    }

}
