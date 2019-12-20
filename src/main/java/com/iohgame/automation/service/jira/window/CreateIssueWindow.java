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
        m_elementMap.put(CreateIssueElement.TAB_BASIC,               ".//a[@id='aui-uid-0']");
        m_elementMap.put(CreateIssueElement.TAB_DEVELOPMENT,         ".//a[@id='aui-uid-1']");
        m_elementMap.put(CreateIssueElement.TAB_ADDITIONAL_INFO,     ".//a[@id='aui-uid-2']");
        m_elementMap.put(CreateIssueElement.TAB_AGILE_GANTTCHART,    ".//a[@id='aui-uid-3']");
        m_elementMap.put(CreateIssueElement.SUMMARY_FIELD,           ".//input[@name='summary']");
        m_elementMap.put(CreateIssueElement.PRIORITY_FIELD,          ".//input[@id='priority-field']");
        m_elementMap.put(CreateIssueElement.COMPONENTS_FIELD,        ".//textarea[@id='components-textarea']");
        m_elementMap.put(CreateIssueElement.ASSIGNEE_FIELD,          ".//input[@id='assignee-field']");
        m_elementMap.put(CreateIssueElement.DESCRIPTION_TEXTAREA,    ".//textarea[@id='description']");
        m_elementMap.put(CreateIssueElement.LABELS_FIELD,            ".//textarea[@id='labels-textarea']");
        m_elementMap.put(CreateIssueElement.FIX_VERSIONS_FIELD,      ".//textarea[@id='fixVersions-textarea']");
        m_elementMap.put(CreateIssueElement.CC_FIELD,                ".//textarea[@name='customfield_15012']");
        m_elementMap.put(CreateIssueElement.CREATE_BUTTON,           ".//input[@name='Create']");
        // @formatter:on
    }

    public enum CreateIssueElement implements PageElement
    {
        TAB_BASIC(ByXPath.class),

        TAB_DEVELOPMENT(ByXPath.class),

        TAB_ADDITIONAL_INFO(ByXPath.class),

        TAB_AGILE_GANTTCHART(ByXPath.class),

        SUMMARY_FIELD(ByXPath.class),

        PRIORITY_FIELD(ByXPath.class),

        COMPONENTS_FIELD(ByXPath.class),

        ASSIGNEE_FIELD(ByXPath.class),

        DESCRIPTION_TEXTAREA(ByXPath.class),

        LABELS_FIELD(ByXPath.class),

        FIX_VERSIONS_FIELD(ByXPath.class),

        CC_FIELD(ByXPath.class),

        CREATE_BUTTON(ByXPath.class);

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
