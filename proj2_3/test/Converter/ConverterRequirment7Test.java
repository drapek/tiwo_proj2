/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Exceptions.MeasureTypeNotRecognised;
import Exceptions.BadNumberOfArgumentsException;
import Exceptions.NumberOutOfDoubleRangeException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *7. Metoda zwraca dane w formacie String, zawierające numer(liczby dziesiętne rozdzielone przecinkiem), spację i nazwę miary docelowej. Np. "50,8 cm".
 * @author dobrowoj
 */
public class ConverterRequirment7Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test
    public void StandardInputTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("10,0 m to km");
        assertTrue(0 == anws.compareTo("0,01 km"));
    }
    @Test
    public void StandardInputTest2() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("34,65 m to km");
        assertTrue(0 == anws.compareTo("0,03465 km"));
    }
    @Test
    public void StandardInputTest3() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("-34,65 m to km");
        assertTrue(0 == anws.compareTo("-0,03465 km"));
    }
    
    @Test
    public void StandardInputWithDotTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("10.0 m to km");
        assertFalse(0 == anws.compareTo("0,01 km"));
    }
    @Test
    public void convertToMultiplyTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2,0 m");
        
        boolean containKilometers = anws.contains("0,002 km");
        boolean containCentimeters = anws.contains("200,0 cm");
        
        assertTrue(containKilometers);
        assertTrue(containCentimeters);
 
    }
    
   
}
