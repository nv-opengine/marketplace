package com.gracefulcode.opengine;

import com.github.opengine.resource.Resource;
import java.util.HashMap;

public class Marketplace<T extends Class<? extends Resource>> {
	protected HashMap<T, Integer> supply;
	protected HashMap<T, Integer> demand;

	public void addSupply(T cls, int amount) {
		if (this.supply == null) {
			this.supply = new HashMap<T, Integer>();
		}
		this.supply.put(cls, this.supply.get(cls) + amount);
	}

	public void addDemand(T cls, int amount) {
		if (this.demand == null) {
			this.demand = new HashMap<T, Integer>();
		}
		this.supply.put(cls, this.demand.get(cls) + amount);
	}

	public String toString() {
		return "Market: supply: " + this.supply.toString() + ", demand: " + this.demand.toString();
	}
}