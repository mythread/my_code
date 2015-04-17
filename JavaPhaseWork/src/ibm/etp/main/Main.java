/**
 * @author zxc
 * 2012 
 */
package ibm.etp.main;

import ibm.etp.bussiness.dao.UserDAO;
import ibm.etp.pojo.MailBox;
import ibm.etp.pojo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * ����� �ṩ���ò���
 * </p>
 */
public class Main {
	private static UserDAO udao = new UserDAO();
	private static MailBox mailbox = new MailBox();
	private static User u;

	/**
	 * <p>
	 * ��ں��� ����Ϊ��
	 * <ol>
	 * <li>��ӡ�˵���1:��¼��2:ע�᣻3:�˳�
	 * <li>1.Ҫ���û����е�¼
	 * <li>��֤�û���Ϣ����ɹ���ִ����һ����ʧ���򷵻���һ��
	 * <li>��ӡ�˵����˵�Ϊ��1:���� ��2:�鿴�ռ��䣻3:�鿴�����䣻4:�˳�
	 * <li>�����û�ѡ��ִ����Ӧ�Ĳ˵�
	 * <li>2.ע�ᣬ��������һ��ʱ����ע��
	 * <li>3.�˳�ϵͳ
	 * </ol>
	 * 
	 * @param args
	 *            </p>
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			menu1();
			String firstchioce = br.readLine();
			s: while (!"3".equals(firstchioce)) {
				int chioce = Integer.parseInt(firstchioce);
				switch (chioce) {
				case 1:
					login();
					break s;
				case 2:
					register();
					break s;
				default:
					System.out.println("��������,�밴�˵���ʾѡ��");
					menu1();
					firstchioce = br.readLine();
					break;
				}
			}
			if ("3".equals(firstchioce)) {
				udao.logout();
			}
		} catch (IOException e) {
			System.out.println("ERROR:ϵͳ�쳣��");
		}

	}

	/**
	 * <pre>
	 * ��ӡ�˵�
	 * ----�˵�------
	 * |1:��¼              |
	 * |2:ע��              |
	 * |3:�˳�              |
	 * -------------
	 * </pre>
	 */
	public static void menu1() {
		System.out.println("----�˵�------");
		System.out.println("|1:��¼              |");
		System.out.println("|2:ע��              |");
		System.out.println("|3:�˳�              |");
		System.out.println("-------------");
	}

	/**
	 * <pre>
	 * ��ӡ�˵�
	 * -------�˵�-------
	 * |1:����                         |
	 * |2:�鿴�ռ���              |
	 * |3:�鿴������              |
	 * |4:�˳�                         |
	 * -----------------
	 * </pre>
	 */
	public static void menu2() {
		System.out.println("-------�˵�-------");
		System.out.println("|1:����                         |");
		System.out.println("|2:�鿴�ռ���              |");
		System.out.println("|3:�鿴������              |");
		System.out.println("|4:�˳�                         |");
		System.out.println("-----------------");
	}

