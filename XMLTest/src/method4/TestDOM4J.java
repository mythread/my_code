package method4;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
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
        System.out.println("DOM4J RUNTIME："   
                + (System.currentTimeMillis() - lasting) + " ms");    
	}

}
