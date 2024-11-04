public class ValidarEndereçoIP {

    public boolean isIPValido(String ip) {
        // Divide o IP em partes
        String[] partes = ip.split("\\.");

        if(partes.length!=4){
            return false;
        }

        for (String parte : partes) {
            // Verifica se a parte é um número e se está no intervalo de 0 a 255
            if (!isNumeroValido(parte)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNumeroValido(String parte) {
        // Verifica se a parte não está vazia
        if (parte.isEmpty()) {
            return false;
        }

        // Tenta converter a parte em um número
        try {
            int numero = Integer.parseInt(parte);

            if(numero == 666){
                return false;
            }

            if(Integer.parseInt(parte) < 0 || Integer.parseInt(parte)>255){
                return false;
            } 
            return true;
        } catch (NumberFormatException e) {
            return false; // Se não puder converter, não é válido
        }
    }
}
