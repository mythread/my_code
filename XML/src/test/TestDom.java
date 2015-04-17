package test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author helinxfy 2009
 */

public class TestDom {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			String uri=TestDom.class.getResource("breakfast_menu.xml").toString();
			uri=uri.substring(6);
			File f = new File(uri);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("food");
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.println("||name:   |"
						+ doc.getElementsByTagName("name").item(i)
								.getFirstChild().getNodeValue());
				System.out.println("||price:  |"
						+ doc.getElementsByTagName("price").item(i)
								.getFirstChild().getNodeValue());
				System.out
						.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DOM RUNTIME£º"
				+ (System.currentTimeMillis() - start) + " ms");

	}
}
