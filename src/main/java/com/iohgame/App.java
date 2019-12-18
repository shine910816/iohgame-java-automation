package com.iohgame;

import com.iohgame.automation.property.LaunchBrowser;
import com.iohgame.automation.property.LaunchBrowser.Browsers;
import com.iohgame.automation.service.baidu.BaiduTopController;
import com.iohgame.automation.service.baidu.window.BaiduTopWindow;

public class App
{
    public static void main(String[] args)
    {
        LaunchBrowser browser = new LaunchBrowser(Browsers.FIREFOX);
        BaiduTopWindow window = new BaiduTopWindow();
        BaiduTopController ctrl = new BaiduTopController(browser, window);
        ctrl.gotoHomePage();
        ctrl.setParameters();
        ctrl.submit();
    }
}
