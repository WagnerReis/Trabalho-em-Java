package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import util.BDUtil;
import util.ConexaoPostGree;

public class UsuarioDAO {
    private static UsuarioDAO usuarioDAO;

    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }

    public boolean persistir(Usuario u) {

        String sql;
        int retorno = 0;

        if (u.getId() != null) {
            sql = " update usuario set login=?,senha=? where id = ? ";
        } else {
            u.setId(BDUtil.getNextID());

            sql = " insert into usuario (login, senha, id) values (?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setString(1, u.getLogin());
            state.setString(2, u.getSenha());
            state.setLong(3, u.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Cliente. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Usuario> buscarTodos() {

        String sql
                = " select * from usuario as u "
                + " order by u.id ";

        ArrayList<Usuario> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getUsuario(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private Usuario getUsuario(ResultSet rs) throws SQLException {

        Usuario u = new Usuario();
        u.setId(rs.getLong("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));
        
        return u;
    }

    public Usuario buscarID(long pId) {
        String sql
                = " select * from usuario as u "
                + " where u.id=" + pId;

        Usuario retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getUsuario(rs);
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(Usuario u) {
        return deletar(u.getId());
    }

    public boolean deletar(Long idUsuario) {
        int retorno = 0;
        String sql = " delete from usuario where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idUsuario);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o Usuario. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("usuario");

    }

    public List<Usuario> pesquisar(String texto) {

        texto = texto.trim();
        
        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from usuario as u  "
                + " where u.id = " + id
                + "  or (upper(u.login) like '%" + texto.toUpperCase() + "%')"
                + " order by u.id ";

        ArrayList<Usuario> retorno = new ArrayList<Usuario>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getUsuario(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;

    }
    
        public List<Usuario> buscar(int indice, String texto) {

        String sql = " select u.id, u.login, u.senha from usuario as u";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where u.id =" + texto;
            } else if (indice == 2) { 
                sql += " where upper(u.login) like '%"
                        + texto.toUpperCase() + "%'";
            } 
        }

        sql += " order by " + indice;
        List<Usuario> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);
                
                while (rs.next()) {
                    retorno.add(getUsuario(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }

    public boolean buscarPorLogin(String login, String senha) {
        String sql
                = " select * from usuario as u "
               // + " where u.login=" + login 
                + "where (upper(u.login) like '%" + login.toUpperCase() + "%')"
                + "and (upper(u.senha) like '%" + senha.toUpperCase() + "%')";
               // + "  AND u.senha= " + senha;

        Usuario retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getUsuario(rs);
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
        return retorno != null;
    }
}
