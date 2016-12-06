/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import java.util.ArrayList;

/**
 *
 * @author drapek
 */
public class MeasureToMeasureFactor {
    //Store all names of first Measure
    private ArrayList <String> measure1Names = new ArrayList<>();
    
    //Store all names of second Measure
    private ArrayList <String> measure2Names = new ArrayList<>();
    
    private double measure1ToMeasure2Multiplyer = 0.0;
    private double measure2ToMeasure1Multiplyer = 0.0;
    
    
    public void setMeasure1ToMeasure2Multiplyer(double multiplyFactor) {
        measure1ToMeasure2Multiplyer = multiplyFactor;
    }
    
    public void setMeasure2ToMeasure1Multiplyer(double multiplyFactor) {
        measure2ToMeasure1Multiplyer = multiplyFactor;
    }
    
    public void addMeasure1Name(String name) {
        measure1Names.add(name);
    }
    
    public void addMeasure2Name(String name) {
        measure2Names.add(name);
    }
   
    //returns aproprate factor if it finds measures in this set
    public Double getMeasureFacotr(String measureFrom, String measureTo) {
        
        boolean isMeasureFromInFirstSet = false;
        boolean isMeasureFromInSecondSet = false;
        
        //search first measure name in first collection
        for( int i = 0; i < measure1Names.size(); i++) {
            if (measure1Names.get(i).equals(measureFrom)) {
                isMeasureFromInFirstSet = true;
                break;
            }
        }
        
        //is can't find in fist set, than serach in second
        if( !isMeasureFromInFirstSet) {
           for( int i = 0; i < measure2Names.size(); i++) {
               if (measure2Names.get(i).equals(measureFrom)) {
                   isMeasureFromInSecondSet = true;
                   break;
               }
           }
        }
        
        //if can't find base measure than return null
        if( !isMeasureFromInFirstSet && !isMeasureFromInSecondSet)
            return null;
        
        Double resultFactor = null; //variable to store finded factor
        
        //Now serach for destination mesaure (param measureTo)
        if( isMeasureFromInFirstSet ) {
            for( int i = 0; i < measure2Names.size(); i++) {
               if (measure2Names.get(i).equals(measureTo)) {
                   resultFactor =  measure1ToMeasure2Multiplyer; 
                   break;
               }
           }
        }
        
        if( isMeasureFromInSecondSet) {
            for( int i = 0; i < measure1Names.size(); i++) {
                if (measure1Names.get(i).equals(measureTo)) {
                    resultFactor = measure2ToMeasure1Multiplyer;
                    break;
                }
            }
        }
        
        if (resultFactor == null)
            return null;
        
        //if the result factor is equal 0, try to inverse the second factor
        if (resultFactor == 0.0) {
            if( isMeasureFromInFirstSet ) {
                if( measure2ToMeasure1Multiplyer == 0.0 )
                    return 0.0; //because both of factors are 0.0, so we can't do nothing about this
                else
                    return (1 / measure1ToMeasure2Multiplyer);
            } else {
                //our base measure is second set
                if( measure1ToMeasure2Multiplyer == 0.0 )
                    return 0.0; //because both of factors are 0.0, so we can't do nothing about this
                else
                    return (1 / measure2ToMeasure1Multiplyer);
            }
        }
        
        return resultFactor;
    }
    
    /**
     * This method give us possibility to find compatible measure to given in @param baseMeasure 
     * @param baseMeasure - to this pattern algorithm will search compatible measures
     * @return 
     */
    public MultiplyConvertionElement getCompatibleMeasure(String baseMeasure) {
        
        boolean matchFinded = false;
         
        //serach base measure in first set of names
        for( int i = 0; i < measure1Names.size(); i++) {
            if (measure1Names.get(i).equals(baseMeasure)) {
                matchFinded = true;
                break;
            }
        }
        
        if( matchFinded ) {
            double measureMultiplyer = measure1ToMeasure2Multiplyer;
            if( measureMultiplyer == 0 && measure2ToMeasure1Multiplyer == 0)
                return null; //because we can't convert measures by multiplyer equal 0
            
            if ( measureMultiplyer == 0 ) 
                measureMultiplyer = 1 / measure2ToMeasure1Multiplyer;
            
            return new MultiplyConvertionElement(measure2Names.get(0), measureMultiplyer);
        } 
        
        
        //if coudn't find in first set, serach in second
        for( int i = 0; i < measure2Names.size(); i++) {
            if (measure2Names.get(i).equals(baseMeasure)) {
                matchFinded = true;
                break;
            }
        }
        
        if( matchFinded ) {
            double measureMultiplyer = measure2ToMeasure1Multiplyer;
            if( measureMultiplyer == 0 && measure1ToMeasure2Multiplyer == 0)
                return null; //because we can't convert measures by multiplyer equal 0
            
            if ( measureMultiplyer == 0 ) 
                measureMultiplyer = 1 / measure1ToMeasure2Multiplyer;
            
     
            return new MultiplyConvertionElement(measure1Names.get(0), measureMultiplyer);
        } 
        
        //if can't find any...
        return null;
    }
}
