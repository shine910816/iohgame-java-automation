package com.iohgame.automation.service.rakuten;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.service.rakuten.window.RakutenLoginWindow;
import com.iohgame.automation.service.rakuten.window.RakutenLoginWindow.RakutenLoginElement;

public class RakutenLoginCotroller extends BaseController<RakutenLoginWindow> implements Inputable
{
    public RakutenLoginCotroller(LaunchBrowser driver, RakutenLoginWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean setParameters()
    {
        LOG.info("Write login name and password");

        if (!write(RakutenLoginElement.LOGIN_NAME, "chen.guoxin@trans-cosmos.com.cn"))
        {
            LOG.error("Write login name failed");
            return false;
        }

        if (!write(RakutenLoginElement.LOGIN_PASSWORD, "!QAZxsw2"))
        {
            LOG.error("Write login password failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        LOG.info("Click login button");

        if (!click(RakutenLoginElement.LOGIN_BUTTON))
        {
            LOG.error("Click login button failed");
            return false;
        }

        return true;
    }

}
