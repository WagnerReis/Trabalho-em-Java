package control;

import dao.UsuarioDAO;
import java.util.List;
import model.Usuario;

public class UsuarioController {

    private static UsuarioController usuarioController;

    public static UsuarioController getInstance() {
        if (usuarioController == null) {
            usuarioController = new UsuarioController();
        }
        return usuarioController;
    }

    public List<Usuario> buscarTodos() {
        return UsuarioDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return UsuarioDAO.getInstance().deletar(id);

    }

    public boolean persistir(Usuario usuario) {
        return UsuarioDAO.getInstance().persistir(usuario);
    }

    public Usuario buscarID(Long id) {

        return UsuarioDAO.getInstance().buscarID(id);
    }

    public List<Usuario> buscar(int indice, String texto) {

        return UsuarioDAO.getInstance().buscar(indice, texto);
    }

    public List<Usuario> pesquisar(String texto) {
        return UsuarioDAO.getInstance().pesquisar(texto);
    }

    public boolean buscarPorLogin(String login, String senha) {
        return UsuarioDAO.getInstance().buscarPorLogin(login, senha);
    }
}
