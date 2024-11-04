
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraIMC {

    public String calcularIMC(double peso,double altura){
        double imc = peso / (altura*altura);
        if(imc < 18.5){
            return "Abaixo do peso";
        }
        else if(imc >= 18.5 && imc < 24.9){
            return "Peso normal";
        }else if(imc >= 25 && imc < 29.9){
            return "Sobrepeso";
        }else{
            return "Obesidade";
        }
    } 

    @Test
    public void testarvalneg(){
        calcularIMC(-2, 1.80);
    }

    @Test
    public void testarval0(){
        calcularIMC(0, 1.80);
    }

    @Test
    public void testacalcularimc(){
        assertEquals("Abaixo do peso",calcularIMC(50, 1.80));
    }

    @Test
    public void testacalcularimc2(){
        assertEquals("Peso normal",calcularIMC(60, 1.60));
    }

    @Test
    public void testacalcularimc3(){
        assertEquals("Sobrepeso",calcularIMC(70, 1.60));
    }

    @Test
    public void testacalcularimc4(){
        assertEquals("Obesidade",calcularIMC(80, 1.60));
    }

}
