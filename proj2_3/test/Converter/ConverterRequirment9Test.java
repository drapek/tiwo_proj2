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
public class ConverterRequirment9Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test( expected = InputNotSupportedException.class)
    public void wrongDigitTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("888O832 m"); //there is o insted of 0

    }
    
    
    @Test
    public void wrongMesurmentTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        boolean exceptionOccured = false;
        try {
            String anws = converter.convert("214 wieloryb to km");
        } catch ( Exception e) {
            exceptionOccured = true;
        }
        
        assertTrue(exceptionOccured);
    }
    
    @Test( expected = InputNotSupportedException.class)
    public void doNotUsedParametrTo() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("8283 m km to");
 
    }
    
     @Test( expected = InputNotSupportedException.class)
    public void wrongUsedThirdParameter() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("8283 m drzewo km");
 
    }
    
   
}
