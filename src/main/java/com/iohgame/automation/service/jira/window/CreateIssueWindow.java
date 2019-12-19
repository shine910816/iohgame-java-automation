package com.iohgame.automation.service.jira.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class CreateIssueWindow extends BaseWindow
{
    public CreateIssueWindow()
    {
        // @formatter:off
        m_elementMap.put(CreateIssueElement.PROJECT_FIELD,       ".//input[@id='project-field']");
        m_elementMap.put(CreateIssueElement.ISSUE_TYPE_FIELD,    ".//input[@id='issuetype-field']");
        m_elementMap.put(CreateIssueElement.NEXT_BUTTON,         ".//input[@id='issue-create-submit']");
        m_elementMap.put(CreateIssueElement.CANCEL_LINK,         ".//input[@id='issue-create-cancel']");
        // @formatter:on
    }

    public enum CreateIssueElement implements PageElement
    {
        PROJECT_FIELD(ByXPath.class),

        ISSUE_TYPE_FIELD(ByXPath.class),

        NEXT_BUTTON(ByXPath.class),

        CANCEL_LINK(ByXPath.class);

        private Class<? extends By> m_type;

        private CreateIssueElement(Class<? extends By> type)
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
