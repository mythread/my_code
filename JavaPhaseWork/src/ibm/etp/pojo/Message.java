/**
 * @author zxc
 * 2012 
 */
package ibm.etp.pojo;
/**
 *信息类：含发信人、收信人、信息
 */
public class Message {
	private String sender;
	private String receiver;
	private String message;
	
	public Message() {
	}

	/**
	 * @param sender
	 * @param receiver
	 * @param message
	 */
	public Message(String sender, String receiver, String message) {
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}

