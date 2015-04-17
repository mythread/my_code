/**
 * @author zxc
 * 2012 
 */
package ibm.etp.bussiness.dao;

import ibm.etp.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/**
 * <p>对User的常用操作
 * <dd>
 * <dl>如登录判断</dl>
 * <dl>如退出</dl>
 * </dd>
 * </p>
 */
public class UserDAO {
	private Properties users;
	private File config;
	private FileReader frconfig;
	private FileWriter fwconfig;
	/**
	 * <pre>
	 * 构造函数：在构造函数中调用私有的init()方法
	 * init()方法进行的是有些初始化工作
	 * </pre>
	 */
	public UserDAO() {
		init();
	}
	/**
	 * <p>
	 * 私有方法，主要是进行一些初始化工作
	 * <dd>
	 * <dl>
	 * 如相关文件在准备等
	 * </dl>
	 * </dd>
	 * </p>
	 */
	private void init() {
		users = new Properties();
		String uri = UserDAO.class.getResource("/ibm/etp/config/user.properties").toString();
		uri=uri.substring(6);
		config = new File(uri);
		try {
			frconfig = new FileReader(config);
			fwconfig = new FileWriter(config, true);
			users.load(frconfig);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * <p>
	 * 注册
	 * @param u 用户对象
	 * @return 如果注册成功，则返回1；如果已存在该用户名，则返回-1；如果注册失败，则返回-2；
	 * </p>
	 */
	public int register(User u){
		if(users.getProperty(u.getUsername())==null){
			try {
				fwconfig.write("\n"+u.getUsername()+"="+u.getPassword());
				fwconfig.flush();
				users.load(frconfig);//重新加载文件
				return 1;
			} catch (IOException e) {//如果发生异常，说明注册失败
				return -2;
			}
			
		}else{//已存在该用户名
			return -1;
		}
	}
	/**
	 * <p>
	 * 登录方法
	 * @param u 用户对象
	 * <dd>
	 * <dl> 如果存在该用户，且密码正确，return 1;</dl>
	 * <dl>如果存在该用户，但密码错误，return -1;</dl>
	 * <dl>如果不存在该用户，return -2;</dl>
	 * </dd>
	 * @return int (1,-1,2)
	 * </p>
	 */
	public int login(User u) {
		String password=users.getProperty(u.getUsername());
		if(password==null){
			return -2;
		}else if(password.equals(u.getPassword())){
			return 1;
		}else{
			return -1;
		}
	}
	/**
	 * <p>
	 * 退出系统<br>
	 * 因为是控制台版本的简易留言系统，所以只需调用：System.exit(0);即可
	 * </p>
	 */
	public void logout(){
		System.exit(0);
	}
	/**
	 * <p>
	 * 根据用户名查找用户是否存在
	 * @param name 用户名
	 * @return 如果存在该用户，则返回true；如果不存在该用户，则返回false
	 *  </p>
	 */
	public boolean findByUsername(String name){
		if(users.getProperty(name)!=null){
			return true;
		}
		return false;
	}
	/**
	 * <p>
	 * 关闭资源
	 * @exception IOException 关闭资源出现问题
	 * </p>
	 */
	public void close() {
		if (frconfig != null) {
			try {
				frconfig.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (fwconfig != null) {
			try {
				fwconfig.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
