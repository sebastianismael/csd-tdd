package csd.tdd;


import org.junit.Assert;
import org.junit.Test;

public class CerraduraTest {

    private Cerradura cerradura = new Cerradura(1234, 3);

    @Test
    public void crearCerraduraDeberiaEstarCerrada(){
        Assert.assertEquals(true, cerradura.estaCerrada());
    }
    
    @Test
    public void crearCerraduraNoDeberiaEstarBloqueada(){
        Assert.assertFalse(cerradura.fueBloqueada());
    }
    
    @Test
    public void abrirConClaveCorrectaDeberiaAbrirLaCerradura(){
        Assert.assertEquals(true, cerradura.abrir(1234));
    }
    
    @Test
    public void abrirConClaveInCorrectaNoDeberiaAbrirLaCerradura(){
        Assert.assertEquals(false, cerradura.abrir(4444));
    }
    
    @Test
    public void aperturaExitosaDeberiaIncrementarContador(){
        cerradura.abrir(1234);
        Assert.assertEquals(1, cerradura.contarAperturasExitosas());
    }
    
    @Test
    public void cerrarCerraduraDeberiaCerrarla(){
        cerradura.abrir(1234);
        Assert.assertEquals(false, cerradura.estaCerrada());
        cerradura.cerrar();
        Assert.assertEquals(true, cerradura.estaCerrada());
    }
    
    @Test
    public void abrirMasDeNVecesConClaveInvalidaDeberiaBloqueaCerradura(){
        cerradura.abrir(444);
        Assert.assertEquals(true, cerradura.estaCerrada());
        Assert.assertEquals(false, cerradura.fueBloqueada());
        cerradura.abrir(444);
        Assert.assertEquals(true, cerradura.estaCerrada());
        Assert.assertEquals(false, cerradura.fueBloqueada());
        cerradura.abrir(444);
        Assert.assertEquals(true, cerradura.estaCerrada());
        Assert.assertEquals(false, cerradura.fueBloqueada());
        cerradura.abrir(444);
        Assert.assertEquals(true, cerradura.estaCerrada());
        Assert.assertEquals(true, cerradura.fueBloqueada());
    }
}
