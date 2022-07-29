/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
//Fungsi import yang digunakan untuk SQL 
import java.sql.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author SaIN
 */
public class form_simulasi_nilai_akhir extends javax.swing.JFrame {

    //    deklarasi variabel 
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    float nilai_absen, nilai_tugas, nilai_uts, nilai_uas, nilai_akhir;
    char index;
    String keterangan;
    
    public form_simulasi_nilai_akhir() {
        initComponents();
        
        input_kode_mk.setEnabled(false);
        
        dbsetting = new koneksi(); 
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        input_mata_kuliah.removeAllItems();
        input_mata_kuliah.addItem("Silahkan Pilih Mata Kuliah");
        input_kode_mk.setText("");
        // size header
        tabel_simulasi_akhir.getTableHeader().setPreferredSize(new Dimension (35,35));
        // font header
        Font fontheader = new Font("Segoi UI", Font.PLAIN, 11);
        // set size header
        tabel_simulasi_akhir.getTableHeader().setFont(fontheader);
        // font cell
        Font fontcell = new Font("Segoi UI", Font.PLAIN, 12);
        // set font cell
        tabel_simulasi_akhir.setFont(fontcell);
        // set font header
        tabel_simulasi_akhir.setModel(tableModel);
        
        // mengatur lebar kolom
        tabel_simulasi_akhir.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabel_simulasi_akhir.getColumnModel().getColumn(1).setPreferredWidth(98);
        tabel_simulasi_akhir.getColumnModel().getColumn(2).setPreferredWidth(97);
        tabel_simulasi_akhir.getColumnModel().getColumn(3).setPreferredWidth(97);
        tabel_simulasi_akhir.getColumnModel().getColumn(4).setPreferredWidth(97);
        tabel_simulasi_akhir.getColumnModel().getColumn(5).setPreferredWidth(78);
        tabel_simulasi_akhir.getColumnModel().getColumn(6).setPreferredWidth(55);
        tabel_simulasi_akhir.getColumnModel().getColumn(7).setPreferredWidth(55);
        tabel_simulasi_akhir.getColumnModel().getColumn(8).setPreferredWidth(55);
        tabel_simulasi_akhir.getColumnModel().getColumn(9).setPreferredWidth(42);
        tabel_simulasi_akhir.getColumnModel().getColumn(10).setPreferredWidth(42);
        tabel_simulasi_akhir.getColumnModel().getColumn(11).setPreferredWidth(58);
        tabel_simulasi_akhir.getColumnModel().getColumn(12).setPreferredWidth(200);
        tabel_simulasi_akhir.getColumnModel().getColumn(13).setPreferredWidth(45);
        tabel_simulasi_akhir.getColumnModel().getColumn(14).setPreferredWidth(45);
        tabel_simulasi_akhir.getColumnModel().getColumn(15).setPreferredWidth(50);
        tabel_simulasi_akhir.getColumnModel().getColumn(16).setPreferredWidth(50);
        tabel_simulasi_akhir.getColumnModel().getColumn(17).setPreferredWidth(96);
        
        // Set Center Alignment of tabel_simulasi_akhir
        TableCellRenderer rendererFromHeader = tabel_simulasi_akhir.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        settableload();
        setcomboBox();
    }
    
