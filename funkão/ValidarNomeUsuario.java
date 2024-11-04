import java.util.regex.Pattern;

public class ValidarNomeUsuario{

    public boolean validarNomeUsuario( String nome ){
        if( nome == null){
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        // Expressão regular:
        // ^ - Início da string
        // [A-Za-z] - Primeiro caractere deve ser uma letra (maiúscula ou minúscula)
        // [A-Za-z0-9]{2,9} - Os próximos 2 a 9 caracteres podem ser letras ou números
        // $ - Fim da string
        String regex = "^[A-Za-z][A-Za-z0-9]{2,9}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(nome).matches();
    }

    public String limparNome(String nome) {
        // Remove caracteres especiais e garante que a primeira letra não seja uma letra
         // Remove caracteres especiais
        String nomeNome = nome.replaceAll("[^a-zA-Z0-9]", "");
        if (nomeNome.length() > 0 && Character.isLetter(nomeNome.charAt(0))) {
            nomeNome = nomeNome.substring(1);
            // Remove a primeira letra, se for letra
        }
        return nomeNome;
    }
}