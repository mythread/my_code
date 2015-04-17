package method4;

import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
public class TestSAX extends DefaultHandler {
	Stack tags = new Stack<String>();

	// startDocument():仅在XML文档开始时调用该方法
	public void startDocument() throws SAXException {
		System.out.println("START DOCUMENT");
	}

	// endDocument():当分析器到达XML文档的末端时调用该方法
	public void endDocument() throws SAXException {
		System.out.println("END DOCUMENT");
	}

	// characters():对元素中包含的字符数据调用该方法
	public void characters(char bur[], int offset, int len) throws SAXException {
		String tag = (String) tags.peek();
		String s = new String(bur, offset, len);
		// System.out.println(s);
		if ("name".equals(tag)) {
			System.out.println("||name:   |" + s);
		}
		if ("price".equals(tag))
			System.out.println("||price:  |" + s);
		System.out.println("-------------------------------------------------");
	}

	// startElement()：每次遇到一个新的开始标记或者元素时(例如，<element>),就调用该方法
	public void startElement(String namespaceURI, String localName,
			String rawName, Attributes attrs) throws SAXException {
		tags.push(rawName);
		System.out.print("<" + rawName);
		int length = attrs.getLength();
		for (int i = 0; i < length; i++) {
			System.out.print("" + attrs.getLocalName(i) + "="
					+ attrs.getValue(i));
		}
		System.out.println(">");
	}

	public void endElement(String namespaceURI, String localName, String rawName)
			throws SAXException {
		System.out.println("</" + rawName + ">");
	}

	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
			SAXParserFactory sf = SAXParserFactory.newInstance();
			SAXParser sp = sf.newSAXParser();
			TestSAX reader = new TestSAX();
			String uri = TestDom.class.getResource("breakfast_menu.xml")
					.toString();
			uri = uri.substring(6);
			sp.parse(new InputSource(uri), reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SAX RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " ms");
	}
}
