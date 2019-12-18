package com.iohgame.automation.service.baidu.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class BaiduTopWindow extends BaseWindow
{
    public BaiduTopWindow()
    {
        //@formatter:off
        m_elementMap.put(BaiduTopElement.SEARCH_KEYWORD,    ".//input[@name='wd']");
        m_elementMap.put(BaiduTopElement.SEARCH_BUTTON,     ".//input[@id='su']");
        //@formatter:on
    }

    public enum BaiduTopElement implements PageElement
    {
        SEARCH_KEYWORD(ByXPath.class),

        SEARCH_BUTTON(ByXPath.class);

        private Class<? extends By> m_type;

        private BaiduTopElement(Class<? extends By> type)
        {
            m_type = type;
        }

        @Override
        public ByType byType()
        {
            return ByType.getType(m_type);
        }
    }
}
