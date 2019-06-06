package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedor;
import util.BDUtil;
import util.ConexaoPostGree;

public class FornecedorDAO {

    private static FornecedorDAO fornecedorDAO;

    public static FornecedorDAO getInstance() {
        if (fornecedorDAO == null) {
            fornecedorDAO = new FornecedorDAO();
        }
        return fornecedorDAO;
    }

    public Long getLastID() {
        return BDUtil.getLastID("fornecedor");

    }

    private Fornecedor getFornecedor(ResultSet rs) throws SQLException {

        Fornecedor i = new Fornecedor();
        i.setId(rs.getLong("id"));
        i.setTelefone(rs.getString("telefone"));
        i.setCelular(rs.getString("Celular"));
        i.setRazaoSocial(rs.getString("razao_social"));
        i.setCnpj(rs.getString("cnpj"));
        i.setCidade(rs.getString("cidade"));
        i.setEstado(rs.getString("estado"));
        i.setBairro(rs.getString("bairro"));
        i.setRua(rs.getString("rua"));
        i.setNumero(rs.getInt("numero"));

        return i;
    }

    public ArrayList<Fornecedor> buscarTodos() {

        String sql
                = " select * from fornecedor as a "
                + " order by a.razao_social ";

        ArrayList<Fornecedor> retorno = new ArrayList<Fornecedor>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getFornecedor(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public boolean persistir(Fornecedor fornecedor) {
        String sql;

        int retorno = 0;
        if (fornecedor.getId() != null) {
            sql = " update fornecedor set  telefone=?, celular=?, razao_social=?, cnpj=?, "
                    + " estado=?, cidade=?, bairro=?, rua=?, numero=?"
                    + " where id = ? ";
        } else {
            fornecedor.setId(BDUtil.getNextID());

            sql = " insert into fornecedor ( telefone, celular, razao_social, cnpj, "
                    + " estado, cidade, bairro, rua, numero, id) values "
                    + " (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setString(1, fornecedor.getTelefone());
            state.setString(2, fornecedor.getCelular());
            state.setString(3, fornecedor.getRazaoSocial());
            state.setString(4, fornecedor.getCnpj());
            state.setString(5, fornecedor.getEstado());
            state.setString(6, fornecedor.getCidade());
            state.setString(7, fornecedor.getBairro());
            state.setString(8, fornecedor.getRua());
            state.setInt(9, fornecedor.getNumero());
            state.setLong(10, fornecedor.getId());

            state.executeUpdate();
            state.close();

            // Grava o N x N de Situacoes do Aluno
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Fornecedor. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public boolean deletar(Fornecedor fornecedor) {
        return deletar(fornecedor.getId());
    }

    public boolean deletar(Long idFornecedor) {
        int retorno = 0;
        String sql = " delete from fornecedor where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idFornecedor);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar a Fonecedor. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Fornecedor buscarID(long pId) {
        String sql
                = " select * from fornecedor as i "
                + " where i.id=" + pId;

        Fornecedor retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getFornecedor(rs);
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }

    public List<Fornecedor> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from fornecedor as i  "
                + " where i.id = " + id
                + "  or (upper(i.estado) like '%" + texto.toUpperCase() + "%')"
                + "  or (i.razao_social  = '" + texto + "')"
                + " order by i.razao_social";

        ArrayList<Fornecedor> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getFornecedor(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }
}
