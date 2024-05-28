package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;



public class Util extends DriverManager {
	
	public enum TimeOut {

	    LOW(5),

	    MIDDLE(10),

	    HIGH(15),

	    CUSTOM_MAX(60);

	    private final int value;

	  public int getValue() {

	        return value;

	    }
	    // enum constructor - cannot be public or protected

	    private TimeOut(int value) {

	        this.value = value;

	    }
	}

	
	   public static void clickFunction(WebElement clickElement ,TimeOut timeOut){
		   try {
		   System.out.println("Start click element !!! ********* ");
		   	WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
	        wait.until(ExpectedConditions.elementToBeClickable(clickElement));

	        clickElement.click();
	        System.out.println("Element is clicked succesfuly !!! *********"+clickElement);
			   Allure.addAttachment("Click is Success","Succes"+clickElement);
		   } catch(Exception e) {
			   System.out.println("Element is not clicked succesfuly !!! ********* " +e);
			   Allure.addAttachment("Click is Failed","Failed");
		   }
	    }

	    public static void sendKeysFunction(WebElement sendKeysElement, String value, TimeOut timeOut){
	    	try {
	    	System.out.println("Start sendKeys Text !!! ********* ");
	    	WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
	        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
			sendKeysElement.clear();
	        sendKeysElement.sendKeys(value);
	        System.out.println("Text is sendKeys succesfuly !!! ********* "+sendKeysElement);
				Allure.addAttachment("SendKeys is Success","Succes"+sendKeysElement);
	    	}catch(Exception e){
	    		System.out.println("Text is not sendKeys !!! ********* " +e);
				Allure.addAttachment("SendKeys is Failed","Failed");
	    	}
	    }

		public static void DragAndDrop(WebElement sourceElement , WebElement targetElement) {

			try{
				System.out.println(" Start drag and Drop!!! *************");

				JavascriptExecutor js = (JavascriptExecutor) webDriver.get();
				String script = "function createEvent(typeOfEvent) {" +
						"var event = document.createEvent(\"CustomEvent\");" +
						"event.initCustomEvent(typeOfEvent, true, true, null);" +
						"event.dataTransfer = {" +
						"data: {}," +
						"setData: function(key, value) {" +
						"this.data[key] = value;" +
						"}," +
						"getData: function(key) {" +
						"return this.data[key];" +
						"}" +
						"};" +
						"return event;" +
						"}" +
						"" +
						"function dispatchEvent(element, event, transferData) {" +
						"if (transferData !== undefined) {" +
						"event.dataTransfer = transferData;" +
						"}" +
						"if (element.dispatchEvent) {" +
						"element.dispatchEvent(event);" +
						"} else if (element.fireEvent) {" +
						"element.fireEvent(\"on\" + event.type, event);" +
						"}" +
						"}" +
						"" +
						"function dragAndDrop(element, target) {" +
						"var dragStartEvent = createEvent('dragstart');" +
						"dispatchEvent(element, dragStartEvent);" +
						"var dropEvent = createEvent('drop');" +
						"dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);" +
						"var dragEndEvent = createEvent('dragend');" +
						"dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);" +
						"}" +
						"" +
						"dragAndDrop(arguments[0], arguments[1]);";

				js.executeScript(script, sourceElement, targetElement);

				// Optionally, you can verify the result of the drag-and-drop
				String textAfterDrop = targetElement.getText();
				if (textAfterDrop.equals("Expected Text After Drop")) {
					System.out.println("Drag and Drop completed successfully!");
				} else {
					System.out.println("Drag and Drop failed.");
				}
			} catch( Exception e) {

				System.out.println(" Drag and Drop could not complete successfully!!!*****************" +e);
			}
		}

