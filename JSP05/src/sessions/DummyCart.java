package sessions;

import java.util.Vector;

/**
 * @author helinxfy 2009
 */

public class DummyCart {
	 Vector<String> v = new Vector<String>();
	    String submit = null;
	    String item = null;
	    
	    private void addItem(String name) {
	    	if(name!=null)
	        v.addElement(name);
	    }

	    private void removeItem(String name) {
	        v.removeElement(name);
	    }

	    public void setItem(String name) {
	    	if(name!=null)
	        item = name;
	    }
	    
	    public void setSubmit(String s) {
	        submit = s;
	    }

	    public String[] getItems() {
	        String[] s = new String[v.size()];
	        v.copyInto(s);
	        return s;
	    }
	    
	    public void processRequest() {
	        if (submit == null || submit.equals("add"))
	            addItem(item);
	        else if (submit.equals("remove")) 
	            removeItem(item);
	        
	        // reset
	        reset();
	    }

	    // reset
	    private void reset() {
	        submit = null;
	        item = null;
	    }
}
