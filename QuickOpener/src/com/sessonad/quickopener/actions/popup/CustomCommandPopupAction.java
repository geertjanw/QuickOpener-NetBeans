package com.sessonad.quickopener.actions.popup;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

/**
 *
 * @author SessonaD
 */
public class CustomCommandPopupAction extends AbstractAction{
    
    final static DialogCustomCommand dialogue=new DialogCustomCommand(null, true);
    
    public CustomCommandPopupAction() {
    }
    
    public CustomCommandPopupAction(String name) {
        super(name);
    }
    
    public CustomCommandPopupAction(String name, Icon icon) {
        super(name, icon);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {                  
                    //dialogue.setAlwaysOnTop(true);
                    dialogue.setVisible(true);
                    String userCommand = (dialogue.getReturnStatus()==DialogCustomCommand.RET_OK)?dialogue.getCommand():null;
                    if (userCommand != null && !userCommand.isEmpty()) {
                        Runtime.getRuntime().exec(userCommand);
                    }
                } catch (Exception ex) {}
            }
        });
    }
    
}