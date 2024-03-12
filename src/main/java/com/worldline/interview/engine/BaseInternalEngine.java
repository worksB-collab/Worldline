package com.worldline.interview.engine;

import com.worldline.interview.fuel.FuelType;

public abstract class BaseInternalEngine {
  
  private final FuelType requiredFuelType;
  private FuelType fuelType;
  
  protected boolean running;
  protected int fuelLevel;
  
  public BaseInternalEngine(final FuelType requiredFuelType) {
    this.requiredFuelType = requiredFuelType;
    running = false;
    fuelLevel = 0;
  }
  
  public void start() {
    if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
      this.running = true;
    } else {
      throw new IllegalStateException("Not able to start engine.");
    }
  }
  
  public void stop() {
    this.running = false;
  }
  
  public boolean isRunning() {
    return this.running;
  }
  
  public void fill(final FuelType fuelType, final int fuelLevel) {
    if (fuelLevel >= 0 && fuelLevel <= 100) {
      this.fuelLevel = fuelLevel;
    } else if (fuelLevel > 100) {
      this.fuelLevel = 100;
    } else {
      this.fuelLevel = 0;
    }
    
    this.fuelType = fuelType;
  }
  
  public FuelType getFuelType() {
    return requiredFuelType;
  }
  
  public abstract double produce(final int quantity);
  
}
