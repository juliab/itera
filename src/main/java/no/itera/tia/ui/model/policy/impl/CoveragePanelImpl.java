package no.itera.tia.ui.model.policy.impl;

import java.util.List;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import no.itera.tia.beans.FormData;
import no.itera.tia.beans.model.InsuranceObject;
import no.itera.tia.beans.model.Risk;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.model.policy.CoveragePanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class CoveragePanelImpl extends PanelImpl implements CoveragePanel {

	public CoveragePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}
	
	@FindBy(css = "[id$='PO2PC:PO2Tab::db'] table tr")
	private List<WebElementFacade> riskRows;
	
	@FindBy(css = "[id$='PriceArealCalculate']")
	private Button calculate;
	
	@FindBy(css = "[id$='PriceArealTotalRiskPrice::content']")
	private Control totalRiskPrice;
	
	@FindBy(css = "[id$='PO2PC:PO2Tab::db'] table")
	private Table<Risk> table;
	
	@Override
	public void fillForm(FormData object) {
	    for (Risk risk : ((InsuranceObject) object).getRisks()) {
	        table.fill(risk);
	    }
	}

	@Override
	public void calculatePrice() {
		calculate.click();
		waitForPageAction();
	}

	@Override
	public Double getTotalRiskPrice() {
		String price = totalRiskPrice.getAttribute(HtmlAttributes.VALUE);
		return Double.valueOf(price);
	}
}
