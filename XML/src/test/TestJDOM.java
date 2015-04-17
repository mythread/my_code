package test;

import java.io.File;
import java.util.List;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * @author helinxfy 2009
 */

public class TestJDOM {
	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();    
        try {    
        	String uri=TestDom.class.getResource("breakfast_menu.xml").toString();
			uri=uri.substring(6);
			File f = new File(uri);
            SAXBuilder builder = new SAXBuilder();    
            org.jdom.Document doc = builder.build(f);    
            Element foo = doc.getRootElement();   
            List allChildren = foo.getChildren();    
            for (int i = 0; i < allChildren.size(); i++) {    
                System.out.println("||name:   |"   
                        + ((Element) allChildren.get(i)).getChild("name")    
                                .getText());    
                System.out.println("||price:  |"   
                        + ((Element) allChildren.get(i)).getChild("price")    
                                .getText());    
                System.out.println("-------------------------------------------------");            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        System.out.println("JDOM RUNTIME£º"   
                + (System.currentTimeMillis() - lasting) + " ms");    

	}
}
