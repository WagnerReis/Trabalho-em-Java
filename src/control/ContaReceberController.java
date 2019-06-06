package control;

import dao.ContaReceberDAO;
import dao.VendaDAO;
import java.util.List;
import model.ContaReceber;
import model.Venda;

public class ContaReceberController {

    private static ContaReceberController contaReceberController;

    public static ContaReceberController getInstance() {
        if (contaReceberController == null) {
            contaReceberController = new ContaReceberController();
        }
        return contaReceberController;
    }

    public List<ContaReceber> buscarTodos() {
        return ContaReceberDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return ContaReceberDAO.getInstance().deletar(id);

    }

    public boolean persistir(ContaReceber contaReceber) {
        return ContaReceberDAO.getInstance().persistir(contaReceber);
    }

    public ContaReceber buscarID(Long id) {

        return ContaReceberDAO.getInstance().buscarID(id);
    }

    public List<ContaReceber> buscar(int indice, String texto) {

        return ContaReceberDAO.getInstance().buscar(indice, texto);
    }

    public List<Venda> buscarTodasVendas() {
        return VendaDAO.getInstance().buscarTodos();
    }

    public List<ContaReceber> pesquisar(String texto) {
        return ContaReceberDAO.getInstance().pesquisar(texto);
    }
}
