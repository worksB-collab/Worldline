package com.worldline.interview;

import com.worldline.interview.engine.BaseInternalEngine;
import com.worldline.interview.engine.InternalCombustionEngine;
import com.worldline.interview.engine.InternalSteamEngine;
import com.worldline.interview.fuel.CombustionFuelType;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.SteamFuelType;

public class WidgetMachine {
    private final InternalCombustionEngine petrolEngine = new InternalCombustionEngine(CombustionFuelType.PETROL);
    private final InternalCombustionEngine dieselEngine = new InternalCombustionEngine(CombustionFuelType.DIESEL);
    private final InternalSteamEngine woodEngine = new InternalSteamEngine(SteamFuelType.WOOD);
    private final InternalSteamEngine coalEngine = new InternalSteamEngine(SteamFuelType.COAL);

    public double produceWidgets(final int quantity) {
        double cost = 0;
        cost += getCostFromProduction(petrolEngine, CombustionFuelType.PETROL, quantity);
        cost += getCostFromProduction(dieselEngine, CombustionFuelType.DIESEL, quantity);
        cost += getCostFromProduction(woodEngine, SteamFuelType.WOOD, quantity);
        cost += getCostFromProduction(coalEngine, SteamFuelType.COAL, quantity);
        
        return cost;
    }
    
    private double getCostFromProduction(final BaseInternalEngine engine, final FuelType fuelType, final int quantity) {
        engine.fill(fuelType, 100);
        engine.start();
        double cost = 0;
        
        if (engine.isRunning()) {
            cost = engine.produce(quantity);
            engine.stop();
        }
        return cost;
    }
    

}
