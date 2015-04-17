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
 * <p>��User�ĳ��ò���
 * <dd>
 * <dl>���¼�ж�</dl>
 * <dl>���˳�</dl>
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
	 * ���캯�����ڹ��캯���е���˽�е�init()����
	 * init()�������е�����Щ��ʼ������
	 * </pre>
	 */
	public UserDAO() {
		init();
	}
	/**
	 * <p>
	 * ˽�з�������Ҫ�ǽ���һЩ��ʼ������
	 * <dd>
	 * <dl>
	 * ������ļ���׼����
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
	 * ע��
	 * @param u �û�����
	 * @return ���ע��ɹ����򷵻�1������Ѵ��ڸ��û������򷵻�-1�����ע��ʧ�ܣ��򷵻�-2��
	 * </p>
	 */
	public int register(User u){
		if(users.getProperty(u.getUsername())==null){
			try {
				fwconfig.write("\n"+u.getUsername()+"="+u.getPassword());
				fwconfig.flush();
				users.load(frconfig);//���¼����ļ�
				return 1;
			} catch (IOException e) {//��������쳣��˵��ע��ʧ��
				return -2;
			}
			
		}else{//�Ѵ��ڸ��û���
			return -1;
		}
	}
	/**
	 * <p>
	 * ��¼����
	 * @param u �û�����
	 * <dd>
	 * <dl> ������ڸ��û�����������ȷ��return 1;</dl>
	 * <dl>������ڸ��û������������return -1;</dl>
	 * <dl>��������ڸ��û���return -2;</dl>
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
	 * �˳�ϵͳ<br>
	 * ��Ϊ�ǿ���̨�汾�ļ�������ϵͳ������ֻ����ã�System.exit(0);����
	 * </p>
	 */
	public void logout(){
		System.exit(0);
	}
	/**
	 * <p>
	 * �����û��������û��Ƿ����
	 * @param name �û���
	 * @return ������ڸ��û����򷵻�true����������ڸ��û����򷵻�false
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
	 * �ر���Դ
	 * @exception IOException �ر���Դ��������
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