	    public static void selectFromDropDown(WebElement element , String text) {

			Util.sendKeysFunction(element, text, TimeOut.MIDDLE);
			Util.useKeyboardButton(element,"DOWN");
			Util.useKeyboardButton(element,"ENTER");
		}
		public static void useKeyboardButton(WebElement sendKeysElement, String keyType){
			try {
				System.out.println("Start Press Keyboard Button ! ********* ");

				switch (keyType) {

					case "ENTER":
						String enter = Keys.chord(Keys.ENTER);
						sendKeysElement.sendKeys(enter);
						break;

					case "DELETE":
						String delete = Keys.chord(Keys.DELETE);
						sendKeysElement.sendKeys(delete);
						break;

					case "UP":
						String up = Keys.chord(Keys.UP);
						sendKeysElement.sendKeys(up);
						break;

					case "DOWN":
						String down = Keys.chord(Keys.DOWN);
						sendKeysElement.sendKeys(down);
						break;

					case "LEFT":
						String left = Keys.chord(Keys.LEFT);
						sendKeysElement.sendKeys(left);
						break;

					case "RIGHT":
						String right = Keys.chord(Keys.RIGHT);
						sendKeysElement.sendKeys(right);
						break;

					case "ESCAPE":
						String escape = Keys.chord(Keys.ESCAPE);
						sendKeysElement.sendKeys(escape);
						break;

					case "BACKSPACE":
						String backspace = Keys.chord(Keys.BACK_SPACE);
						sendKeysElement.sendKeys(backspace);
						break;

					case "TAB":
						String tab = Keys.chord(Keys.TAB);
						sendKeysElement.sendKeys(tab);
						break;
				}
			}catch(Exception e){
				System.out.println("Text is not sendKeys !!! ********* " +e);
				Allure.addAttachment("SendKeys is Failed","Failed");
			}
		}

		public void switchTab(String keyType){
			try{
				System.out.println("Start switch to nexTab!!!************");
				Set<String> handles = webDriver.get().getWindowHandles(); //parentid,childid,subchildid
				Iterator it = handles.iterator();
				String parentid = (String)  it.next();
				String childid = (String) it.next();

				switch (keyType){

					case "ParentTab":
						webDriver.get().switchTo().window(parentid);
						break;

					case "ChildTab":
						webDriver.get().switchTo().window(childid);
						break;
				}

				System.out.println("Switch to next Tab completed successfully !!! ***************" + keyType);
				Allure.addAttachment("Switch Tab is Failed","Success" + keyType);

			} catch (Exception e) {

				System.out.println("Something went wrong when switch to Tab!!! ***************");
				Allure.addAttachment("Switch Tab is Failed","Failed");
			}

		}
		public static void waitUntilElementInvisible(WebElement invisibleElement , TimeOut timeOut) {

		try {

			System.out.println("Start wait element to be invisible!!! ************");
			WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
			wait.until(ExpectedConditions.invisibilityOf(invisibleElement));
			System.out.println("Element invisible now!!! **************** INVISIBLE_ELEMENT:" + invisibleElement);


		}catch (Exception e) {

			System.out.println("Element is not invisible!!! ************");
			Allure.addAttachment("Invisibility is Failed", "Failed");
			}

	}

	public void scrollUntilElementVisible(WebElement element) throws InterruptedException  {

		((JavascriptExecutor) webDriver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
	public void moveToElement(WebElement element) {

		Actions actions = new Actions(webDriver.get());
		actions.moveToElement(element);
		actions.perform();
		System.out.println("Move to element !!! **************");
	}

	public void fileUpload(String filePath) {

		try {
			System.out.println("Start File Upload !!! **************");
			File uploadFile = new File(filePath);

			WebElement fileInput = webDriver.get().findElement(By.cssSelector("input[type=file]"));
			fileInput.sendKeys(uploadFile.getAbsolutePath());
			System.out.println("File Upload Successfully!!! **************" + fileInput + "///" + filePath);
			Allure.addAttachment("File upload is successful", "Success" + fileInput + "///" + filePath);
		} catch ( Exception e) {

			System.out.println("File upload is not successfully!!! *************" + e);
			Allure.addAttachment("File upload is Failed", "Failed");
		}
	}

	static FileReader reader;
	static Properties p;

	public static byte[] takeScreenShot() {
		return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
	}

	public static String properties(String fileName, String value) {
		String propValue = null;
		try {
			reader = new FileReader("AppConfig" + "//" + fileName + ".properties");
			p = new Properties();
			p.load(reader);
			propValue = p.getProperty(value);
		} catch (FileNotFoundException e) {
			new RuntimeException("File is not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			new RuntimeException("IO exception occured");
		}
		return propValue;
	}
		

	public static String getURL() {
		return webDriver.get().getCurrentUrl();
	}
}
