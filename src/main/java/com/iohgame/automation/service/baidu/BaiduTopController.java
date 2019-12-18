package com.iohgame.automation.service.baidu;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.motion.Inputable;
import com.iohgame.automation.property.parameters.motion.simple.HomePage;
import com.iohgame.automation.service.baidu.window.BaiduTopWindow;
import com.iohgame.automation.service.baidu.window.BaiduTopWindow.BaiduTopElement;

public class BaiduTopController extends BaseController<BaiduTopWindow> implements HomePage, Inputable
{
    public BaiduTopController(LaunchBrowser driver, BaiduTopWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean gotoHomePage()
    {
        LOG.info("Open url");

        if (!setPage("https://www.baidu.com/"))
        {
            LOG.error("Open url failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean setParameters()
    {
        LOG.info("Write keyword");

        if (!write(BaiduTopElement.SEARCH_KEYWORD, "ssr.163.com"))
        {
            LOG.error("Write keyword failed");
            return false;
        }

        return true;
    }

    @Override
    public boolean submit()
    {
        LOG.info("Click search button");

        if (!click(BaiduTopElement.SEARCH_BUTTON))
        {
            LOG.error("Click search button failed");
            return false;
        }

        return true;
    }
}
