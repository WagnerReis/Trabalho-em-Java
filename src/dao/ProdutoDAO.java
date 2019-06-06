package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import util.BDUtil;
import util.ConexaoPostGree;

public class ProdutoDAO {
    private static ProdutoDAO produtoDAO;

    public static ProdutoDAO getInstance() {
        if (produtoDAO == null) {
            produtoDAO = new ProdutoDAO();
        }
        return produtoDAO;
    }

    public boolean persistir(Produto p) {

        String sql;
        int retorno = 0;

        if (p.getId() != null) {
            sql = " update produto set nome=?,valor=?, descricao=? where id = ? ";
        } else {
            p.setId(BDUtil.getNextID());

            sql = " insert into produto (nome, valor, descricao, id) values (?, ?, ?, ?) ";
        }

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);

            state.setString(1, p.getNome());
            state.setFloat(2, p.getValor());
            state.setString(3, p.getDescricao());
            state.setLong(4, p.getId());

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na persistência do Produto. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public ArrayList<Produto> buscarTodos() {

        String sql
                = " select * from produto as p "
                + " order by p.nome ";

        ArrayList<Produto> retorno = new ArrayList<>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getProduto(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    private Produto getProduto(ResultSet rs) throws SQLException {

        Produto p = new Produto();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setValor(rs.getFloat("valor"));
        
        return p;
    }

    public Produto buscarID(long pId) {
        String sql
                = " select * from produto as p "
                + " where p.id=" + pId;

        Produto retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno = getProduto(rs);
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return retorno;
    }

    public boolean deletar(Produto p) {
        return deletar(p.getId());
    }

    public boolean deletar(Long idProduto) {
        int retorno = 0;
        String sql = " delete from produto where id = ? ";

        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            state.setLong(1, idProduto);

            retorno = state.executeUpdate();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o Produto. \nErro:" + e.getMessage());
        }
        return retorno > 0;
    }

    public Long getLastID() {
        return BDUtil.getLastID("produto");

    }

    public List<Produto> pesquisar(String texto) {

        texto = texto.trim();
        
        long id = 0;
        try {
            id = Long.parseLong(texto);
        } catch (Exception e) {
        }

        String sql
                = " select * from produto as p  "
                + " where p.id = " + id
                + "  or (upper(p.nome) like '%" + texto.toUpperCase() + "%')"
                + " order by p.nome ";

        ArrayList<Produto> retorno = new ArrayList<Produto>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getProduto(rs));
            }

            state.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
        return retorno;
    }
    
        public ArrayList<Produto> buscarNome(String pnome) {

        String sql = " select * from produto as p ";

        if (!pnome.equals("")) {
            sql = sql + " where upper(p.nome) like '%" + pnome.toUpperCase() + "%' ";
        }

        sql = sql + " order by p.nome ";

        ArrayList<Produto> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);
                
                while (rs.next()) {
                    retorno.add(getProduto(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }
        
        public List<Produto> buscar(int indice, String texto) {

        String sql = " select p.id, p.nome, p.valor, p.descricao from produto as p";

        if (!texto.equals("")) {
            if (indice == 0) { // codigo 
                sql += " where p.id =" + texto;
            } else if (indice == 1) { // nome
                sql += " where p.nome ='" + texto + "'";
            } 
        }

        sql += " order by " + indice;
        List<Produto> retorno = new ArrayList<>();
        try {
            try (Statement state = ConexaoPostGree.getConexao().createStatement()) {
                ResultSet rs = state.executeQuery(sql);
                
                while (rs.next()) {
                    retorno.add(getProduto(rs));
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }
}
