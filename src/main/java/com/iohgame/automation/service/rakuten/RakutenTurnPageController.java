package com.iohgame.automation.service.rakuten;

import com.iohgame.automation.property.BaseController;
import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.parameters.PageWindow;
import com.iohgame.automation.property.parameters.motion.simple.Optionable;
import com.iohgame.framework.utility.parameters.property.OptionElement;

public class RakutenTurnPageController extends BaseController<PageWindow> implements Optionable
{
    public RakutenTurnPageController(LaunchBrowser driver, PageWindow window)
    {
        super(driver, window);
    }

    @Override
    public boolean submit(OptionElement page)
    {
        LOG.info("Turn page for: " + page);

        String url = "";
        switch ((RakutenPage) page)
        {
            case LOGIN_PAGE:
                url = "https://app.rakuten.co.jp/engine/authorize?response_type=code&client_id=nbabrowser_qa&scope=30days%40Access%2Cmemberinfo_read_name&service_id=n001&redirect_uri=https%3A%2F%2Fqa.nba.rakuten.co.jp%2F";
                break;

            case NBA_THREAD_DETAIL:
                url = "https://qa.nba.rakuten.co.jp/community/5235";
                break;

            default:
                LOG.error("Not found this page: " + page);
                return false;
        }

        if (!setPage(url))
        {
            LOG.error("Turn page failed");
            return false;
        }

        return true;
    }

    public enum RakutenPage implements OptionElement
    {
        LOGIN_PAGE,

        NBA_THREAD_DETAIL;

        @Override
        public String val()
        {
            return name();
        }
    }
}
