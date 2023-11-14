/*
 * #projeto de sistema simples de login em java
 * @author Lívia Mendes
 * @version 14.11.2023
 */
public class login {

    private String usuario;
    private int senha;
    private String[] banco_usuarios = new String[50];
    private int[] banco_senhas = new int[50];

    public login(){ /*construtor */

    }

    public String cadastrar(String username, int password) {
        usuario = username;
        senha = password;
        boolean valido = true;
        String retorno = "";
        if (getDisponibilidade() > 0) { //checa se há espaço no banco de usuários
                if (isUsuario(username)) { //checa se o nome de usuário está disponível para cadastro
                    valido = false;
                }
            if (valido) {
                for (int i = 0; i < banco_usuarios.length; i++) {
                    if (banco_usuarios[i] == null) {
                        banco_usuarios[i] = usuario; //guarda o usuario e sua senha no mesmo index de arrays diferentes
                        banco_senhas[i] = senha;

                        retorno = "Usuário cadastrado com sucesso";
                    }
                }
            } else {
                retorno = "Nome de usuário indisponível.";
            }
        }
        return retorno;
    }
    
    public int getDisponibilidade() { //verifica número de espaços disponíveis no banco
        int disponibilidade = 0;
        for (int i = 0; i < banco_usuarios.length; i++) {
            if (banco_usuarios[i] == null) {
                disponibilidade++;
            }
        }
        return disponibilidade;
    }

    public boolean isUsuario(String username) { //verifica se um nome de usuário está cadastrado no sistema
        boolean existe = false;
        for (String name : banco_usuarios) {
            if (name.equals(username)) {
                existe = true;
            }
        }
        return existe;
    }
    
    public String conectar(String username, int password) { //conecta o usuário ao sistema
        usuario = username;
        senha = password;
        boolean match = false;
        String retorno = "";

        if (isUsuario(username)) {
            for (int i = 0; i < banco_usuarios.length; i++) {
                for (int j = 0; j < banco_senhas.length; j++) {
                    if (banco_usuarios[i].equals(username) && banco_senhas[j] == senha) {
                        match = true;
                    }
                }
            }
            if (match) {
                retorno = "Usuário conectado";
            } else {
                retorno = "Senha incorreta";
            }
        } else {
            retorno = "Usuário não encontrado";
        }

        return retorno;
    }

    public void deletarUsuario() { //deleta um usuário do sistema
    }
    
    public void alterarSenha() { //altera a senha de um usuário
    }
    
    public void alterarUsuario() { //altera o nome de usuário
    }

}