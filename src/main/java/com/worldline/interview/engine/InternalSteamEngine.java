package com.worldline.interview.engine;

import com.worldline.interview.fuel.SteamFuelType;

public class InternalSteamEngine extends BaseInternalEngine{
    
    public InternalSteamEngine(final SteamFuelType requiredFuelType) {
        super(requiredFuelType);
    }
    
    @Override
    public double produce(final int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;
        
        if (getFuelType() == SteamFuelType.WOOD) {
            costPerBatch = 4.35;
        } else if (getFuelType() == SteamFuelType.COAL) {
            costPerBatch = 5.65;
        }
        
        while (batch < quantity) {
            batch = batch + 2;
            batchCount++;
        }
        
        return batchCount * costPerBatch;
    }
    
}
