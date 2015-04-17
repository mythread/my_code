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
 * 入口类 提供常用操作
 * </p>
 */
public class Main {
	private static UserDAO udao = new UserDAO();
	private static MailBox mailbox = new MailBox();
	private static User u;

	/**
	 * <p>
	 * 入口函数 流程为：
	 * <ol>
	 * <li>打印菜单：1:登录；2:注册；3:退出
	 * <li>1.要求用户进行登录
	 * <li>验证用户信息，如成功则执行下一步，失败则返回上一步
	 * <li>打印菜单，菜单为：1:发信 ；2:查看收件箱；3:查看发件箱；4:退出
	 * <li>根据用户选择执行相应的菜单
	 * <li>2.注册，两次密码一致时方能注册
	 * <li>3.退出系统
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
					System.out.println("输入有误,请按菜单提示选择！");
					menu1();
					firstchioce = br.readLine();
					break;
				}
			}
			if ("3".equals(firstchioce)) {
				udao.logout();
			}
		} catch (IOException e) {
			System.out.println("ERROR:系统异常！");
		}

	}

	/**
	 * <pre>
	 * 打印菜单
	 * ----菜单------
	 * |1:登录              |
	 * |2:注册              |
	 * |3:退出              |
	 * -------------
	 * </pre>
	 */
	public static void menu1() {
		System.out.println("----菜单------");
		System.out.println("|1:登录              |");
		System.out.println("|2:注册              |");
		System.out.println("|3:退出              |");
		System.out.println("-------------");
	}

	/**
	 * <pre>
	 * 打印菜单
	 * -------菜单-------
	 * |1:发信                         |
	 * |2:查看收件箱              |
	 * |3:查看发件箱              |
	 * |4:退出                         |
	 * -----------------
	 * </pre>
	 */
	public static void menu2() {
		System.out.println("-------菜单-------");
		System.out.println("|1:发信                         |");
		System.out.println("|2:查看收件箱              |");
		System.out.println("|3:查看发件箱              |");
		System.out.println("|4:退出                         |");
		System.out.println("-----------------");
	}

	/**
	 * <p>
	 * 调用相应的方法进行注册
	 * </p>
	 */
	public static void register() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=====请输入注册信息=====");
			System.out.print("用户名：");
			String username = br.readLine();
			System.out.print("密码：");
			String password = br.readLine();
			System.out.print("密码确认：");
			String password1 = br.readLine();
			if (password.equals(password1)) {
				reglogic(username, password);
			} else {
				boolean error = true;
				while (error) {
					System.out.println("两次输入的密码不一致，请重新输入！");
					System.out.print("密码：");
					password = br.readLine();
					System.out.print("密码确认：");
					password1 = br.readLine();
					if (password.equals(password1)) {
						error = false;
					}
				}
				reglogic(username, password);
			}
		} catch (IOException e) {
			System.out.println("ERROR:系统发生异常，注册失败！");
		}
	}

	/**
	 * <p>
	 * 注册逻辑方法：
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码 将传入的参数生成一个新的User实例，然后调用UserDAO.register(u)进行注册。
	 *            </p>
	 */
	public static void reglogic(String username, String password) {
		User u = new User(username, password);
		int result = udao.register(u);
		if (result == 1) {
			System.out.println("注册成功！");
			login();
		} else if (result == -1) {
			System.out.println("注册失败,原因：已存在该用户！请重新注册！");
			register();
		} else {
			System.out.println("注册失败,原因：系统异常！请重新注册！");
			register();
		}
	}

	/**
	 * 登录菜单
	 */
	public static void login() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=====请输入登录信息=====");
			System.out.print("用户名：");
			String username = br.readLine();
			System.out.print("密码：");
			String password = br.readLine();
			if (username != null & username.trim().length() != 0
					& password != null & password.trim().length() != 0) {
				u = new User(username, password);
				int result = udao.login(u);
				while (result == -2) {
					System.out.println("不存在该用户！请重新输入：");
					System.out.print("用户名：");
					username = br.readLine();
					System.out.print("密码：");
					password = br.readLine();
					if (username != null & username.trim().length() != 0
							& password != null & password.trim().length() != 0) {
						u = new User(username, password);
						result = udao.login(u);
					}
				}
				while (result == -1) {
					System.out.println("密码有误！请重新输入：");
					System.out.print("用户名：");
					username = br.readLine();
					System.out.print("密码：");
					password = br.readLine();
					if (username != null & username.trim().length() != 0
							& password != null & password.trim().length() != 0) {
						u = new User(username, password);
						result = udao.login(u);
					}
				}
				if (result == 1) {
					System.out.println("======登录成功！=======");
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
							System.out.println("输入有误，请重新输入！");
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
			System.out.println("ERROR:系统异常，登录失败！");
		}
	}

	/**
	 * <p>
	 * 发送信息 流程为：
	 * <ol>
	 * <li>提示“=========发信息=========”
	 * <li>提示“收件人：”
	 * <li>控制台输入收件人姓名
	 * <li>提示“内容：”
	 * <li>控制台输入内容
	 * <li>调用MailBox的sendMessage(u, receiver, message)方法
	 * {@link ibm.etp.pojo.MailBox#sendMessage(User, String, String)}
	 * </ol>
	 * </p>
	 */
	public static void sendMessage() {
		try {
			BufferedReader send = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("=========发信息=========");
			System.out.print("收件人：");
			String receiver = send.readLine();
			System.out.print("内容：");
			String message = send.readLine();
			mailbox.sendMessage(u, receiver, message);
		} catch (IOException e) {
			System.out.println("ERROR:发信息失败!");
		}
	}

	/**
	 * <p>
	 * 查看发件箱：调用MailBox的findBySender(u);
	 * {@link ibm.etp.pojo.MailBox#findBySender(User)}
	 * </p>
	 */
	public static void checkSendBox() {
		mailbox.findBySender(u);
	}

	/**
	 * <p>
	 * 查看发件箱：调用MailBox的findByReceiver(u);
	 * {@link ibm.etp.pojo.MailBox#findByReceiver(User)}
	 * </p>
	 */
	public static void checkReceiveBox() {
		mailbox.findByReceiver(u);
	}
}
