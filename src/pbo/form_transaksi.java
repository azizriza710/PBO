/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
//Fungsi import yang digunakan untuk SQL 
import java.sql.*;
/**
 *
 * @author SaIN
 */
public class form_transaksi extends javax.swing.JFrame {

    //    deklarasi variabel 
//    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    int total_bayar = 0;
    public form_transaksi() {
        initComponents();
        
//        input_harga.setEnabled(false);
        
//        dbsetting = new koneksi(); 
//        driver = dbsetting.SettingPanel("DBDriver");
//        database = dbsetting.SettingPanel("DBDatabase");
//        user = dbsetting.SettingPanel("DBUsername");
//        pass = dbsetting.SettingPanel("DBPassword");
        
//        input_menu.removeAllItems();
//        input_menu.addItem("Silahkan Pilih Menu");
//        input_harga.setText("");
//        setcomboBoxMenu();
//    
//        table_transaksi.setModel(tableModel);
    }

//    private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
//    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
//        //        membuat judul header 
//        return new javax.swing.table.DefaultTableModel (
//            new Object[][] {},
//            new String [] {
//                "Banyak",
//                "Daftar Menu",
//                "Harga",
//                "Jumlah"
//            }
//        )
////                disable perubahan pada grid 
//        { 
//            boolean[] canEdit = new boolean[] {
//                false,false
//            };
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit[columnIndex];
//            }
//        };
//    }
    
//    private void setcomboBoxMenu() {
//        try {
//            Class.forName(driver);
//            Connection kon = DriverManager.getConnection(
//                database,
//                user,
//                pass);
//            Statement stt = kon.createStatement();
//            String SQL = "SELECT * FROM daftar_menu";
//            ResultSet res = stt.executeQuery(SQL);
//            
//            while(res.next()) {
////                data[0] = res.getString("nama_mk");
//                input_menu.addItem(res.getString("nama_menu"));
//            }
//            res.close();
//            stt.close();
//            kon.close();
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
//                    JOptionPane.INFORMATION_MESSAGE);
//            System.exit(0);
//        }
//    }
    
