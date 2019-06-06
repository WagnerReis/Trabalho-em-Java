package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ItemVenda;
import util.BDUtil;
import util.ConexaoPostGree;

public class ItemVendaDAO {

    private static ItemVendaDAO itemVendaDAO;

    public static ItemVendaDAO getInstance() {
        if (itemVendaDAO == null) {
            itemVendaDAO = new ItemVendaDAO();
        }
        return itemVendaDAO;
    }

    public boolean persistir(ItemVenda iv) {

        String sql;
        int retorno = 0;

        if (iv.getId() != null) {
            sql = " update item_venda set quantidade=?, valor=?, id_venda=?, id_produto=? where id = ? ";
        } else {
            iv.setId(BDUtil.getNextID());

            sql = " insert into item_venda (quantidade, valor, id_venda, id_produto, id) values (?, ?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setInt(1, iv.getQuantidade());
            state.setFloat(2, iv.getValor());
            state.setLong(3, iv.getVenda().getId());
            state.setLong(4, iv.getProduto().getId());
            state.setLong(5, iv.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do ItemVenda. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<ItemVenda> buscarTodos() {

        String sql
                = " select * from item_venda as iv "
                + " order by iv.id ";

        ArrayList<ItemVenda> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getItemVenda(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private ItemVenda getItemVenda(ResultSet rs) throws SQLException {

        ItemVenda iv = new ItemVenda();
        iv.setId(rs.getLong("id"));
        iv.setQuantidade(rs.getInt("quantidade"));
        iv.setVenda(VendaDAO.getInstance().buscarID(rs.getLong("id_venda")));
        iv.setProduto(ProdutoDAO.getInstance().buscarID(rs.getLong("id_produto")));

        return iv;
    }

    public ItemVenda buscarID(long pId) {
        String sql
                = " select * from item_venda as iv "
                + " where iv.id=" + pId;

        ItemVenda retorno = null;
        try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getItemVenda(rs);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(ItemVenda iv) {
        return deletar(iv.getId());
    }

    public boolean deletar(Long idItemVenda) {
        int retorno = 0;
        String sql = " delete from item_venda where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idItemVenda);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o ItemVenda. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("item_venda");

    }

    public List<ItemVenda> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from item_venda as iv  ";

        ArrayList<ItemVenda> retorno = new ArrayList<ItemVenda>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getItemVenda(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;

    }

    public List<ItemVenda> buscar(int indice, String texto) {

        String sql = " select iv.id, iv.quantidade, iv.id_venda, iv.id_produto from item_venda as iv ";

        if (!texto.equals("")) {
            if (indice == 0) { // id 
                sql += " where iv.id =" + texto;
            }
        }

        sql += " order by " + indice;
        List<ItemVenda> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getItemVenda(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

    public ArrayList<ItemVenda> buscarPorItemVenda(long idVenda) {

        String sql
                = " select * from venda v "
                + " inner join item_venda as iv on v.id = iv.id"
                + " where iv.id=" + idVenda;

        ArrayList<ItemVenda> retorno = new ArrayList<ItemVenda>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getItemVenda(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return retorno;
    }
}
