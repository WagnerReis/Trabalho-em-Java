package control;

import dao.CompraDAO;
import dao.ContaPagarDAO;
import dao.ProdutoDAO;
import java.util.List;
import model.Compra;
import model.ContaPagar;
import model.Produto;

public class ContaPagarController {

    private static ContaPagarController contaPagarController;

    public static ContaPagarController getInstance() {
        if (contaPagarController == null) {
            contaPagarController = new ContaPagarController();
        }
        return contaPagarController;
    }

    public List<ContaPagar> buscarTodos() {
        return ContaPagarDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return ContaPagarDAO.getInstance().deletar(id);

    }

    public boolean persistir(ContaPagar contaPagar) {
        return ContaPagarDAO.getInstance().persistir(contaPagar);
    }

    public ContaPagar buscarID(Long id) {

        return ContaPagarDAO.getInstance().buscarID(id);
    }

    public List<ContaPagar> pesquisar(String texto) {
        return ContaPagarDAO.getInstance().pesquisar(texto);
    }

    public List<Compra> buscarTodasCompra() {
        return CompraDAO.getInstance().buscarTodos();
    }

}
