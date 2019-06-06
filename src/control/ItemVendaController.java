package control;

import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.util.List;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class ItemVendaController {

    private static ItemVendaController itemVendaController;

    public static ItemVendaController getInstance() {
        if (itemVendaController == null) {
            itemVendaController = new ItemVendaController();
        }
        return itemVendaController;
    }

    public List<ItemVenda> buscarTodos() {
        return ItemVendaDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return ItemVendaDAO.getInstance().deletar(id);

    }

    public boolean persistir(ItemVenda itemVenda) {
        return ItemVendaDAO.getInstance().persistir(itemVenda);
    }

    public ItemVenda buscarID(Long id) {

        return ItemVendaDAO.getInstance().buscarID(id);
    }

    public List<ItemVenda> buscar(int indice, String texto) {

        return ItemVendaDAO.getInstance().buscar(indice, texto);
    }

    public List<Produto> buscarTodosProdutos() {
        return ProdutoDAO.getInstance().buscarTodos();
    }

    public List<Venda> buscarTodasVendas() {
        return VendaDAO.getInstance().buscarTodos();
    }

    public List<ItemVenda> pesquisar(String texto) {
        return ItemVendaDAO.getInstance().pesquisar(texto);
    }
}
