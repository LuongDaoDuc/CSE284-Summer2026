package buoi3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PetGUI extends JFrame {
    private JTextField txtId, txtName, txtAge, txtStatus, txtExtra;
    private JComboBox<String> cbType;
    private JCheckBox chkVaccinated; 
    private JLabel lblExtra;
    private JTable table;
    private DefaultTableModel tableModel;

    private final IPetManager petManager = new PetManager();
    private static final String FILE_TXT = "Pet.txt";
    private static final String FILE_DAT = "Pet.dat";

    public PetGUI() {
        setTitle("QUẢN LÝ THÚ CƯNG");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        initUI();
        loadDefaultData();
    }

    private void loadDefaultData() {
        try {
            petManager.loadFromFile(FILE_TXT);
            refreshTable();
        } catch (Exception e) {
            System.err.println("Chưa tìm thấy hoặc không thể đọc file " + FILE_TXT + " lúc khởi động.");
        }
    }

    private void initUI() {

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10)); 
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Thú Cưng"));

        inputPanel.add(new JLabel("Loại Thú Cưng:"));
        cbType = new JComboBox<>(new String[]{"Dog", "Cat"});
        inputPanel.add(cbType);

        inputPanel.add(new JLabel("Mã Thú Cưng (ID):"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Tên Thú Cưng:"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Tuổi:"));
        txtAge = new JTextField();
        inputPanel.add(txtAge);

        inputPanel.add(new JLabel("Trạng Thái:"));
        txtStatus = new JTextField();
        inputPanel.add(txtStatus);

        lblExtra = new JLabel("Giống Chó:");
        txtExtra = new JTextField();
        inputPanel.add(lblExtra);
        inputPanel.add(txtExtra);

        inputPanel.add(new JLabel("Trạng Thái Tiêm Chủng:"));
        chkVaccinated = new JCheckBox("Đã tiêm Vắc-xin");
        inputPanel.add(chkVaccinated);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAdd = new JButton("Thêm");
        JButton btnDelete = new JButton("Xóa");
        JButton btnUpdateStatus = new JButton("Cập Nhật Status");
        JButton btnSearch = new JButton("Tìm Kiếm ID");
        JButton btnClear = new JButton("Làm Mới");
        JButton btnSaveTxt = new JButton("Lưu TXT");
        JButton btnLoadTxt = new JButton("Tải TXT");
        JButton btnSaveDat = new JButton("Lưu DAT");
        JButton btnLoadDat = new JButton("Tải DAT");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdateStatus);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnSaveTxt);
        buttonPanel.add(btnLoadTxt);
        buttonPanel.add(btnSaveDat);
        buttonPanel.add(btnLoadDat);

        String[] columns = {"Loại", "ID", "Tên", "Tuổi", "Trạng Thái", "Giống/Màu", "Tiêm Vacxin", "Cân Nặng (kg)", "Sức Khỏe"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // --- ĐĂNG KÝ SỰ KIỆN ---

        cbType.addActionListener(e -> {
            String selected = (String) cbType.getSelectedItem();
            if ("Dog".equalsIgnoreCase(selected)) {
                lblExtra.setText("Giống Chó:");
            } else {
                lblExtra.setText("Màu Lông:");
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    cbType.setSelectedItem(tableModel.getValueAt(row, 0).toString());
                    txtId.setText(tableModel.getValueAt(row, 1).toString());
                    txtName.setText(tableModel.getValueAt(row, 2).toString());
                    txtAge.setText(tableModel.getValueAt(row, 3).toString());
                    txtStatus.setText(tableModel.getValueAt(row, 4).toString());
                    txtExtra.setText(tableModel.getValueAt(row, 5).toString());
                    String isVaccinatedStr = tableModel.getValueAt(row, 6).toString();
                    chkVaccinated.setSelected("Đã tiêm".equalsIgnoreCase(isVaccinatedStr));
                }
            }
        });

        btnAdd.addActionListener(e -> addPetAction());
        btnDelete.addActionListener(e -> deletePetAction());
        btnUpdateStatus.addActionListener(e -> updateStatusAction());
        btnSearch.addActionListener(e -> searchPetAction());
        btnClear.addActionListener(e -> clearForm());
        btnSaveTxt.addActionListener(e -> {
            petManager.saveToFile(FILE_TXT);
            JOptionPane.showMessageDialog(this, "Lưu danh sách vào file Text thành công!");
        });
        btnLoadTxt.addActionListener(e -> {
            petManager.loadFromFile(FILE_TXT);
            refreshTable();
            JOptionPane.showMessageDialog(this, "Tải dữ liệu từ file Text thành công!");
        });
        btnSaveDat.addActionListener(e -> {
            petManager.saveToFile(FILE_DAT);
            JOptionPane.showMessageDialog(this, "Lưu danh sách vào file Binary DAT thành công!");
        });
        btnLoadDat.addActionListener(e -> {
            petManager.loadFromFile(FILE_DAT);
            refreshTable();
            JOptionPane.showMessageDialog(this, "Tải dữ liệu từ file Binary DAT thành công!");
        });
    }

    // --- CÁC HÀM XỬ LÝ NGHIỆP VỤ ---

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Pet p : petManager.getPetList()) {
            String type = (p instanceof Dog) ? "Dog" : "Cat";
            String extra = (p instanceof Dog) ? ((Dog) p).getBreed() : ((Cat) p).getColour();
            Object[] row = {
                type,
                p.getPetID(),
                p.getName(),
                p.getAge(),
                p.getStatus(),
                extra,
                p.isVaccinated() ? "Đã tiêm" : "Chưa tiêm",
                String.format("%.1f", p.calculateWeight()),
                p.getHealthStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtStatus.setText("");
        txtExtra.setText("");
        chkVaccinated.setSelected(false);
        cbType.setSelectedIndex(0);
        table.clearSelection();
    }

    private void addPetAction() {
        try {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            String ageStr = txtAge.getText().trim();
            String status = txtStatus.getText().trim();
            String extra = txtExtra.getText().trim();
            String type = (String) cbType.getSelectedItem();
            boolean isVaccinated = chkVaccinated.isSelected();

            if (ageStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tuổi không được để trống!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int age = Integer.parseInt(ageStr);

            if (petManager.searchPetById(id) != null) {
                JOptionPane.showMessageDialog(this, "Mã thú cưng đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Pet pet = "Dog".equalsIgnoreCase(type)
                    ? new Dog(id, name, age, status, extra)
                    : new Cat(id, name, age, status, extra);

            pet.setVaccinated(isVaccinated);

            petManager.addPet(pet);
            refreshTable();
            JOptionPane.showMessageDialog(this, "Thêm thú cưng thành công!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là một số nguyên hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidPetDataException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi dữ liệu", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deletePetAction() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hoặc chọn Mã ID cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa thú cưng có mã ID: " + id + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (petManager.removePet(id)) {
                refreshTable();
                clearForm();
                JOptionPane.showMessageDialog(this, "Xóa thú cưng thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thú cưng có mã ID trên!");
            }
        }
    }

    private void updateStatusAction() {
        String id = txtId.getText().trim();
        String newStatus = txtStatus.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hoặc nhập Mã ID cần cập nhật!");
            return;
        }

        Pet p = petManager.searchPetById(id);
        if (p != null) {
            petManager.updatePetStatus(id, newStatus);
            p.setVaccinated(chkVaccinated.isSelected()); 
            refreshTable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thú cưng có mã ID: " + id);
        }
    }

    private void searchPetAction() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã ID để tìm kiếm!");
            return;
        }

        Pet p = petManager.searchPetById(id);
        if (p != null) {
            for (int i = 0; i < table.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 1).toString().equalsIgnoreCase(id)) {
                    table.setRowSelectionInterval(i, i);
                    cbType.setSelectedItem(tableModel.getValueAt(i, 0).toString());
                    txtId.setText(p.getPetID());
                    txtName.setText(p.getName());
                    txtAge.setText(String.valueOf(p.getAge()));
                    txtStatus.setText(p.getStatus());
                    txtExtra.setText((p instanceof Dog) ? ((Dog) p).getBreed() : ((Cat) p).getColour());
                    chkVaccinated.setSelected(p.isVaccinated());
                    break;
                }
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy thú cưng!");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thú cưng có mã ID: " + id);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetGUI().setVisible(true));
    }
}