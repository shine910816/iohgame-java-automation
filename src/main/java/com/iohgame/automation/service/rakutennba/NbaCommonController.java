package com.iohgame.automation.service.rakutennba;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Navigatable;
import com.iohgame.automation.service.rakutennba.window.NbaCommonWindow;
import com.iohgame.automation.service.rakutennba.window.NbaCommonWindow.NbaCommonElement;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public class NbaCommonController extends BaseController<NbaCommonWindow> implements Navigatable
{
    private static final String HOME_PAGE = "http://qa.nba.rakuten.co.jp/";
    private static final boolean SCORE_ON_SETTING = true;

    public NbaCommonController(LaunchBrowser driver, NbaCommonWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean gotoHomePage()
    {
        LOG.info("Go to home page");

        if (!setPage(HOME_PAGE))
        {
            LOG.error("Go to home page failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean ready()
    {
        LOG.info("Page setting ready");

        if (hasElement(NbaCommonElement.SCORE_SETTING_BOX))
        {
            if (SCORE_ON_SETTING)
            {
                if (!click(getElement(NbaCommonElement.SCORE_SETTING_BOX, NbaCommonElement.SCORE_ON_CHECKBOX)))
                {
                    LOG.error("Click score on checkbox failed");
                    return false;
                }
            }
            else
            {
                if (!click(getElement(NbaCommonElement.SCORE_SETTING_BOX, NbaCommonElement.SCORE_OFF_CHECKBOX)))
                {
                    LOG.error("Click score off checkbox failed");
                    return false;
                }
            }

            if (!click(getElement(NbaCommonElement.SCORE_SETTING_BOX, NbaCommonElement.SCORE_SETTING_UNDISPLAY_CHECKBOX)))
            {
                LOG.error("Click do not display score on setting checkbox failed");
                return false;
            }

            if (!click(getElement(NbaCommonElement.SCORE_SETTING_BOX, NbaCommonElement.SCORE_SETTING_OK_BUTTON)))
            {
                LOG.error("Click score setting OK button failed");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean submit(OptionElement page)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
