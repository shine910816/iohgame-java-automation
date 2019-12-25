package com.iohgame.automation.property;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.HtmlAttributes;
import com.iohgame.automation.property.parameters.PageController;
import com.iohgame.automation.property.parameters.PageWindow;
import com.iohgame.automation.property.parameters.PageElement;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Utility;

public abstract class BaseController<W extends PageWindow> extends MainClass implements PageController
{
    private LaunchBrowser m_driver;
    private W m_window;

    public BaseController(LaunchBrowser driver, W window)
    {
        m_driver = driver;
        m_window = window;
    }

    private WebDriver driver()
    {
        return m_driver.driver();
    }

    protected boolean setPage(String url)
    {
        try
        {
            driver().get(url);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
            return false;
        }
        return true;
    }

    protected String getPage()
    {
        return driver().getCurrentUrl();
    }

    protected SearchContext getElement(PageElement element)
    {
        try
        {
            return driver().findElement(getBy(element));
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }

    protected void sleep(long time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            LOG.error(e.getMessage());
        }
    }

    protected List<SearchContext> getElementList(PageElement element)
    {
        List<SearchContext> result = new ArrayList<>();
        try
        {
            List<WebElement> list = driver().findElements(getBy(element));
            for (WebElement item : list)
            {
                result.add(item);
            }
            return result;
        }
        catch (NoSuchElementException e)
        {
            return result;
        }
    }

    protected SearchContext getElement(SearchContext haystack, PageElement needle)
    {
        try
        {
            return ((WebElement) haystack).findElement(getBy(needle));
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }

    protected List<SearchContext> getElementList(SearchContext haystack, PageElement needle)
    {
        List<SearchContext> result = new ArrayList<>();
        try
        {
            List<WebElement> list = ((WebElement) haystack).findElements(getBy(needle));
            for (WebElement item : list)
            {
                result.add(item);
            }
            return result;
        }
        catch (NoSuchElementException e)
        {
            return result;
        }
    }

    protected SearchContext getElement(PageElement haystack, PageElement needle)
    {
        return getElement(getElement(haystack), needle);
    }

    protected List<SearchContext> getElementList(PageElement haystack, PageElement needle)
    {
        return getElementList(getElement(haystack), needle);
    }

    protected String getText(SearchContext element)
    {
        if (element == null)
        {
            return null;
        }
        return ((WebElement) element).getText();
    }

    protected String getText(PageElement element)
    {
        return getText(getElement(element));
    }

    protected String getAttibute(SearchContext element, HtmlAttributes attr)
    {
        if (element == null)
        {
            return null;
        }
        return ((WebElement) element).getAttribute(attr.val());
    }

    protected String getAttibute(PageElement element, HtmlAttributes attr)
    {
        return getAttibute(getElement(element), attr);
    }

    protected boolean hasElement(PageElement element)
    {
        return getElement(element) != null;
    }

    protected boolean hasElements(PageElement element)
    {
        return !Utility.isEmpty(getElementList(element));
    }

    protected boolean click(SearchContext element)
    {
        if (element == null)
        {
            return false;
        }
        ((WebElement) element).click();
        return true;
    }

    protected boolean click(PageElement element)
    {
        return click(getElement(element));
    }

    protected boolean clear(SearchContext element)
    {
        if (element == null)
        {
            return false;
        }
        LOG.info(((WebElement) element).getTagName());
        ((WebElement) element).clear();
        return true;
    }

    protected boolean clear(PageElement element)
    {
        return clear(getElement(element));
    }

    protected boolean write(SearchContext element, String context, boolean isClear)
    {
        if (element == null)
        {
            return false;
        }
        if (isClear && !clear(element))
        {
            return false;
        }
        ((WebElement) element).sendKeys(context);
        return true;
    }

    protected boolean write(PageElement element, String context, boolean isClear)
    {
        return write(getElement(element), context, isClear);
    }

    protected boolean write(SearchContext element, String context)
    {
        if (element == null)
        {
            return false;
        }
        return write(element, context, true);
    }

    protected boolean write(PageElement element, String context)
    {
        return write(element, context, true);
    }

    protected boolean writeTextarea(SearchContext element, String context)
    {
        if (element == null)
        {
            return false;
        }
        ((WebElement) element).sendKeys(Keys.TAB);
        ((WebElement) element).clear();
        ((WebElement) element).sendKeys(context);
        return true;
    }

    protected boolean writeTextarea(PageElement element, String context)
    {
        return writeTextarea(getElement(element), context);
    }

    protected boolean writeTag(SearchContext element, String context)
    {
        if (element == null)
        {
            return false;
        }
        ((WebElement) element).sendKeys(context);
        ((WebElement) element).sendKeys(Keys.ENTER);
        return true;
    }

    protected boolean writeTag(PageElement element, String context)
    {
        return writeTag(getElement(element), context);
    }

    protected boolean writePulldown(SearchContext element, String context)
    {
        if (element == null)
        {
            return false;
        }
        ((WebElement) element).sendKeys(Keys.BACK_SPACE);
        ((WebElement) element).sendKeys(context);
        ((WebElement) element).sendKeys(Keys.ENTER);
        return true;
    }

    protected boolean writePulldown(PageElement element, String context)
    {
        return writePulldown(getElement(element), context);
    }

    private By getBy(PageElement element)
    {
        String elementContext = m_window.getContext(element);
        ByType type = element.byType();
        switch (type)
        {
            case BY_CLASS_NAME:
                return By.className(elementContext);
            case BY_ID:
                return By.id(elementContext);
            case BY_NAME:
                return By.name(elementContext);
            case BY_TAG_NAME:
                return By.tagName(elementContext);
            case BY_X_PATH:
            default:
                return By.xpath(elementContext);
        }
    }
}