    // HEADER TABLE
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel()
    {
        // membuat judul header
        return new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String [] {"Nama M.K",
                            "<html><center>Persentase<br>Absen</center></html>",
                            "<html><center>Persentase<br>Tugas</center></html>",
                            "<html><center>Persentase<br>UTS</center></html>",
                            "<html><center>Persentase<br>UAS</center></html>",
                            "<html><center>Absensi</center></html>",
                            "<html><center>Tgs 1</center></html>",
                            "<html><center>Tgs 2</center></html>",
                            "<html><center>Tgs 3</center></html>",
                            "<html><center>UTS</center></html>",
                            "<html><center>UAS</center></html>",
                            "<html><center>Nilai<br>Absen</center></html>",
                            "<html><center>Nilai Tugas</center></html>",
                            "<html><center>Nilai<br>UTS</center></html>",
                            "<html><center>Nilai<br>UAS</center></html>",
                            "<html><center>Nilai<br>Akhir</center></html>",
                            "Index",
                            "Keterangan"}    
        )
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]
            {
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        };
    }
    
    // KONEKSI JFRAME DENGAN DATABASE MYSQL
    String datatabel[] = new String[18];
    private void settableload()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            // Menampilkan data nilai dari tabel simulasi nilai akhir
            Statement stt=kon.createStatement();
            String SQL = "SELECT * FROM `simulasi_nilai_akhir`";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next())
            {
                datatabel[0] = res.getString(1);
                datatabel[1] = res.getString(2);
                datatabel[2] = res.getString(3);
                datatabel[3] = res.getString(4);
                datatabel[4] = res.getString(5);
                datatabel[5] = res.getString(6);
                datatabel[6] = res.getString(7);
                datatabel[7] = res.getString(8);
                datatabel[8] = res.getString(9);
                datatabel[9] = res.getString(10);
                datatabel[10] = res.getString(11);
                datatabel[11] = res.getString(12);
                datatabel[12] = res.getString(13);
                datatabel[13] = res.getString(14);
                datatabel[14] = res.getString(15);
                datatabel[15] = res.getString(16);
                datatabel[16] = res.getString(17);
                datatabel[17] = res.getString(18);
                tableModel.addRow(datatabel);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    // COMBOBOX 
    String data[] = new String[1];
    private void setcomboBox() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()) {
//                data[0] = res.getString("nama_mk");
                input_mata_kuliah.addItem(res.getString("nama_mk"));
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

    // METHOD HITUNG NILAI ABSEN, NILAI TUGAS, NILAI UTS, NILAI UAS
    public void hitung_nilai()
    {
        // Ubah string to int or float
        float kehadiran = Float.valueOf(input_kehadiran.getText());
        float per_absen = Float.valueOf(input_persentase_absen.getText());
        float per_tug = Float.valueOf(input_persentase_tugas.getText());
        float per_uts = Float.valueOf(input_persentase_uts.getText());
        float per_uas = Float.valueOf(input_persentase_uas.getText());
        float tug1 = Float.valueOf(input_tugas1.getText());
        float tug2 = Float.valueOf(input_tugas2.getText());
        float tug3 = Float.valueOf(input_tugas3.getText());
        float uts = Float.valueOf(input_uts.getText());
        float uas = Float.valueOf(input_uas.getText());
        
        // HITUNG NILAI ABSEN
        nilai_absen = (((kehadiran/14)*100*per_absen)/100);
        // HITUNG NILAI TUGAS
        nilai_tugas = (((tug1 + tug2+ tug3)/3)*(per_tug/100));
        // HITUNG NILAI UTS
        nilai_uts = (uts * (per_uts/100));
        // HITUNG NILAI UAS
        nilai_uas = (uas * (per_uas/100));
        // HITUNG NILAI AKHIR
        nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;
    }
    
    // METHOD MENENTUKAN INDEX
    public void index()
    {
        hitung_nilai();
        if(nilai_akhir>=80 && nilai_akhir<=100){
            index = 'A';
        }
        else if(nilai_akhir>=68 && nilai_akhir<=79){
            index = 'B';
        }
        else if(nilai_akhir>=56 && nilai_akhir<=67){
            index = 'C';
        }
        else if(nilai_akhir>=45 && nilai_akhir<=55){
            index = 'D';
        }
        else if(nilai_akhir>=0 && nilai_akhir<=44){
            index = 'E';
        }
    }
    
    //METHOD MENENTUKAN KETERANGAN
    public void keterangan()
    {
        index();
        if(index=='A' || index=='B' || index=='C'){
            keterangan = "LULUS";
        }
        else{
            keterangan = "Tidak Lulus";
        }
    }

    // METHOD MEMBERSIHKAN DATA MENONAKTIFKAN TEKS DAN MENGAKTIFKAN TEKS
    public void membersihkan_text()
    {
        input_mata_kuliah.setSelectedItem("");
        input_kode_mk.setText("");
        input_persentase_absen.setText("");
        input_persentase_tugas.setText("");
        input_persentase_uts.setText("");
        input_persentase_uas.setText("");
        input_kehadiran.setText("");
        input_tugas1.setText("");
        input_tugas2.setText("");
        input_tugas3.setText("");
        input_uts.setText("");
        input_uas.setText("");
    }
    public void nonaktif_text()
    {
        input_mata_kuliah.setEnabled(false);
        input_kode_mk.setEnabled(false);
        input_persentase_absen.setEnabled(false);
        input_persentase_tugas.setEnabled(false);
        input_persentase_uts.setEnabled(false);
        input_persentase_uas.setEnabled(false);
        input_kehadiran.setEnabled(false);
        input_tugas1.setEnabled(false);
        input_tugas2.setEnabled(false);
        input_tugas3.setEnabled(false);
        input_uts.setEnabled(false);
        input_uas.setEnabled(false);
    }
    public void aktif_teks()
    {
        input_mata_kuliah.setEnabled(true);
        input_kode_mk.setEnabled(true);
        input_persentase_absen.setEnabled(true);
        input_persentase_tugas.setEnabled(true);
        input_persentase_uts.setEnabled(true);
        input_persentase_uas.setEnabled(true);
        input_kehadiran.setEnabled(true);
        input_tugas1.setEnabled(true);
        input_tugas2.setEnabled(true);
        input_tugas3.setEnabled(true);
        input_uts.setEnabled(true);
        input_uas.setEnabled(true);
    }
    
    // METHOD TAMPIL DATA DALAM JTEXTFIELD
    int row = 0;
    public void tampil_field()
    {
        row = tabel_simulasi_akhir.getSelectedRow();
        input_mata_kuliah.setSelectedItem(tableModel.getValueAt(row, 0));
        input_persentase_absen.setText(tableModel.getValueAt(row, 1).toString());
        input_persentase_tugas.setText(tableModel.getValueAt(row, 2).toString());
        input_persentase_uts.setText(tableModel.getValueAt(row, 3).toString());
        input_persentase_uas.setText(tableModel.getValueAt(row, 4).toString());
        input_kehadiran.setText(tableModel.getValueAt(row, 5).toString());
        input_tugas1.setText(tableModel.getValueAt(row, 6).toString());
        input_tugas2.setText(tableModel.getValueAt(row, 7).toString());
        input_tugas3.setText(tableModel.getValueAt(row, 8).toString());
        input_uts.setText(tableModel.getValueAt(row, 9).toString());
        input_uas.setText(tableModel.getValueAt(row, 10).toString());
        
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
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
        tentang_pembuat = new javax.swing.JPanel();
        icon6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        data_mahasiswa = new javax.swing.JPanel();
        icon7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        data_mata_kuliah = new javax.swing.JPanel();
        icon8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        data_nilai = new javax.swing.JPanel();
        icon9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        simulasi_kasus = new javax.swing.JPanel();
        icon10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        simulasi_nilai_akhir = new javax.swing.JPanel();
        icon11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panel_title = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        panel_content = new javax.swing.JPanel();
        input_kode_mk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        input_persentase_absen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_simulasi_akhir = new javax.swing.JTable();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        input_persentase_tugas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        input_persentase_uts = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        input_persentase_uas = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        input_kehadiran = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        input_tugas1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        input_tugas2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        input_tugas3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        input_uts = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        input_uas = new javax.swing.JTextField();
        input_mata_kuliah = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebar.setBackground(new java.awt.Color(65, 83, 128));

        tentang_pembuat.setBackground(new java.awt.Color(65, 83, 128));
        tentang_pembuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tentang_pembuat.setPreferredSize(new java.awt.Dimension(175, 43));
        tentang_pembuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tentang_pembuatMouseClicked(evt);
            }
        });

        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/people_20px.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tentang Pembuat");

        javax.swing.GroupLayout tentang_pembuatLayout = new javax.swing.GroupLayout(tentang_pembuat);
        tentang_pembuat.setLayout(tentang_pembuatLayout);
        tentang_pembuatLayout.setHorizontalGroup(
            tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tentang_pembuatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon6)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        tentang_pembuatLayout.setVerticalGroup(
            tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tentang_pembuatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon6)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16))
        );

        data_mahasiswa.setBackground(new java.awt.Color(65, 83, 128));
        data_mahasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_mahasiswa.setPreferredSize(new java.awt.Dimension(175, 43));
        data_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_mahasiswaMouseClicked(evt);
            }
        });

        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/student_male_20px.png"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Data Mahasiswa");

        javax.swing.GroupLayout data_mahasiswaLayout = new javax.swing.GroupLayout(data_mahasiswa);
        data_mahasiswa.setLayout(data_mahasiswaLayout);
        data_mahasiswaLayout.setHorizontalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mahasiswaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon7)
                .addGap(27, 27, 27)
                .addComponent(jLabel15)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        data_mahasiswaLayout.setVerticalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon7)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        data_mata_kuliah.setBackground(new java.awt.Color(65, 83, 128));
        data_mata_kuliah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_mata_kuliah.setPreferredSize(new java.awt.Dimension(175, 43));
        data_mata_kuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_mata_kuliahMouseClicked(evt);
            }
        });

        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/open_book_20px.png"))); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Data Mata Kuliah");

        javax.swing.GroupLayout data_mata_kuliahLayout = new javax.swing.GroupLayout(data_mata_kuliah);
        data_mata_kuliah.setLayout(data_mata_kuliahLayout);
        data_mata_kuliahLayout.setHorizontalGroup(
            data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mata_kuliahLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon8)
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        data_mata_kuliahLayout.setVerticalGroup(
            data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mata_kuliahLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon8)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("APLIKASI KEMAHASISWAAN");

        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 30));

        data_nilai.setBackground(new java.awt.Color(65, 83, 128));
        data_nilai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_nilai.setPreferredSize(new java.awt.Dimension(175, 43));
        data_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_nilaiMouseClicked(evt);
            }
        });

        icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/clipboard_list_20px.png"))); // NOI18N

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Data Nilai");

        javax.swing.GroupLayout data_nilaiLayout = new javax.swing.GroupLayout(data_nilai);
        data_nilai.setLayout(data_nilaiLayout);
        data_nilaiLayout.setHorizontalGroup(
            data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_nilaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon9)
                .addGap(29, 29, 29)
                .addComponent(jLabel18)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        data_nilaiLayout.setVerticalGroup(
            data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_nilaiLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon9)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        simulasi_kasus.setBackground(new java.awt.Color(65, 83, 128));
        simulasi_kasus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simulasi_kasus.setPreferredSize(new java.awt.Dimension(175, 43));
        simulasi_kasus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simulasi_kasusMouseClicked(evt);
            }
        });

        icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/task_23px.png"))); // NOI18N

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Simulasi Kasus");

        javax.swing.GroupLayout simulasi_kasusLayout = new javax.swing.GroupLayout(simulasi_kasus);
        simulasi_kasus.setLayout(simulasi_kasusLayout);
        simulasi_kasusLayout.setHorizontalGroup(
            simulasi_kasusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulasi_kasusLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon10)
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        simulasi_kasusLayout.setVerticalGroup(
            simulasi_kasusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulasi_kasusLayout.createSequentialGroup()
                .addGroup(simulasi_kasusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(icon10))
                .addGap(77, 77, 77))
        );

        simulasi_nilai_akhir.setBackground(new java.awt.Color(65, 83, 128));
        simulasi_nilai_akhir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simulasi_nilai_akhir.setPreferredSize(new java.awt.Dimension(175, 43));
        simulasi_nilai_akhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simulasi_nilai_akhirMouseClicked(evt);
            }
        });

        icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/todo_list_20px.png"))); // NOI18N

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Simulasi Nilai Akhir");

        javax.swing.GroupLayout simulasi_nilai_akhirLayout = new javax.swing.GroupLayout(simulasi_nilai_akhir);
        simulasi_nilai_akhir.setLayout(simulasi_nilai_akhirLayout);
        simulasi_nilai_akhirLayout.setHorizontalGroup(
            simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulasi_nilai_akhirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon11)
                .addGap(29, 29, 29)
                .addComponent(jLabel19)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        simulasi_nilai_akhirLayout.setVerticalGroup(
            simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulasi_nilai_akhirLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(data_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_mata_kuliah, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simulasi_nilai_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tentang_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(data_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(data_mata_kuliah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(data_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(simulasi_nilai_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tentang_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        panel_title.setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(65, 83, 128));
        label1.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_titleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_titleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panel_content.setBackground(new java.awt.Color(255, 255, 255));
        panel_content.setForeground(new java.awt.Color(255, 255, 255));
        panel_content.setPreferredSize(new java.awt.Dimension(1100, 700));

        input_kode_mk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Kode M.K");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Persentase Absen");

        input_persentase_absen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nama Mata Kuliah");

        tabel_simulasi_akhir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabel_simulasi_akhir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18"
            }
        ));
        tabel_simulasi_akhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_simulasi_akhirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_simulasi_akhir);

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("%");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Persentase Tugas");

        input_persentase_tugas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("%");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Persentase UTS");

        input_persentase_uts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("%");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setText("Persentase UAS");

        input_persentase_uas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel34.setText("%");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setText("Kehadiran");

        input_kehadiran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        input_kehadiran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_kehadiranKeyReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Tugas 1");

        input_tugas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel35.setText("Tugas 2");

        input_tugas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setText("Tugas 3");

        input_tugas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setText("UTS");

        input_uts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel38.setText("UAS");

        input_uas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_mata_kuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        input_mata_kuliah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        input_mata_kuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                input_mata_kuliahMouseClicked(evt);
            }
        });
        input_mata_kuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_mata_kuliahActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Pertemuan");

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addComponent(input_persentase_absen, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(44, 44, 44)
                        .addComponent(input_persentase_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(57, 57, 57)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addComponent(input_persentase_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel34))
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addComponent(input_persentase_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11))))
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(input_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(input_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_contentLayout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addGap(58, 58, 58)
                            .addComponent(input_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_contentLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(input_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(input_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(42, 42, 42)
                                .addComponent(input_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(161, 161, 161))
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_kode_mk)
                    .addComponent(input_mata_kuliah, 0, 279, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(btn_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_mata_kuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(input_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(input_persentase_absen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(input_persentase_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(input_persentase_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(input_persentase_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(input_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(input_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(input_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(input_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(input_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

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
                .addComponent(panel_content, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tentang_pembuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentang_pembuatMouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Tentang Pembuat");
    }//GEN-LAST:event_tentang_pembuatMouseClicked

    private void data_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mahasiswaMouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Data Mahasiswa");
    }//GEN-LAST:event_data_mahasiswaMouseClicked

    private void data_mata_kuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mata_kuliahMouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Data Mata Kuliah");
    }//GEN-LAST:event_data_mata_kuliahMouseClicked

    private void data_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_nilaiMouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Data Nilai");
    }//GEN-LAST:event_data_nilaiMouseClicked

    private void simulasi_kasusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulasi_kasusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simulasi_kasusMouseClicked

    private void simulasi_nilai_akhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulasi_nilai_akhirMouseClicked
        // TODO add your handling code here:
        //        text_ubah.setText("Ini Simulasi Nilai Akhir");
    }//GEN-LAST:event_simulasi_nilai_akhirMouseClicked

    private void input_mata_kuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_mata_kuliahMouseClicked
        // TODO add your handling code here:
//        input_kode_mk.setText("");
//        try {
//            Class.forName(driver);
//            Connection kon = DriverManager.getConnection(
//                database,
//                user,
//                pass);
//            Statement stt = kon.createStatement();
//            String SQL = "SELECT * FROM mata_kuliah WHERE nama_mk='"+input_mata_kuliah.getSelectedItem()+"';";
//            ResultSet res = stt.executeQuery(SQL);
//            
//            while(res.next()) {
//                input_kode_mk.setText(res.getString("nomor_mk"));
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
    }//GEN-LAST:event_input_mata_kuliahMouseClicked

    private void input_mata_kuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_mata_kuliahActionPerformed
        // TODO add your handling code here:
        input_kode_mk.setText("");
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mata_kuliah WHERE nama_mk='"+input_mata_kuliah.getSelectedItem()+"';";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()) {
                input_kode_mk.setText(res.getString("nomor_mk"));
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
    }//GEN-LAST:event_input_mata_kuliahActionPerformed

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // TODO add your handling code here:
        membersihkan_text();
        input_persentase_absen.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambahMouseClicked
    
    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
        String data[] = new String[18];
        hitung_nilai();
        index();
        keterangan();
        
        if ((input_persentase_absen.getText().isEmpty()) || input_persentase_tugas.getText().isEmpty()
                || input_persentase_uts.getText().isEmpty() || input_persentase_uas.getText().isEmpty()
                || input_kehadiran.getText().isEmpty() || input_tugas1.getText().isEmpty()
                || input_tugas2.getText().isEmpty() || input_tugas3.getText().isEmpty()
                || input_uts.getText().isEmpty() || input_uas.getText().isEmpty()
                || input_kode_mk.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            input_persentase_absen.requestFocus();
        }
//        if ((input_persentase_absen.getText().isEmpty()) || (input_persentase_tugas.getText().isEmpty())
//                || (input_persentase_uts.getText().isEmpty()) || (input_persentase_uas.getText().isEmpty())
//                || (input_kehadiran.getText().isEmpty()) || (input_tugas1.getText().isEmpty())
//                || (input_tugas2.getText().isEmpty()) || (input_tugas3.getText().isEmpty())
//                || (input_uts.getText().isEmpty()) || (input_uas.getText().isEmpty())
//                || (input_kode_mk.getText().isEmpty()))
//        {
//            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
//            input_persentase_absen.requestFocus();
//        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO `simulasi_nilai_akhir` (`nama_mk`, "
                        + "`persentase_absen`, "
                        + "`persentase_tugas`, "
                        + "`persentase_uts`, "
                        + "`persentase_uas`, "
                        + "`absensi`, "
                        + "`tgs_1`, "
                        + "`tgs_2`, "
                        + "`tgs_3`, "
                        + "`uts`, "
                        + "`uas`, "
                        + "`nilai_absen`, "
                        + "`nilai_tugas`, "
                        + "`nilai_uts`, "
                        + "`nilai_uas`, "
                        + "`nilai_akhir`, "
                        + "`index`, "
                        + "`keterangan`)"
                        +"VALUES "
                        +"( '"+input_mata_kuliah.getSelectedItem()+"',"
                        +" ' "+input_persentase_absen.getText()+" ',"
                        +" ' "+input_persentase_tugas.getText()+" ',"
                        +" ' "+input_persentase_uts.getText()+" ',"
                        +" ' "+input_persentase_uas.getText()+" ',"
                        +" ' "+input_kehadiran.getText()+" ',"
                        +" ' "+input_tugas1.getText()+" ',"
                        +" ' "+input_tugas2.getText()+" ',"
                        +" ' "+input_tugas3.getText()+" ',"
                        +" ' "+input_uts.getText()+" ',"
                        +" ' "+input_uas.getText()+" ',"
                        +" ' "+nilai_absen+" ',"
                        +" ' "+nilai_tugas+" ',"
                        +" ' "+nilai_uts+" ',"
                        +" ' "+nilai_uas+" ',"
                        +" ' "+nilai_akhir+" ',"
                        +" ' "+index+" ',"
                        +" ' "+keterangan+" ')";
                
                stt.executeUpdate(SQL);
                data[0] = (String) input_mata_kuliah.getSelectedItem();
                data[1] = input_persentase_absen.getText();
                data[2] = input_persentase_tugas.getText();
                data[3] = input_persentase_uts.getText();
                data[4] = input_persentase_uas.getText();
                data[5] = input_kehadiran.getText();
                data[6] = input_tugas1.getText();
                data[7] = input_tugas2.getText();
                data[8] = input_tugas3.getText();
                data[9] = input_uts.getText();
                data[10] = input_uas.getText();
                data[11] = Float.toString(nilai_absen);
                data[12] = Float.toString(nilai_tugas);
                data[13] = Float.toString(nilai_uts);
                data[14] = Float.toString(nilai_uas);
                data[15] = Float.toString(nilai_akhir);
                data[16] = Character.toString(index);
                data[17] = keterangan;
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_text();
                btn_simpan.setEnabled(false);
                nonaktif_text();
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void tabel_simulasi_akhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_simulasi_akhirMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_tabel_simulasi_akhirMouseClicked

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
        // TODO add your handling code here:
        String nama_mk = (String)input_mata_kuliah.getSelectedItem();
        String per_absen = input_persentase_absen.getText();
        String per_tug = input_persentase_tugas.getText();
        String per_uts = input_persentase_uts.getText();
        String per_uas = input_persentase_uas.getText();
        String absen = input_kehadiran.getText();
        String tug1 = input_tugas1.getText();
        String tug2 = input_tugas2.getText();
        String tug3 = input_tugas3.getText();
        String uts = input_uts.getText();
        String uas = input_uas.getText();
        
        hitung_nilai();
        index();
        keterangan();
        
        if ((input_persentase_absen.getText().isEmpty()) || (input_persentase_tugas.getText().isEmpty())
                || (input_persentase_uts.getText().isEmpty()) || (input_persentase_uas.getText().isEmpty())
                || (input_kehadiran.getText().isEmpty()) || (input_tugas1.getText().isEmpty())
                || (input_tugas2.getText().isEmpty()) || (input_tugas3.getText().isEmpty())
                || (input_uts.getText().isEmpty()) || (input_uas.getText().isEmpty())
                || (input_kode_mk.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            input_persentase_absen.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `simulasi_nilai_akhir` "
                        + "SET `nama_mk` = '"+nama_mk+"', "
                        + "`persentase_absen`='"+per_absen+"',"
                        + "`persentase_tugas`='"+per_tug+"',"
                        + "`persentase_uts`='"+per_uts+"',"
                        + "`persentase_uas`='"+per_uas+"',"
                        + "`absensi`='"+absen+"',"
                        + "`tgs_1`='"+tug1+"',"
                        + "`tgs_2`='"+tug2+"',"
                        + "`tgs_3`='"+tug3+"',"
                        + "`uts`='"+uts+"',"
                        + "`uas`='"+uas+"',"
                        + "`nilai_absen`='"+nilai_absen+"',"
                        + "`nilai_tugas`='"+nilai_tugas+"',"
                        + "`nilai_uts`='"+nilai_uts+"',"
                        + "`nilai_uas`='"+nilai_uas+"',"
                        + "`nilai_akhir`='"+nilai_akhir+"',"
                        + "`index`='"+index+"',"
                        + "`keterangan`='"+keterangan+"'"
                        + " WHERE "
                        + "`nama_mk`'"+tableModel.getValueAt(row, 0).toString()+"';";
//                        "UPDATE `simulasi_nilai_akhir` "
//                        + "SET `nama_mk`='"+nama_mk+"',"
//                        + "`persentase_absen`='"+per_absen+"',"
//                        + "`persentase_tugas`='"+per_tug+"',"
//                        + "`persentase_uts`='"+per_uts+"',"
//                        + "`persentase_uas`='"+per_uas+"',"
//                        + "`absensi`='"+absen+"',"
//                        + "`tugas_1`='"+tug1+"',"
//                        + "`tugas_2`='"+tug2+"',"
//                        + "`tugas_3`='"+tug3+"',"
//                        + "`uts`='"+uts+"',"
//                        + "`uas`='"+uas+"' "
//                        + "WHERE "
//                        + "`nama_mk`='"+tableModel.getValueAt(row, 0).toString()+"';";
                stt.execute(SQL);
                data[0] = nama_mk;
                data[1] = per_absen;
                data[2] = per_tug;
                data[3] = per_uts;
                data[4] = per_uas;
                data[5] = absen;
                data[6] = tug1;
                data[7] = tug2;
                data[8] = tug3;
                data[9] = uts;
                data[10] = uas;
                data[11] = Float.toString(nilai_absen);
                data[12] = Float.toString(nilai_tugas);
                data[13] = Float.toString(nilai_uts);
                data[14] = Float.toString(nilai_uas);
                data[15] = Float.toString(nilai_akhir);
                data[16] = Character.toString(index);
                data[17] = keterangan;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                membersihkan_text();
                btn_ubah.setEnabled(false);
                nonaktif_text();
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "Delete From simulasi_nilai_akhir "
                    + "where "
                    + "nama_mk='"+tableModel.getValueAt(row, 0).toString()+"'";
            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_text();
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        // TODO add your handling code here:
        membersihkan_text();
        nonaktif_text();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        // TODO add your handling code here:
        login masuk = new login();
        masuk.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluarMouseClicked

    private void input_kehadiranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_kehadiranKeyReleased
        // TODO add your handling code here:
        int absen = Integer.valueOf(input_kehadiran.getText());
        if(absen>14){
            JOptionPane.showMessageDialog(null, "Maksimal Kehadiran adalah 14 pertemuan");
            input_kehadiran.setText("");
        }
    }//GEN-LAST:event_input_kehadiranKeyReleased

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
            java.util.logging.Logger.getLogger(form_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_simulasi_nilai_akhir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_batal;
    private javax.swing.JPanel btn_hapus;
    private javax.swing.JPanel btn_keluar;
    private javax.swing.JPanel btn_simpan;
    private javax.swing.JPanel btn_tambah;
    private javax.swing.JPanel btn_ubah;
    private javax.swing.JPanel data_mahasiswa;
    private javax.swing.JPanel data_mata_kuliah;
    private javax.swing.JPanel data_nilai;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JTextField input_kehadiran;
    private javax.swing.JTextField input_kode_mk;
    private javax.swing.JComboBox<String> input_mata_kuliah;
    private javax.swing.JTextField input_persentase_absen;
    private javax.swing.JTextField input_persentase_tugas;
    private javax.swing.JTextField input_persentase_uas;
    private javax.swing.JTextField input_persentase_uts;
    private javax.swing.JTextField input_tugas1;
    private javax.swing.JTextField input_tugas2;
    private javax.swing.JTextField input_tugas3;
    private javax.swing.JTextField input_uas;
    private javax.swing.JTextField input_uts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Label label1;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_title;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel simulasi_kasus;
    private javax.swing.JPanel simulasi_nilai_akhir;
    private javax.swing.JTable tabel_simulasi_akhir;
    private javax.swing.JPanel tentang_pembuat;
    // End of variables declaration//GEN-END:variables
}
