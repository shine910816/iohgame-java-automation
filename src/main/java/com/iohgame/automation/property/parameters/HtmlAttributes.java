package com.iohgame.automation.property.parameters;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public enum HtmlAttributes implements OptionElement
{
    ACTION,

    METHOD,

    CLASS,

    NAME,

    ID,

    HREF,

    SRC,

    VALUE,

    TYPE,

    COLSPAN,

    ROWSPAN,

    ALT,

    TITLE,

    CHECKED,

    SELECTED,

    PLACEHOLDER;

    @Override
    public String val()
    {
        return name().toLowerCase();
    }
}
