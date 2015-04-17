package org.webshopping.struts.action.bean;

public class Trolley {

	private String pid;
	private String name;
	private String unitprice;

	public Trolley() {

	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	@Override
	public int hashCode() {

		return pid.hashCode() + name.hashCode()
				+ unitprice.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Trolley)) {
			return false;
		}
		
		Trolley t = (Trolley) obj;
		return this.name.equals(t.getName()) && this.pid.equals(t.getPid())
				&& this.unitprice.equals(t.getUnitprice());
	}

}
