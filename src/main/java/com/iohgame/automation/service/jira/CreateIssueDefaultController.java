package com.iohgame.automation.service.jira;

import com.iohgame.automation.property.DataController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.service.jira.window.CreateIssueDefaultWindow;
import com.iohgame.automation.service.jira.window.CreateIssueDefaultWindow.CreateIssueDefaultElement;
import com.iohgame.service.jira.JiraTicketAnalysis;

public class CreateIssueDefaultController extends DataController<CreateIssueDefaultWindow, JiraTicketAnalysis> implements Inputable
{
    public CreateIssueDefaultController(LaunchBrowser driver, CreateIssueDefaultWindow window, JiraTicketAnalysis data)
    {
        super(driver, window, data);
    }

    @Override
    public boolean setParameters()
    {
        LOG.info("Write project and issue type");

        if (!writePulldown(CreateIssueDefaultElement.PROJECT_FIELD, connect().getContent().project()))
        {
            LOG.error("Write project failed");
            return false;
        }

        if (!writePulldown(CreateIssueDefaultElement.ISSUE_TYPE_FIELD, connect().getContent().issueType()))
        {
            LOG.error("Write issue type failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        LOG.info("Click next button");

        if (!click(CreateIssueDefaultElement.NEXT_BUTTON))
        {
            LOG.error("Click next button failed");
            return false;
        }

        return true;
    }

}
