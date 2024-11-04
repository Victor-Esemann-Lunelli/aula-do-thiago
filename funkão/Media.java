public class Media {

    public double calcularMediaPonderada(double[] notas, double[] pesos) {
        double somaNotasPesos = 0;
        double somaPesos = 0;

        for (int i = 0; i <= notas.length-1; i++) {
           if (notas[i]<0) {
            throw new IllegalArgumentException("Nota não pode ser negativa!!");
           }
           if (pesos[i]<=0) {
            throw new IllegalArgumentException("Peso não pode ser negativo nem zero!!");
           }
        }

        // Calcula a soma das notas multiplicadas pelos pesos e a soma dos pesos
        for (int i = 0; i <= notas.length-1; i++) {
            somaNotasPesos += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        // Calcula a média ponderada
        return somaNotasPesos / somaPesos;
    }

}
