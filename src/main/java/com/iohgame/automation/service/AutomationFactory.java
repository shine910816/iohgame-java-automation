package com.iohgame.automation.service;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.PageController;
import com.iohgame.automation.property.parameters.ServicePages;
import com.iohgame.automation.service.jira.CreateIssueController;
import com.iohgame.automation.service.jira.JiraLoginController;
import com.iohgame.automation.service.jira.window.CreateIssueWindow;
import com.iohgame.automation.service.jira.window.JiraLoginWindow;
import com.iohgame.framework.utility.Request;
import com.iohgame.framework.utility.ServiceFactory;
import com.iohgame.framework.utility.parameters.property.OptionElement;

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

        switch ((ServicePages) page)
        {
            case JIRA_LOGIN:
                ctrl = new JiraLoginController(m_driver, new JiraLoginWindow());
                break;

            case JIRA_CREATE:
                ctrl = new CreateIssueController(m_driver, new CreateIssueWindow());
                break;

            default:
                LOG.error("Page controller is not found by " + page);
                break;
        }

        return ctrl;
    }
}
