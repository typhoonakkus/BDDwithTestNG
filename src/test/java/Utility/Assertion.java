package Utility;

import Base.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.ByteArrayInputStream;

public class Assertion extends DriverManager {

    public static void TextExactMatch(WebElement element , String expectedText) {
        try {
            System.out.println("****************START ASSERT ELEMENT TEXT:" + element);
            Reporter.log("Starting Text Includes Assertion.**********");
            Assert.assertEquals(element.getText(), expectedText, "Assert error !!!!!Text of the element do not match****" + element);
            Allure.addAttachment("TextIncludesAssertScreen", new ByteArrayInputStream(Util.takeScreenShot()));
        }catch (Exception e){
            System.out.println("Something went wrong while Assertion !!!! ********* " +e);
        }
    }

    public static void TextIncludes(WebElement element , String expectedText) {

        Reporter.log("Starting Text Includes Assertion.**********");
        System.out.println("****************ELEMENT_TEXT:"+element.getText());
        Assert.assertSame(element.getText(), expectedText, "Assert error !!!!!Text of the element do not match****"+element);
        Allure.addAttachment("TextIncludesAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }

    public static void ElementExist(WebElement element) {

        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertNotNull(element,"Assert error !!!!!  Element not exist********");
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }

    public static void notElementExist(WebElement element) {

        System.out.println("**********Start element not exist assertion" + element);
        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertNull(element,"Assert error !!!!!  Element exist********");
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }

    public static void getTitleExactMatch(String expectedTitle) {

        System.out.println("**********Start get title exact match assertion EXPECTED TITLE IS:" + expectedTitle);
        String actualTitle = webDriver.get().getTitle();
        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertEquals(actualTitle, expectedTitle, "Assert error!!! Title of the element do not match***************" );
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }

    public static void getTitleIncludesMatch(String expectedTitle) {

        System.out.println("**********Start get title includes match assertion EXPECTED TITLE IS:" + expectedTitle);
        String actualTitle = webDriver.get().getTitle();
        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertEquals(actualTitle.contains(expectedTitle), true, "Assert error!!! Title of the element do not includes***************" );
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }
 }
