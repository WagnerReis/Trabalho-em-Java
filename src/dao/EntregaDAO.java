package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Entrega;
import util.BDUtil;
import util.ConexaoPostGree;

public class EntregaDAO {

    private static EntregaDAO entregaDAO;

    public static EntregaDAO getInstance() {
        if (entregaDAO == null) {
            entregaDAO = new EntregaDAO();
        }
        return entregaDAO;
    }

    public boolean persistir(Entrega et) {

        String sql;
        int retorno = 0;

        if (et.getId() != null) {
            sql = " update entrega set data=?, estado=?, cidade=?, rua=?, numero=?, bairro=?, referencia=?, id_venda=? where id = ? ";
        } else {
            et.setId(BDUtil.getNextID());

            sql = " insert into entrega (data, estado, cidade, rua, numero, bairro, referencia, id_venda, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setDate(1, et.getData() == null ? null
                    : new java.sql.Date(et.getData().getTime()));
            state.setString(2, et.getEstado());
            state.setString(3, et.getCidade());
            state.setString(4, et.getRua());
            state.setInt(5, et.getNumero());
            state.setString(6, et.getBairro());
            state.setString(7, et.getReferencia());
            state.setLong(8, et.getVenda().getId());
            state.setLong(9, et.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência da Entrega. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Entrega> buscarTodos() {

        String sql
                = " select * from entrega as e "
                + " order by e.id ";

        ArrayList<Entrega> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getEntrega(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private Entrega getEntrega(ResultSet rs) throws SQLException {

        Entrega e = new Entrega();
        e.setId(rs.getLong("id"));
        e.setData(rs.getDate("data"));
        e.setEstado(rs.getString("estado"));
        e.setCidade(rs.getString("cidade"));
        e.setRua(rs.getString("rua"));
        e.setNumero(rs.getInt("numero"));
        e.setBairro(rs.getString("bairro"));
        e.setReferencia(rs.getString("referencia"));
        e.setVenda(VendaDAO.getInstance().buscarID(rs.getLong("id_venda")));

        return e;
    }

    public Entrega buscarID(long pId) {
        String sql
                = " select * from entrega as e "
                + " where e.id=" + pId;

        Entrega retorno = null;
        try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getEntrega(rs);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(Entrega et) {
        return deletar(et.getId());
    }

    public boolean deletar(Long idClienteFisico) {
        int retorno = 0;
        String sql = " delete from entrega where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idClienteFisico);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a Entrega. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("entrega");

    }

    public List<Entrega> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from entrega as e  "
                + " where e.id = " + id
                + "  or (upper(e.estado) like '%" + texto.toUpperCase() + "%')"
                + "  or (e.cidade  = '" + texto + "')"
                + "  or (e.referencia  = '" + texto + "')"
                + " order by e.id ";

        ArrayList<Entrega> retorno = new ArrayList<Entrega>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getEntrega(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;

    }

    public List<Entrega> buscar(int indice, String texto) {

        String sql = " select e.id, e.data, e.estado, e.cidade, e.rua, "
                + " e.numero, e.bairro, e.referencia, e.id_venda from entrega as e ";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where e.id =" + texto;
            } else if (indice == 1) { // numero
                sql += " where e.numero ='" + texto + "'";
            } else if (indice == 2) { // estado
                sql += " where upper(e.estado) like '%"
                        + texto.toUpperCase() + "%'";
            }
        }

        sql += " order by " + indice;
        List<Entrega> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getEntrega(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
