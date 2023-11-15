/*
 * #projeto de sistema simples de login em java
 * @author Lívia Mendes
 * @version 14.11.2023
 */

import java.util.*;

public class login {
    private Scanner entrada = new Scanner(System.in);
    private String usuario;
    private int senha;
    private String endEmail;
    /*private ArrayList<String> arrUsuarios = new ArrayList<String>();
    private ArrayList<Integer> arrSenhas = new ArrayList<Integer>();
    private ArrayList<String> arrEmails = new ArrayList<String>();*/
    private ArrayList<User> arrUsers = new ArrayList<User>();

    public login() { /*construtor */

    }

    public String cadastrar(String username, int password, String email) {
        usuario = username;
        senha = password;
        endEmail = email;
        boolean valido = true;
        String retorno = "";
        if (getDisponibilidade() > 0) { //checa se há espaço no banco de usuários
                if (isUsuario(username)||isUsuarioEmail(email)) { //checa se o nome de usuário está disponível para cadastro
                    valido = false;
                }
            if (valido) {
                User user = new User(username, password, endEmail);
                /*arrUsuarios.add(user.getUsuario());
                arrEmails.add(user.getEmail());
                arrSenhas.add(user.getSenha());*/
                arrUsers.add(user);
            } else {
                retorno = "Nome de usuário indisponível.";
            }
        }
        return retorno;
    }
    
    public int getDisponibilidade() { //verifica número de espaços disponíveis no banco
        int disponibilidade = 0;
        for(User user : arrUsers){
             if (user == null) {
                disponibilidade++;
            }
        }
        return disponibilidade;
    }

    public boolean isUsuario(String username) { //verifica se um nome de usuário está cadastrado no sistema
        boolean existe = false;
        for (User user : arrUsers) {
            if (user.getUsuario().equals(username)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean isUsuarioEmail(String email) { //verifica se um email está cadastrado no sistema
        boolean existe = false;
        for (User user : arrUsers) {
            if (user.getEmail().equals(email)) {
                existe = true;
            }
        }
        return existe;
    }
    
    public String conectarUsuario(String username, int password) { //conecta o usuário ao sistema por meio do nome de usuário
        usuario = username;
        senha = password;
        boolean match = false;
        String retorno = "";

        if(isUsuario(username)){
            for (User user : arrUsers) {
                if (user.getUsuario().equals(username) && user.getSenha() == senha) {
                    match = true;
                }
            }
            if (match) {
                retorno = "Usuário conectado";
            } else {
                retorno = "Senha incorreta";
            }
        }else {
            retorno = "Usuário não encontrado";
        }

        /*if (isUsuario(username)) {
            if (user.getUsuario()==username) {
                match = true;
            }
            if (match) {
                retorno = "Usuário conectado";
            } else {
                retorno = "Senha incorreta";
            }
        } else {
            retorno = "Usuário não encontrado";
        }*/

        return retorno;
    }
    
    public String conectarEmail(String email, int password) { //conecta usuário ao sistema por meio do email
        endEmail = email;
        senha = password;
        boolean match = false;
        String retorno = "";

        if(isUsuarioEmail(endEmail)){
            for (User user : arrUsers) {
                if (user.getEmail().equals(endEmail) && user.getSenha() == senha) {
                    match = true;
                }
            }
            if (match) {
                retorno = "Usuário conectado";
            } else {
                retorno = "Senha incorreta";
            }
        }else {
            retorno = "Usuário não encontrado";
        }

        /*if (isUsuarioEmail(endEmail)) {
            if (arrUsuarios.indexOf(endEmail) == arrSenhas.indexOf(senha)) {
                match = true;
            }
            if (match) {
                retorno = "Usuário conectado";
            } else {
                retorno = "Senha incorreta";
            }
        } else {
            retorno = "Usuário não encontrado";
        }*/

        return retorno;
    }

    public void deletarUsuario(String username) { //deleta um usuário do sistema
        if (isUsuario(username)) {
            System.out.println("digite sua senha:"); //verificação de senha
            int senhaAux = entrada.nextInt();
            for (User user : arrUsers) {
                if (user.getUsuario().equals(username) && user.getSenha() == senhaAux) {
                    System.out.println("tem certeza de que deseja deletar esta conta? Digite Sim para confirmar ou Não para cancelar");
                    String resposta = entrada.nextLine();
                    if (resposta.equals("sim") || resposta.equals("Sim") || resposta.equals("SIM")) {
                        arrUsers.remove(user);
                    } else {
                        break;
                    }
                }
            }
        }
    }
    
    public void alterarSenha() { //altera a senha de um usuário
    }
    
    public void alterarUsuario() { //altera o nome de usuário
    }

}