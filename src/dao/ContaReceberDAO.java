package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ContaReceber;
import util.BDUtil;
import util.ConexaoPostGree;

public class ContaReceberDAO {

    private static ContaReceberDAO contaReceberDAO;

    public static ContaReceberDAO getInstance() {
        if (contaReceberDAO == null) {
            contaReceberDAO = new ContaReceberDAO();
        }
        return contaReceberDAO;
    }

    public boolean persistir(ContaReceber cr) {

        String sql;
        int retorno = 0;

        if (cr.getId() != null) {
            sql = " update conta_receber set valor=?, data=?, id_venda=? where id = ? ";
        } else {
            cr.setId(BDUtil.getNextID());

            sql = " insert into conta_receber (valor, data, id_venda, id) values (?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setFloat(1, cr.getValor());
            state.setDate(2, cr.getData() == null ? null
                    : new java.sql.Date(cr.getData().getTime()));
            state.setLong(3, cr.getVenda().getId());
            state.setLong(4, cr.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência da conta à receber. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<ContaReceber> buscarTodos() {

        String sql
                = " select * from conta_receber as cr "
                + " order by cr.id ";

        ArrayList<ContaReceber> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getContaReceber(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    private ContaReceber getContaReceber(ResultSet rs) throws SQLException {

        ContaReceber cr = new ContaReceber();
        cr.setId(rs.getLong("id"));
        cr.setValor(rs.getFloat("valor"));
        cr.setData(rs.getDate("data"));
        cr.setVenda(VendaDAO.getInstance().buscarID(rs.getLong("id_venda")));

        return cr;
    }

    public ContaReceber buscarID(long pId) {
        String sql
                = " select * from conta_receber as cr "
                + " where cr.id=" + pId;

        ContaReceber retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getContaReceber(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean deletar(ContaReceber cr) {
        return deletar(cr.getId());
    }

    public boolean deletar(Long idContaReceber) {
        int retorno = 0;
        String sql = " delete from conta_receber where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idContaReceber);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a conta. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("conta_receber");

    }

    public List<ContaReceber> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from conta_receber as cr  ";
        ArrayList<ContaReceber> retorno = new ArrayList<ContaReceber>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getContaReceber(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

    public ArrayList<ContaReceber> buscarPorVenda(long idVenda) {

        String sql
                = " select * from venda v "
                + " inner join conta_receber as cr on v.id = cr.id"
                + " where cr.id=" + idVenda;

        ArrayList<ContaReceber> retorno = new ArrayList<ContaReceber>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getContaReceber(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return retorno;
    }

    public List<ContaReceber> buscar(int indice, String texto) {

        String sql = " select cr.id, cr.valor, cr.data, cr.id_venda from conta_receber as cr ";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where e.id =" + texto;
            }
        }

        sql += " order by " + indice;
        List<ContaReceber> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getContaReceber(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
