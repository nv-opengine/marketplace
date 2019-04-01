import org.junit.Test;
import static org.junit.Assert.*;

import com.gracefulcode.opengine.Marketplace;
import com.github.opengine.resource.Resource;

public class MarketplaceTest {
	private static class Food implements Resource {
		public String getName() {
			return "Food";
		}
	}

	@Test
	public void initiallyNoSupply() {
		Marketplace marketplace = new Marketplace();
		assertEquals(new Integer(0), marketplace.getSupply(Food.class));
	}

	@Test
	public void initiallyNoDemand() {
		Marketplace marketplace = new Marketplace();
		assertEquals(new Integer(0), marketplace.getDemand(Food.class));
	}

	@Test
	public void simpleAddSupply() {
		Marketplace marketplace = new Marketplace();
		marketplace.addSupply(Food.class, 1);
		assertEquals(new Integer(1), marketplace.getSupply(Food.class));
		assertEquals(new Integer(0), marketplace.getDemand(Food.class));
	}

	@Test
	public void simpleAddDemand() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 1);
		assertEquals(new Integer(1), marketplace.getDemand(Food.class));
		assertEquals(new Integer(0), marketplace.getSupply(Food.class));
	}

	@Test
	public void doubleAddSupply() {
		Marketplace marketplace = new Marketplace();
		marketplace.addSupply(Food.class, 1);
		marketplace.addSupply(Food.class, 1);
		assertEquals(new Integer(2), marketplace.getSupply(Food.class));
		assertEquals(new Integer(0), marketplace.getDemand(Food.class));
	}

	@Test
	public void doubleAddDemand() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 1);
		marketplace.addDemand(Food.class, 1);
		assertEquals(new Integer(2), marketplace.getDemand(Food.class));
		assertEquals(new Integer(0), marketplace.getSupply(Food.class));
	}

	@Test
	public void netSupplyUninitialized() {
		Marketplace marketplace = new Marketplace();
		assertEquals(new Integer(0), marketplace.getNetSupply(Food.class));
	}

	@Test
	public void netSupplyOnlySupply() {
		Marketplace marketplace = new Marketplace();
		marketplace.addSupply(Food.class, 1);
		assertEquals(new Integer(1), marketplace.getNetSupply(Food.class));
	}

	@Test
	public void netSupplyOnlyDemand() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 1);
		assertEquals(new Integer(-1), marketplace.getNetSupply(Food.class));
	}

	@Test
	public void netSupplyEvenlyMatched() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 10);
		marketplace.addSupply(Food.class, 10);
		assertEquals(new Integer(0), marketplace.getNetSupply(Food.class));
	}

	@Test
	public void netSupplyMoreSupply() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 10);
		marketplace.addSupply(Food.class, 20);
		assertEquals(new Integer(10), marketplace.getNetSupply(Food.class));
	}

	@Test
	public void netSupplyMoreDemand() {
		Marketplace marketplace = new Marketplace();
		marketplace.addDemand(Food.class, 20);
		marketplace.addSupply(Food.class, 10);
		assertEquals(new Integer(-10), marketplace.getNetSupply(Food.class));
	}
}
