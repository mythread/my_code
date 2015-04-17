package etp.bean;
/**
 * @author helinxfy 2009
 */

public class AccessCount {
	private String firstPage;
	private int accessCount=1;
	public String getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCountIncrement(int increment) {
		this.accessCount = this.accessCount+increment;
	}
	
}
