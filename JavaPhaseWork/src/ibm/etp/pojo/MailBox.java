/**
 * @author zxc
 * 2012 
 */
package ibm.etp.pojo;

import ibm.etp.bussiness.dao.UserDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * <p>
 * 简易邮箱类
 * 能根据条件查找信息
 * 含的属性有：messageslist(type:ArrayList<Message> 从文件加载的信息),
 * messages(type:File 文件)
 * </p>
 */
public class MailBox {
	private ArrayList<Message> messageslist;
	private File messages;
	/**
	 * <p>
	 * 构造函数，调用init()进行初始化
	 * </p>
	 */
	public MailBox() {
		init();
	}

	/**
	 * 初始化函数 用于从ibm/etp/messagesdb/messages.txt中加载信息 然后利用BufferedReader读取文件内容，
	 * 根据文件的组成规则，截取对应的字符串， 并生成对应的Message对象， 最后将该Message对象添加到messageslist中去。
	 */
	private void init() {
		messageslist = new ArrayList<Message>();
		String url = MailBox.class.getResource(
				"/ibm/etp/messagesdb/messages.txt").toString();
		url = url.substring(6);
		messages = new File(url);
		try {
			BufferedReader br = new BufferedReader(new FileReader(messages));
			String message = br.readLine();
			while (message != null) {
				int indext = message.indexOf("TO");
				int indexm = message.indexOf("MESSAGE");
				String from = message.substring(5, indext);
				String to = message.substring(indext + 3, indexm);
				String ms = message.substring(indexm + 8);
				Message newmessage = new Message(from, to, ms);
				messageslist.add(newmessage);
				message = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据发件人姓名输出其发送的信息，如果未找到，则提示“没有邮件！”；如果有，则打印相关信息
	 * @param sender 发信人
	 */
	public void findBySender(User sender) {
		System.out.println("****************发件箱****************");
		int i=0;
		for (Iterator iterator = messageslist.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			if (m.getSender().equals(sender.getUsername())) {
				System.out.println("序号：" + (++i) + "，收信人："
						+ m.getReceiver() + "，内容为："
						+ m.getMessage());
			}
		}
		if(i==0){
			System.out.println("没有邮件！");
		}
	}
	/**
	 * 根据收信人的姓名，输出收信人为该用户的信息，如果未找到，则提示“没有邮件！”；如果有，则打印相关信息
	 * @param receiver 收信人
	 */
	public void findByReceiver(User receiver) {
		System.out.println("****************收件箱****************");
		int i=0;
		for (Iterator iterator = messageslist.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			if (m.getReceiver().equals(receiver.getUsername())) {
				System.out.println("序号：" + (++i) + "，发件人："
						+ m.getSender() + "，内容为："
						+ m.getMessage());
			}
		}
		if(i==0){
			System.out.println("没有邮件！");
		}
	}
	/**
	 * <p>
	 * 发送信息<br>
	 * 如果存在用户为收信人，则可发送，否则提示“对不起，发信失败！原因：不存在该收信人”<br>
	 * 发信的操作其实就是往文件写入信息，当然是要套用固定格式“FROM:XxxTO:XxxMESSAGE:yourmessage”
	 * @param sender 发信人
	 * @param receiver 收信人
	 * @param message 信息
	 * </p>
	 */
	public void sendMessage(User sender, String receiver, String message) {
		UserDAO udao = new UserDAO();
		//如果存在该收信人，则正常发信
		if (udao.findByUsername(receiver)) {
			Message m = new Message(sender.getUsername(), receiver, message);
			messageslist.add(m);
			try {
				FileWriter fw = new FileWriter(messages, true);
				fw.write("FROM:" + m.getSender() + "TO:" + m.getReceiver()
						+ "MESSAGE:" + m.getMessage() + "\n");
				fw.flush();
				fw.close();
				System.out.println("=======邮件发送成功 ======");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{//如果不存在该收信人，则发信失败
			System.out.println("对不起，发信失败！原因：不存在该收信人");
		}
	}
}