    public void membersihkan_teks() {
        qty_air.setText("");
        qty_ayam.setText("");
        qty_ceker.setText("");
        qty_kepala.setText("");
        qty_mie_goreng.setText("");
        qty_mie_nelongso.setText("");
        qty_nasi.setText("");
        qty_paket_mie_ayam.setText("");
        qty_paket_nasi_ayam.setText("");
        qty_sayap.setText("");
        qty_teh.setText("");
        qty_telor.setText("");
        qty_usus.setText("");
        j_air.setText("");
        j_ayam.setText("");
        j_ceker.setText("");
        j_kepala.setText("");
        j_mie_goreng.setText("");
        j_mie_nelongso.setText("");
        j_nasi.setText("");
        j_paket_mie_ayam.setText("");
        j_paket_nasi_ayam.setText("");
        j_sayap.setText("");
        j_teh.setText("");
        j_telor.setText("");
        j_usus.setText("");
        total_harga.setText("");
        air.setSelected(false);
        ayam.setSelected(false);
        ceker.setSelected(false);
        kepala.setSelected(false);
        mie_goreng.setSelected(false);
        mie_nelongso.setSelected(false);
        nasi.setSelected(false);
        paket_nasi_ayam.setSelected(false);
        paket_mie_ayam.setSelected(false);
        sayap.setSelected(false);
        teh.setSelected(false);
        telor.setSelected(false);
        usus.setSelected(false);
    }
    public void nonaktif_teks() {
        qty_air.setEnabled(false);
        qty_ayam.setEnabled(false);
        qty_ceker.setEnabled(false);
        qty_kepala.setEnabled(false);
        qty_mie_goreng.setEnabled(false);
        qty_mie_nelongso.setEnabled(false);
        qty_nasi.setEnabled(false);
        qty_paket_mie_ayam.setEnabled(false);
        qty_paket_nasi_ayam.setEnabled(false);
        qty_sayap.setEnabled(false);
        qty_teh.setEnabled(false);
        qty_telor.setEnabled(false);
        qty_usus.setEnabled(false);
        j_air.setEnabled(false);
        j_ayam.setEnabled(false);
        j_ceker.setEnabled(false);
        j_kepala.setEnabled(false);
        j_mie_goreng.setEnabled(false);
        j_mie_nelongso.setEnabled(false);
        j_nasi.setEnabled(false);
        j_paket_mie_ayam.setEnabled(false);
        j_paket_nasi_ayam.setEnabled(false);
        j_sayap.setEnabled(false);
        j_teh.setEnabled(false);
        j_telor.setEnabled(false);
        j_usus.setEnabled(false);
        total_harga.setEnabled(false);
        air.setEnabled(false);
        ayam.setEnabled(false);
        ceker.setEnabled(false);
        kepala.setEnabled(false);
        mie_goreng.setEnabled(false);
        mie_nelongso.setEnabled(false);
        nasi.setEnabled(false);
        paket_nasi_ayam.setEnabled(false);
        paket_mie_ayam.setEnabled(false);
        sayap.setEnabled(false);
        teh.setEnabled(false);
        telor.setEnabled(false);
        usus.setEnabled(false);
    }
    public void aktif_teks() {
        qty_air.setEnabled(true);
        qty_ayam.setEnabled(true);
        qty_ceker.setEnabled(true);
        qty_kepala.setEnabled(true);
        qty_mie_goreng.setEnabled(true);
        qty_mie_nelongso.setEnabled(true);
        qty_nasi.setEnabled(true);
        qty_paket_mie_ayam.setEnabled(true);
        qty_paket_nasi_ayam.setEnabled(true);
        qty_sayap.setEnabled(true);
        qty_teh.setEnabled(true);
        qty_telor.setEnabled(true);
        qty_usus.setEnabled(true);
        j_air.setEnabled(true);
        j_ayam.setEnabled(true);
        j_ceker.setEnabled(true);
        j_kepala.setEnabled(true);
        j_mie_goreng.setEnabled(true);
        j_mie_nelongso.setEnabled(true);
        j_nasi.setEnabled(true);
        j_paket_mie_ayam.setEnabled(true);
        j_paket_nasi_ayam.setEnabled(true);
        j_sayap.setEnabled(true);
        j_teh.setEnabled(true);
        j_telor.setEnabled(true);
        j_usus.setEnabled(true);
        total_harga.setEnabled(true);
        air.setEnabled(true);
        ayam.setEnabled(true);
        ceker.setEnabled(true);
        kepala.setEnabled(true);
        mie_goreng.setEnabled(true);
        mie_nelongso.setEnabled(true);
        nasi.setEnabled(true);
        paket_nasi_ayam.setEnabled(true);
        paket_mie_ayam.setEnabled(true);
        sayap.setEnabled(true);
        teh.setEnabled(true);
        telor.setEnabled(true);
        usus.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_title = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        sidebar = new javax.swing.JPanel();
        tentang_pembuat1 = new javax.swing.JPanel();
        icon6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        data_mahasiswa1 = new javax.swing.JPanel();
        icon7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        data_mata_kuliah1 = new javax.swing.JPanel();
        icon8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        data_nilai1 = new javax.swing.JPanel();
        icon9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Simulasi_nilai_akhir2 = new javax.swing.JPanel();
        icon10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Simulasi_nilai_akhir3 = new javax.swing.JPanel();
        icon11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panel_content = new javax.swing.JPanel();
        ceker = new javax.swing.JCheckBox();
        usus = new javax.swing.JCheckBox();
        sayap = new javax.swing.JCheckBox();
        kepala = new javax.swing.JCheckBox();
        ayam = new javax.swing.JCheckBox();
        mie_nelongso = new javax.swing.JCheckBox();
        paket_nasi_ayam = new javax.swing.JCheckBox();
        paket_mie_ayam = new javax.swing.JCheckBox();
        nasi = new javax.swing.JCheckBox();
        mie_goreng = new javax.swing.JCheckBox();
        telor = new javax.swing.JCheckBox();
        air = new javax.swing.JCheckBox();
        teh = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        h_ceker = new javax.swing.JLabel();
        h_usus = new javax.swing.JLabel();
        h_sayap = new javax.swing.JLabel();
        h_kepala = new javax.swing.JLabel();
        h_ayam = new javax.swing.JLabel();
        h_mie_nelongso = new javax.swing.JLabel();
        h_paket_nasi_ayam = new javax.swing.JLabel();
        h_paket_mie_ayam = new javax.swing.JLabel();
        h_nasi = new javax.swing.JLabel();
        h_mie_goreng = new javax.swing.JLabel();
        h_telor = new javax.swing.JLabel();
        h_air = new javax.swing.JLabel();
        h_teh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qty_ceker = new javax.swing.JTextField();
        qty_usus = new javax.swing.JTextField();
        qty_sayap = new javax.swing.JTextField();
        qty_kepala = new javax.swing.JTextField();
        qty_ayam = new javax.swing.JTextField();
        qty_mie_nelongso = new javax.swing.JTextField();
        qty_paket_nasi_ayam = new javax.swing.JTextField();
        qty_paket_mie_ayam = new javax.swing.JTextField();
        qty_nasi = new javax.swing.JTextField();
        qty_mie_goreng = new javax.swing.JTextField();
        qty_telor = new javax.swing.JTextField();
        qty_air = new javax.swing.JTextField();
        qty_teh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        btn_pesan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pict = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        total_harga = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        j_ceker = new javax.swing.JTextField();
        j_usus = new javax.swing.JTextField();
        j_sayap = new javax.swing.JTextField();
        j_kepala = new javax.swing.JTextField();
        j_ayam = new javax.swing.JTextField();
        j_mie_nelongso = new javax.swing.JTextField();
        j_paket_nasi_ayam = new javax.swing.JTextField();
        j_paket_mie_ayam = new javax.swing.JTextField();
        j_nasi = new javax.swing.JTextField();
        j_mie_goreng = new javax.swing.JTextField();
        j_telor = new javax.swing.JTextField();
        j_air = new javax.swing.JTextField();
        j_teh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_title.setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(65, 83, 128));
        label1.setText("ORDER MENU");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_titleLayout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        sidebar.setBackground(new java.awt.Color(65, 83, 128));

