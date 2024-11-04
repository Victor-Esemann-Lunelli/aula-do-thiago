import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testeMedia {
//  entrada                        ResEsp    ResEnc
//  N{10.0,9.0,5.0} e P{8,1,1}     9.4       9.4
//  N{-1.0,5.0,-4.0} e P{8,1,1}    erro      erro
//  N{"abc",5.0,4.0} e P{8,1,1}    erro      erro
//  N{10.0,9.0,5.0} e P{0,0,0}     erro
//  N{10.0} e P{8}                 8.0
//  N{10.0,9.0,8.0} e P{1,2}       erro
//  N{} e P{}                      erro

@Test
public void testemedia(){
    double notas[] = new double[]{10.0,9.0,5.0};
    double pesos[] = new double[]{8,1,1};
    Media m = new Media();
    double cm = m.calcularMediaPonderada(notas,pesos);
    assertEquals(9.4,cm,1);
}

@Test(expected = IllegalArgumentException.class)
public void testemediaNegativa(){
    double notas[] = new double[]{-1.0,5.0,-4.0};
    double pesos[] = new double[]{8,1,1};
    Media m = new Media();
    m.calcularMediaPonderada(notas,pesos);
}

@Test(expected = IllegalArgumentException.class)
public void testemediaLetras(){
    double notas[] = new double[]{Integer.parseInt("a"),5.0,-4.0};
    double pesos[] = new double[]{8,1,1};
    Media m = new Media();
    m.calcularMediaPonderada(notas,pesos);
}

@Test(expected = IllegalArgumentException.class)
public void testemediaPeso0(){
    double notas[] = new double[]{10.0,9.0,5.0};
    double pesos[] = new double[]{0,0,0};
    Media m = new Media();
    m.calcularMediaPonderada(notas,pesos);
}
}
