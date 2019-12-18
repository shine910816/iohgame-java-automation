package com.iohgame.automation.property.parameters.motion.simple;

import com.iohgame.framework.utility.parameters.property.OptionElement;

public interface Optionable<T extends OptionElement>
{
    public boolean submit(T page);
}
