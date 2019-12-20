package com.iohgame.automation.service;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.PageController;
import com.iohgame.automation.property.parameters.ServicePages;
import com.iohgame.automation.service.jira.CreateIssueDefaultController;
import com.iohgame.automation.service.jira.JiraLoginController;
import com.iohgame.automation.service.jira.window.CreateIssueDefaultWindow;
import com.iohgame.automation.service.jira.window.JiraLoginWindow;
import com.iohgame.framework.connect.base.ConnectBase;
import com.iohgame.framework.utility.Request;
import com.iohgame.framework.utility.ServiceFactory;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.JiraTicketAnalysis;
import com.iohgame.service.jira.JiraTicketYamlColumns;
import com.iohgame.service.property.YamlLoader;

public class AutomationFactory extends ServiceFactory
{
    private LaunchBrowser m_driver;

    protected AutomationFactory(Request request, LaunchBrowser driver)
    {
        super(request);
        m_driver = driver;
    }

    public PageController getController(OptionElement page)
    {
        PageController ctrl = null;
        ConnectBase data = null;

        switch ((ServicePages) page)
        {
            case JIRA_LOGIN:
            case JIRA_CREATE:
                data = new JiraTicketAnalysis(YamlLoader.getInstance().analysis("jira_ticket", JiraTicketYamlColumns.class));
                break;

            default:
                LOG.error("Connection is not found by " + page);
                break;
        }

        switch ((ServicePages) page)
        {
            case JIRA_LOGIN:
                ctrl = new JiraLoginController(m_driver, new JiraLoginWindow(), (JiraTicketAnalysis) data);
                break;

            case JIRA_CREATE:
                ctrl = new CreateIssueDefaultController(m_driver, new CreateIssueDefaultWindow(), (JiraTicketAnalysis) data);
                break;

            default:
                LOG.error("Page controller is not found by " + page);
                break;
        }

        return ctrl;
    }
}
