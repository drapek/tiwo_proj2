/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Exceptions.MeasureTypeNotRecognised;
import Exceptions.BadNumberOfArgumentsException;
import Exceptions.InputNotSupportedException;
import Exceptions.NumberOutOfDoubleRangeException;
import java.util.InputMismatchException;
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
public class ConverterRequirment4Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test(expected = MeasureTypeNotRecognised.class)
    public void measureNotSuporrtedTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("2 yards");
        assertNotNull(anws);
 
    }
    
    @Test
    public void convertToMultiplyConversions() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("2 m");
        
        boolean containKilometers = anws.contains("0.002 km");
        boolean containCentimeters = anws.contains("200.0 cm");
        
        System.out.println("Anwser: " + anws);
        
        assertTrue(containKilometers);
        assertTrue(containCentimeters);
        
        
 
    }
    
    @Test( expected = BadNumberOfArgumentsException.class)
    public void givenOnlyOneArgument() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("100");
    }
    
    
    @Test( expected = BadNumberOfArgumentsException.class)
    public void notSpecifiedDestinationMeasure() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("100 km to");
    }
    
    @Test( expected = InputNotSupportedException.class)
    public void toManyArgumentsToConvert() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("100 km to meter sweter");
    }
}
