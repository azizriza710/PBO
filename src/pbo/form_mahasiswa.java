/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
//Fungsi import yang digunakan untuk SQL 
import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author saffana
 */
public class form_mahasiswa extends javax.swing.JFrame {

    //    deklarasi variabel 
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    JDateChooser chooser = new JDateChooser();
    
    /**
     * Creates new form NewJFrame
     */
    public form_mahasiswa() {
        initComponents();
        
        chooser.setDateFormatString("yyyy-mmm-dd");
        
        dbsetting = new koneksi(); 
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        // font header
        Font fontheader = new Font("Segoi UI", Font.BOLD, 14);
        // set size header
        tabel_mahasiswa.getTableHeader().setFont(fontheader);
        
        // Set Center Alignment of tabel_simulasi_akhir
        TableCellRenderer rendererFromHeader = tabel_mahasiswa.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tabel_mahasiswa.setModel(tableModel);
        //        S e t  C e n t e r R o w 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        int i;
        for (i=0; i<=4; i++){
            tabel_mahasiswa.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        tabel_mahasiswa.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        settableload();
    }

    private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        //        membuat judul header 
        return new javax.swing.table.DefaultTableModel (
            new Object[][] {},
            new String [] {
                "NIM",
                "Nama",
                "Tempat Lahir",
                "Tanggal Lahir",
                "Alamat"
            }
        )
//                disable perubahan pada grid 
        { 
            boolean[] canEdit = new boolean[] {
                false,false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }
    
    String[] data = new String[5];
    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mahasiswa";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);                
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    
    
    public void membersihkan_teks() {
        nim.setText("");
        nama.setText("");
        tempat_lahir.setText("");
        tanggal_lahir.setDate(null);
        alamat.setText("");
    }
    public void nonaktif_teks() {
        nim.setEnabled(false);
        nama.setEnabled(false);
        tempat_lahir.setEnabled(false);
        tanggal_lahir.setEnabled(false);
        alamat.setEnabled(false);
    }
    public void aktif_teks() {
        nim.setEnabled(true);
        nama.setEnabled(true);
        tempat_lahir.setEnabled(true);
        tanggal_lahir.setEnabled(true);
        alamat.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field() {
        
        btn_ubah.setEnabled(false);
        row = tabel_mahasiswa.getSelectedRow();
        nim.setText(tableModel.getValueAt(row, 0).toString());
        nama.setText(tableModel.getValueAt(row, 1).toString());
        tempat_lahir.setText(tableModel.getValueAt(row, 2).toString());
        
//        tanggal_lahir.setDateFormatString("yyyy-MM-dd");
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String ttl = df.format(Date.valueOf(tableModel.getValueAt(row, 3).toString()));
        tanggal_lahir.setDate(Date.valueOf(ttl));
        
        alamat.setText(tableModel.getValueAt(row, 4).toString());
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(true);
        btn_keluar.setEnabled(false);
        aktif_teks();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        input_cari = new javax.swing.JTextField();
        nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tempat_lahir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        alamat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_mahasiswa = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        btn_batal = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btn_ubah = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tanggal_lahir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tentang_pembuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tentang_pembuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(65, 83, 128));
        label1.setText("FORM MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jPanel2InputMethodTextChanged(evt);
            }
        });

        input_cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        input_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_cariKeyReleased(evt);
            }
        });

        nim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("NIM");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nama");

        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Tempat Lahir");

        tempat_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Tanggal Lahir");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Masukan Data");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Pencarian Data Mahasiswa");

        jSeparator2.setForeground(new java.awt.Color(65, 83, 128));

        alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        tabel_mahasiswa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabel_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_mahasiswa);

        jSeparator3.setForeground(new java.awt.Color(65, 83, 128));

        btn_batal.setBackground(new java.awt.Color(255, 255, 255));
        btn_batal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });
        btn_batal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Batal");
        btn_batal.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/file_delete_20px.png"))); // NOI18N
        btn_batal.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hapusMouseEntered(evt);
            }
        });
        btn_hapus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Hapus");
        btn_hapus.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/delete_20px.png"))); // NOI18N
        btn_hapus.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        btn_simpan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Simpan");
        btn_simpan.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/add_file_20px.png"))); // NOI18N
        btn_simpan.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_ubah.setBackground(new java.awt.Color(255, 255, 255));
        btn_ubah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubahMouseClicked(evt);
            }
        });
        btn_ubah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Ubah");
        btn_ubah.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/edit_20px.png"))); // NOI18N
        btn_ubah.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_keluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_keluarMouseClicked(evt);
            }
        });
        btn_keluar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Keluar");
        btn_keluar.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/cancel_20px.png"))); // NOI18N
        btn_keluar.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });
        btn_tambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Tambah");
        btn_tambah.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/add_20px.png"))); // NOI18N
        btn_tambah.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tanggal_lahir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggal_lahirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(97, 97, 97)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(tanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(157, 157, 157)))
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 626, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(120, 120, 120)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_batal, btn_hapus, btn_keluar, btn_simpan, btn_tambah, btn_ubah});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tentang_pembuat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentang_pembuat1MouseClicked
        // TODO add your handling code here:
        homepage utama = new homepage();
        utama.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_tentang_pembuat1MouseClicked

    private void data_mahasiswa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mahasiswa1MouseClicked
        // TODO add your handling code here:
        form_mahasiswa mahasiswa = new form_mahasiswa();
        mahasiswa.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_mahasiswa1MouseClicked

    private void data_mata_kuliah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mata_kuliah1MouseClicked
        // TODO add your handling code here:
        form_mata_kuliah matkul = new form_mata_kuliah();
        matkul.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_mata_kuliah1MouseClicked

    private void data_nilai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_nilai1MouseClicked
        // TODO add your handling code here:
        form_data_nilai nilai = new form_data_nilai();
        nilai.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_nilai1MouseClicked

    private void Simulasi_nilai_akhir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Simulasi_nilai_akhir2MouseClicked
        // TODO add your handling code here:
        form_simulasi_nilai_akhir nilai_akhir = new form_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_Simulasi_nilai_akhir2MouseClicked

    private void Simulasi_nilai_akhir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Simulasi_nilai_akhir3MouseClicked
        // TODO add your handling code here:
        form_simulasi_nilai_akhir nilai_akhir = new form_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_Simulasi_nilai_akhir3MouseClicked

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_alamatActionPerformed

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
        nim.requestFocus();
        
        btn_ubah.setBackground(Color.gray);
        btn_hapus.setBackground(Color.gray);
        btn_keluar.setBackground(Color.gray);
        btn_simpan.setBackground(Color.white);
        
        btn_ubah.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
        // TODO add your handling code here:
        String input_nim = nim.getText();
        String input_nama = nama.getText();
        String input_tempat_lahir = tempat_lahir.getText();
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString = df.format(tanggal_lahir.getDate());
        String input_ttl = todayAsString;
        String input_alamat = alamat.getText();
        
        if ((input_nim.isEmpty()) | (input_nama.isEmpty()) | (input_tempat_lahir.isEmpty()) | (input_ttl.isEmpty()) | (input_alamat.isEmpty())) {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            nim.requestFocus();
        } else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
                Statement stt = kon.createStatement();
