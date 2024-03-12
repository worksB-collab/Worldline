package com.worldline.interview.engine;

import com.worldline.interview.fuel.CombustionFuelType;

public class InternalCombustionEngine extends BaseInternalEngine{
    
    public InternalCombustionEngine(final CombustionFuelType requiredFuelType) {
        super(requiredFuelType);
    }
    
    @Override
    public double produce(final int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;
        
        if (getFuelType() == CombustionFuelType.PETROL) {
            costPerBatch = 9;
        } else if (getFuelType() == CombustionFuelType.DIESEL) {
            costPerBatch = 12;
        }
        
        while (batch < quantity) {
            batch = batch + 8;
            batchCount++;
        }
        
        return batchCount * costPerBatch;
    }
    
}
