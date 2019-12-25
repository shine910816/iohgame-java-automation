package com.iohgame.automation.service.rakuten.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class RakutenLoginWindow extends BaseWindow
{
    public RakutenLoginWindow()
    {
        // @formatter:off
        m_elementMap.put(RakutenLoginElement.LOGIN_NAME,        ".//input[@name='u']");
        m_elementMap.put(RakutenLoginElement.LOGIN_PASSWORD,    ".//input[@name='p']");
        m_elementMap.put(RakutenLoginElement.LOGIN_BUTTON,      ".//input[@name='submit']");
        // @formatter:on
    }

    public enum RakutenLoginElement implements PageElement
    {
        LOGIN_NAME(ByXPath.class),

        LOGIN_PASSWORD(ByXPath.class),

        LOGIN_BUTTON(ByXPath.class);

        private Class<? extends By> m_type;

        private RakutenLoginElement(Class<? extends By> type)
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
