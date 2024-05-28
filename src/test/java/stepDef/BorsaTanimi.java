package stepDef;

import Utility.Assertion;
import Utility.Util;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import Base.DriverManager;
import Utility.Find;
import Utility.SelectDropDown;
import Utility.Find.FTimeOut;
import Utility.Find.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class BorsaTanimi extends DriverManager {
	
	@Given("click menuButton")
	public void click_menuButton() {
        WebElement mnBtn = Find.Element(Locator.id, "menuBtn", FTimeOut.MIDDLE);
		Util.clickFunction(mnBtn, Util.TimeOut.LOW);
	}

	@And("click enstruman hiyerarsisi")
	public void click_enstruman_hiyerarsisi() {
		WebElement selectedMenu = Find.Element(Locator.id, "Enstrüman Hiyerarşisi", FTimeOut.MIDDLE);
		Util.clickFunction(selectedMenu, Util.TimeOut.LOW);
	}

	@When("click borsa tanimi")
	public void click_borsa_tanimi() {
		WebElement EnstrumanHiyerarsi = Find.Element(Locator.id, "Borsa Tanımı", FTimeOut.MIDDLE);
		Util.clickFunction(EnstrumanHiyerarsi, Util.TimeOut.LOW);
	}

	@Then("verify borsa tanimi ekrani")
	public void verify_borsa_tanimi_ekrani() {
		WebElement BorsaTanimEkran = Find.Element(Locator.id, "EdtrComp_245", FTimeOut.MIDDLE);
		Assertion.ElementExist(BorsaTanimEkran);
	}

	//TEMEL Bilgiler Girişi

	@When("write borsa kodu {string}")
	public void write_borsa_kodu(String borsaKodu) {
		WebElement borsaKod = Find.Element( Locator.id, "input-641", FTimeOut.MIDDLE);
		Util.sendKeysFunction(borsaKod, borsaKodu, Util.TimeOut.LOW);
	}
	@When("write borsa adi {string}")
	public void write_borsa_adi(String borsaAdi) {
		WebElement borsa = Find.Element( Locator.id,"input-645", FTimeOut.MIDDLE);
		Util.sendKeysFunction(borsa, borsaAdi, Util.TimeOut.LOW);
	}
	@When("write borsa aciklama {string}")
	public void write_borsa_aciklama(String aciklama) {
		WebElement comment = Find.Element( Locator.id,"input-649", FTimeOut.MIDDLE);
		Util.sendKeysFunction(comment, aciklama, Util.TimeOut.LOW);

	}
	@When("select ulke kodu {string}")
	public void select_ulke_kodu(String ulkeKodu) {
		WebElement country = Find.Element( Locator.id,"input-655", FTimeOut.MIDDLE);
		Util.selectFromDropDown(country,"TR");
	}

	@When("write MIC kodu {string}")
	public void write_MIC_kodu(String micKodu) {
		WebElement mic = Find.Element( Locator.id,"input-669", FTimeOut.MIDDLE);
		Util.sendKeysFunction(mic, micKodu, Util.TimeOut.LOW);
	}

	@When("select gecerlilik zamani {string}")
	public void select_gecerlilik_zamani(String gecerlilikZamani) {
		WebElement validTimeRadioBtn = Find.Element( Locator.xPath, "//*[text()='"+gecerlilikZamani+"']", FTimeOut.MIDDLE);
		Util.clickFunction(validTimeRadioBtn, Util.TimeOut.LOW);
	}

	@When("click kaydet button")
	public void click_kaydet_button() {
		WebElement kaydetBtn = Find.Element( Locator.id, "EdtrComp_12853", FTimeOut.MIDDLE);
		Util.clickFunction(kaydetBtn, Util.TimeOut.MIDDLE);
	}
	@Then("verify approve popup")
	public void verify_approve_popup() {
		WebElement approv = Find.Element(Locator.id,"lblSendToApproveSuccess", FTimeOut.MIDDLE);
		Assertion.TextExactMatch(approv,"BORSA126 kodlu Borsa \"Hemen\" (09.12.2022) kaydedilmek üzere onaya gönderilecektir, devam etmek istiyor musunuz?");
	}
	@Then("click {string} button")
	public void click_button(String approveType) {
		WebElement approvSelect = Find.Element(Locator.xPath, "//*[@id=\"EdtrComp_3358\"]//*[text()='"+approveType+"']", FTimeOut.MIDDLE);
		Util.clickFunction(approvSelect, Util.TimeOut.MIDDLE);
		WebElement mic = Find.Element( Locator.id,"input-669", FTimeOut.MIDDLE);
		Util.useKeyboardButton(mic,"ESCAPE");
	}
	@Then("click Logoff button")
	public void click_Logoff_button() {
		WebElement logoff = Find.Element(Locator.id, "EdtrComp_2635", FTimeOut.MIDDLE);
		Util.clickFunction(logoff, Util.TimeOut.HIGH);
	}
}
