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
public class DOM4JParseWebXML {
	private static File file = new File(DOM4JParseWebXML.class.getResource("web.xml").getPath());
	
	public static void getAllServletName() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElm = document.getRootElement();
		
		List elements = rootElm.elements("servlet");
		System.out.println("web.xml文件总共有" + elements.size() + "个servlet");
		for (Iterator<Element> i = rootElm.elementIterator("servlet"); i.hasNext();) {
			Element tmpElm = i.next();
			System.out.println(tmpElm.elementText("servlet-name"));
		}
	}
	
	public static void getAllServletMapping() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String xpath = "/web-app/servlet-mapping/url-pattern";
		
		List<Element> elements = document.selectNodes(xpath);
		for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
			Element element = iterator.next();
			System.out.println(element.getStringValue());
		}
	}
	
	public static void searchFilterMapping() {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String xpath = "//filter-mapping[url-pattern='/*']";
		List<Element> elements = document.selectNodes(xpath);
		for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
			Element element = iterator.next();
			System.out.println(element.elementText("filter-name"));
		}
	}
	
	public static void main(String[] args) {
//		DOM4JParseWebXML.getAllServletName();
//		DOM4JParseWebXML.getAllServletMapping();
		DOM4JParseWebXML.searchFilterMapping();
	}
}
