package no.itera.tia.ui.controls.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.Entity;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.ui.controls.TableRow;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class TableImpl<T extends Entity> extends PanelImpl implements Table<T> {
    
    private List<Header> headings = new ArrayList<>();
    private WebElement tableElement;
    private By headerLocator = By.xpath("./parent::div/preceding-sibling::div//th[@id]");
    private String rowsCssLocator = "tr[_afrrk]";
    private ElementLocator tableLocator;
    
    public TableImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
        super(page, locator, timeoutInMilliseconds);
        tableLocator = locator;
        tableElement = locator.findElement();
        initializeHeadings();
    }
    
    private void initializeHeadings() {
        List<WebElement> elements = tableElement.findElements(headerLocator);
        for (int i = 0; i < elements.size(); i++) {
            String id = elements.get(i).getAttribute(HtmlAttributes.ID.toString());
            if (id.endsWith("rowHeader0") || id.endsWith("rowfiller0")) {
                continue;
            }
            String title = elements.get(i).getAttribute(HtmlAttributes.TEXT.toString()).replace("* ", "").trim();
            headings.add(new Header(title, i + 1));
        }
    }
    
    @Override
    public List<TableRow<T>> getRows() {
        List<TableRow<T>> rows = new ArrayList<>();
        for (int i = 0; i < tableElement.findElements(By.cssSelector(rowsCssLocator)).size(); i++) {
            rows.add(initializeRow(i + 1));
        }
        return rows;
    }

    @Override
    public TableRow<T> getRow(int index) {
        return initializeRow(index);
    }
    
    public List<Header> getHeadings() {
        return headings;
    }
    
    @Override
    public boolean contains(T object) {
        int totalNumberOfRows = tableElement.findElements(By.cssSelector(rowsCssLocator)).size();
        return contains(object, totalNumberOfRows);
    }
    
    @Override
    public boolean contains(T object, int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            TableRow<T> row = initializeRow(i + 1);
            if (row.contains(object)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public TableRow<T> findRowContaining(T object) {
        for (int i = 0; i < tableElement.findElements(By.cssSelector(rowsCssLocator)).size(); i++) {
            TableRow<T> row = initializeRow(i + 1);
            if (row.contains(object)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<TableRow<T>> findRowsContaining(T object) {
        List<TableRow<T>> rows = new ArrayList<>();
        for (int i = 0; i < tableElement.findElements(By.cssSelector(rowsCssLocator)).size(); i++) {
            TableRow<T> row = initializeRow(i + 1);
            if (row.contains(object)) {
                rows.add(row);
            }
        }
        return rows;
    }
    

    @Override
    public void fill(T object) {
        findRowContaining(object).fill(object);
    }

    @Override
    public void fillAllRows(T object) {
        getRows().stream().forEach(r -> r.fill(object));
    }
    
    private TableRow<T> initializeRow(int index) {
        return new TableRowImpl<T>((BasePage) getPage(), 
                new RowsLocator(index), 
                getImplicitTimeoutInMilliseconds(), headings);
    }
    
    private class RowsLocator implements ElementLocator {
        
        private int index;
        
        public RowsLocator(int index) {
            this.index = index;
        }
        
        @Override
        public WebElement findElement() {
            try {
                return tableElement.findElement(By.cssSelector(rowsCssLocator + ":nth-child(" + index + ")"));
            } catch (StaleElementReferenceException e) {
                tableElement = tableLocator.findElement();
                System.out.println("table StaleElementReferenceException");
                return tableElement.findElement(By.cssSelector(rowsCssLocator + ":nth-child(" + index + ")"));
            }
        }

        @Override
        public List<WebElement> findElements() {
            try {
                return tableElement.findElements(By.cssSelector(rowsCssLocator));
            } catch (StaleElementReferenceException e) {
                tableElement = tableLocator.findElement();
                System.out.println("table StaleElementReferenceException");
                return tableElement.findElements(By.cssSelector(rowsCssLocator));
            }
        }
    }
    
    public static class Header {
        private String title;
        private int index;
        
        public Header(String title, int index) {
            this.title = title;
            this.index = index;
        }
        
        public String getTitle() {
            return title;
        }
        
        public int getIndex() {
            return index;
        }
    }
}
