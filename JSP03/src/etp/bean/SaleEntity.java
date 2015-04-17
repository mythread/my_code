package etp.bean;

/**
 * @author helinxfy 2009
 */

public class SaleEntity {
	private String itemID = "unknown";
	private double discountCode = 1.0;
	private int numItems = 0;

	public SaleEntity() {
		super();
	}

	public SaleEntity(String itemID, double discountCode, int numItems) {
		super();
		this.itemID = itemID;
		this.discountCode = discountCode;
		this.numItems = numItems;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public double getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(double discountCode) {
		this.discountCode = discountCode;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public double getItemCost() {
		double cost;
		if (itemID.equals("a")) {
			cost = 10 * getDiscountCode();
		} else {
			cost = 12;
		}
		return cost;
	}

	public double getTotalCost() {
		return (getItemCost() * getNumItems());
	}
}
