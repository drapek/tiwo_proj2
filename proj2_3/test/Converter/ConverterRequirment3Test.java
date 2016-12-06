/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Exceptions.BadNumberOfArgumentsException;
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
public class ConverterRequirment3Test {
    private Converter converter;
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }
    
    @Test
    public void goodMeasureTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2 centimeters to inch");
        assertNotNull(anws);
        
    }
    
    @Test(expected = MeasureTypeNotRecognised.class)
    public void measureNotSuporrtedTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2 yards to inch");
        assertNotNull(anws);
 
    }
    
    @Test(expected = MeasureTypeNotRecognised.class)
    public void measureNotSuporrtedTest2() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2 km to yard");
        assertNotNull(anws);
       
    }
    
    @Test(expected = MeasureTypeNotRecognised.class)
    public void measureNameMispelledTest() throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException {
        String anws = converter.convert("2 centtimeters to inch");
        assertNotNull(anws);
        
    }

}
