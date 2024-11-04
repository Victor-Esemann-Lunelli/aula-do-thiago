
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testeValidarCalculoFrete {
  
//  entrada               ResEsp    ResEnc
//  p:50 d:30 tb:300      415       415
//  p:0 d:0 tb:0          0         0 
//  p:-50 d:30 tb:300     exceção   exceção} Código corrigido, caso contrário resultaria em um valor numérico.
//  p:-50 d:-30 tb:-300   exceção   exceção} Código corrigido, caso contrário resultaria em um valor numérico.

    @Test
    public void calcularFrete(){
        CalculoFrete c = new CalculoFrete();
        Double resultado = c.calcularFrete(50, 30, 300);
        assertEquals(415,resultado,0.01);
    }

    @Test
    public void calcularFrete0(){
        CalculoFrete c = new CalculoFrete();
        assertEquals(0,c.calcularFrete(0, 0, 0),0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcularFreteNegativo(){
        CalculoFrete c = new CalculoFrete();
        c.calcularFrete(-50, -30, -20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcularFrete1Negativo(){
        CalculoFrete c = new CalculoFrete();
        c.calcularFrete(-50, 30, 20);
    }
}
