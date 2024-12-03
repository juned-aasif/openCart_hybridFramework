package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class RobotFileUpload {
	/* This Robot class can select file from file explorer.
	 * Pre-requisite: the file explorer must be opened. 
	 * Use Action class to click on the upload file button
	 */
	
	public void uploadFile(String filePath) throws AWTException {
		//robot class
		Robot rb = new Robot();
		rb.delay(2000);
				
		// copy the path
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				
		//simulate CTRL+V to paste the copied file path
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
				
		// Simulate Enter to confirm the file selection
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