        tentang_pembuat1.setBackground(new java.awt.Color(65, 83, 128));
        tentang_pembuat1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tentang_pembuat1.setPreferredSize(new java.awt.Dimension(175, 43));
        tentang_pembuat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tentang_pembuat1MouseClicked(evt);
            }
        });

        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/people_20px.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tentang Pembuat");

        javax.swing.GroupLayout tentang_pembuat1Layout = new javax.swing.GroupLayout(tentang_pembuat1);
        tentang_pembuat1.setLayout(tentang_pembuat1Layout);
        tentang_pembuat1Layout.setHorizontalGroup(
            tentang_pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tentang_pembuat1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon6)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        tentang_pembuat1Layout.setVerticalGroup(
            tentang_pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tentang_pembuat1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tentang_pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon6)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16))
        );

        data_mahasiswa1.setBackground(new java.awt.Color(65, 83, 128));
        data_mahasiswa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_mahasiswa1.setPreferredSize(new java.awt.Dimension(175, 43));
        data_mahasiswa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_mahasiswa1MouseClicked(evt);
            }
        });

        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/student_male_20px.png"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Data Mahasiswa");

        javax.swing.GroupLayout data_mahasiswa1Layout = new javax.swing.GroupLayout(data_mahasiswa1);
        data_mahasiswa1.setLayout(data_mahasiswa1Layout);
        data_mahasiswa1Layout.setHorizontalGroup(
            data_mahasiswa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mahasiswa1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon7)
                .addGap(27, 27, 27)
                .addComponent(jLabel15)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        data_mahasiswa1Layout.setVerticalGroup(
            data_mahasiswa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswa1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_mahasiswa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon7)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        data_mata_kuliah1.setBackground(new java.awt.Color(65, 83, 128));
        data_mata_kuliah1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_mata_kuliah1.setPreferredSize(new java.awt.Dimension(175, 43));
        data_mata_kuliah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_mata_kuliah1MouseClicked(evt);
            }
        });

        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/open_book_20px.png"))); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Data Mata Kuliah");

        javax.swing.GroupLayout data_mata_kuliah1Layout = new javax.swing.GroupLayout(data_mata_kuliah1);
        data_mata_kuliah1.setLayout(data_mata_kuliah1Layout);
        data_mata_kuliah1Layout.setHorizontalGroup(
            data_mata_kuliah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mata_kuliah1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon8)
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        data_mata_kuliah1Layout.setVerticalGroup(
            data_mata_kuliah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mata_kuliah1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_mata_kuliah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon8)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("APLIKASI KEMAHASISWAAN");

        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 30));

        data_nilai1.setBackground(new java.awt.Color(65, 83, 128));
        data_nilai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_nilai1.setPreferredSize(new java.awt.Dimension(175, 43));
        data_nilai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_nilai1MouseClicked(evt);
            }
        });

        icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/clipboard_list_20px.png"))); // NOI18N

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Data Nilai");

        javax.swing.GroupLayout data_nilai1Layout = new javax.swing.GroupLayout(data_nilai1);
        data_nilai1.setLayout(data_nilai1Layout);
        data_nilai1Layout.setHorizontalGroup(
            data_nilai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_nilai1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon9)
                .addGap(29, 29, 29)
                .addComponent(jLabel18)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        data_nilai1Layout.setVerticalGroup(
            data_nilai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_nilai1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_nilai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon9)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        Simulasi_nilai_akhir2.setBackground(new java.awt.Color(65, 83, 128));
        Simulasi_nilai_akhir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Simulasi_nilai_akhir2.setPreferredSize(new java.awt.Dimension(175, 43));
        Simulasi_nilai_akhir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Simulasi_nilai_akhir2MouseClicked(evt);
            }
        });

        icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/task_23px.png"))); // NOI18N

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Simulasi Kasus");

        javax.swing.GroupLayout Simulasi_nilai_akhir2Layout = new javax.swing.GroupLayout(Simulasi_nilai_akhir2);
        Simulasi_nilai_akhir2.setLayout(Simulasi_nilai_akhir2Layout);
        Simulasi_nilai_akhir2Layout.setHorizontalGroup(
            Simulasi_nilai_akhir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Simulasi_nilai_akhir2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon10)
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        Simulasi_nilai_akhir2Layout.setVerticalGroup(
            Simulasi_nilai_akhir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Simulasi_nilai_akhir2Layout.createSequentialGroup()
                .addGroup(Simulasi_nilai_akhir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(icon10))
                .addGap(77, 77, 77))
        );

        Simulasi_nilai_akhir3.setBackground(new java.awt.Color(65, 83, 128));
        Simulasi_nilai_akhir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Simulasi_nilai_akhir3.setPreferredSize(new java.awt.Dimension(175, 43));
        Simulasi_nilai_akhir3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Simulasi_nilai_akhir3MouseClicked(evt);
            }
        });

        icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/todo_list_20px.png"))); // NOI18N

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Simulasi Nilai Akhir");

        javax.swing.GroupLayout Simulasi_nilai_akhir3Layout = new javax.swing.GroupLayout(Simulasi_nilai_akhir3);
        Simulasi_nilai_akhir3.setLayout(Simulasi_nilai_akhir3Layout);
        Simulasi_nilai_akhir3Layout.setHorizontalGroup(
            Simulasi_nilai_akhir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Simulasi_nilai_akhir3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon11)
                .addGap(29, 29, 29)
                .addComponent(jLabel19)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        Simulasi_nilai_akhir3Layout.setVerticalGroup(
            Simulasi_nilai_akhir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Simulasi_nilai_akhir3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(Simulasi_nilai_akhir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon11)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_mahasiswa1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_mata_kuliah1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_nilai1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Simulasi_nilai_akhir3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Simulasi_nilai_akhir2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tentang_pembuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(data_mahasiswa1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(data_mata_kuliah1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(data_nilai1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Simulasi_nilai_akhir3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(Simulasi_nilai_akhir2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(tentang_pembuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panel_content.setBackground(new java.awt.Color(255, 255, 255));
        panel_content.setForeground(new java.awt.Color(255, 255, 255));
        panel_content.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_content.setPreferredSize(new java.awt.Dimension(1100, 700));
        panel_content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ceker.setText("Ceker ndower");
        ceker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cekerMouseClicked(evt);
            }
        });
        panel_content.add(ceker, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 60, -1, -1));

        usus.setText("Usus ndower");
        usus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ususMouseClicked(evt);
            }
        });
        panel_content.add(usus, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 97, -1, -1));

        sayap.setText("Sayap ndower");
        sayap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sayapMouseClicked(evt);
            }
        });
        panel_content.add(sayap, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 134, -1, -1));

        kepala.setText("Kepala ndower");
        kepala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kepalaMouseClicked(evt);
            }
        });
        panel_content.add(kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 171, -1, -1));

        ayam.setText("Ayam geprek");
        ayam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayamMouseClicked(evt);
            }
        });
        panel_content.add(ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 208, -1, -1));

        mie_nelongso.setText("Mie nelongso");
        mie_nelongso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mie_nelongsoMouseClicked(evt);
            }
        });
        panel_content.add(mie_nelongso, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 245, -1, -1));

        paket_nasi_ayam.setText("Paket nasi ayam geprek");
        paket_nasi_ayam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paket_nasi_ayamMouseClicked(evt);
            }
        });
        panel_content.add(paket_nasi_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 282, -1, -1));

        paket_mie_ayam.setText("Paket mie ayam geprek");
        paket_mie_ayam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paket_mie_ayamMouseClicked(evt);
            }
        });
        panel_content.add(paket_mie_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 319, -1, -1));

        nasi.setText("Nasi");
        nasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nasiMouseClicked(evt);
            }
        });
        panel_content.add(nasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 356, -1, -1));

        mie_goreng.setText("Mie goreng");
        mie_goreng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mie_gorengMouseClicked(evt);
            }
        });
        panel_content.add(mie_goreng, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 393, -1, -1));

        telor.setText("Telor ceplok/dadar");
        telor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telorMouseClicked(evt);
            }
        });
        panel_content.add(telor, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 430, -1, -1));

        air.setText("Air mineral");
        air.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airMouseClicked(evt);
            }
        });
        panel_content.add(air, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 467, -1, -1));

        teh.setText("Teh pucuk");
        teh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tehMouseClicked(evt);
            }
        });
        panel_content.add(teh, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 504, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 83, 128));
        jLabel1.setText("DAFTAR MENU");
        panel_content.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 22, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 83, 128));
        jLabel2.setText("HARGA");
        panel_content.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 22, -1, -1));

        h_ceker.setText("Rp. 12.000,-");
        panel_content.add(h_ceker, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 62, -1, -1));

        h_usus.setText("Rp. 12.000,-");
        panel_content.add(h_usus, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 99, -1, -1));

        h_sayap.setText("Rp. 17.500,-");
        panel_content.add(h_sayap, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 136, -1, -1));

        h_kepala.setText("Rp. 12.000,-");
        panel_content.add(h_kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 173, -1, -1));

        h_ayam.setText("Rp. 17.500,-");
        panel_content.add(h_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 210, -1, -1));

        h_mie_nelongso.setText("Rp. 12.000,-");
        panel_content.add(h_mie_nelongso, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 247, -1, -1));

        h_paket_nasi_ayam.setText("Rp. 21.500,-");
        panel_content.add(h_paket_nasi_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 284, -1, -1));

        h_paket_mie_ayam.setText("Rp. 22.500,-");
        panel_content.add(h_paket_mie_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 321, -1, -1));

        h_nasi.setText("Rp. 5000,-");
        panel_content.add(h_nasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 358, -1, -1));

        h_mie_goreng.setText("Rp. 6000,-");
        panel_content.add(h_mie_goreng, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 395, -1, -1));

        h_telor.setText("Rp. 3.000,-");
        panel_content.add(h_telor, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 432, -1, -1));

        h_air.setText("Rp. 5.000,-");
        panel_content.add(h_air, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 469, -1, -1));

        h_teh.setText("Rp. 6.000,-");
        panel_content.add(h_teh, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 506, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 83, 128));
        jLabel3.setText("BANYAK");
        panel_content.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 22, -1, -1));
        panel_content.add(qty_ceker, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 59, 50, -1));
        panel_content.add(qty_usus, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 96, 50, -1));
        panel_content.add(qty_sayap, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 133, 50, -1));
        panel_content.add(qty_kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 170, 50, -1));
        panel_content.add(qty_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 207, 50, -1));
        panel_content.add(qty_mie_nelongso, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 244, 50, -1));
        panel_content.add(qty_paket_nasi_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 281, 50, -1));
        panel_content.add(qty_paket_mie_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 318, 50, -1));
        panel_content.add(qty_nasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 355, 50, -1));
        panel_content.add(qty_mie_goreng, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 392, 50, -1));
        panel_content.add(qty_telor, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 429, 50, -1));
        panel_content.add(qty_air, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 466, 50, -1));
        panel_content.add(qty_teh, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 503, 50, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 83, 128));
        jLabel4.setText("JUMLAH");
        panel_content.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 22, -1, -1));
        panel_content.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 87, 655, -1));

        jSeparator2.setForeground(new java.awt.Color(65, 83, 128));
        panel_content.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 50, 655, -1));
        panel_content.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 124, 655, -1));
        panel_content.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 161, 655, -1));
        panel_content.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 198, 655, -1));
        panel_content.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 235, 655, -1));
        panel_content.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 272, 655, -1));
        panel_content.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 309, 655, -1));
        panel_content.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 346, 655, -1));
        panel_content.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 383, 655, -1));
        panel_content.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 420, 655, -1));
        panel_content.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 457, 655, -1));
        panel_content.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 494, 655, -1));

        btn_pesan.setBackground(new java.awt.Color(255, 255, 255));
        btn_pesan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_pesan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pesan.setMinimumSize(new java.awt.Dimension(84, 30));
        btn_pesan.setPreferredSize(new java.awt.Dimension(84, 30));
        btn_pesan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Pesan");
        btn_pesan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/add_20px.png"))); // NOI18N
        btn_pesan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_content.add(btn_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 96, 39));

        btn_cancel.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.setMinimumSize(new java.awt.Dimension(84, 30));
        btn_cancel.setPreferredSize(new java.awt.Dimension(84, 30));
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });
        btn_cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Cancel");
        btn_cancel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/delete_20px.png"))); // NOI18N
        btn_cancel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_content.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 96, 39));

        btn_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_keluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_keluar.setMinimumSize(new java.awt.Dimension(84, 30));
        btn_keluar.setPreferredSize(new java.awt.Dimension(84, 30));
        btn_keluar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Keluar");
        btn_keluar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        pict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/cancel_20px.png"))); // NOI18N
        btn_keluar.add(pict, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panel_content.add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 120, 39));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "TOTAL HARGA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(65, 83, 128))); // NOI18N

        jLabel10.setText("Rp. ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panel_content.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));
        panel_content.add(j_ceker, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 59, 80, -1));
        panel_content.add(j_usus, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 96, 80, -1));
        panel_content.add(j_sayap, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 133, 80, -1));
        panel_content.add(j_kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 170, 80, -1));
        panel_content.add(j_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 207, 80, -1));
        panel_content.add(j_mie_nelongso, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 244, 80, -1));
        panel_content.add(j_paket_nasi_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 281, 80, -1));
        panel_content.add(j_paket_mie_ayam, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 318, 80, -1));
        panel_content.add(j_nasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 355, 80, -1));
        panel_content.add(j_mie_goreng, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 392, 80, -1));
        panel_content.add(j_telor, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 429, 80, -1));
        panel_content.add(j_air, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 466, 80, -1));
        panel_content.add(j_teh, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 503, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                    .addComponent(panel_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tentang_pembuat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentang_pembuat1MouseClicked
//        // TODO add your handling code here:
//        homepage utama = new homepage();
//        utama.setVisible(true);
//
//        this.setVisible(false);
    }//GEN-LAST:event_tentang_pembuat1MouseClicked

    private void data_mahasiswa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mahasiswa1MouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Data Mahasiswa");
    }//GEN-LAST:event_data_mahasiswa1MouseClicked

    private void data_mata_kuliah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mata_kuliah1MouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Data Mata Kuliah");
    }//GEN-LAST:event_data_mata_kuliah1MouseClicked

    private void data_nilai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_nilai1MouseClicked
        // TODO add your handling code here:
