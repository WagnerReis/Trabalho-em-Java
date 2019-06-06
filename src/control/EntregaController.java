package control;

import dao.EntregaDAO;
import dao.VendaDAO;
import java.util.List;
import model.Entrega;
import model.Venda;

public class EntregaController {

    private static EntregaController entregaController;

    public static EntregaController getInstance() {
        if (entregaController == null) {
            entregaController = new EntregaController();
        }
        return entregaController;
    }

    public List<Entrega> buscarTodos() {
        return EntregaDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return EntregaDAO.getInstance().deletar(id);

    }

    public boolean persistir(Entrega entrega) {
        return EntregaDAO.getInstance().persistir(entrega);
    }

    public Entrega buscarID(Long id) {

        return EntregaDAO.getInstance().buscarID(id);
    }

    public List<Entrega> buscar(int indice, String texto) {

        return EntregaDAO.getInstance().buscar(indice, texto);
    }

    public List<Venda> buscarTodasVendas() {
        return VendaDAO.getInstance().buscarTodos();
    }

    public List<Entrega> pesquisar(String texto) {
        return EntregaDAO.getInstance().pesquisar(texto);
    }
}
