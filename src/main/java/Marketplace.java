package com.gracefulcode.opengine;

import com.github.opengine.resource.Resource;
import java.util.HashMap;

public class Marketplace<T extends Class<? extends Resource>> {
	protected HashMap<T, Integer> supply;
	protected HashMap<T, Integer> demand;

	public Integer getSupply(T cls) {
		if (this.supply == null) return 0;
		return this.supply.getOrDefault(cls, 0);
	}

	public Integer getNetSupply(T cls) {
		int total = 0;
		if (this.supply != null) {
			total += this.supply.getOrDefault(cls, 0);
		}
		if (this.demand != null) {
			total -= this.demand.getOrDefault(cls, 0);
		}
		return total;
	}

	public Integer getDemand(T cls) {
		if (this.demand == null) return 0;
		return this.demand.getOrDefault(cls, 0);
	}

	public void addSupply(T cls, int amount) {
		if (this.supply == null) {
			this.supply = new HashMap<T, Integer>();
		}
		this.supply.put(cls, this.supply.getOrDefault(cls, 0) + amount);
	}

	public void addDemand(T cls, int amount) {
		if (this.demand == null) {
			this.demand = new HashMap<T, Integer>();
		}
		this.demand.put(cls, this.demand.getOrDefault(cls, 0) + amount);
	}

	public String toString() {
		return "Market: supply: " + (this.supply == null ? "null" : this.supply.toString()) + ", demand: " + (this.demand == null ? "null" : this.demand.toString());
	}
}