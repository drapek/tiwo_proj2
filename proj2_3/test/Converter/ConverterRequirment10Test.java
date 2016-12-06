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
public class ConverterRequirment10Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }

    @Test
    public void silentFlagTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1024 m to km --silent"); //there is o insted of 0
        assertTrue(anws.equals("1.024"));
    }
    
    
    @Test( expected = InputNotSupportedException.class)
    public void silentFlagInWrongPosition() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1024 --silent m to km"); //there is o insted of 0

    }
    
    @Test( expected = BadNumberOfArgumentsException.class)
    public void silentFlagInMultiplyOutput() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1024 m --silnet"); //there is o insted of 0

    }
    
     @Test( expected = InputNotSupportedException.class)
    public void badNumberOfParametrsWithSilentFlagTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1024 m km --silent"); //there is o insted of 0

    }
    
   
   
}
