package control;

import dao.ItemCompraDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import model.ItemCompra;
import model.Produto;

public class ItemCompraController {

    private static ItemCompraController itemCompraController;

    public static ItemCompraController getInstance() {
        if (itemCompraController == null) {
            itemCompraController = new ItemCompraController();
        }
        return itemCompraController;
    }

    public List<ItemCompra> buscarTodos() {
        return ItemCompraDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return ItemCompraDAO.getInstance().deletar(id);

    }

    public boolean persistir(ItemCompra itemCompra) {
        return ItemCompraDAO.getInstance().persistir(itemCompra);
    }

    public ItemCompra buscarID(Long id) {

        return ItemCompraDAO.getInstance().buscarID(id);
    }

    public List<ItemCompra> pesquisar(String texto) {
        return ItemCompraDAO.getInstance().pesquisar(texto);
    }

    public List<Produto> buscarTodasProdutos() {
        return ProdutoDAO.getInstance().buscarTodos();
    }

}
