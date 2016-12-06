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
 *
 * @author drapek
 */
public class ConverterRequirment5Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test(expected = MeasureTypeNotRecognised.class)
    public void measureNotSuporrtedTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2,0 yards");
        assertNotNull(anws);
 
    }
    
    @Test
    public void convertToMultiplyConversions() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2.0 m");
        
        boolean containKilometers = anws.contains("0.002 km");
        boolean containCentimeters = anws.contains("200.0 cm");
        
        assertTrue(containKilometers);
        assertTrue(containCentimeters);
 
    }
    
   
    
    @Test
    public void commaTesterGoodMeasureConverstionTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("3.0 m to cm");
        
        boolean isContainGoodAnwser = anws.contains("300.0 cm");
        System.out.println(anws);
        assertTrue(isContainGoodAnwser);
    }
}
