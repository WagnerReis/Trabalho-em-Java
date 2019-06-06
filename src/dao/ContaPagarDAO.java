package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ContaPagar;
import util.BDUtil;
import util.ConexaoPostGree;

public class ContaPagarDAO {

    private static ContaPagarDAO contaPagarDAO;

    public static ContaPagarDAO getInstance() {
        if (contaPagarDAO == null) {
            contaPagarDAO = new ContaPagarDAO();
        }
        return contaPagarDAO;
    }

    public Long getLastID() {
        return BDUtil.getLastID("conta_pagar");

    }

    private ContaPagar getContaPagar(ResultSet rs) throws SQLException {

        ContaPagar i = new ContaPagar();
        i.setId(rs.getLong("id"));
        i.setValor(rs.getFloat("valor"));
        i.setData(rs.getDate("data"));
        i.setCompra(CompraDAO.getInstance().buscarID(rs.getLong("id_compra")));

        return i;
    }

    public ArrayList<ContaPagar> buscarTodos() {

        String sql
                = " select * from conta_pagar as a "
                + " order by a.id ";

        ArrayList<ContaPagar> retorno = new ArrayList<ContaPagar>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getContaPagar(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean persistir(ContaPagar contaPagar) {
        String sql;

        int retorno = 0;
        if (contaPagar.getId() != null) {
            sql = " update conta_pagar set  valor=?, data= ?, id_compra=? "
                    + " where id = ? ";
        } else {
            contaPagar.setId(BDUtil.getNextID());

            sql = " insert into conta_pagar ( valor, data, id_compra, id ) values"
                    + " (?,?,?,?)";
        }
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setFloat(1, contaPagar.getValor());
            state.setDate(2, contaPagar.getData() == null ? null
                    : new java.sql.Date(contaPagar.getData().getTime()));
            state.setLong(3, contaPagar.getCompra().getId());
            state.setLong(4, contaPagar.getId());

            state.executeUpdate();
            state.close();

            // Grava o N x N de Situacoes do Aluno
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do ContaPagar. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public boolean deletar(ContaPagar contaPagar) {
        return deletar(contaPagar.getId());
    }

    public boolean deletar(Long idItemCompra) {
        int retorno = 0;
        String sql = " delete from conta_pagar where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idItemCompra);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a ContaPagar. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ContaPagar buscarID(long pId) {
        String sql
                = " select * from conta_pagar as i "
                + " where i.id=" + pId;

        ContaPagar retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getContaPagar(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public List<ContaPagar> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from conta_pagar as i  ";

        ArrayList<ContaPagar> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getContaPagar(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
