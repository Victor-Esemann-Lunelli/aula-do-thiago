import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidarNota {
    
public boolean validarnota(double nota){
    return nota >= 0 && nota<=10;
}

@Test
public void numneg(){
    assertFalse(validarnota(-10));
}

@Test(expected = IllegalArgumentException.class)
public void letra(){
   validarnota(Integer.parseInt("abc"));
}

@Test
public void num(){
    assertTrue(validarnota(1));
}

@Test
public void nummaior(){
    assertFalse(validarnota(15));
}

@Test
public void numfloat(){
    assertTrue(validarnota(2.5));
}

@Test
public void num0(){
    assertTrue(validarnota(0));
}

}
