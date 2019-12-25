package com.iohgame.automation.service;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.PageController;
import com.iohgame.automation.property.parameters.ServicePages;
import com.iohgame.automation.service.jira.CreateIssueController;
import com.iohgame.automation.service.jira.CreateIssueDefaultController;
import com.iohgame.automation.service.jira.JiraLoginController;
import com.iohgame.automation.service.jira.window.CreateIssueDefaultWindow;
import com.iohgame.automation.service.jira.window.CreateIssueWindow;
import com.iohgame.automation.service.jira.window.JiraLoginWindow;
import com.iohgame.automation.service.rakuten.RakutenLoginCotroller;
import com.iohgame.automation.service.rakuten.RakutenTurnPageController;
import com.iohgame.automation.service.rakuten.window.RakutenLoginWindow;
import com.iohgame.automation.service.rakutennba.ThreadDetailController;
import com.iohgame.automation.service.rakutennba.window.ThreadDetailWindow;
import com.iohgame.framework.utility.Request;
import com.iohgame.framework.utility.ServiceFactory;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.JiraTicketAnalysis;
import com.iohgame.service.jira.JiraTicketYamlColumns;
import com.iohgame.service.property.YamlLoader;

public class AutomationFactory extends ServiceFactory
{
    private LaunchBrowser m_driver;
    private JiraTicketAnalysis m_jiraData;

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
                ctrl = new JiraLoginController(m_driver, new JiraLoginWindow(), getJiraTicketData());
                break;

            case JIRA_CREATE_DEFAULT:
                ctrl = new CreateIssueDefaultController(m_driver, new CreateIssueDefaultWindow(), getJiraTicketData());
                break;

            case JIRA_CREATE:
                ctrl = new CreateIssueController(m_driver, new CreateIssueWindow(), getJiraTicketData());
                break;

            case RAKUTEN_PAGE_TURN:
                ctrl = new RakutenTurnPageController(m_driver, null);
                break;

            case RAKUTEN_LOGIN:
                ctrl = new RakutenLoginCotroller(m_driver, new RakutenLoginWindow());
                break;

            case NBA_THREAD_DETAIL:
                ctrl = new ThreadDetailController(m_driver, new ThreadDetailWindow());
                break;

            default:
                LOG.error("Page controller is not found by " + page);
                break;
        }

        return ctrl;
    }

    private JiraTicketAnalysis getJiraTicketData()
    {
        if (m_jiraData == null)
        {
            m_jiraData = new JiraTicketAnalysis(YamlLoader.getInstance().analysis("jira_ticket", JiraTicketYamlColumns.class));
        }
        return m_jiraData;
    }
}
