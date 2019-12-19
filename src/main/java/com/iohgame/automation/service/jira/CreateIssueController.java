package com.iohgame.automation.service.jira;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.service.jira.window.CreateIssueWindow;
import com.iohgame.automation.service.jira.window.CreateIssueWindow.CreateIssueElement;

public class CreateIssueController extends BaseController<CreateIssueWindow> implements Inputable
{
    public CreateIssueController(LaunchBrowser driver, CreateIssueWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean setParameters()
    {
        LOG.info("Write project and issue type");

        if (!writePulldown(CreateIssueElement.PROJECT_FIELD, "Rakuten TV NBA One Destination Project (RTNODP)"))
        {
            LOG.error("Write project failed");
            return false;
        }

        if (!writePulldown(CreateIssueElement.ISSUE_TYPE_FIELD, "Bug"))
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

        if (!click(CreateIssueElement.NEXT_BUTTON))
        {
            LOG.error("Click next button failed");
            return false;
        }

        return true;
    }

}
