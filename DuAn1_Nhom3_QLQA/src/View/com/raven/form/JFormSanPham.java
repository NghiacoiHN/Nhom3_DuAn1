/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.com.raven.form;

import DomainModels.ChiTietSP;
import Sevices.ChatLieuService;
import Sevices.ChiTietSPService;
import Sevices.MauSacService;
import Sevices.SanPhamService;
import Sevices.SizeService;
import Sevices.impl.ChatLieuServiceImpl;
import Sevices.impl.ChiTietSPServiceImpl;
import Sevices.impl.MauSacServiceImpl;
import Sevices.impl.SanPhamServiceImpl;
import Sevices.impl.SizeServiceImpl;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ViewModels.ChatLieuResponse;
import ViewModels.ChiTietSPResponse;
import ViewModels.MauSacResponse;
import ViewModels.SanPhamResponse;
import ViewModels.SizeResponse;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class JFormSanPham extends javax.swing.JPanel {

    final ChiTietSPService ctspService = new ChiTietSPServiceImpl();
    final ChatLieuService clService = new ChatLieuServiceImpl();
    final MauSacService msService = new MauSacServiceImpl();
    final SizeService sizeService = new SizeServiceImpl();
    final SanPhamService spService = new SanPhamServiceImpl();

    /**
     * Creates new form Form_1
     */
    public JFormSanPham() {
        initComponents();
        loadCTSP();
        loadComboBox();
    }

    public void loadCTSP() {
        List<ChiTietSPResponse> listCTSP = ctspService.getView();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã chi tiết sản phẩm", "Chất liệu", "Màu sắc", "Size", "Sản phẩm", "Mô tả", "Số lượng tồn",
            "Giá nhập", "Giá bán", "Trạng thái"});
        for (ChiTietSPResponse ctsp : listCTSP) {
            model.addRow(new Object[]{ctsp.getMaChiTietSP(), ctsp.getChatLieu(), ctsp.getMauSac(), ctsp.getSize(), ctsp.getSanPham(), ctsp.getMoTa(),
                ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.trangThai()});
        }
        tblChiTietSP.setModel(model);

    }

    public void loadComboBox() {
        cbChatLieu.removeAllItems();
        List<ChatLieuResponse> listCL = clService.getAll();
        for (ChatLieuResponse cl : listCL) {
            cbChatLieu.addItem(cl);
        }

        cbMauSac.removeAllItems();
        List<MauSacResponse> listMS = msService.getAll();
        for (MauSacResponse ms : listMS) {
            cbMauSac.addItem(ms);
        }

        cbSize.removeAllItems();
        List<SizeResponse> listSize = sizeService.getAll();
        for (SizeResponse size : listSize) {
            cbSize.addItem(size);
        }

        cbSanPham.removeAllItems();
        List<SanPhamResponse> listSP = spService.getAll();
        for (SanPhamResponse sp : listSP) {
            cbSanPham.addItem(sp);
        }
    }

    public void loadTextField(int index) {
        txtMaCTSP.setText(tblChiTietSP.getValueAt(index, 0).toString());

        for (int i = 0; i < cbChatLieu.getItemCount(); i++) {
            String cbcl = cbChatLieu.getItemAt(i).getTen();
            String tbcl = tblChiTietSP.getValueAt(index, 1).toString();
            
            if (cbcl.equalsIgnoreCase(tbcl)) {
                cbChatLieu.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbMauSac.getItemCount(); i++) {
            String cbms = cbMauSac.getItemAt(i).getTen();
            String tbms = tblChiTietSP.getValueAt(index, 2).toString();
            
            if (cbms.equalsIgnoreCase(tbms)) {
                cbMauSac.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbSize.getItemCount(); i++) {
            String cbsize = cbSize.getItemAt(i).getSoSize();
            String tbsize = tblChiTietSP.getValueAt(index, 3).toString();
            
            if (cbsize.equalsIgnoreCase(tbsize)) {
                cbSize.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbSanPham.getItemCount(); i++) {
            String cbsp = cbSanPham.getItemAt(i).getTen();
            String tbsp = tblChiTietSP.getValueAt(index, 4).toString();
            
            if (cbsp.equalsIgnoreCase(tbsp)) {
                cbSanPham.setSelectedIndex(i);
            }
        }
        txtMota.setText(tblChiTietSP.getValueAt(index, 5).toString());
        txtSoLuongTon.setText(tblChiTietSP.getValueAt(index, 6).toString());
        txtGiaNhap.setText(tblChiTietSP.getValueAt(index, 7).toString());
        txtGiaBan.setText(tblChiTietSP.getValueAt(index, 8).toString());

        if (tblChiTietSP.getValueAt(index, 9).toString().equalsIgnoreCase("còn bán")) {
            rdConHang.setSelected(true);
        }
        if (tblChiTietSP.getValueAt(index, 9).toString().equalsIgnoreCase("ngừng bán")) {
            rdNgungKD.setSelected(true);
        }

    }

    public ChiTietSP getData() {
        ChiTietSP ctsp = new ChiTietSP();
        ctsp.setMaChiTietSP(txtMaCTSP.getText().trim());

        ChatLieuResponse chatLieu = (ChatLieuResponse) cbChatLieu.getSelectedItem();
        ctsp.setIdChatLieu(chatLieu.getId());

        MauSacResponse mauSac = (MauSacResponse) cbMauSac.getSelectedItem();
        ctsp.setIdMauSac(mauSac.getId());

        SizeResponse size = (SizeResponse) cbSize.getSelectedItem();
        ctsp.setIdSize(size.getId());

        SanPhamResponse sp = (SanPhamResponse) cbSanPham.getSelectedItem();
        ctsp.setIdSP(sp.getId());

        ctsp.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
        ctsp.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(txtGiaNhap.getText())));
        ctsp.setGiaBan(BigDecimal.valueOf(Double.parseDouble(txtGiaBan.getText())));
        ctsp.setMoTa(txtMota.getText());

        if (rdConHang.isSelected()) {
            ctsp.setTrangThai(1);
        }
        if (rdNgungKD.isSelected()) {
            ctsp.setTrangThai(2);
        }

        return ctsp;
    }

    public boolean checkValidate() {
        if (txtMaCTSP.getText().isBlank() || txtSoLuongTon.getText().isBlank() || txtGiaNhap.getText().isBlank()
                || txtGiaBan.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }

        if (txtMaCTSP.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "Mã chi tiết sản phẩm không được quá 20 ký tự");
            return false;
        }

        try {
            int soLuongTon = Integer.parseInt(txtSoLuongTon.getText().trim());
            if (soLuongTon < 0 || soLuongTon > 1000000000) {
                JOptionPane.showMessageDialog(this, "Số lượng tồn không dược < 0 và > 1000000000 ");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số nguyên");
            return false;
        }

        try {
            double giaNhap = Double.parseDouble(txtGiaNhap.getText().trim());
            if (giaNhap < 0 || giaNhap > 1000000000) {
                JOptionPane.showMessageDialog(this, "Giá nhập không dược < 0 và > 1000000000 ");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
            return false;
        }

        try {
            double giaBan = Double.parseDouble(txtGiaBan.getText().trim());
            if (giaBan < 0 || giaBan > 1000000000) {
                JOptionPane.showMessageDialog(this, "Giá bán không dược < 0 và > 1000000000 ");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số");
            return false;
        }

        if (!rdConHang.isSelected() || !rdNgungKD.isSelected()) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 trạng thái");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        trangThaiCTSP = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelBorder6 = new com.raven.swing.PanelBorder();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        panelBorder7 = new com.raven.swing.PanelBorder();
        jLabel9 = new javax.swing.JLabel();
        btnThem2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        btnXoa2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbMauSac = new javax.swing.JComboBox<MauSacResponse>();
        cbSize = new javax.swing.JComboBox<SizeResponse>();
        cbSanPham = new javax.swing.JComboBox<SanPhamResponse>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        rdConHang = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        rdNgungKD = new javax.swing.JRadioButton();
        cbChatLieu = new javax.swing.JComboBox<ChatLieuResponse>();
        jPanel2 = new javax.swing.JPanel();
        panelBorder2 = new com.raven.swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelBorder3 = new com.raven.swing.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        spTable2 = new javax.swing.JScrollPane();
        tblGioHang = new com.raven.swing.Table();

        setPreferredSize(new java.awt.Dimension(1031, 681));

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 127, 127));
        jLabel8.setText("Thông tin sản phẩm");

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietSP);

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(127, 127, 127));
        jLabel9.setText("Quản lý sản phẩm");

        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Add.png"))); // NOI18N
        btnThem2.setText("Thêm");
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Update.png"))); // NOI18N
        btnSua2.setText("Sửa");
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Xoa.png"))); // NOI18N
        btnXoa2.setText("Xóa");
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã chi tiết sản phẩm");

        txtMaCTSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Chất liệu");

        jLabel7.setText("Màu sắc");

        jLabel10.setText("Size");

        jLabel11.setText("Sản phẩm");

        cbMauSac.setModel(new javax.swing.DefaultComboBoxModel<MauSacResponse>());

        cbSize.setModel(new javax.swing.DefaultComboBoxModel<SizeResponse>());

        cbSanPham.setModel(new javax.swing.DefaultComboBoxModel<SanPhamResponse>());

        jLabel12.setText("Số lượng tồn");

        jLabel13.setText("Giá nhập");

        jLabel14.setText("Giá bán");

        jLabel15.setText("Trạng thái");

        jLabel16.setText("Mô tả");

        trangThaiCTSP.add(rdConHang);
        rdConHang.setText("Còn bán");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane1.setViewportView(txtMota);

        trangThaiCTSP.add(rdNgungKD);
        rdNgungKD.setText("Ngừng kinh doanh");

        cbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieuResponse>());

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addGap(28, 28, 28)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(cbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(199, 199, 199)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(44, 44, 44)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addComponent(rdConHang)
                                .addGap(18, 18, 18)
                                .addComponent(rdNgungKD))
                            .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSoLuongTon)
                                .addComponent(txtGiaNhap)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(rdConHang)
                    .addComponent(rdNgungKD))
                .addGap(18, 18, 18)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem2)
                            .addComponent(btnSua2)
                            .addComponent(btnXoa2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel1);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("Thuộc tính sản phẩm");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Update.png"))); // NOI18N
        btnSua.setText("Sửa");

        btnXoa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Xoa.png"))); // NOI18N
        btnXoa4.setText("Xóa");

        jLabel1.setText("Mã");

        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Chất liệu");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Màu sắc");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Size");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Sản phẩm");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Loại sản phẩm");

        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Tên thuộc tính");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1))
                        .addGap(65, 65, 65)))
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa4))
                .addContainerGap())
        );

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Bảng thuộc tính");

        spTable2.setBorder(null);

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "User Type", "Joined", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable2.setViewportView(tblGioHang);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        // TODO add your handling code here:
        loadTextField(tblChiTietSP.getSelectedRow());
    }//GEN-LAST:event_tblChiTietSPMouseClicked

    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
        // TODO add your handling code here:
        if (checkValidate()) {
            JOptionPane.showMessageDialog(this, ctspService.add(getData()));
            loadCTSP();
        }

    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        // TODO add your handling code here:
        if (checkValidate()) {
            JOptionPane.showMessageDialog(this, ctspService.update(getData()));
            loadCTSP();
        }
    }//GEN-LAST:event_btnSua2ActionPerformed

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed
        // TODO add your handling code here:
        if (tblChiTietSP.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để xóa");
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chứ?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, ctspService.delete(txtMaCTSP.getText()));
                loadCTSP();
            }
        }
    }//GEN-LAST:event_btnXoa2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnXoa2;
    private javax.swing.JButton btnXoa4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<ChatLieuResponse> cbChatLieu;
    private javax.swing.JComboBox<MauSacResponse> cbMauSac;
    private javax.swing.JComboBox<SanPhamResponse> cbSanPham;
    private javax.swing.JComboBox<SizeResponse> cbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.raven.swing.PanelBorder panelBorder2;
    private com.raven.swing.PanelBorder panelBorder3;
    private com.raven.swing.PanelBorder panelBorder6;
    private com.raven.swing.PanelBorder panelBorder7;
    private javax.swing.JRadioButton rdConHang;
    private javax.swing.JRadioButton rdNgungKD;
    private javax.swing.JScrollPane spTable2;
    private javax.swing.JTable tblChiTietSP;
    private com.raven.swing.Table tblGioHang;
    private javax.swing.ButtonGroup trangThaiCTSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtSoLuongTon;
    // End of variables declaration//GEN-END:variables
}
