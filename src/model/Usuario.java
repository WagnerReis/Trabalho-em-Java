package model;

import java.util.List;

public class Usuario {

    private Long id;
    private String login;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return id + "-" + login;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario a = (Usuario) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }
}
