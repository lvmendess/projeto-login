public class testes {
    public static void main(String[] args) {
        login log1 = new login();

        System.out.println(log1.cadastrar("livia", 152, "liviamendes@gmail.com")); //testado; funcionando

        System.out.println(log1.isUsuario("livia")); //testado; funcionando
        System.out.println(log1.isUsuario("mendes"));

        System.out.println(log1.isUsuarioEmail("liviamendes@gmail.com")); //testado; funcionando
        System.out.println(log1.isUsuarioEmail("mendes@gmail.com"));

        System.out.println(log1.conectarUsuario("livia", 152));
    }
}
