package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Venda;
import util.BDUtil;
import util.ConexaoPostGree;


public class VendaDAO {

    private static VendaDAO vendaDAO;

    public static VendaDAO getInstance() {
        if (vendaDAO == null) {
            vendaDAO = new VendaDAO();
        }
        return vendaDAO;
    }

    public boolean persistir(Venda v) {

        String sql;
        int retorno = 0;

        if (v.getId() != null) {
            sql = " update venda set data=?, id_cliente=?, id_funcionario=? where id = ? ";
        } else {
            v.setId(BDUtil.getNextID());

            sql = " insert into venda (data, id_cliente, id_funcionario, id) values (?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setDate(1, v.getData() == null ? null
                    : new java.sql.Date(v.getData().getTime()));
            state.setLong(2, v.getCliente().getId());
            state.setLong(3, v.getFuncionario().getId());
            state.setLong(4, v.getId());            

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência da Venda. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Venda> buscarTodos() {

        String sql
                = " select * from venda as v "
                + " order by v.id ";

        ArrayList<Venda> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getVenda(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

        private Venda getVenda(ResultSet rs) throws SQLException {

        Venda v = new Venda();
        v.setId(rs.getLong("id"));
        v.setData(rs.getDate("data"));
        v.setCliente(ClienteDAO.getInstance().buscarID(rs.getLong("id_cliente")));
        v.setFuncionario(FuncionarioDAO.getInstance().buscarID(rs.getLong("id_funcionario")));
        v.setContasReceber(ContaReceberDAO.getInstance().buscarPorVenda(rs.getLong("id")));
        v.setItensVenda(ItemVendaDAO.getInstance().buscarPorItemVenda(rs.getLong("id")));
        
        return v;
    }


    public Venda buscarID(long pId) {
        String sql
                = " select * from venda as v "
                + " where v.id=" + pId;

        Venda retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getVenda(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean deletar(Venda v) {
        return deletar(v.getId());
    }

    public boolean deletar(Long idVenda) {
        int retorno = 0;
        String sql = " delete from Venda where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idVenda);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a Venda. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("venda");

    }

    public List<Venda> pesquisar(String texto) {

        texto = texto.trim();
        
        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from venda as v  "
                + " order by v.id ";
        
        ArrayList<Venda> retorno = new ArrayList<Venda>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getVenda(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

    public List<Venda> buscar(int indice, String texto) {

        String sql = " select v.id, v.data, v.id_cliente, v.id_funcionario from venda as v ";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where v.id =" + texto;
            }
        }

        sql += " order by " + indice;
        List<Venda> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);
                
                while (rs.next()) {
                    retorno.add(getVenda(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
