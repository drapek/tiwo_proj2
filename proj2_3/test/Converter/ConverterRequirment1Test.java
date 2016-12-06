package Converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.BadNumberOfArgumentsException;
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
public class ConverterRequirment1Test {
    
    private Converter converter;
    
    public ConverterRequirment1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        converter = new Converter();
        
    }
    
    @After
    public void tearDown() {
    }
    
    /**************** Tests of method correct ***************************************/
    @Test
    public void inputValidationOfMethodCorrectTest() throws BadNumberOfArgumentsException {
        
        boolean isCorrect = converter.correct("20 inch to cm");
        
        assertTrue(isCorrect);
        
    }
    
    @Test
    public void inputValidationOfMethodCorrect2Test() throws BadNumberOfArgumentsException {
        
        boolean isCorrect = converter.correct("20.423 inch to cm");
        
        assertTrue(isCorrect);
        
    }
    
     @Test
    public void inputValidationOfMethodCorrectWithFalseInputTest() throws BadNumberOfArgumentsException {
        
        boolean anwser = converter.correct("inch 20 to cm");
   
        assertFalse(anwser);
        
    }
    
     @Test
    public void inputValidationOfMethodCorrectWithFalse2InputTest() throws BadNumberOfArgumentsException {
        
        boolean anwser = converter.correct("inch to 20 cm");
        
        assertFalse(anwser);
        
    }
    
     @Test
    public void inputValidationOfMethodCorrectWithFalse3InputTest() throws BadNumberOfArgumentsException {
        
        boolean anwser = converter.correct("20dfa inch to cm");
        
        assertFalse(anwser);
        
    }
    
     @Test
    public void inputValidationOfMethodCorrectWithFalse4InputTest() throws BadNumberOfArgumentsException {
        
        boolean anwser = converter.correct("20 inch cm");
        
        assertFalse(anwser);
        
    }
    
    @Test
    public void inputValidationOfMethodCorrectWithFalse5InputTest() throws BadNumberOfArgumentsException {
        
        boolean anwser = converter.correct("40 123 inch to cm");
        
        assertFalse(anwser);
        
    }
    
}
