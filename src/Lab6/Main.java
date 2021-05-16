package Lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel mainPanel;
    private JButton findButton;
    private JButton buyButton;
    private JList medicinesList;
    private JButton addButton;
    private JButton updateButton;
   // private JComponent successText;


    public Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        //this.successText.setVisible(false);
        this.pack();
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame mainPanel = new Main("Main");
        mainPanel.setBounds(615, 315, 750, 450);
        mainPanel.setVisible(true);
    }
}
