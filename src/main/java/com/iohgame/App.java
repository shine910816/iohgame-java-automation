package com.iohgame;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.LaunchBrowser.Browsers;
import com.iohgame.automation.property.parameters.ServicePages;
import com.iohgame.automation.service.AutomationCollection;
import com.iohgame.automation.service.rakuten.RakutenTurnPageController.RakutenPage;
import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.Request;

public class App extends MainClass
{
    private AutomationCollection m_collection;

    public App(String[] args)
    {
        LaunchBrowser browser = new LaunchBrowser(Browsers.FIREFOX);
        Request request = new Request(args);
        m_collection = new AutomationCollection(request, browser);
    }

    public void run()
    {
        m_collection.turnPage(ServicePages.RAKUTEN_PAGE_TURN, RakutenPage.LOGIN_PAGE);
        m_collection.write(ServicePages.RAKUTEN_LOGIN);
        m_collection.turnPage(ServicePages.RAKUTEN_PAGE_TURN, RakutenPage.NBA_THREAD_DETAIL);
        m_collection.write(ServicePages.NBA_THREAD_DETAIL);
    }

    public static void main(String[] args)
    {
        new App(args).run();
    }
}
