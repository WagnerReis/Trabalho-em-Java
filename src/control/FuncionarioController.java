package control;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Funcionario;
import model.Usuario;

public class FuncionarioController {

    private static FuncionarioController funcionarioController;

    public static FuncionarioController getInstance() {
        if (funcionarioController == null) {
            funcionarioController = new FuncionarioController();
        }
        return funcionarioController;
    }

    public List<Funcionario> buscarTodos() {
        return FuncionarioDAO.getInstance().buscarTodos();
    }

    public boolean deletar(Long id) {
        return FuncionarioDAO.getInstance().deletar(id);

    }

    public boolean persistir(Funcionario funcionario) {
        return FuncionarioDAO.getInstance().persistir(funcionario);
    }

    public Funcionario buscarID(Long id) {

        return FuncionarioDAO.getInstance().buscarID(id);
    }

    public List<Funcionario> buscar(int indice, String texto) {

        return FuncionarioDAO.getInstance().buscar(indice, texto);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return UsuarioDAO.getInstance().buscarTodos();
    }

    public List<Funcionario> pesquisar(String texto) {
        return FuncionarioDAO.getInstance().pesquisar(texto);
    }
}
