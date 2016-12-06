/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Exceptions.BadNumberOfArgumentsException;
import Exceptions.InputNotSupportedException;
import Exceptions.MeasureTypeNotRecognised;
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
public class ConverterRequirment2Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }
    
    @Test
    public void measureNamesTest1() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("2 centimeters to inch");
        assertNotNull(anws);
    }
    
    @Test
    public void measureNamesTest2() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("93 cm to inch");
        assertNotNull(anws);
    }
    
    @Test
    public void measureNamesTest3() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("22 centymetry to cale");
        assertNotNull(anws);
    }
    
    @Test
    public void measureNamesTest4() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException, InputNotSupportedException {
        String anws = converter.convert("1 centymetr to cal");
        assertNotNull(anws);
    }

}
