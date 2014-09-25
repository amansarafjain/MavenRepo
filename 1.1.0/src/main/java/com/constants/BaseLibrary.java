/**
 * 
 */
package com.constants;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

/**
 * @author impadmin
 *
 */
public class BaseLibrary extends login {
	Robot robot;
	  public static String datestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_").format(new Date());
	  public static File scrFile;
	  public static String Scr_name=System.getProperty("user.dir") + System.getProperty("file.separator") + "screenshots" + System.getProperty("file.separator")+ datestamp ;

	  
public String current_date(){
	   DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
       //get current date time with Date()
       Date date = new Date();
       return dateFormat.format(date);
}
	  
	public void control_L()throws InterruptedException, AWTException{
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		// CTRL+L is now pressed (receiving application should see a "key down" event.)
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void rtype(String message) throws InterruptedException,
	     AWTException {
	 // chars without Shift = 44,45,46,47,61,91,93,92,59,39,32,96
	 robot = new Robot();
	 int ascii = 0;
	 char ch = ' ';

	 List<Character> chars = Arrays.asList(')', '!', '@', '#', '$', '%', '^', '&', '*', '(', '|',
	         '~', '{', '}', ':', '"', '<', '>', '?');
	 List<Integer> codes = Arrays.asList(KeyEvent.VK_0, KeyEvent.VK_1,
	         KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5,
	         KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9,
	         KeyEvent.VK_BACK_SLASH, KeyEvent.VK_BACK_QUOTE,
	         KeyEvent.VK_OPEN_BRACKET, KeyEvent.VK_CLOSE_BRACKET,
	         KeyEvent.VK_SEMICOLON, KeyEvent.VK_QUOTE, KeyEvent.VK_COMMA,
	         KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH);
	 /*Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK,false);
	 Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK,false);*/
	 try {
	     for (int i = 0; i < message.length(); i++) {
	    	 robot.delay(50);
	         ch = message.charAt(i);
	         ascii = (int) ch;
	         if (ascii == 96) {
	             robot.keyPress(KeyEvent.VK_BACK_QUOTE);
	         } else if (ascii == 126) {
	             robot.keyPress(KeyEvent.VK_SHIFT);
	             robot.keyPress(KeyEvent.VK_BACK_QUOTE);
	             robot.keyRelease(KeyEvent.VK_SHIFT);
	         }         
	         else if (ascii == 95) {
	             robot.keyPress(KeyEvent.VK_SHIFT);
	             robot.keyPress(45);
	             robot.keyRelease(45);
	             robot.keyRelease(KeyEvent.VK_SHIFT);
	         } else if (ascii == 39) {
	             robot.keyPress(KeyEvent.VK_QUOTE);
	         } else if (ascii >= 97 && ascii <= 122) {
	             robot.keyPress(ascii - 32);
	             robot.keyRelease(ascii - 32);
	         } else if (ascii == 39 || ascii == 32
	                 || (ascii >= 44 && ascii <= 57) || ascii == 59
	                 || ascii == 61 || ascii == 91 || ascii == 92
	                 || ascii == 93) {
	             robot.keyPress(ascii);
	             robot.keyRelease(ascii);
	         } else {
	             robot.keyPress(KeyEvent.VK_SHIFT);
	             if (ascii >= 65 && ascii <= 122) {
	                 robot.keyPress(ascii);
	                 robot.keyRelease(ascii);
	             } else if (chars.contains(ch)) {
	                 int k = chars.indexOf(ch);
	                 robot.keyPress(codes.get(k));
	             }
	             robot.keyRelease(KeyEvent.VK_SHIFT);
	         }
	         //robot.delay(1000);
	         //Thread.sleep(3000);
	     }
	 } catch (Exception e) {
	     throw new WebDriverException("Unable to enter Text");
	     /*
	      * JOptionPane.showMessageDialog(null,
	      * "Implementation not available for : " + ch);
	      * robot.keyRelease(KeyEvent.VK_SHIFT); robot = null; chars = null;
	      * codes = null; //System.exit(0);
	      */
	 }

	 robot = null;
	 chars = null;
	 codes = null;
	}

	public void rtab() {
	 try {
	     robot = new Robot();
	     robot.keyPress(KeyEvent.VK_TAB);
	     robot.keyRelease(KeyEvent.VK_TAB);
	 } catch (Exception e) {
	     e.printStackTrace();
	     throw new WebDriverException("Unable to perform Tab Operation");
	 }
	 robot = null;
	}

	public void rClick() {

	 try {
	     robot = new Robot();
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	 }  catch (Exception e) {
	     e.printStackTrace();
	     throw new WebDriverException("Unable to perform Click Operation");
	 }
	 robot = null;
	}
	
	public static void Take_Screenshot() throws IOException{
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(Scr_name));	
	}
}