//                
                String SQL = "UPDATE `mahasiswa` " +
"SET " +
"`nim` = "+input_nim+", " +
"`nama` = '"+input_nama+"', " +
"tempat_lahir='"+input_tempat_lahir+"', " +
"tanggal_lahir='"+input_ttl+"', " +
"alamat='"+input_alamat+"' " +
"WHERE `mahasiswa`.`nim` = "+tableModel.getValueAt(row, 0)+";";
                stt.executeUpdate(SQL);
                data[0] = input_nim;
                data[1] = input_nama;
                data[2] = input_tempat_lahir;
                data[3] = input_ttl;
                data[4] = input_alamat;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_ubah.setEnabled(false);
                btn_ubah.setBackground(Color.gray);
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Diubah", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/change_50px.png"));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
        try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
                Statement stt = kon.createStatement();
                String SQL = "DELETE FROM mahasiswa "
                        + "WHERE "
                        + "nim='"+tableModel.getValueAt(row, 0).toString()+"'";
                stt.executeUpdate(SQL);
                tableModel.removeRow(row);
                stt.close();
                kon.close();
                membersihkan_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Terhapus", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/delete_50px.png"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data Ini Tidak Dapat Dihapus Karena Sedang Digunakan Di Dalam Data Nilai", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
        String data[] = new String[5];
        
        if ((nim.getText().isEmpty() || (nama.getText().isEmpty()) || (tanggal_lahir.getDate() == null) || (tempat_lahir.getText().isEmpty()) || (alamat.getText().isEmpty()))) {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            nim.requestFocus();
        } else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database, 
                        user,
                        pass
                );
                Statement stt = kon.createStatement();
                
                String pattern = "yyyy-MM-dd";
                DateFormat df = new SimpleDateFormat(pattern);
                String ttl = df.format(tanggal_lahir.getDate());
                
                String SQL = "INSERT INTO mahasiswa(nim, nama, tempat_lahir, tanggal_lahir, alamat)"
                        + "VALUES "
                        + "( '"+nim.getText()+"',"
                        + " '"+nama.getText()+"',"
                        + " '"+tempat_lahir.getText()+"',"
                        + " '"+ttl+"',"
                        + " '"+alamat.getText()+"')";
                stt.executeUpdate(SQL);
                data[0] = nim.getText();
                data[1] = nama.getText();
                data[2] = tempat_lahir.getText();
                data[3] = ttl;
                data[4] = alamat.getText();
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_ubah.setBackground(Color.gray);
                btn_keluar.setBackground(Color.white);
                btn_ubah.setEnabled(false);
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/ok_50px.png"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanMouseClicked

    
    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
        nonaktif_teks();
        btn_keluar.setBackground(Color.white);        
    }//GEN-LAST:event_btn_batalMouseClicked

    private void tabel_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mahasiswaMouseClicked
        // TODO add your handling code here:
        btn_simpan.setEnabled(false);
        if(evt.getClickCount()==1){
            btn_ubah.setBackground(Color.white);
            btn_hapus.setBackground(Color.white);
            btn_simpan.setBackground(Color.gray);
            btn_simpan.setEnabled(false);
            tampil_field();
        }
    }//GEN-LAST:event_tabel_mahasiswaMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        // TODO add your handling code here:
        login masuk = new login();
        masuk.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluarMouseClicked

    private void nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimActionPerformed

    private void btn_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseEntered

    private void jPanel2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jPanel2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2InputMethodTextChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(JFrame.MAXIMIZED_BOTH);        
    }//GEN-LAST:event_formWindowOpened

    private void input_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_cariKeyReleased
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database, 
                    user,
                    pass
            );
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mahasiswa WHERE "
                    + "( nim LIKE '%"+input_cari.getText()+"%' OR "
                    + "nama LIKE '%"+input_cari.getText()+"%' OR "
                    + "tempat_lahir LIKE '%"+input_cari.getText()+"%' OR "
                    + "alamat LIKE '%"+input_cari.getText()+"%');";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_input_cariKeyReleased

    private void tanggal_lahirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggal_lahirMouseClicked
        // TODO add your handling code here:
        tanggal_lahir.setDateFormatString("yyyy-MM-dd");
    }//GEN-LAST:event_tanggal_lahirMouseClicked

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
            java.util.logging.Logger.getLogger(form_mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_mahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Simulasi_nilai_akhir2;
    private javax.swing.JPanel Simulasi_nilai_akhir3;
    private javax.swing.JTextField alamat;
    private javax.swing.JPanel btn_batal;
    private javax.swing.JPanel btn_hapus;
    private javax.swing.JPanel btn_keluar;
    private javax.swing.JPanel btn_simpan;
    private javax.swing.JPanel btn_tambah;
    private javax.swing.JPanel btn_ubah;
    private javax.swing.JPanel data_mahasiswa1;
    private javax.swing.JPanel data_mata_kuliah1;
    private javax.swing.JPanel data_nilai1;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JTextField input_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Label label1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTable tabel_mahasiswa;
    private com.toedter.calendar.JDateChooser tanggal_lahir;
    private javax.swing.JTextField tempat_lahir;
    private javax.swing.JPanel tentang_pembuat1;
    // End of variables declaration//GEN-END:variables
}
