package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;
import util.BDUtil;
import util.ConexaoPostGree;

public class FuncionarioDAO {

    private static FuncionarioDAO funcionarioDAO;

    public static FuncionarioDAO getInstance() {
        if (funcionarioDAO == null) {
            funcionarioDAO = new FuncionarioDAO();
        }
        return funcionarioDAO;
    }

    public boolean persistir(Funcionario f) {

        String sql;
        int retorno = 0;

        if (f.getId() != null) {
            sql = " update funcionario set nome=?, tipo=?, cpf=?, telefone=?, celular=?, estado=?, cidade=?, bairro=?, rua=?, numero=?, id_usuario=? where id = ? ";
        } else {
            f.setId(BDUtil.getNextID());

            sql = " insert into funcionario (nome, tipo, cpf, telefone, celular, estado, cidade, bairro, rua, numero, id_usuario, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setString(1, f.getNome());
            state.setInt(2, f.getTipo());
            state.setString(3, f.getCpf());
            state.setString(4, f.getTelefone());
            state.setString(5, f.getCelular());
            state.setString(6, f.getEstado());
            state.setString(7, f.getCidade());
            state.setString(8, f.getBairro());
            state.setString(9, f.getRua());
            state.setInt(10, f.getNumero());
            state.setLong(11, f.getUsuario().getId());
            state.setLong(12, f.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Funcionario. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Funcionario> buscarTodos() {

        String sql
                = " select * from funcionario as f "
                + " order by f.nome ";

        ArrayList<Funcionario> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getFuncionario(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private Funcionario getFuncionario(ResultSet rs) throws SQLException {

        Funcionario f = new Funcionario();
        f.setId(rs.getLong("id"));
        f.setNome(rs.getString("nome"));
        f.setTipo(rs.getInt("tipo"));
        f.setCpf(rs.getString("cpf"));
        f.setCpf(rs.getString("telefone"));
        f.setCpf(rs.getString("celular"));
        f.setEstado(rs.getString("estado"));
        f.setCidade(rs.getString("cidade"));
        f.setBairro(rs.getString("bairro"));
        f.setRua(rs.getString("rua"));
        f.setNumero(rs.getInt("numero"));
        f.setUsuario(UsuarioDAO.getInstance().buscarID(rs.getLong("id_usuario")));

        return f;
    }

    public Funcionario buscarID(long pId) {
        String sql
                = " select * from funcionario as f "
                + " where f.id=" + pId;

        Funcionario retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getFuncionario(rs);
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(Funcionario f) {
        return deletar(f.getId());
    }

    public boolean deletar(Long idFuncionario) {
        int retorno = 0;
        String sql = " delete from funcionario where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idFuncionario);

            // executeUpdate retorna o nro de registros afetados
            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o Funcionario. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("funcionario");

    }

    public List<Funcionario> pesquisar(String texto) {

        texto = texto.trim();

        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from funcionario as f  "
                + " where f.id = " + id
                + "  or (upper(f.nome) like '%" + texto.toUpperCase() + "%')"
                + "  or (f.cpf  = '" + texto + "')"
                + " order by f.nome ";

        ArrayList<Funcionario> retorno = new ArrayList<Funcionario>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getFuncionario(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;

    }

    public List<Funcionario> buscar(int indice, String texto) {

        String sql = " select f.id, f.nome, f.tipo, f.cpf, f.telefone, "
                + " f.celular, f.estado, f.cidade, f.bairro, f.rua, f.numero, f.id_usuario from funcionario as f ";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where f.id =" + texto;
            } else if (indice == 1) { // numero
                sql += " where f.cpf ='" + texto + "'";
            } else if (indice == 2) { // estado
                sql += " where upper(f.nome) like '%"
                        + texto.toUpperCase() + "%'";
            }
        }

        sql += " order by " + indice;
        List<Funcionario> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);

                while (rs.next()) {
                    retorno.add(getFuncionario(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

}
