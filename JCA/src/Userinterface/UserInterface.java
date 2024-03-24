package Userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame{
    private JPanel userPanel;
    public UserInterface(){
        userPanel = new UserPanel();
        this.add(userPanel);
        this.setSize(500,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.darkGray);
        this.setForeground(Color.white);
        this.setLayout(new GridLayout(1,1,0,0));
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new UserInterface();
    }
    private class UserPanel extends JPanel{
        UserPanel(){
            this.setLayout(new GridLayout());
        }
    }

}