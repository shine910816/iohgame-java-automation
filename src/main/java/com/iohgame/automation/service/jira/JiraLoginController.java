package com.iohgame.automation.service.jira;

import com.iohgame.automation.property.DataController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.property.parameters.motion.simple.Optionable;
import com.iohgame.automation.service.jira.window.JiraLoginWindow;
import com.iohgame.automation.service.jira.window.JiraLoginWindow.JiraLoginElement;
import com.iohgame.framework.utility.parameters.property.OptionElement;
import com.iohgame.service.jira.JiraTicketAnalysis;

public class JiraLoginController extends DataController<JiraLoginWindow, JiraTicketAnalysis> implements Optionable, Inputable
{
    public JiraLoginController(LaunchBrowser driver, JiraLoginWindow window, JiraTicketAnalysis connect)
    {
        super(driver, window, connect);
    }

    @Override
    public boolean submit(OptionElement page)
    {
        LOG.info("Turn to page: " + page);

        switch ((JiraPageIndex) page)
        {
            case LOGIN:
                if (!setPage("https://jira.rakuten-it.com/jira/login.jsp"))
                {
                    LOG.error("Turn to JIRA login page failed");
                    return false;
                }
                break;

            case CREATE:
                if (!setPage("https://jira.rakuten-it.com/jira/secure/CreateIssue!default.jspa"))
                {
                    LOG.error("Turn to JIRA ticket create page failed");
                    return false;
                }
                break;

            default:
                LOG.error("Jira page index is invalid");
                return false;
        }

        return true;
    }

    @Override
    public boolean setParameters()
    {
        LOG.info("Write user name and password");

        if (!write(JiraLoginElement.USER_NAME, "wang.lichun@trans-cosmos.com.cn"))
        {
            LOG.error("Write user name failed");
            return false;
        }

        if (!write(JiraLoginElement.PASSWORD, "!QAZxsw2"))
        {
            LOG.error("Write password failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        LOG.info("Click login button");

        if (!click(JiraLoginElement.LOGIN_BUTTON))
        {
            LOG.error("Click login button failed");
            return false;
        }

        return true;
    }

    public enum JiraPageIndex implements OptionElement
    {
        LOGIN,

        CREATE;

        @Override
        public String val()
        {
            return name();
        }
    }
}
