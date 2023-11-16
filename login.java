/*
 * #projeto de sistema simples de login em java
 * @author Lívia Mendes
 * @version 16.11.2023
 */

import java.util.*;

public class login {
    private Scanner entrada = new Scanner(System.in);

    private ArrayList<User> arrUsers = new ArrayList<User>();
    private boolean usuarioConectado;

    public login() { /* construtor */

    }

    public String cadastrar(String username, int password, String email) {
        boolean valido = true;
        String retorno = "";
        if (isUsuario(username) || isUsuarioEmail(email)) { // checa se o nome de usuário está disponível para cadastro
            valido = false;
        }
        if (valido) {
            User user = new User(username, password, email);
            arrUsers.add(user);
            retorno = "Usuário cadastrado com sucesso.";
        } else {
            retorno = "Nome de usuário indisponível.";
        }
        return retorno;
    }

    public boolean isUsuario(String username) { // verifica se um nome de usuário está cadastrado no sistema
        boolean existe = false;
        for (User user : arrUsers) {
            if (user.getUsuario().equals(username)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean isUsuarioEmail(String email) { // verifica se um email está cadastrado no sistema
        boolean existe = false;
        for (User user : arrUsers) {
            if (user.getEmail().equals(email)) {
                existe = true;
            }
        }
        return existe;
    }

    public String conectarUsuario(String username, int password) { // conecta o usuário ao sistema por meio do nome de
                                                                   // usuário
        boolean match = false;
        String retorno = "";

        if (isUsuario(username)) {
            for (User user : arrUsers) {
                if (user.getUsuario().equals(username) && user.getSenha() == password) {
                    match = true;
                }
            }
            if (match) {
                retorno = "Usuário conectado";
                usuarioConectado = true;
            } else {
                retorno = "Senha incorreta";
            }
        } else {
            retorno = "Usuário não encontrado";
        }
        return retorno;
    }

    public String conectarEmail(String email, int password) { //conecta usuário ao sistema por meio do email
        boolean match = false;
        String retorno = "";

        if (isUsuarioEmail(email)) {
            for (User user : arrUsers) {
                if (user.getEmail().equals(email) && user.getSenha() == password) {
                    match = true;
                }
            }
            if (match) {
                retorno = "Usuário conectado";
                usuarioConectado = true;
            } else {
                retorno = "Senha incorreta";
            }
        } else {
            retorno = "Usuário não encontrado";
        }

        return retorno;
    }

    public void deletarUsuario(User usuario) { // deleta um usuário do sistema
        if (isUsuario(usuario.getUsuario())) {
            if (usuarioConectado) {
                System.out.println("digite sua senha:"); // verificação de senha
                int senhaAux = entrada.nextInt();
                for (User user : arrUsers) {
                    if (user.getUsuario().equals(usuario.getUsuario()) && user.getSenha() == senhaAux) {
                        System.out.println(
                                "tem certeza de que deseja deletar esta conta? Digite Sim para confirmar ou Não para cancelar");
                        String resposta = entrada.nextLine();
                        if (resposta.equals("sim") || resposta.equals("Sim") || resposta.equals("SIM")) {
                            arrUsers.remove(user);
                        } else {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("usuário deve estar conectado para poder executar essa ação");
            }
        } else {
            System.out.println("usuário não encontrado");
        }
    }

    public void alterarUsuario(String usuario) { // altera o username de um usuário
        boolean existe = true;
        String newUser = "";
        if (isUsuario(usuario)) {
            //int ind = arrUsers.indexOf(usuario);
            if (usuarioConectado) {
                while (existe == true) { //verifica se o novo nome de usuário já existe
                    System.out.println("digite o novo nome de usuário: ");
                    newUser = entrada.nextLine();
                    if (isUsuario(newUser)) {
                        System.out.println("nome de usuário indisponível");
                    } else {
                        existe = false;
                    }
                }
                System.out.println("digite sua senha:"); // verificação de senha
                int senhaAux = entrada.nextInt();
                entrada.nextLine();
                for (User user : arrUsers) {
                    if (user.getUsuario().equals(usuario) && user.getSenha() == senhaAux) {
                        System.out.println(
                                "tem certeza de que deseja alterar sua senha? Digite Sim para confirmar ou Não para cancelar");
                        String resposta = entrada.nextLine();
                        if (resposta.equals("sim") || resposta.equals("Sim") || resposta.equals("SIM")) {
                            user.setUsuario(newUser);
                            System.out.println("usuário alterado com sucesso");
                        } else {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("usuário deve estar conectado para poder executar essa ação");
            }
        } else {
            System.out.println("usuário não encontrado");
        }
    }

    public void alterarSenha(String usuario) { // altera a senha de um usuário
        int newPassword = 0;
        boolean check = false;
        if (isUsuario(usuario)) {
            if (usuarioConectado) {
                System.out.println("digite sua senha:"); // verificação de senha
                int senhaAux = entrada.nextInt();
                entrada.nextLine();
                for (User user : arrUsers) {
                    if (user.getUsuario().equals(usuario) && user.getSenha() == senhaAux) {
                        System.out.println(
                                "tem certeza de que deseja alterar sua senha? Digite Sim para confirmar ou Não para cancelar");
                        String resposta = entrada.nextLine();
                        if (resposta.equals("sim") || resposta.equals("Sim") || resposta.equals("SIM")) {
                            System.out.println("digite sua nova senha: ");
                            newPassword = entrada.nextInt();
                            while (check == false) {
                                System.out.println("repita a senha: ");
                                int newPasswordAux = entrada.nextInt();
                                if (newPassword == newPasswordAux) {
                                    check = true;
                                    user.setSenha(newPassword);
                                    System.out.println("usuário alterado com sucesso");
                                } else {
                                    System.out.println("as senhas não coincidem. tente novamente");
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("usuário deve estar conectado para poder executar essa ação");
            }
        } else {
            System.out.println("usuário não encontrado");
        }
    }
}