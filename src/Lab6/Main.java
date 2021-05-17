package Lab6;

import Lab5.Model.Medicine;
import Lab5.Model.MedicineStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Main extends JFrame{
    private final MedicineStore medicineStore = new MedicineStore();
    private JPanel mainPanel;
    private JList<Medicine> medicinesList;
    private JButton addButton;
    private JButton buyButton;
    private JButton findButton;
    private JButton updateButton;

    public Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        DefaultListModel<Medicine> medicinesListModel = new DefaultListModel<>();
        medicinesListModel.addAll(medicineStore.getMedicineStorage());
        medicinesList.setModel(medicinesListModel);

        buyButton.addActionListener(actionEvent -> {
            Medicine selectedMedicine = medicinesList.getSelectedValue();
            medicineStore.deleteMedicine(selectedMedicine);
            medicinesListModel.removeElement(selectedMedicine);
        });

        findButton.addActionListener(actionEvent -> {
            FindMedicineDialog dialog = new FindMedicineDialog(medicinesList);
            dialog.pack();
            dialog.setVisible(true);
        });

        addButton.addActionListener(actionEvent -> {
            AddMedicineDialog dialog = new AddMedicineDialog(medicinesList);
            dialog.pack();
            dialog.setVisible(true);
        });

        updateButton.addActionListener(actionEvent -> {
            medicinesListModel.clear();
            medicinesListModel.addAll(medicineStore.getMedicineStorage());
            medicinesList.setModel(medicinesListModel);
        });
    }

    public static void main(String[] args) {
        JFrame mainPanel = new Main("Main");
        mainPanel.setBounds(615, 315, 750, 450);
        mainPanel.setVisible(true);
    }

}
