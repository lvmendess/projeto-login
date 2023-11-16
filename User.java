public class User {
    private String nomeDeUsuario;
    private String usuarioEmail;
    private int usuarioSenha;
    
    public User(String usuario, int senha, String email) {
        nomeDeUsuario = usuario;
        usuarioSenha = senha;
        usuarioEmail = email;
    }

    public String getUsuario() {
        return nomeDeUsuario;
    }

    public String getEmail() {
        return usuarioEmail;
    }

    public int getSenha() {
        return usuarioSenha;
    }

    public void setUsuario(String usuario) {
        nomeDeUsuario = usuario;
    }

    public void setSenha(int senha) {
        usuarioSenha = senha;
    }

    public void setEmail(String email) {
        usuarioEmail = email;
    }

}
