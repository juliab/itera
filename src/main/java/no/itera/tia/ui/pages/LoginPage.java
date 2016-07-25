package no.itera.tia.ui.pages;

import static no.itera.tia.ui.pages.LoginPage.DEFAULT_URL;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import no.itera.tia.beans.model.User;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Input;

/**
 * This class represents Login of TIA application
 * 
 * @author yulia.siroshtan
 */
@DefaultUrl(DEFAULT_URL)
public class LoginPage extends BasePage {
	
	// TODO take base url out
	public final static String DEFAULT_URL = "http://172.29.67.42:7003/tiaweb/faces/Login";
	
	@FindBy(xpath = ".//*[contains(@id, 'username::content')]")
	private Input userName;
	
	@FindBy(xpath = ".//*[contains(@id, 'password::content')]")
	private Input password;
	
	@FindBy(xpath = ".//*[contains(@id, 'login')]")
	private Button loginButton;
	
	public void login(User user) {
		userName.sendKeys(user.getLogin());
		this.password.sendKeys(user.getPassword());
		loginButton.click();
		waitForPageToLoad();
	}
}
