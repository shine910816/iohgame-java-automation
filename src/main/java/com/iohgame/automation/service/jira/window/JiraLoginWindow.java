package com.iohgame.automation.service.jira.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class JiraLoginWindow extends BaseWindow
{
    public JiraLoginWindow()
    {
        // @formatter:off
        m_elementMap.put(JiraLoginElement.USER_NAME,       ".//input[@name='os_username']");
        m_elementMap.put(JiraLoginElement.PASSWORD,        ".//input[@name='os_password']");
        m_elementMap.put(JiraLoginElement.LOGIN_BUTTON,    ".//input[@id='login-form-submit']");
        // @formatter:on
    }

    public enum JiraLoginElement implements PageElement
    {
        USER_NAME(ByXPath.class),

        PASSWORD(ByXPath.class),

        LOGIN_BUTTON(ByXPath.class);

        private Class<? extends By> m_type;

        private JiraLoginElement(Class<? extends By> type)
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
