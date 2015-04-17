package test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author helinxfy 2009
 */

public class TestDOM4J {
	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();    
        try {    
        	String uri=TestDom.class.getResource("breakfast_menu.xml").toString();
			uri=uri.substring(6);
			File f = new File(uri);   
            SAXReader reader = new SAXReader();    
            Document doc = reader.read(f);    
            Element root = doc.getRootElement();    
            Element foo;    
            for (Iterator i = root.elementIterator("food"); i.hasNext();) {    
                foo = (org.dom4j.Element) i.next();    
                System.out.println("||name:   |" + foo.elementText("name"));    
                System.out.println("||price:  |" + foo.elementText("price"));    
                System.out.println("-------------------------------------------------");    
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        System.out.println("DOM4J RUNTIME£º"   
                + (System.currentTimeMillis() - lasting) + " ms");    
	}

}
