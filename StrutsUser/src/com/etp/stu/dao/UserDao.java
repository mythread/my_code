package com.etp.stu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.etp.stu.commom.dao.DBConnection;
/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-03-28	WXIBM			zxc						create
 */
public class UserDao {
	public static boolean isUseridAvailable(String userid) {
		String sql = "select t.status_id from t_user t where t.user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<HashMap<Object, Object>> result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.size() > 0) {
			String status_id = (String) result.get(0).get("STATUS_ID");
			if ("2".equals(status_id)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasUserid(String userid) {
		String sql = "select t.status_id from t_user t where t.user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<HashMap<Object, Object>> result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null && result.size() > 0) {
				return true;
		}
		return false;
	}
	
	public static boolean isLogin(String userid, String password) {
		String sql = "select t.status_id from t_user t where t.user_id = ? and trim(t.user_pwd) = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
			connection.setString(2, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.size() > 0) {
			return true;
		}
		return false;
	}
	
	public static String getUsername(String userid) {
		String sql = "select t.user_name from t_user t where t.user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<HashMap<Object, Object>> result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) result.get(0).get("USER_NAME");
	}
	
	public static void setOnline(String userid) {
		String sql = "update t_user t set t.status_id = '1' where t.user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List getUserinfo(String userid) {
		String sql = "select user_name, user_mailaddress from t_user where user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<HashMap<Object, Object>> search(String userid, String username) {
		String sql = "select t_user.user_id, t_user.user_name, t_user.user_mailaddress, t_status.status_name from t_user, t_status where t_status.status_id = t_user.status_id and user_id like ? and user_name like ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, "%" + userid + "%");
			connection.setString(2, "%" + username + "%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List result = null;
		try {
			result = connection.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void logout(String userid) {
		String sql = "update t_user t set t.status_id = '2' where t.user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void logoutall() {
		String sql = "update t_user set status_id = '2' where status_id = '1'";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void useredit(String userid, String username, String password, String email) {
		String sql = "update t_user set user_name = ?, user_pwd = ?, user_mailaddress = ? where user_id = ?";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, username);
			connection.setString(2, password);
			connection.setString(3, email);
			connection.setString(4, userid);
			connection.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void userreg(String userid, String username, String password, String email) {
		String sql = "insert into t_user(user_name, user_pwd, user_mailaddress, user_id, status_id)values(?, ?, ?, ?, '1')";
		DBConnection connection = new DBConnection(sql);
		try {
			connection.setString(1, username);
			connection.setString(2, password);
			connection.setString(3, email);
			connection.setString(4, userid);
			connection.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
