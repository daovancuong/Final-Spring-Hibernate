package org.cuong.model;

import java.beans.PropertyEditorSupport;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
public class UserNameEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String name) throws IllegalArgumentException {
        if (name.contains("Ms.") || name.contains("Mr.")) {
            setValue(name);
        } else {
            setValue("Ms." + name);
        }
        
    }
    
}