//        form_data_nilai nilai = new form_data_nilai();
//        nilai.setVisible(true);
//
//        this.setVisible(false);
    }//GEN-LAST:event_data_nilai1MouseClicked

    private void Simulasi_nilai_akhir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Simulasi_nilai_akhir2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Simulasi_nilai_akhir2MouseClicked

    private void Simulasi_nilai_akhir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Simulasi_nilai_akhir3MouseClicked
        // TODO add your handling code here:
        form_simulasi_nilai_akhir nilai_akhir = new form_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_Simulasi_nilai_akhir3MouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        j_air.setEnabled(false);
        j_ayam.setEnabled(false);
        j_ceker.setEnabled(false);
        j_kepala.setEnabled(false);
        j_mie_goreng.setEnabled(false);
        j_mie_nelongso.setEnabled(false);
        j_nasi.setEnabled(false);
        j_paket_mie_ayam.setEnabled(false);
        j_paket_nasi_ayam.setEnabled(false);
        j_sayap.setEnabled(false);
        j_teh.setEnabled(false);
        j_telor.setEnabled(false);
        j_usus.setEnabled(false);
        qty_air.setEnabled(false);
        qty_ayam.setEnabled(false);
        qty_ceker.setEnabled(false);
        qty_kepala.setEnabled(false);
        qty_mie_goreng.setEnabled(false);
        qty_mie_nelongso.setEnabled(false);
        qty_nasi.setEnabled(false);
        qty_paket_mie_ayam.setEnabled(false);
        qty_paket_nasi_ayam.setEnabled(false);
        qty_sayap.setEnabled(false);
        qty_teh.setEnabled(false);
        qty_telor.setEnabled(false);
        qty_usus.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void cekerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekerMouseClicked
        // TODO add your handling code here:
        qty_ceker.setEnabled(true);
        j_ceker.setEnabled(true);
    }//GEN-LAST:event_cekerMouseClicked

    private void ususMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ususMouseClicked
        // TODO add your handling code here:
        qty_usus.setEnabled(true);
        j_usus.setEnabled(true);
    }//GEN-LAST:event_ususMouseClicked

    private void sayapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sayapMouseClicked
        // TODO add your handling code here:
        qty_sayap.setEnabled(true);
        j_sayap.setEnabled(true);
    }//GEN-LAST:event_sayapMouseClicked

    private void kepalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kepalaMouseClicked
        // TODO add your handling code here:
        qty_kepala.setEnabled(true);
        j_kepala.setEnabled(true);
    }//GEN-LAST:event_kepalaMouseClicked

    private void ayamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayamMouseClicked
        // TODO add your handling code here:
        qty_ayam.setEnabled(true);
        j_ayam.setEnabled(true);
    }//GEN-LAST:event_ayamMouseClicked

    private void mie_nelongsoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mie_nelongsoMouseClicked
        // TODO add your handling code here:
        qty_mie_nelongso.setEnabled(true);
        j_mie_nelongso.setEnabled(true);
    }//GEN-LAST:event_mie_nelongsoMouseClicked

    private void paket_nasi_ayamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paket_nasi_ayamMouseClicked
        // TODO add your handling code here:
        qty_paket_nasi_ayam.setEnabled(true);
        j_paket_nasi_ayam.setEnabled(true);
    }//GEN-LAST:event_paket_nasi_ayamMouseClicked

    private void paket_mie_ayamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paket_mie_ayamMouseClicked
        // TODO add your handling code here:
        qty_paket_mie_ayam.setEnabled(true);
        j_paket_mie_ayam.setEnabled(true);
    }//GEN-LAST:event_paket_mie_ayamMouseClicked

    private void nasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nasiMouseClicked
        // TODO add your handling code here:
        qty_nasi.setEnabled(true);
        j_nasi.setEnabled(true);
    }//GEN-LAST:event_nasiMouseClicked

    private void mie_gorengMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mie_gorengMouseClicked
        // TODO add your handling code here:
        qty_mie_goreng.setEnabled(true);
        j_mie_goreng.setEnabled(true);
    }//GEN-LAST:event_mie_gorengMouseClicked

    private void telorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telorMouseClicked
        // TODO add your handling code here:
        qty_telor.setEnabled(true);
        j_telor.setEnabled(true);
    }//GEN-LAST:event_telorMouseClicked

    private void airMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_airMouseClicked
        // TODO add your handling code here:
        qty_air.setEnabled(true);
        j_air.setEnabled(true);
    }//GEN-LAST:event_airMouseClicked

    private void tehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tehMouseClicked
        // TODO add your handling code here:
        qty_teh.setEnabled(true);
        j_teh.setEnabled(true);
    }//GEN-LAST:event_tehMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Simulasi_nilai_akhir2;
    private javax.swing.JPanel Simulasi_nilai_akhir3;
    private javax.swing.JCheckBox air;
    private javax.swing.JCheckBox ayam;
    private javax.swing.JPanel btn_cancel;
    private javax.swing.JPanel btn_keluar;
    private javax.swing.JPanel btn_pesan;
    private javax.swing.JCheckBox ceker;
    private javax.swing.JPanel data_mahasiswa1;
    private javax.swing.JPanel data_mata_kuliah1;
    private javax.swing.JPanel data_nilai1;
    private javax.swing.JLabel h_air;
    private javax.swing.JLabel h_ayam;
    private javax.swing.JLabel h_ceker;
    private javax.swing.JLabel h_kepala;
    private javax.swing.JLabel h_mie_goreng;
    private javax.swing.JLabel h_mie_nelongso;
    private javax.swing.JLabel h_nasi;
    private javax.swing.JLabel h_paket_mie_ayam;
    private javax.swing.JLabel h_paket_nasi_ayam;
    private javax.swing.JLabel h_sayap;
    private javax.swing.JLabel h_teh;
    private javax.swing.JLabel h_telor;
    private javax.swing.JLabel h_usus;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField j_air;
    private javax.swing.JTextField j_ayam;
    private javax.swing.JTextField j_ceker;
    private javax.swing.JTextField j_kepala;
    private javax.swing.JTextField j_mie_goreng;
    private javax.swing.JTextField j_mie_nelongso;
    private javax.swing.JTextField j_nasi;
    private javax.swing.JTextField j_paket_mie_ayam;
    private javax.swing.JTextField j_paket_nasi_ayam;
    private javax.swing.JTextField j_sayap;
    private javax.swing.JTextField j_teh;
    private javax.swing.JTextField j_telor;
    private javax.swing.JTextField j_usus;
    private javax.swing.JCheckBox kepala;
    private java.awt.Label label1;
    private javax.swing.JCheckBox mie_goreng;
    private javax.swing.JCheckBox mie_nelongso;
    private javax.swing.JCheckBox nasi;
    private javax.swing.JCheckBox paket_mie_ayam;
    private javax.swing.JCheckBox paket_nasi_ayam;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_title;
    private javax.swing.JLabel pict;
    private javax.swing.JTextField qty_air;
    private javax.swing.JTextField qty_ayam;
    private javax.swing.JTextField qty_ceker;
    private javax.swing.JTextField qty_kepala;
    private javax.swing.JTextField qty_mie_goreng;
    private javax.swing.JTextField qty_mie_nelongso;
    private javax.swing.JTextField qty_nasi;
    private javax.swing.JTextField qty_paket_mie_ayam;
    private javax.swing.JTextField qty_paket_nasi_ayam;
    private javax.swing.JTextField qty_sayap;
    private javax.swing.JTextField qty_teh;
    private javax.swing.JTextField qty_telor;
    private javax.swing.JTextField qty_usus;
    private javax.swing.JCheckBox sayap;
    private javax.swing.JPanel sidebar;
    private javax.swing.JCheckBox teh;
    private javax.swing.JCheckBox telor;
    private javax.swing.JPanel tentang_pembuat1;
    private javax.swing.JTextField total_harga;
    private javax.swing.JCheckBox usus;
    // End of variables declaration//GEN-END:variables
}
