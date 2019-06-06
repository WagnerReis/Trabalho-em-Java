package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDUtil {

    public static Long getNextID() {

        String sql = " select nextval('sequence_geral') ";
        Long retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            if (rs.next()) {
                retorno = rs.getLong("nextval");
            }

            state.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return retorno;
    }
    
    public static Long getLastID(String tabela){
        
      String sql = " select coalesce(max(i.id), 0) as maior from " + tabela + " as i ";
               

        Long retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            if (rs.next()) {
                retorno = rs.getLong("maior");
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;
    }
}
