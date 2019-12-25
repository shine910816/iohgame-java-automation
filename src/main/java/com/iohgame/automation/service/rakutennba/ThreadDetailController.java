package com.iohgame.automation.service.rakutennba;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.service.rakutennba.window.ThreadDetailWindow;
import com.iohgame.automation.service.rakutennba.window.ThreadDetailWindow.ThreadDetailElement;
import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;

public class ThreadDetailController extends BaseController<ThreadDetailWindow> implements Inputable
{
    public ThreadDetailController(LaunchBrowser driver, ThreadDetailWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean setParameters()
    {
        int max = 1000;

        while (getElementList(ThreadDetailElement.COMMENT_LIST).size() < max)
        {
            if (!writeComment(getElementList(ThreadDetailElement.COMMENT_LIST).size() + 1))
            {
                LOG.error("Write comment failed");
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        return true;
    }

    private boolean writeComment(int i)
    {
        sleep(3000);

        String text = "COMMENT_0000_" + Utility.getCurrentDate(ConstDatetime.DATE) + "_" + Utility.getCurrentDate(ConstDatetime.TIME);
        if (!write(ThreadDetailElement.COMMENT_FIELD, text))
        {
            return false;
        }

        sleep(3000);

        if (!click(ThreadDetailElement.COMMENT_POST_BUTTON))
        {
            return false;
        }

        return true;
    }
}
