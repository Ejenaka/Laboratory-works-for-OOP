package Lab6;

import Lab5.Model.Medicine;
import Lab5.Model.MedicineStore;

import javax.swing.*;
import java.awt.event.*;

public class AddMedicineDialog extends JDialog {
    private final MedicineStore medicineStore = new MedicineStore();
    private JList<Medicine> medicineList;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField producerField;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel producerLabel;
    private JLabel doctorSignLabel;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;

    public AddMedicineDialog(JList<Medicine> medicineList) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.medicineList = medicineList;

        buttonOK.addActionListener(e -> addMedicineToDB());
        buttonCancel.addActionListener(e -> onCancel());

        yesRadioButton.addActionListener(e -> noRadioButton.setSelected(false));
        noRadioButton.addActionListener(e -> yesRadioButton.setSelected(false));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void addMedicineToDB() {
        if (!nameField.getText().isEmpty() && !priceField.getText().isEmpty() && !producerField.getText().isEmpty()) {
            String name = nameField.getText();
            int price = TryParser.tryParseFromTextField(this, priceField);
            String producer = producerField.getText();
            boolean isRquireDoctor = getDoctorSignFromRadioButton();
            Medicine medicine = new Medicine(name, price, producer, isRquireDoctor);

            medicineStore.addMedicine(medicine);
            DefaultListModel<Medicine> model = (DefaultListModel<Medicine>) medicineList.getModel();
            model.addElement(medicine);

            dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Fill all fields");
        }
    }

    private void onCancel() {
        dispose();
    }

    private boolean getDoctorSignFromRadioButton() {
        return yesRadioButton.isSelected();
    }
}
