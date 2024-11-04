public class CalculoFrete {

    // Método para calcular o frete
    public double calcularFrete(double peso, double distancia, double tarifaBase) {

        if(peso<0 || distancia<0 || tarifaBase<0){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }

        double valorPorKm = 0.5; // Valor por quilômetro percorrido
        double valorPorKg = 2.0; // Valor por quilograma de peso

        // Calcula o frete com base na fórmula
        double frete = tarifaBase + (valorPorKm * distancia) + (valorPorKg * peso);
        return frete;
    }
}

