package XMLUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
/**
 * Class provide util function of XML operation
 */
public class XMLUtil {

	private static DocumentBuilder parser = null;
	private static Transformer transformer = null;
	static { 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
		try {
			parser = factory.newDocumentBuilder();
			parser.setEntityResolver(new EntityResolver(){
				public InputSource resolveEntity(String publicId,
						String systemId) throws SAXException, IOException {
					return new InputSource(new StringBufferInputStream(""));
				}
			});
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void putValue(Node node, String value){
		if (node == null) {
			return;
		}
		if (value == null || value.trim().length() == 0) {
			initValue(node);
			return;
		}
		Document doc = node.getOwnerDocument();
		if (doc == null) {
			return;
		}
		switch (node.getNodeType()) {
		case 5: // '\005'
		case 6: // '\006'
		case 7: // '\007'
		default:
			break;

		case 3: // '\003'
		case 4: // '\004'
		case 8: // '\b'
			((CharacterData)node).setData(value.trim());
			break;

		case 2: // '\002'
			((Attr)node).setValue(value.trim());
			break;

		case 1: // '\001'
			if (!node.hasChildNodes()) {
				node.appendChild(doc.createTextNode(value.trim()));
				break;
			}
			
			NodeList childNodes = node.getChildNodes();
			int length = childNodes.getLength();
			for (int i = 0; i < length; i++) {
				Node child = childNodes.item(i);
				if (child != null && isText(child)) {
					((CharacterData)child).setData(value.trim());
					return;
				}
			}

			node.appendChild(doc.createTextNode(value.trim()));
			break;
		}
	}
	
    public static String getValue(Node contextNode, String xpath) {
    	if (contextNode == null) {
    		return null;
    	}
    	String value = null;
    	try {
    		value = XPathAPI.eval(contextNode, xpath).toString();
    	}
    	catch (Exception e) { }
    	if (value != null) {
    		value = value.trim();
    		if (value.length() == 0) {
    			value = null;
    		}
    	}
    	return value;
		}
	
	public static void putValue(Node node, String xpath, String value){
		if(node == null)
			return;
		
		try {
			putValue(XPathAPI.selectSingleNode(node, xpath), value);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
    public static void initValue(Node node) {
    	if (node == null) {
    		return;
    	}
    	switch (node.getNodeType()) {
    	case 5: // '\005'
    	case 6: // '\006'
    	case 7: // '\007'
    	default:
    		break;

    	case 3: // '\003'
    	case 4: // '\004'
    	case 8: // '\b'
    		((CharacterData)node).setData("");
    		break;

    	case 2: // '\002'
    		Attr attrNode = (Attr)node;
    		attrNode.setValue("");
    		break;

    	case 1: // '\001'
    		if (!node.hasChildNodes()) {
    			break;
    		}
    		NodeList childNodes = node.getChildNodes();
    		int length = childNodes.getLength();
    		for (int i = 0; i < length; i++) {
    			Node child = childNodes.item(i);
    			if (child != null && isText(child)) {
    				node.removeChild(child);
    			}
    		}

    		break;
    	}
	}
	
    public static boolean isText(Node node) {
    	switch (node.getNodeType()) {
    	case 3: // '\003'
    	case 4: // '\004'
    		return true;
    	}
    	return false;
    }

    public static String convertToString(Node node) {
    	try {
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(node), new StreamResult(writer));
			return writer.toString();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
    }

    public static Node getNode(Node context, String xpath) {
    	Node node = null;
    	NodeList nodeList = executeQuery(context, xpath);
    	if (nodeList.getLength() > 0) {
    		node = nodeList.item(0);
    	}
    	return node;
	}
    
    public static NodeList executeQuery(Node instance, String xpath) {
    	NodeList nodeList = null;
    	try {
    		nodeList = XPathAPI.selectNodeList(instance, xpath);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return nodeList;
	}
    

    public static String getValue(Node node) {
    	if (node == null) {
    		return null;
        }
    	String value = null;
    	switch (node.getNodeType()) {
    		case 3: // '\003'
    		case 4: // '\004'
    		case 8: // '\b'
    			value = ((CharacterData)node).getNodeValue();
    			break;

    		case 2: // '\002'
    			value = ((Attr)node).getValue();
    			break;
    		case 1: // '\001'
    			NodeList childNodes = node.getChildNodes();
    			int length = childNodes.getLength();
    			for (int i = 0; i < length; i++) {
    				Node child = childNodes.item(i);
    				if (child.getNodeType()==3||child.getNodeType()==4) {
    					value =((CharacterData)child).getData();
    				}
    			}
    			break;
    	}
    	if (value != null) {
    		value = value.trim();
    		if (value.length() == 0) {
    			value = null;
            }
        }
    	return value;
    }

    public static Document parseFile(String filepath){
    	try {
			return parser.parse(XMLUtil.class.getResourceAsStream(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    public static Document parseFile(InputStream input){
    	try {
			return parser.parse(new InputSource(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static Document getEmptyDocument() {
    	return parser.newDocument();
    }
    
//    public static String escapeXML(String xmlString) {
//   	 return xmlString == null ? null : xmlString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");
//   }
//
//    public static String unescapeXML(String xmlString) {
//    	return xmlString == null ? null : xmlString.replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&amp;", "&");
//	}
}
