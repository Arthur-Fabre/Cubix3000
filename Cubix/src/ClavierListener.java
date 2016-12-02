import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class ClavierListener implements KeyListener{
		
	 

    public void keyPressed(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}   	

    public void keyReleased(KeyEvent e) {
    	int a;
    	java.io.OutputStreamWriter ff;
    	ff=Isn.openOut("T");
    	
      System.out.println("Code touche relâchée : " + e.getKeyCode() + " - caractère touche relâchée : " + e.getKeyChar()); 
      a=e.getKeyCode();
      
      Isn.printlnToFile(ff, a);
      Isn.closeOut(ff);
      //System.out.println(a);
      
  	try {
		Thread.sleep(10);
	} catch (InterruptedException ex){
		ex.printStackTrace();; 
      
    }
  }
}