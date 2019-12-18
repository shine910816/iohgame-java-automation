package com.iohgame.automation.property.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;

public enum ByType
{
    BY_CLASS_NAME(ByClassName.class),

    BY_ID(ById.class),

    BY_NAME(ByName.class),

    BY_TAG_NAME(ByTagName.class),

    BY_X_PATH(ByXPath.class),

    UNKNOWN(By.class);

    private Class<? extends By> m_by;

    private ByType(Class<? extends By> by)
    {
        m_by = by;
    }

    public Class<? extends By> val()
    {
        return m_by;
    }

    public static ByType getType(Class<? extends By> by)
    {
        for (ByType type : values())
        {
            if (type.val().equals(by))
            {
                return type;
            }
        }
        return UNKNOWN;
    }
}
