package Lab6;

import Lab5.Model.Medicine;
import Lab5.Model.MedicineStore;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FindMedicineDialog extends JDialog {
    private final MedicineStore medicineStore = new MedicineStore();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField producerField;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel producerLabel;

    public FindMedicineDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        List<Medicine> foundMedicines = new ArrayList<>();
        if (producerField.toString() == null && priceField.toString() == null) {
            foundMedicines = medicineStore.getMedicineByName(nameField.toString());
        }
        if (nameField.toString() == null && producerField.toString() == null) {

            foundMedicines = medicineStore.getMedicineByPrice(tryParseIntegerFromTextField(priceField));
        }
        if (nameField.toString() == null && priceField.toString() == null) {
            foundMedicines = medicineStore.getMedicineByProducer(producerField.toString());
        }
        if (nameField.toString() != null && priceField.toString() != null && producerField.toString() != null) {

            foundMedicines.add(medicineStore.getMedicine(
                    nameField.toString(),
                    tryParseIntegerFromTextField(priceField),
                    producerField.toString())
            );
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid operation: at least 1 operation must be written");
        }
        dispose();
    }

    private int tryParseIntegerFromTextField(JTextField field) {
        int price = 0;
        try {
            price = Integer.parseInt(field.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price format error");
        }
        return price;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FindMedicineDialog dialog = new FindMedicineDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
