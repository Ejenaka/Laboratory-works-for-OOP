package Lab6;

import Lab5.Model.Medicine;
import Lab5.Model.MedicineStore;
import org.junit.platform.commons.function.Try;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

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

    public FindMedicineDialog(JList<Medicine> medicineList) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            DefaultListModel<Medicine> model = new DefaultListModel<>();
            model.addAll(findMedicinesFromDb());
            medicineList.setModel(model);
        });

        buttonCancel.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

    }

    private List<Medicine> findMedicinesFromDb() {
        List<Medicine> foundMedicines = new ArrayList<>();
        if (producerField.getText().isEmpty() && priceField.getText().isEmpty()) {
            foundMedicines = medicineStore.getMedicineByName(nameField.getText());
        }
        else if (nameField.getText().isEmpty() && producerField.getText().isEmpty()) {
            foundMedicines = medicineStore.getMedicineByPrice(TryParser.tryParseFromTextField(this, priceField));
        }
        else if (nameField.getText().isEmpty() && priceField.getText().isEmpty()) {
            foundMedicines = medicineStore.getMedicineByProducer(producerField.getText());
        }
        else if (!nameField.getText().isEmpty() && !priceField.getText().isEmpty() && !producerField.getText().isEmpty()) {
            try {
                foundMedicines.add(medicineStore.getMedicine(
                        nameField.getText(),
                        TryParser.tryParseFromTextField(this, priceField),
                        producerField.getText())
                );
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(this, "No medicines are found");
                return foundMedicines;
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid operation: at least 1 operation must be written");
        }

        dispose();

        return foundMedicines;
    }

    private void onCancel() {
        dispose();
    }
}
