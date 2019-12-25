package com.iohgame.automation.service;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.ServicePages;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.property.parameters.motion.simple.Optionable;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Request;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public class AutomationCollection extends MainClass
{
    private AutomationFactory m_factory;

    public AutomationCollection(Request request, LaunchBrowser driver)
    {
        m_factory = new AutomationFactory(request, driver);
    }

    public boolean turnPage(ServicePages page, OptionElement option)
    {
        Optionable controller = null;

        switch (page)
        {
            case JIRA_LOGIN:
            case RAKUTEN_PAGE_TURN:
                controller = (Optionable) m_factory.getController(page);
                break;

            default:
                LOG.error("Controller is not found: " + page);
                return false;
        }

        if (!controller.submit(option))
        {
            LOG.error("Submit by option failed");
            return false;
        }

        return true;
    }

    public boolean write(ServicePages page)
    {
        Inputable controller = null;

        switch (page)
        {
            case JIRA_LOGIN:
            case JIRA_CREATE_DEFAULT:
            case JIRA_CREATE:
            case RAKUTEN_LOGIN:
            case NBA_THREAD_DETAIL:
                controller = (Inputable) m_factory.getController(page);
                break;

            default:
                LOG.error("Controller is not found: " + page);
                return false;
        }

        if (!controller.setParameters())
        {
            LOG.error("Setting parameters is failed");
            return false;
        }

        if (!controller.submit())
        {
            LOG.error("Submitting is failed");
            return false;
        }

        return true;
    }
}