	/**
	 * <p>
	 * ������Ӧ�ķ�������ע��
	 * </p>
	 */
	public static void register() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=====������ע����Ϣ=====");
			System.out.print("�û�����");
			String username = br.readLine();
			System.out.print("���룺");
			String password = br.readLine();
			System.out.print("����ȷ�ϣ�");
			String password1 = br.readLine();
			if (password.equals(password1)) {
				reglogic(username, password);
			} else {
				boolean error = true;
				while (error) {
					System.out.println("������������벻һ�£����������룡");
					System.out.print("���룺");
					password = br.readLine();
					System.out.print("����ȷ�ϣ�");
					password1 = br.readLine();
					if (password.equals(password1)) {
						error = false;
					}
				}
				reglogic(username, password);
			}
		} catch (IOException e) {
			System.out.println("ERROR:ϵͳ�����쳣��ע��ʧ�ܣ�");
		}
	}

	/**
	 * <p>
	 * ע���߼�������
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ���� ������Ĳ�������һ���µ�Userʵ����Ȼ�����UserDAO.register(u)����ע�ᡣ
	 *            </p>
	 */
	public static void reglogic(String username, String password) {
		User u = new User(username, password);
		int result = udao.register(u);
		if (result == 1) {
			System.out.println("ע��ɹ���");
			login();
		} else if (result == -1) {
			System.out.println("ע��ʧ��,ԭ���Ѵ��ڸ��û���������ע�ᣡ");
			register();
		} else {
			System.out.println("ע��ʧ��,ԭ��ϵͳ�쳣��������ע�ᣡ");
			register();
		}
	}

	/**
	 * ��¼�˵�
	 */
	public static void login() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=====�������¼��Ϣ=====");
			System.out.print("�û�����");
			String username = br.readLine();
			System.out.print("���룺");
			String password = br.readLine();
			if (username != null & username.trim().length() != 0
					& password != null & password.trim().length() != 0) {
				u = new User(username, password);
				int result = udao.login(u);
				while (result == -2) {
					System.out.println("�����ڸ��û������������룺");
					System.out.print("�û�����");
					username = br.readLine();
					System.out.print("���룺");
					password = br.readLine();
					if (username != null & username.trim().length() != 0
							& password != null & password.trim().length() != 0) {
						u = new User(username, password);
						result = udao.login(u);
					}
				}
				while (result == -1) {
					System.out.println("�����������������룺");
					System.out.print("�û�����");
					username = br.readLine();
					System.out.print("���룺");
					password = br.readLine();
					if (username != null & username.trim().length() != 0
							& password != null & password.trim().length() != 0) {
						u = new User(username, password);
						result = udao.login(u);
					}
				}
				if (result == 1) {
					System.out.println("======��¼�ɹ���=======");
					menu2();
					String choose = br.readLine();
					while (!"4".equals(choose)) {
						int casevalue = Integer.parseInt(choose);
						switch (casevalue) {
						case 1:
							sendMessage();
							menu2();
							choose = br.readLine();
							break;
						case 2:
							checkReceiveBox();
							menu2();
							choose = br.readLine();
							break;
						case 3:
							checkSendBox();
							menu2();
							choose = br.readLine();
							break;
						default:
							System.out.println("�����������������룡");
							menu2();
							choose = br.readLine();
							break;
						}
					}
					if ("4".equals(choose)) {
						udao.logout();
					}
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR:ϵͳ�쳣����¼ʧ�ܣ�");
		}
	}

	/**
	 * <p>
	 * ������Ϣ ����Ϊ��
	 * <ol>
	 * <li>��ʾ��=========����Ϣ=========��
	 * <li>��ʾ���ռ��ˣ���
	 * <li>����̨�����ռ�������
	 * <li>��ʾ�����ݣ���
	 * <li>����̨��������
	 * <li>����MailBox��sendMessage(u, receiver, message)����
	 * {@link ibm.etp.pojo.MailBox#sendMessage(User, String, String)}
	 * </ol>
	 * </p>
	 */
	public static void sendMessage() {
		try {
			BufferedReader send = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=========����Ϣ=========");
			System.out.print("�ռ��ˣ�");
			String receiver = send.readLine();
			System.out.print("���ݣ�");
			String message = send.readLine();
			mailbox.sendMessage(u, receiver, message);
		} catch (IOException e) {
			System.out.println("ERROR:����Ϣʧ��!");
		}
	}

	/**
	 * <p>
	 * �鿴�����䣺����MailBox��findBySender(u);
	 * {@link ibm.etp.pojo.MailBox#findBySender(User)}
	 * </p>
	 */
	public static void checkSendBox() {
		mailbox.findBySender(u);
	}

	/**
	 * <p>
	 * �鿴�����䣺����MailBox��findByReceiver(u);
	 * {@link ibm.etp.pojo.MailBox#findByReceiver(User)}
	 * </p>
	 */
	public static void checkReceiveBox() {
		mailbox.findByReceiver(u);
	}
}
