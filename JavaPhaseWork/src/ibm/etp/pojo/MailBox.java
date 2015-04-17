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
 * ����������
 * �ܸ�������������Ϣ
 * ���������У�messageslist(type:ArrayList<Message> ���ļ����ص���Ϣ),
 * messages(type:File �ļ�)
 * </p>
 */
public class MailBox {
	private ArrayList<Message> messageslist;
	private File messages;
	/**
	 * <p>
	 * ���캯��������init()���г�ʼ��
	 * </p>
	 */
	public MailBox() {
		init();
	}

	/**
	 * ��ʼ������ ���ڴ�ibm/etp/messagesdb/messages.txt�м�����Ϣ Ȼ������BufferedReader��ȡ�ļ����ݣ�
	 * �����ļ�����ɹ��򣬽�ȡ��Ӧ���ַ����� �����ɶ�Ӧ��Message���� ��󽫸�Message������ӵ�messageslist��ȥ��
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
	 * ���ݷ�������������䷢�͵���Ϣ�����δ�ҵ�������ʾ��û���ʼ�����������У����ӡ�����Ϣ
	 * @param sender ������
	 */
	public void findBySender(User sender) {
		System.out.println("****************������****************");
		int i=0;
		for (Iterator iterator = messageslist.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			if (m.getSender().equals(sender.getUsername())) {
				System.out.println("��ţ�" + (++i) + "�������ˣ�"
						+ m.getReceiver() + "������Ϊ��"
						+ m.getMessage());
			}
		}
		if(i==0){
			System.out.println("û���ʼ���");
		}
	}
	/**
	 * ���������˵����������������Ϊ���û�����Ϣ�����δ�ҵ�������ʾ��û���ʼ�����������У����ӡ�����Ϣ
	 * @param receiver ������
	 */
	public void findByReceiver(User receiver) {
		System.out.println("****************�ռ���****************");
		int i=0;
		for (Iterator iterator = messageslist.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			if (m.getReceiver().equals(receiver.getUsername())) {
				System.out.println("��ţ�" + (++i) + "�������ˣ�"
						+ m.getSender() + "������Ϊ��"
						+ m.getMessage());
			}
		}
		if(i==0){
			System.out.println("û���ʼ���");
		}
	}
	/**
	 * <p>
	 * ������Ϣ<br>
	 * ��������û�Ϊ�����ˣ���ɷ��ͣ�������ʾ���Բ��𣬷���ʧ�ܣ�ԭ�򣺲����ڸ������ˡ�<br>
	 * ���ŵĲ�����ʵ�������ļ�д����Ϣ����Ȼ��Ҫ���ù̶���ʽ��FROM:XxxTO:XxxMESSAGE:yourmessage��
	 * @param sender ������
	 * @param receiver ������
	 * @param message ��Ϣ
	 * </p>
	 */
	public void sendMessage(User sender, String receiver, String message) {
		UserDAO udao = new UserDAO();
		//������ڸ������ˣ�����������
		if (udao.findByUsername(receiver)) {
			Message m = new Message(sender.getUsername(), receiver, message);
			messageslist.add(m);
			try {
				FileWriter fw = new FileWriter(messages, true);
				fw.write("FROM:" + m.getSender() + "TO:" + m.getReceiver()
						+ "MESSAGE:" + m.getMessage() + "\n");
				fw.flush();
				fw.close();
				System.out.println("=======�ʼ����ͳɹ� ======");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{//��������ڸ������ˣ�����ʧ��
			System.out.println("�Բ��𣬷���ʧ�ܣ�ԭ�򣺲����ڸ�������");
		}
	}
}
