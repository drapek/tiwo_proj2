/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Exceptions.MeasureTypeNotRecognised;
import Exceptions.BadNumberOfArgumentsException;
import Exceptions.NumberOutOfDoubleRangeException;
import java.util.ArrayList;

/**
 *
 * @author drapek
 */
public class Converter {
    private ArrayList <MeasureToMeasureFactor> listOfMeasures;
    private boolean useDotOnOutput;
    
    public Converter() {
        loadDefaultMeasures();
        useDotOnOutput = true;
    }
    protected boolean correct(String inputToValidate) throws BadNumberOfArgumentsException {
        String [] tableOfWords = inputToValidate.split(" ");
        
        
        if( tableOfWords.length  < 2)
            throw new BadNumberOfArgumentsException();
        
        if( tableOfWords.length == 4) {
            //The case when we specify destination measurment eg. 20 inch to cm
            if( !tableOfWords[2].equals("to") )
                return false;
        } 
        
        if (tableOfWords.length == 3 || tableOfWords.length > 4)
            throw new BadNumberOfArgumentsException();
        
        
        
        /* check if first word is an digit */ 
        try {
            Double.parseDouble(tableOfWords[0]);
        } catch( Exception e) {
            return false;
        }
      
        return true;
    }
    
    /**
     * main function of this class, provide converstion 
     */
    public String convert(String input) throws MeasureTypeNotRecognised, BadNumberOfArgumentsException, NumberOutOfDoubleRangeException { 
        
        //decide on comma or dot(Polish vs American notation)
        if(input.contains(","))
        {
            useDotOnOutput = false;
            input = input.replace(',', '.');
        }
        else
            useDotOnOutput = true;
            
        
        //validate input
        if (!correct(input))
            return null;
       
        
        //above we make the validation, so we don't have to check it once more
        String [] tableOfWords = input.split(" ");
        
        //check if it is request for mutliply output
        if( tableOfWords.length == 2) {
            return convertToMultiplyMeasures(tableOfWords);
        }
        
        String measureFrom = tableOfWords[1];
        String measureTo = tableOfWords[3];
        
        Double orginalValue = Double.parseDouble(tableOfWords[0]);
        if(  orginalValue == Double.NEGATIVE_INFINITY || orginalValue == Double.POSITIVE_INFINITY)
            throw new NumberOutOfDoubleRangeException();
        
        //we are seraching for apropate conversion factor
        Double converseFacotr = null;
        
        for( int i = 0; i < listOfMeasures.size(); i++) {
            Double findedMeasure = listOfMeasures.get(i).getMeasureFacotr(measureFrom, measureTo);
            if (findedMeasure != null) {
                converseFacotr = findedMeasure;
                break;
            }
                   
        }
        
        //if we can't find factor return null
        if( converseFacotr == null)
            throw new MeasureTypeNotRecognised();
        
        Double convertedValue = orginalValue * converseFacotr;
        
        //build Anwser  
        String result = convertedValue.toString() + " " + measureTo;
        if(useDotOnOutput == false)
            result = result.replace(".", ",");
        
        return result;
    }
    
    /**
     * method to generate multiply measures. It occurs when user input only digit and base measure.
     * This function should generate output which all possible convertions. 
     */
    private String convertToMultiplyMeasures(String [] inputArray) throws MeasureTypeNotRecognised, NumberOutOfDoubleRangeException {
        Double originValue = Double.parseDouble(inputArray[0]);
        if(  originValue == Double.NEGATIVE_INFINITY || originValue == Double.POSITIVE_INFINITY)
            throw new NumberOutOfDoubleRangeException();
        
        String originMeasure = inputArray[1];
        String result = "";
                
        for( int i = 0; i < listOfMeasures.size(); i++) {
            MultiplyConvertionElement tmp = listOfMeasures.get(i).getCompatibleMeasure(originMeasure);
            
            //if finded compalible measure than add it to result
            if( tmp != null) {
                double convertedValue = originValue * tmp.getMeasureFactor();
                result += ( convertedValue + " " + tmp.getDestiantionMeasureName() + "\n"); 
            }
            
        }
        
        if( result == "") 
            throw new MeasureTypeNotRecognised();
        if(useDotOnOutput == false)
            result = result.replace(".", ",");
        
        //prepare anwser
        return result;
    }
    
    /**
     * this method load default measures, which will be always avaiable with class Converter
     */
    private void loadDefaultMeasures() {
        listOfMeasures = new ArrayList<>();
        
        //inch to cm converter
        MeasureToMeasureFactor inchToCm = new MeasureToMeasureFactor();
       
        //add names of first measure
        inchToCm.addMeasure1Name("inch");
        inchToCm.addMeasure1Name("cal");
        inchToCm.addMeasure1Name("cale");
        inchToCm.addMeasure1Name("cali");
        
        //add names of second measure
        inchToCm.addMeasure2Name("cm");
        inchToCm.addMeasure2Name("centimeter");
        inchToCm.addMeasure2Name("centimeters");
        inchToCm.addMeasure2Name("centymetr");
        inchToCm.addMeasure2Name("centymetrów");
        inchToCm.addMeasure2Name("centymetry");
        
        //set inch to cm multiplyer
        inchToCm.setMeasure1ToMeasure2Multiplyer(2.54);
        
        listOfMeasures.add(inchToCm);
        
        //km to meters
        MeasureToMeasureFactor kmToM = new MeasureToMeasureFactor();
        
        //add names of first measure
        kmToM.addMeasure1Name("km");
        kmToM.addMeasure1Name("kilometer");
        kmToM.addMeasure1Name("kilometers");
        kmToM.addMeasure1Name("kilometr");
        kmToM.addMeasure1Name("kilometry");
        kmToM.addMeasure1Name("kilometrów");
        
         //add names of second measure
        kmToM.addMeasure2Name("m");
        kmToM.addMeasure2Name("meter");
        kmToM.addMeasure2Name("metrów");
        kmToM.addMeasure2Name("metry");
        kmToM.addMeasure2Name("metr");
        
        
        kmToM.setMeasure1ToMeasure2Multiplyer(1000.0);
        
        listOfMeasures.add(kmToM);
        
        MeasureToMeasureFactor mToCm = new MeasureToMeasureFactor();
        //add names of first measure
        mToCm.addMeasure1Name("m");
        mToCm.addMeasure1Name("meter");
        mToCm.addMeasure1Name("metrów");
        mToCm.addMeasure1Name("metry");
        mToCm.addMeasure1Name("metr");
        
        mToCm.addMeasure2Name("cm");
        mToCm.addMeasure2Name("centimeter");
        mToCm.addMeasure2Name("centymetry");
        mToCm.addMeasure2Name("centymetr");
        mToCm.addMeasure2Name("centymetrów");
        
        mToCm.setMeasure1ToMeasure2Multiplyer(100.0);
        
        listOfMeasures.add(mToCm);
                
    }
    
    
}
