package XMLUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
 * 1.00		2011-03-28	IBM			zxc					create
 */
public class TestXML {
	public static void main(String[] args) {
		Document doc = XMLUtil.parseFile(TestXML.class
				.getResourceAsStream("test.xml"));
		// 1.
//		System.out.println("【TestXML.main()】\n" + XMLUtil.convertToString(doc));

		// 2.
//		Node nameNode = XMLUtil.getNode(doc, "/userinfo/user[2]/name");
//		System.out.println("【TestXML.main()】"
//				+ nameNode.getFirstChild().getNodeValue());

		// 3.
//		Node proNode = XMLUtil.getNode(doc, "/userinfo/user/address/province");
//		System.out.println("【TestXML.main()】"
//				+ proNode.getFirstChild().getNodeValue());

		// 4.
//		System.out.println("【TestXML.main()】" + XMLUtil.getValue(nameNode));
//		System.out.println("【TestXML.main()】"
//				+ XMLUtil.getValue(doc, "/userinfo/user[2]/name"));

		// 5.
//		NodeList userList = XMLUtil.executeQuery(doc, "/userinfo/user");
//		for (int i = 0; i < userList.getLength(); i++) {
//			Node userNode = userList.item(i);
//			System.out.println("【TestXML.main()】"
//					+ XMLUtil.getValue(userNode, "name"));
//		}

		// 6.
//		NodeList usernameList = XMLUtil
//				.executeQuery(doc, "/userinfo/user/name");
//		for (int i = 0; i < usernameList.getLength(); i++) {
//			Node userNode = usernameList.item(i);
//			System.out.println("【TestXML.main()】" + XMLUtil.getValue(userNode));
//		}

		// 7.
//		XMLUtil.putValue(doc, "/userinfo/user[1]/name", "fdsfjoejofa");
//		System.out.println("【TestXML.main()】"
//				+ XMLUtil.getValue(doc, "/userinfo/user[1]/name"));

		// 8.
		XMLUtil.putValue(doc, "/userinfo/user[1]/name", "fdsfjoejofa");
		System.out.println("【TestXML.main()】"
				+ XMLUtil.getValue(doc, "/userinfo/user[1]/name"));

		String xmlStr = XMLUtil.convertToString(doc);

		File xmlFile = new File(TestXML.class.getResource("test.xml").getFile());
		System.out.println("【TestXML.main()】"
				+ TestXML.class.getResource("test.xml").getFile());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(xmlFile);
			fos.write(xmlStr.getBytes("utf8"));
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
