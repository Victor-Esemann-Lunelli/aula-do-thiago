import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaiorValorVetor {
    public static int posicaoMaiorValor(int[] vetor){
        if (vetor == null || vetor.length == 0) {
            return -1;
        }

    int MaiorValor = vetor[0];
    int indiceMaiorValor = 0;
    
    for(int i = 1 ; i < vetor.length;i++){
        if (vetor[i] > MaiorValor){
            MaiorValor = vetor[i];
            indiceMaiorValor = i;
        }
    }
    return indiceMaiorValor;
    }

@Test
public void testarPosicaoMaiorValor(){
    int vetor[] = new int []{0,1,2};
    assertEquals(2, posicaoMaiorValor(vetor));
}

@Test
public void testarPosicaoMaiorValor0(){
    int vetor[] = new int []{0,0,0};
    assertEquals(0, posicaoMaiorValor(vetor));
}

@Test
public void testarPosicaoMaiorValornull(){
    int vetor[] = new int []{};
    assertEquals(-1, posicaoMaiorValor(vetor));
}

@Test
public void testarPosicaoMaiorValorneg(){
    int vetor[] = new int []{-1,8,7};
    assertEquals(1, posicaoMaiorValor(vetor));
}

@Test(expected = IllegalArgumentException.class)
public void testarPosicaoMaiorValorletra(){
    int vetor[] = new int []{Integer.parseInt("abc"),8,7};
    assertEquals(1, posicaoMaiorValor(vetor));
}
}
