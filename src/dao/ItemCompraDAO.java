package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ItemCompra;
import util.BDUtil;
import util.ConexaoPostGree;

public class ItemCompraDAO {

    private static ItemCompraDAO itemCompraDAO;

    public static ItemCompraDAO getInstance() {
        if (itemCompraDAO == null) {
            itemCompraDAO = new ItemCompraDAO();
        }
        return itemCompraDAO;
    }

    public Long getLastID() {
        return BDUtil.getLastID("item_compra");
    }

    private ItemCompra getItemCompra(ResultSet rs) throws SQLException {

        ItemCompra i = new ItemCompra();
        i.setId(rs.getLong("id"));
        i.setQuantidade(rs.getInt("quantidade"));
        i.setValor(rs.getFloat("valor"));
        i.setProduto(ProdutoDAO.getInstance().buscarID(rs.getLong("id_produto")));
        i.setProduto(ProdutoDAO.getInstance().buscarID(rs.getLong("id_compra")));

        return i;
    }

    public ArrayList<ItemCompra> buscarTodos() {

        String sql
                = " select * from item_compra as a "
                + " order by a.id ";

        ArrayList<ItemCompra> retorno = new ArrayList<ItemCompra>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getItemCompra(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean persistir(ItemCompra itemCompra) {
        String sql;

        int retorno = 0;
        if (itemCompra.getId() != null) {
            sql = " update item_compra set  quantidade=?, valor= ?, id_produto=?, id_compra=? "
                    + " where id = ? ";
        } else {
            itemCompra.setId(BDUtil.getNextID());

            sql = " insert into item_compra ( quantidade, valor, id_produto , id_compra,id) values "
                    + " (?,?,?,?,?)";
        }
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setInt(1, itemCompra.getQuantidade());
            state.setFloat(2, itemCompra.getValor());
            state.setLong(3, itemCompra.getProduto().getId());
            state.setLong(4, itemCompra.getCompra().getId());
            state.setLong(5, itemCompra.getId());

            state.executeUpdate();
            state.close();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do itemCompra. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public boolean deletar(ItemCompra itemCompra) {
        return deletar(itemCompra.getId());
    }

    public boolean deletar(Long idItemCompra) {
        int retorno = 0;
        String sql = " delete from item_compra where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idItemCompra);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a ItemCompra. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ItemCompra buscarID(long pId) {
        String sql
                = " select * from item_compra as i "
                + " where i.id=" + pId;

        ItemCompra retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getItemCompra(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public List<ItemCompra> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from item_compra as i  ";

        ArrayList<ItemCompra> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getItemCompra(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
