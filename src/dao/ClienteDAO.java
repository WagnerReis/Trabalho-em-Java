package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import util.BDUtil;
import util.ConexaoPostGree;

public class ClienteDAO {

    private static ClienteDAO clienteDAO;

    public static ClienteDAO getInstance() {
        if (clienteDAO == null) {
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }

    public boolean persistir(Cliente cf) {

        String sql;
        int retorno = 0;

        if (cf.getId() != null) {
            sql = " update cliente set nome=?,telefone=?, celular=?, tipo=?, cpf=?, cnpj=?, estado=?, cidade=?, bairro=?, rua=?, numero=? where id = ? ";
        } else {
            cf.setId(BDUtil.getNextID());

            sql = " insert into cliente (nome, telefone, celular, tipo, cpf, cnpj, estado, cidade, bairro, rua, numero, id) values (?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setString(1, cf.getNome());
            state.setString(2, cf.getTelefone());
            state.setString(3, cf.getCelular());
            state.setInt(4, cf.getTipo());
            state.setString(5, cf.getCpf());
            state.setString(6, cf.getCnpj());
            state.setString(7, cf.getEstado());
            state.setString(8, cf.getCidade());
            state.setString(9, cf.getBairro());
            state.setString(10, cf.getRua());
            state.setInt(11, cf.getNumero());
            state.setLong(12, cf.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Cliente. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Cliente> buscarTodos() {

        String sql
                = " select * from cliente as c "
                + " order by c.nome ";

        ArrayList<Cliente> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getCliente(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private Cliente getCliente(ResultSet rs) throws SQLException {

        Cliente c = new Cliente();
        c.setId(rs.getLong("id"));
        c.setNome(rs.getString("nome"));
        c.setNome(rs.getString("telefone"));
        c.setNome(rs.getString("celular"));
        c.setTipo(rs.getInt("tipo"));
        c.setCpf(rs.getString("cpf"));
        c.setCnpj(rs.getString("cnpj"));
        c.setEstado(rs.getString("estado"));
        c.setCidade(rs.getString("cidade"));
        c.setBairro(rs.getString("bairro"));
        c.setRua(rs.getString("rua"));
        c.setNumero(rs.getInt("numero"));

        return c;
    }

    public Cliente buscarID(long pId) {
        String sql
                = " select * from cliente as c "
                + " where c.id=" + pId;

        Cliente retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getCliente(rs);
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(Cliente cf) {
        return deletar(cf.getId());
    }

    public boolean deletar(Long idClienteFisico) {
        int retorno = 0;
        String sql = " delete from cliente where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idClienteFisico);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o Cliente. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("cliente");

    }

    public List<Cliente> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from cliente as c  "
                + " where c.id = " + id
                + "  or (upper(c.nome) like '%" + texto.toUpperCase() + "%')"
                + "  or (c.cpf  = '" + texto + "')"
                + " order by c.nome ";

        ArrayList<Cliente> retorno = new ArrayList<Cliente>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getCliente(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;

    }

    public ArrayList<Cliente> buscarNome(String pnome) {

        String sql = " select * from cliente as c ";

        if (!pnome.equals("")) {
            sql = sql + " where upper(c.nome) like '%" + pnome.toUpperCase() + "%' ";
        }

        sql = sql + " order by c.nome ";

        ArrayList<Cliente> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getCliente(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public List<Cliente> buscar(int indice, String texto) {

        String sql = " select c.id, c.nome, c.telefone, c.celular, c.tipo, "
                + " c.cpf, c.cnpj, c.estado, c.cidade, c.bairro, c.rua, c.numero from cliente as c ";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where c.id =" + texto;
            } else if (indice == 1) { // cpf
                sql += " where c.cpf ='" + texto + "'";
            } else if (indice == 2) { // Nome
                sql += " where upper(c.nome) like '%"
                        + texto.toUpperCase() + "%'";
            } else if (indice == 3) { // Cnpj
                sql += " where c.cpf ='" + texto + "'";
            }
        }

        sql += " order by " + indice;
        List<Cliente> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getCliente(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
