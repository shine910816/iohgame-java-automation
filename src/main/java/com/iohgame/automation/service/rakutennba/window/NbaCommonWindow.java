package com.iohgame.automation.service.rakutennba.window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.iohgame.automation.property.BaseWindow;
import com.iohgame.automation.property.parameters.ByType;
import com.iohgame.automation.property.parameters.PageElement;

public class NbaCommonWindow extends BaseWindow
{
    public NbaCommonWindow()
    {
        // @formatter:off
        m_elementMap.put(NbaCommonElement.SCORE_SETTING_BOX,                   ".//div[@class='ScoreModal-content']");
        m_elementMap.put(NbaCommonElement.SCORE_ON_CHECKBOX,                   "//div[@class='ScoreModal-radioButton-showScore']//div[@class='ScoreModal-radioButton-circle']");
        m_elementMap.put(NbaCommonElement.SCORE_OFF_CHECKBOX,                  "//div[@class='ScoreModal-radioButton-hiddenScore']//div[@class='ScoreModal-radioButton-circle']");
        m_elementMap.put(NbaCommonElement.SCORE_SETTING_UNDISPLAY_CHECKBOX,    "//div[@class='ScoreModal-checkbox']/div[@class='bCheckBox']");
        m_elementMap.put(NbaCommonElement.SCORE_SETTING_OK_BUTTON,             "//div[@class='ScoreModal-button']/a");
        m_elementMap.put(NbaCommonElement.TUTORIAL_BOX,                        ".//div[@class='TutorialModal-modal']");
        m_elementMap.put(NbaCommonElement.TUTORIAL_CLOSE_BUTTON,               "//div[@class='TutorialModal-button']/a");
        m_elementMap.put(NbaCommonElement.TUTORIAL_UNDISPLAY_CHECKBOX,         "//div[@class='TutorialModal-check']/div[contains(@class,'bCheckBox')]");
        m_elementMap.put(NbaCommonElement.LOGIN_BUTTON,                        ".//div[contains(@class,'theNav-head')]//div[contains(@class,'theNav-head-links')]/a");
        // @formatter:on
    }

    public enum NbaCommonElement implements PageElement
    {
        SCORE_SETTING_BOX(ByXPath.class),

        SCORE_ON_CHECKBOX(ByXPath.class),

        SCORE_OFF_CHECKBOX(ByXPath.class),

        SCORE_SETTING_UNDISPLAY_CHECKBOX(ByXPath.class),

        SCORE_SETTING_OK_BUTTON(ByXPath.class),

        TUTORIAL_BOX(ByXPath.class),

        TUTORIAL_CLOSE_BUTTON(ByXPath.class),

        TUTORIAL_UNDISPLAY_CHECKBOX(ByXPath.class),

        LOGIN_BUTTON(ByXPath.class),

        ;

        private Class<? extends By> m_type;

        private NbaCommonElement(Class<? extends By> type)
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
