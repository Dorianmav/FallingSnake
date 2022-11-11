package snake;

import javax.swing.*;

public class Register implements SnakeObserver{

    JComponent component;

    public Register(JComponent component){
        this.component = component;
    }
    @Override
    public void update() {
        component.repaint();
    }
}
