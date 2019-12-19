package com.iohgame.automation.property.parameters;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum ServicePages implements OptionElement
{
    JIRA_LOGIN,

    JIRA_DASHBOARD,

    JIRA_CREATE;

    @Override
    public String val()
    {
        return name();
    }
}
