package com.iohgame.automation.property.parameters;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum ServicePages implements OptionElement
{
    JIRA_LOGIN,

    JIRA_DASHBOARD,

    JIRA_CREATE_DEFAULT,

    JIRA_CREATE,

    RAKUTEN_LOGIN,

    RAKUTEN_PAGE_TURN,

    NBA_THREAD_DETAIL;

    @Override
    public String val()
    {
        return name();
    }
}
