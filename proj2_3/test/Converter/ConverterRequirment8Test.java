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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Test if multiply output is separated by '/n'
 * @author drapek
 */
public class ConverterRequirment8Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test
    public void testIfAnwsersAreInSeperatedLines() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("5034 m ");
       
        boolean anwsKmIsSeperatedLine = anws.contains("5.034 km\n");
        boolean anwsCmIsSeperatedLine = anws.contains("503400.0 cm\n");
        
        assertTrue(anwsKmIsSeperatedLine);
        assertTrue(anwsCmIsSeperatedLine);
        
 
    }
    
    
    @Test
    public void testForNotMultiplyInput() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1000 m to km");
       
        assertFalse(anws.contains("\n")); //this one output shoudn't contain new line indicator
 
    }
    
   
}
