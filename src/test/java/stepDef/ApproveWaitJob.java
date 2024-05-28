package stepDef;

import Base.DriverManager;
import Utility.Assertion;
import Utility.Find;
import Utility.Find.FTimeOut;
import Utility.Find.Locator;
import Utility.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class ApproveWaitJob extends DriverManager {

	@Given("click Islem Yonetimi")
	public void click_islem_yonetimi() {
		WebElement IslemYonetimi = Find.Element(Find.Locator.id, "İşlem Yönetimi", Find.FTimeOut.MIDDLE);
		Util.clickFunction(IslemYonetimi, Util.TimeOut.LOW);
	}
	@When("click Havuzda Bekleyenler")
	public void click_havuzda_bekleyenler() {
		WebElement HavuzdaBekleyen = Find.Element(Find.Locator.id, "Havuzda Bekleyenler", Find.FTimeOut.MIDDLE);
		Util.clickFunction(HavuzdaBekleyen, Util.TimeOut.LOW);
	}
	@Then("validate Havuzda Bekleyenler page")
	public void validate_havuzda_bekleyenler_page() {
		WebElement validHavuzdaBekleyenPage = Find.Element( Find.Locator.id, "EdtrComp_71", Find.FTimeOut.MIDDLE);
		Util.clickFunction(validHavuzdaBekleyenPage, Util.TimeOut.LOW);
	}
	@Given("click borsa tanimi onayda bekleyen job {string}")
	public void click_borsa_tanimi_onayda_bekleyen_job(String borsaKodu) {
		WebElement selectedBorsaTanimiJob = Find.Element( Find.Locator.xPath, "//*[@id=\"TaskDataTable\"]/div[1]/table/tbody//*[contains(.,'"+borsaKodu+"')]", Find.FTimeOut.MIDDLE);
		Util.clickFunction(selectedBorsaTanimiJob, Util.TimeOut.LOW);
	}
}
