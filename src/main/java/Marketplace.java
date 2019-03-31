package com.gracefulcode.opengine;

public class Marketplace {
	protected HashMap<Class<? extends Resource>, Integer> supply;
	protected HashMap<Class<? extends Resource>, Integer> demand;

	public void addSupply(Class<? extends Resource> cls, int amount) {
		if (Marketplace.supply == null) {
			Marketplace.supply = new HashMap<cls, Integer>();
		}
		Marketplace.supply.put(cls, Marketplace.supply.get(cls) + amount);
	}

	public void addDemand(Class<? extends Resource> cls, int amount) {
		if (Marketplace.demand == null) {
			Marketplace.demand = new HashMap<cls, Integer>();
		}
		Marketplace.supply.put(cls, Marketplace.demand.get(cls) + amount);
	}

	public String toString() {
		return "Market: supply: " + this.supply.toString() + ", demand: " + this.demand.toString();
	}
}