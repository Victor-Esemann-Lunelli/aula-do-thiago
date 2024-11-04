import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testeValidarIp {
    @Test
    public void testarIp(){
        ValidarEndereçoIP v = new ValidarEndereçoIP();
        assertTrue(v.isIPValido("193.152.54.29"));
    }

    @Test
    public void testarIpInvalido(){
        ValidarEndereçoIP v = new ValidarEndereçoIP();
        assertFalse(v.isIPValido("257.152.256.256"));
    }

    @Test
    public void testarLetras(){
        ValidarEndereçoIP v = new ValidarEndereçoIP();
        assertFalse(v.isIPValido("a.b.c.d"));
    }

    @Test
    public void testarIpmaior(){
        ValidarEndereçoIP v = new ValidarEndereçoIP();
        assertFalse(v.isIPValido("132.152.251.122.123"));
    }

    @Test
    public void testarIpmenor(){
        ValidarEndereçoIP v = new ValidarEndereçoIP();
        assertFalse(v.isIPValido("132.152.251"));
    }
}
