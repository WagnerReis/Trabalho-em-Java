package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Compra;
import util.BDUtil;
import util.ConexaoPostGree;

public class CompraDAO {

    private static CompraDAO compraDAO;

    public static CompraDAO getInstance() {
        if (compraDAO == null) {
            compraDAO = new CompraDAO();
        }
        return compraDAO;
    }

    public Long getLastID() {
        return BDUtil.getLastID("compra");

    }

    private Compra getCompra(ResultSet rs) throws SQLException {

        Compra compra = new Compra();
        compra.setId(rs.getLong("id"));
        compra.setData(rs.getDate("data"));
        compra.setFornecedor(FornecedorDAO.getInstance().buscarID(rs.getLong("id_fornecedor")));
        //   compra.setContaPagar(ContaPagarDAO.getInstance().buscarTodos());
        //   compra.setItemCompra(ItemCompraDAO.getInstance().buscarTodos());
        compra.setFuncionario(FuncionarioDAO.getInstance().buscarID(rs.getLong("id_funcionario")));

        return compra;
    }

    public ArrayList<Compra> buscarTodos() {

        String sql
                = " select * from compra as a "
                + " order by a.id ";

        ArrayList<Compra> retorno = new ArrayList<Compra>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getCompra(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean persistir(Compra compra) {
        String sql;

        int retorno = 0;
        if (compra.getId() != null) {
            sql = " update compra set  data=?, id_fornecedor=?, id_funcionario=? "
                    + " where id = ? ";
        } else {
            compra.setId(BDUtil.getNextID());

            sql = " insert into compra (data,id_fornecedor,id_funcionario, id) values "
                    + " (?,?,?,?)";
        }
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setDate(1, compra.getData() == null ? null
                    : new java.sql.Date(compra.getData().getTime()));
            state.setLong(2, compra.getFornecedor().getId());
            state.setLong(3, compra.getFuncionario().getId());
            state.setLong(4, compra.getId());

            state.executeUpdate();
            state.close();

            // Grava o N x N de Situacoes do Aluno
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Fornecedor. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public boolean deletar(Compra compra) {
        return deletar(compra.getId());
    }

    public boolean deletar(Long idCompra) {
        int retorno = 0;
        String sql = " delete from compra where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idCompra);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a Compra. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Compra buscarID(long pId) {
        String sql
                = " select * from compra as i "
                + " where i.id=" + pId;

        Compra retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getCompra(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public List<Compra> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from compra as i  ";
        // + " where i.id = " + id
        //+ " order by i.id";

        ArrayList<Compra> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getCompra(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }
}
