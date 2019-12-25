package com.iohgame.automation.service.rakutennba.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class ThreadDetailWindow extends BaseWindow
{
    public ThreadDetailWindow()
    {
        // @formatter:off
        m_elementMap.put(ThreadDetailElement.COMMENT_FIELD,          ".//textarea[@name='comment']");
        m_elementMap.put(ThreadDetailElement.COMMENT_POST_BUTTON,    ".//button[contains(@class,'bActionButton')]");
        m_elementMap.put(ThreadDetailElement.COMMENT_LIST,           ".//div[@class='CommentCard']");
        m_elementMap.put(ThreadDetailElement.NG_WORD_HINT_BOX,       ".//div[contains(@class,'bSnackbar-content')]");
        // @formatter:on
    }

    public enum ThreadDetailElement implements PageElement
    {
        COMMENT_FIELD(ByXPath.class),

        COMMENT_POST_BUTTON(ByXPath.class),

        COMMENT_LIST(ByXPath.class),

        NG_WORD_HINT_BOX(ByXPath.class);

        private Class<? extends By> m_type;

        private ThreadDetailElement(Class<? extends By> type)
        {
            m_type = type;
        }

        @Override
        public ByType byType()
        {
            return ByType.getType(m_type);
        }
    }
}
