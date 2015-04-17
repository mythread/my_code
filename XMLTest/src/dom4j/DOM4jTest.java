package dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
public class DOM4jTest {
	private static File file = new File(DOM4jTest.class.getResource("web.xml").getPath());
	
	
	public static int getServletCount() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElm = document.getRootElement();
		List<Element> elements = rootElm.elements("servlet");
		return elements.size();
	}
	
	public static void getAllServletMapping() {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElm = document.getRootElement();
		List<Element> serlvetMappingElements = rootElm.elements("servlet-mapping");
		for (int i = 0; i < serlvetMappingElements.size(); i++) {
			Element erlvetMappingelement = serlvetMappingElements.get(i);
			Element urlPattenelement = erlvetMappingelement.element("url-pattern");
			System.out.println(urlPattenelement.getStringValue());
		}
	}
	
	public static void getAllServletMapping2() {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String xpath = "/web-app/servlet-mapping/url-pattern";
		List<Element> elements = document.selectNodes(xpath);
		for (int i = 0; i < elements.size(); i++) {
			Element urlPatternElement = elements.get(i);
			System.out.println(urlPatternElement.getStringValue());
		}
	}
	
	
	public static void main(String[] args) {
//		System.out.println(DOM4jTest.getServletCount());
//		DOM4jTest.getAllServletMapping();
		DOM4jTest.getAllServletMapping2();
	}
}
