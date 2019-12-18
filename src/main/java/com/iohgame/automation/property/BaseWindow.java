package com.iohgame.automation.property;

import java.util.HashMap;
import java.util.Map;

import com.iohgame.automation.property.parameters.PageElement;
import com.iohgame.automation.property.parameters.PageWindow;
import com.iohgame.framework.utility.MainClass;

public abstract class BaseWindow extends MainClass implements PageWindow
{
    protected final Map<PageElement, String> m_elementMap = new HashMap<>();

    @Override
    public String getContext(PageElement key)
    {
        return m_elementMap.get(key);
    }
}
