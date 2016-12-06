/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

/**
 *
 * @author drapek
 */
public class MultiplyConvertionElement {
    private String destiantionMeasureName;
    private Double measureFactor;

    public MultiplyConvertionElement(String destinationMesureName, Double measureFactor) {
        this.destiantionMeasureName = destinationMesureName;
        this.measureFactor = measureFactor;
    }

    
    
    public String getDestiantionMeasureName() {
        return destiantionMeasureName;
    }

    public Double getMeasureFactor() {
        return measureFactor;
    }
    
 
    
}
