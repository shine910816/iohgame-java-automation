package com.iohgame.automation.property;

import com.iohgame.automation.property.parameters.PageWindow;
import com.iohgame.framework.connect.base.ConnectBase;

public abstract class DataController<W extends PageWindow, C extends ConnectBase> extends BaseController<W>
{
    private C m_connect;

    public DataController(LaunchBrowser driver, W window, C connect)
    {
        super(driver, window);
        m_connect = connect;
    }

    protected C connect()
    {
        return m_connect;
    }
}
