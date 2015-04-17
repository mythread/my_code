package test;

import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author helinxfy 2009
 */

public class TestSAX extends DefaultHandler {
	Stack tags=new Stack<String>();
	//startDocument():����XML�ĵ���ʼʱ���ø÷���
	public void startDocument() throws SAXException{ 
		System.out.println("START DOCUMENT");
		}
	//endDocument():������������XML�ĵ���ĩ��ʱ���ø÷���
		public void endDocument() throws SAXException{ 
		System.out.println("END DOCUMENT");
		}
		//characters():��Ԫ���а������ַ����ݵ��ø÷���
		public void characters(char bur[], int offset,int len)
		throws SAXException{
		String tag=(String) tags.peek();
		 String s = new String(bur,offset,len);
		 //System.out.println(s);
		 if("name".equals(tag))
		 {
		 System.out.println("||name:   |"+ s);
		 }
		 if("price".equals(tag))
			System.out.println("||price:  |"+s);
			System.out.println("-------------------------------------------------");
		 }
		 //startElement()��ÿ������һ���µĿ�ʼ��ǻ���Ԫ��ʱ(���磬<element>),�͵��ø÷���
		public void startElement(String namespaceURI,
		String localName, String rawName,Attributes attrs)throws SAXException{
			tags.push(rawName);
		System.out.print("<"+rawName);
		int length = attrs.getLength();
		for(int i=0;i<length;i++){
	    System.out.print(""+attrs.getLocalName(i)+
		"="+attrs.getValue(i));
	    }
		System.out.println(">");
		}
		public void endElement(String namespaceURI,
		String localName,String rawName)throws SAXException{
		System.out.println("</"+rawName+">");
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
		System.out.println("SAX RUNTIME��"
				+ (System.currentTimeMillis() - lasting) + " ms");
	}
}
