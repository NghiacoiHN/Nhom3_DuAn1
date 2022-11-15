package com.raven.component;

import Utilities.DBConnection;
import View.com.raven.main.ViewMainLogin;
import View.com.raven.main.ViewMainManage;
import View.com.raven.main.ViewMainStaff;
import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    Button btnLogin = new Button();
    MyTextField txtSDT = new MyTextField();
    MyPasswordField txtPass = new MyPasswordField();

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        LoginManage();
//        LoginStaff();
        login.setVisible(false);
        register.setVisible(true);

    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ĐĂNG KÝ");
        register.add(cmd, "w 40%, h 40");
    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);

        txtSDT.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtSDT.setHint("Số Điện Thoại");
        login.add(txtSDT, "w 60%");

        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
//        JButton cmdForget = new JButton("Forgot your password ?");
        JButton cmdForget = new JButton("");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);

        btnLogin.setBackground(new Color(7, 164, 121));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("ĐĂNG NHẬP");
        login.add(btnLogin, "w 40%, h 40");

        //ChangeTab
//        cmd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new ViewMainManage().setVisible(true);
//            }
//        });
    }

    private void LoginManage() {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.sql.Connection connection = null;
                try {
                    connection = DBConnection.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                String userName = txtSDT.getText();
                String passWord = txtPass.getText();
                String sql = "Select * from NhanVien WHERE SDT='" + userName + "'and MatKhau ='" + passWord + "'";
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet rs = null;
                try {
                    rs = ps.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (rs.next()) {
                        ViewMainManage home = new ViewMainManage();
                        home.show();
                        ViewMainLogin login = new ViewMainLogin();
                        login.dispose();

                    } else {
                        JOptionPane.showMessageDialog(txtPass, "Sai Tài Khoản Hoặc Mật Khẩu");
                        txtSDT.setText("");
                        txtPass.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
//     private void LoginStaff() {
//        btnLogin.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                java.sql.Connection connection = null;
//                try {
//                    connection = DBConnection.getConnection();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                String userName = txtSDT.getText();
//                String passWord = txtPass.getText();
//                String sql = "Select * from NhanVien WHERE SDT='" + userName + "'and MatKhau ='" + passWord + "''";
//                PreparedStatement ps = null;
//                try {
//                    ps = connection.prepareStatement(sql);
//                } catch (SQLException ex) {
//                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                ResultSet rs = null;
//                try {
//                    rs = ps.executeQuery();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                    if (rs.next()) {
//                        ViewMainStaff home = new ViewMainStaff();
//                        home.show();
//                    } else {
//                        JOptionPane.showMessageDialog(txtPass, "Sai Tài Khoản Hoặc Mật Khẩu");
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });

//    }
    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
