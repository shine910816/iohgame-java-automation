package com.iohgame.automation.property.parameters.motion;

import com.iohgame.automation.property.parameters.motion.simple.HomePage;
import com.iohgame.automation.property.parameters.motion.simple.Optionable;

public interface Navigatable extends HomePage, Optionable
{
    public boolean ready();
}
