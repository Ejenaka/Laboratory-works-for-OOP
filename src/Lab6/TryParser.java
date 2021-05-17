package Lab6;

import javax.swing.*;
import java.awt.*;

public class TryParser {
    public static int tryParseFromTextField(Component component, JTextField textField) {
        int result = 0;
        try {
            result  = Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(component, "Number format error");
        }
        return result;
    }
}
