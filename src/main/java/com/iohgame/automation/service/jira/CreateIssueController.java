package com.iohgame.automation.service.jira;

import com.iohgame.automation.property.DataController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.service.jira.window.CreateIssueWindow.CreateIssueElement;
import com.iohgame.automation.service.jira.window.CreateIssueWindow;
import com.iohgame.service.jira.JiraTicketAnalysis;
import com.iohgame.service.jira.JiraTicketContent.JiraTicketLabels;

public class CreateIssueController extends DataController<CreateIssueWindow, JiraTicketAnalysis> implements Inputable
{
    public CreateIssueController(LaunchBrowser driver, CreateIssueWindow window, JiraTicketAnalysis data)
    {
        super(driver, window, data);
    }

    @Override
    public boolean setParameters()
    {
        if (!setBasic())
        {
            LOG.error("Set basic failed");
            return false;
        }

        if (!setDevelopment())
        {
            LOG.error("Set development failed");
            return false;
        }

        if (!setAdditional())
        {
            LOG.error("Set additional failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        LOG.info("Click create button");

        // TODO comment out after implement complete
        // if (!click(CreateIssueElement.CREATE_BUTTON))
        // {
        // LOG.error("Click create button failed");
        // return false;
        // }

        return true;
    }

    private boolean setBasic()
    {
        LOG.info("Set additional");

        if (!click(CreateIssueElement.TAB_BASIC))
        {
            LOG.error("Switch tab failed");
            return false;
        }

        if (!write(CreateIssueElement.SUMMARY_FIELD, connect().getContent().summary()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        if (!writePulldown(CreateIssueElement.PRIORITY_FIELD, connect().getContent().priority()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        if (!writeTag(CreateIssueElement.COMPONENTS_FIELD, connect().getContent().components()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        if (!writePulldown(CreateIssueElement.ASSIGNEE_FIELD, connect().getContent().assignee()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        if (!writeTextarea(CreateIssueElement.DESCRIPTION_TEXTAREA, connect().getContent().description()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        for (JiraTicketLabels label : connect().getContent().labels())
        {
            if (!writeTag(CreateIssueElement.LABELS_FIELD, label.val()))
            {
                LOG.error("Write cc failed");
                return false;
            }
        }

        return true;
    }

    private boolean setDevelopment()
    {
        LOG.info("Set development");

        if (!click(CreateIssueElement.TAB_DEVELOPMENT))
        {
            LOG.error("Switch tab failed");
            return false;
        }

        if (!writeTag(CreateIssueElement.FIX_VERSIONS_FIELD, connect().getContent().fixVersions()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        return true;
    }

    private boolean setAdditional()
    {
        LOG.info("Set additional");

        if (!click(CreateIssueElement.TAB_ADDITIONAL_INFO))
        {
            LOG.error("Switch tab failed");
            return false;
        }

        if (!writeTextarea(CreateIssueElement.CC_FIELD, connect().getContent().cc()))
        {
            LOG.error("Write cc failed");
            return false;
        }

        return true;
    }
}
