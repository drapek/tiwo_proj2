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
public class ConverterRequirment6Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test( expected = NumberOutOfDoubleRangeException.class)
    public void givenDigitToLargeTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("10E83949 m to km");
        assertNotNull(anws);
        System.out.println(anws);
 
    }
    
    @Test (expected = NumberOutOfDoubleRangeException.class)
    public void givenDigitToSmallTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("-42142424213e9324 m to km");
        assertNotNull(anws);
 
    }
    
     @Test
    public void givenDigitIsBoundValueTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("1.7976931348623157E308 m to km");
        assertNotNull(anws);
 
    }
    
    @Test( expected = NumberOutOfDoubleRangeException.class)
    public void givenDigitToLargeMultiplyOptionTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("998834E3223 m ");
        assertNotNull(anws);
 
    }
    
   
}
