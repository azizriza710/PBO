/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.*;
import java.text.DecimalFormat;
//Fungsi import yang digunakan untuk SQL 
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author HP
 */
public class form_data_nilai extends javax.swing.JFrame {

    //    deklarasi variabel 
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    String cari_nim = "", cari_nomor_mk= "";
    DecimalFormat df = new DecimalFormat("#.#");
    public form_data_nilai() {
        initComponents();
        
        input_kode_mk.setEnabled(false);
        input_nim.setEnabled(false);
        input_kehadiran.setEnabled(false);
        input_tugas1.setEnabled(false);
        input_tugas2.setEnabled(false);
        input_tugas3.setEnabled(false);
        input_uts.setEnabled(false);
        input_uas.setEnabled(false);
        input_angkatan.setEnabled(false);
        
        input_cari_data.requestFocus(false);
        
        dbsetting = new koneksi(); 
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        input_nama.removeAllItems();
        input_nama.addItem("Silahkan Pilih Nama");
        input_nim.setText("");
        input_nama_matkul.removeAllItems();
        input_nama_matkul.addItem("Silahkan Pilih Mata Kuliah");
        input_kode_mk.setText("");
        setcomboBoxNama();
        setcomboBoxMatkul();
        
        // size header
        tabel_nilai_mahasiswa.getTableHeader().setPreferredSize(new Dimension (35,35));
        // font header
        Font fontheader = new Font("Segoi UI", Font.BOLD, 13);
        // set size header
        tabel_nilai_mahasiswa.getTableHeader().setFont(fontheader);
        // font cell
        Font fontcell = new Font("Segoi UI", Font.PLAIN, 12);
        // set font cell
        tabel_nilai_mahasiswa.setFont(fontcell);
        
        // Set Center Alignment of tabel_simulasi_akhir
        TableCellRenderer rendererFromHeader = tabel_nilai_mahasiswa.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tabel_nilai_mahasiswa.setModel(tableModel);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(5).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(6).setPreferredWidth(40);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(7).setPreferredWidth(40);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(8).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(9).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(10).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(11).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(12).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(13).setPreferredWidth(50);
        tabel_nilai_mahasiswa.getColumnModel().getColumn(14).setPreferredWidth(100);
        
//        S e t  C e n t e r R o w 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        int i;
        for (i=1; i<=14; i++){
            tabel_nilai_mahasiswa.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        
        
        settableload();
        
        
    }
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
       return new javax.swing.table.DefaultTableModel
               (
                   new Object [][] {},
                   new String [] {"Nama",
                                  "Nama M.K",
                                  "Absensi",
                                  "Tgs 1",
                                  "Tgs 2",
                                  "Tgs 3",
                                  "UTS",
                                  "UAS",
                                  "<html><center>Nilai<br>Absen</center></html>",
                                  "<html><center>Nilai<br>Tugas</center></html>",
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
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        };
    }
    
    String data[] = new String[15];
    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM nilai_mahasiswa";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()) {
                Statement stt_nama = kon.createStatement();
                String SQL_nama = "SELECT * FROM mahasiswa WHERE nim="+res.getInt("nim")+";";
                ResultSet res_nama = stt_nama.executeQuery(SQL_nama);
//                System.out.println(res_nama.next());
                Statement stt_nama_matkul = kon.createStatement();
                String SQL_nama_matkul = "SELECT * FROM mata_kuliah WHERE nomor_mk="+res.getInt("nomor_mk")+";";
                ResultSet res_nama_matkul = stt_nama_matkul.executeQuery(SQL_nama_matkul);
                
//                get data 
                double jumlah_pertemuan = res.getInt("kehadiran");
                double tugas1 = res.getInt("tugas_1");
                double tugas2 = res.getInt("tugas_2");
                double tugas3 = res.getInt("tugas_3");
                double uts = res.getInt("uts");
                double uas = res.getInt("uas");
//                end 
                double nilai_absen = (((jumlah_pertemuan/14)*100*5)/100);
                double nilai_tugas = (((tugas1+tugas2+tugas3)/3)*(0.25));
                double nilai_uts = uts*0.3;
                double nilai_uas = uas*0.4;
                double nilai_akhir = nilai_absen+nilai_tugas+nilai_uts+nilai_uas;
                String index;
                if(nilai_akhir >= 80 & nilai_akhir <= 100){
                    index = "A";
                } else if(nilai_akhir >= 68 & nilai_akhir <= 79){
                    index = "B";
                } else if(nilai_akhir >= 56 & nilai_akhir <= 67){
                    index = "C";
                } else if(nilai_akhir >= 45 & nilai_akhir <= 55){
                    index = "D";
                } else {
                    index = "E";
                }
                String keterangan = null;
                if(index == "A" | index == "B" | index == "C"){
                    keterangan = "Lulus";
                }else if(index == "D" | index == "E"){
                    keterangan = "Tidak Lulus";
                } 
                if(jumlah_pertemuan < 11){
                    keterangan = "Tidak Lulus";
                }
                res_nama.next();
                res_nama_matkul.next();
                
                data[0] = res_nama.getString("nama");
                data[1] = res_nama_matkul.getString("nama_mk");
                data[2] = String.format("%.0f",jumlah_pertemuan);
                data[3] = Double.toString(tugas1);
                data[4] = Double.toString(tugas2);
                data[5] = Double.toString(tugas3);
                data[6] = Double.toString(uts);
                data[7] = Double.toString(uas);
                data[8] = String.format("%.1f",nilai_absen);
                data[9] = String.format("%.1f",nilai_tugas);
                data[10] = String.format("%.1f",nilai_uts);
                data[11] = String.format("%.1f",nilai_uas);
                data[12] = String.format("%.1f",nilai_akhir);
                data[13] = index;
                data[14] = keterangan;
                tableModel.addRow(data);

                res_nama.close();
                stt_nama.close();
                res_nama_matkul.close();
                stt_nama_matkul.close();
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
    
    private void setcomboBoxNama() {
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
//                data[0] = res.getString("nama_mk");
                input_nama.addItem(res.getString("nama"));
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
    
    private void setcomboBoxMatkul() {
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
                input_nama_matkul.addItem(res.getString("nama_mk"));
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
    
    public void membersihkan_teks()
    {
        input_tugas1.setText("");
        input_tugas2.setText("");
        input_tugas3.setText("");
        input_uts.setText("");
        input_uas.setText("");
        input_kehadiran.setText("");
        input_angkatan.setText("");
        input_nim.setText("");
        input_kode_mk.setText("");
    }
    public void nonaktif_teks() {
        input_tugas1.setEnabled(false);
        input_tugas2.setEnabled(false);
        input_tugas3.setEnabled(false);
        input_uts.setEnabled(false);
        input_uas.setEnabled(false);
        input_kehadiran.setEnabled(false);
        input_angkatan.setEnabled(false);
        input_nim.setEnabled(false);
        input_kode_mk.setEnabled(false);
        input_nama.setEnabled(false);
        input_nama_matkul.setEnabled(false);
    }
    public void aktif_teks() {
        input_tugas1.setEnabled(true);
        input_tugas2.setEnabled(true);
        input_tugas3.setEnabled(true);
        input_uts.setEnabled(true);
        input_uas.setEnabled(true);
        input_kehadiran.setEnabled(true);
        input_angkatan.setEnabled(true);
        input_nim.setEnabled(true);
        input_kode_mk.setEnabled(true);
        input_nama.setEnabled(true);
        input_nama_matkul.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = tabel_nilai_mahasiswa.getSelectedRow();
        input_nama.setSelectedItem(tableModel.getValueAt(row, 0).toString());
        input_nama_matkul.setSelectedItem(tableModel.getValueAt(row, 1).toString());
        input_kehadiran.setText(tableModel.getValueAt(row, 2).toString());
        input_tugas1.setText(tableModel.getValueAt(row, 3).toString());
        input_tugas2.setText(tableModel.getValueAt(row, 4).toString());
        input_tugas3.setText(tableModel.getValueAt(row, 5).toString());
        input_uts.setText(tableModel.getValueAt(row, 6).toString());
        input_uas.setText(tableModel.getValueAt(row, 7).toString());
        input_angkatan.setText("2022");
        
        
        
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_keluar.setEnabled(false);
        aktif_teks();
//        input_nama.setText(tableModel.getValueAt(row, 0).toString());
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
        data_mahasiswa = new javax.swing.JPanel();
        icon_mahasiswa = new javax.swing.JLabel();
        btn_mahasiswa = new javax.swing.JLabel();
        data_mata_kuliah = new javax.swing.JPanel();
        icon_matkul = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        data_nilai = new javax.swing.JPanel();
        icon_nilai = new javax.swing.JLabel();
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
        input_cari_data = new javax.swing.JTextField();
        input_nim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        input_kehadiran = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai_mahasiswa = new javax.swing.JTable();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        input_tugas1 = new javax.swing.JTextField();
        input_tugas2 = new javax.swing.JTextField();
        input_tugas3 = new javax.swing.JTextField();
        input_uts = new javax.swing.JTextField();
        input_kode_mk = new javax.swing.JTextField();
        input_nama = new javax.swing.JComboBox<>();
        input_nama_matkul = new javax.swing.JComboBox<>();
        input_uas = new javax.swing.JTextField();
        input_angkatan = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        data_mahasiswa.setBackground(new java.awt.Color(65, 83, 128));
        data_mahasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_mahasiswa.setPreferredSize(new java.awt.Dimension(175, 43));
        data_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_mahasiswaMouseClicked(evt);
            }
        });

        icon_mahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/student_male_20px.png"))); // NOI18N

        btn_mahasiswa.setBackground(new java.awt.Color(255, 255, 255));
        btn_mahasiswa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_mahasiswa.setForeground(new java.awt.Color(255, 255, 255));
        btn_mahasiswa.setText("Data Mahasiswa");

        javax.swing.GroupLayout data_mahasiswaLayout = new javax.swing.GroupLayout(data_mahasiswa);
        data_mahasiswa.setLayout(data_mahasiswaLayout);
        data_mahasiswaLayout.setHorizontalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mahasiswaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon_mahasiswa)
                .addGap(27, 27, 27)
                .addComponent(btn_mahasiswa)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        data_mahasiswaLayout.setVerticalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_mahasiswa)
                    .addComponent(btn_mahasiswa))
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

        icon_matkul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/open_book_20px.png"))); // NOI18N

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
                .addComponent(icon_matkul)
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        data_mata_kuliahLayout.setVerticalGroup(
            data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mata_kuliahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_matkul)
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

        icon_nilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/clipboard_list_20px.png"))); // NOI18N

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
                .addComponent(icon_nilai)
                .addGap(29, 29, 29)
                .addComponent(jLabel18)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        data_nilaiLayout.setVerticalGroup(
            data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_nilaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_nilai)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(tentang_pembuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panel_title.setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(65, 83, 128));
        label1.setText("FORM NILAI MAHASISWA");

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

        input_cari_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        input_cari_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_cari_dataKeyReleased(evt);
            }
        });

        input_nim.setEditable(false);
        input_nim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        input_nim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                input_nimKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Tugas 3");

        input_kehadiran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));
        input_kehadiran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                input_kehadiranKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Masukan Data");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Pencarian Data Nilai Mahasiswa");

        jSeparator2.setForeground(new java.awt.Color(65, 83, 128));

        tabel_nilai_mahasiswa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabel_nilai_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ));
        tabel_nilai_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_nilai_mahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_nilai_mahasiswa);

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("NIM");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Kehadiran");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setText("Tugas 1");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Tugas 2");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nama");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setText("Nama Mata Kuliah");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel34.setText("Kode M.K");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel35.setText("UTS");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setText("UAS");

        input_tugas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_tugas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_tugas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_uts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_kode_mk.setEditable(false);
        input_kode_mk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        input_nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        input_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_namaActionPerformed(evt);
            }
        });

        input_nama_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        input_nama_matkul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        input_nama_matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nama_matkulActionPerformed(evt);
            }
        });

        input_uas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        input_angkatan.setEditable(false);
        input_angkatan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 83, 128)));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setText("Angkatan");

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(20, 20, 20)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_kehadiran, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_nama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addComponent(input_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(110, 110, 110))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel6))
                                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_contentLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(input_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)))
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(24, 24, 24)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_kode_mk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_nama_matkul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(265, 265, 265))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1)
                .addGap(42, 42, 42))
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(btn_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(input_cari_data, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(input_cari_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(input_nama_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(input_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(input_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(input_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(input_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(input_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(input_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(input_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(input_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
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
        // TODO add your handling code here:
        homepage utama = new homepage();
        utama.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_tentang_pembuat1MouseClicked

    private void data_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mahasiswaMouseClicked
        // TODO add your handling code here:
        form_mahasiswa mahasiswa = new form_mahasiswa();
        mahasiswa.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_mahasiswaMouseClicked

    private void data_mata_kuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mata_kuliahMouseClicked
        // TODO add your handling code here:
        form_mata_kuliah matkul = new form_mata_kuliah();
        matkul.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_mata_kuliahMouseClicked

    private void data_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_nilaiMouseClicked
        // TODO add your handling code here:
        form_data_nilai nilai = new form_data_nilai();
        nilai.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_nilaiMouseClicked

    private void simulasi_kasusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulasi_kasusMouseClicked
        // TODO add your handling code here:
        form_transaksi transaksi = new form_transaksi();
        transaksi.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_simulasi_kasusMouseClicked

    private void simulasi_nilai_akhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulasi_nilai_akhirMouseClicked
        // TODO add your handling code here:
        form_simulasi_nilai_akhir nilai_akhir = new form_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_simulasi_nilai_akhirMouseClicked

    private void tabel_nilai_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_nilai_mahasiswaMouseClicked
        // TODO add your handling code here:
        System.out.println("masuk");
        btn_simpan.setEnabled(false);
        if(evt.getClickCount()==1){
            btn_ubah.setBackground(Color.white);
            btn_hapus.setBackground(Color.white);
            btn_simpan.setBackground(Color.gray);
            btn_simpan.setEnabled(false);
            tampil_field();
        }

    }//GEN-LAST:event_tabel_nilai_mahasiswaMouseClicked

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
        nonaktif_teks();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
        try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
                
//                C A R I  N I M 
                Statement stt_nama = kon.createStatement();
                String SQL_nama = "SELECT * FROM mahasiswa "
                        + "WHERE nama"
                        + "='"+tableModel.getValueAt(row, 0).toString()+"'";
                ResultSet res_nama = stt_nama.executeQuery(SQL_nama);
                res_nama.next();
                Integer nim = res_nama.getInt("nim");
//                E N D 

//                   C A R I  N O M O R M K 
                Statement stt_matkul = kon.createStatement();
                String SQL_matkul = "SELECT * FROM mata_kuliah "
                        + "WHERE nama_mk"
                        + "='"+tableModel.getValueAt(row, 1).toString()+"'";
                ResultSet res_matkul = stt_matkul.executeQuery(SQL_matkul);
                res_matkul.next();
                Integer nomor_mk = res_matkul.getInt("nomor_mk");
//                E N D 
                
                Statement stt = kon.createStatement();
                String SQL = "DELETE FROM `nilai_mahasiswa` WHERE nim="+nim+" AND nomor_mk="+nomor_mk+";";
                stt.executeUpdate(SQL);
                tableModel.removeRow(row);
//                res.close();
                stt.close();
                res_nama.close();
                stt_nama.close();
                kon.close();
                membersihkan_teks();
                input_nama.setSelectedIndex(0);
                input_nama_matkul.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Data Telah Terhapus", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/delete_50px.png"));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
        String data[] = new String[15];
        
        if ((input_nim.getText().isEmpty()) || (input_kehadiran.getText().isEmpty())
                || (input_kehadiran.getText().isEmpty()) || (input_tugas1.getText().isEmpty())
                || (input_tugas2.getText().isEmpty()) || (input_tugas3.getText().isEmpty())
                || (input_uts.getText().isEmpty()) || (input_uas.getText().isEmpty())
                || (input_kode_mk.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            input_nim.requestFocus();
        } else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database, 
                        user,
                        pass
                );
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO nilai_mahasiswa(nim, nomor_mk, kehadiran, tugas_1, tugas_2, tugas_3, uts, uas, angkatan)"
                        + "VALUES "
                        + "( '"+input_nim.getText()+"',"
                        + " '"+input_kode_mk.getText()+"',"
                        + " '"+input_kehadiran.getText()+"',"
                        + " '"+input_tugas1.getText()+"',"
                        + " '"+input_tugas2.getText()+"',"
                        + " '"+input_tugas3.getText()+"',"
                        + " '"+input_uts.getText()+"',"
                        + " '"+input_uas.getText()+"',"
                        + " '"+input_angkatan.getText()+"')";
                stt.executeUpdate(SQL);
                String nama = String.valueOf(input_nama.getSelectedItem());
                String matkul = String.valueOf(input_nama_matkul.getSelectedItem());
                double tgs1 = Integer.parseInt(input_tugas1.getText());
                Integer tgs2 = Integer.parseInt(input_tugas2.getText());
                Integer tgs3 = Integer.parseInt(input_tugas3.getText());                
                Integer jumlah_pertemuan = Integer.parseInt(input_kehadiran.getText());
                Integer uts = Integer.parseInt(input_uts.getText());
                Integer uas = Integer.parseInt(input_uas.getText());
                
                double nilai_absen = (((jumlah_pertemuan/14)*100*5)/100);
                double nilai_tugas = (((tgs1+tgs2+tgs3)/3)*(0.25));
                double nilai_uts = uts*0.3;
                double nilai_uas = uas*0.4;
                double nilai_akhir = nilai_absen+nilai_tugas+nilai_uts+nilai_uas;
                
                String index;
                if(nilai_akhir >= 80 & nilai_akhir <= 100){
                    index = "A";
                } else if(nilai_akhir >= 68 & nilai_akhir <= 79){
                    index = "B";
                } else if(nilai_akhir >= 56 & nilai_akhir <= 67){
                    index = "C";
                } else if(nilai_akhir >= 45 & nilai_akhir <= 55){
                    index = "D";
                } else {
                    index = "E";
                }
                String keterangan = null;
                if(index == "A" | index == "B" | index == "C"){
                    keterangan = "Lulus";
                }else if(index == "D" | index == "E"){
                    keterangan = "Tidak Lulus";
                } 
                if(jumlah_pertemuan < 11){
                    keterangan = "Tidak Lulus";
                }
                double tugas1 = Double.valueOf(input_tugas1.getText());
                double tugas2 = Double.valueOf(input_tugas1.getText());
                double tugas3 = Double.valueOf(input_tugas1.getText());
                double getuts = Double.valueOf(input_uts.getText());
                double getuas = Double.valueOf(input_tugas1.getText());
                data[0] = nama;
                data[1] = matkul;
                data[2] = input_kehadiran.getText();
                data[3] = String.valueOf(tugas1);
                data[4] = String.valueOf(tugas2);
                data[5] = String.valueOf(tugas3);
                data[6] = String.valueOf(getuts);
                data[7] = String.valueOf(getuas);
                data[8] = String.format("%.1f",nilai_absen);
                data[9] = String.format("%.1f",nilai_tugas);
                data[10] = String.format("%.1f",nilai_uts);
                data[11] = String.format("%.1f",nilai_uas);
                data[12] = String.format("%.1f",nilai_akhir);
                data[13] = index;
                data[14] = keterangan;
                
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_keluar.setBackground(Color.white);
                btn_ubah.setEnabled(false);
                input_nama.setSelectedIndex(0);
                input_nama_matkul.setSelectedIndex(0);
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/ok_50px.png"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        

    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
        // TODO add your handling code here:
        String nama = (String)input_nama.getSelectedItem();
        String nama_matkul = (String)input_nama_matkul.getSelectedItem();
        String kode_mk = input_kode_mk.getText();
        String nim = input_nim.getText();
        String kehadiran = input_kehadiran.getText();
        String tug1 = input_tugas1.getText();
        String tug2 = input_tugas2.getText();
        String tug3 = input_tugas3.getText();
        String uts = input_uts.getText();
        String uas = input_uas.getText();
        String angkatan = input_angkatan.getText();
        
        if ((input_nim.getText().isEmpty()) || (input_kehadiran.getText().isEmpty())
                || (input_kehadiran.getText().isEmpty()) || (input_tugas1.getText().isEmpty())
                || (input_tugas2.getText().isEmpty()) || (input_tugas3.getText().isEmpty())
                || (input_uts.getText().isEmpty()) || (input_uas.getText().isEmpty())
                || (input_kode_mk.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            input_nim.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `nilai_mahasiswa` "
                        + "SET `nim`="+nim+","
                        + "`nomor_mk`='"+kode_mk+"',"
                        + "`kehadiran`='"+kehadiran+"',"
                        + "`tugas_1`='"+tug1+"',"
                        + "`tugas_2`='"+tug2+"',"
                        + "`tugas_3`='"+tug3+"',"
                        + "`uts`='"+uts+"',"
                        + "`uas`='"+uas+"', "
                        + "`angkatan`="+Integer.valueOf(angkatan)+" "
                        + "WHERE "
                        + "`nim`="+nim+" AND nomor_mk="+kode_mk+";";
                stt.execute(SQL);
                data[0] = nim;
                data[1] = kode_mk;
                data[2] = kehadiran;
                data[3] = tug1;
                data[4] = tug2;
                data[5] = tug3;
                data[6] = uts;
                data[7] = uas;
                data[8] = angkatan;
                tableModel.setRowCount(0);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                nonaktif_teks();
                settableload();
                input_nama.setSelectedIndex(0);
                input_nama_matkul.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Data Telah Diubah", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("picture/change_50px.png"));
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        // TODO add your handling code here:
        login masuk = new login();
        masuk.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluarMouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // TODO add your handling code here:
        int year = Calendar.getInstance().get(Calendar.YEAR);
        membersihkan_teks();
        input_nama.requestFocus();
        input_angkatan.setText(Integer.toString(year));
        
        btn_ubah.setBackground(Color.gray);
        btn_hapus.setBackground(Color.gray);
        btn_keluar.setBackground(Color.gray);
        btn_simpan.setBackground(Color.white);
        
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void input_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_namaActionPerformed
        // TODO add your handling code here:
        input_nim.setText("");
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mahasiswa WHERE nama='"+input_nama.getSelectedItem()+"';";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()) {
                System.out.println("masuk nim");
                input_nim.setText(res.getString("nim"));
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
    }//GEN-LAST:event_input_namaActionPerformed

    private void input_kode_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_kode_mkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_kode_mkActionPerformed

    private void input_nama_matkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nama_matkulActionPerformed
        // TODO add your handling code here:
        input_kode_mk.setText("");
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                database,
                user,
                pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM mata_kuliah WHERE nama_mk='"+input_nama_matkul.getSelectedItem()+"';";
            ResultSet res = stt.executeQuery(SQL);
//            System.out.println(res);
            while(res.next()) {
                System.out.println("masuk kode");
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
    }//GEN-LAST:event_input_nama_matkulActionPerformed

    private void input_nimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_nimKeyPressed
        // TODO add your handling code here:
        int year = Calendar.getInstance().get(Calendar.YEAR);
        input_angkatan.setText(Integer.toString(year));

    }//GEN-LAST:event_input_nimKeyPressed

    private void input_kehadiranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_kehadiranKeyPressed
        // TODO add your handling code here:
        input_angkatan.setText("2022");
    }//GEN-LAST:event_input_kehadiranKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(JFrame.MAXIMIZED_BOTH);        
    }//GEN-LAST:event_formWindowOpened

    private void input_cari_dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_cari_dataKeyReleased
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        String SQL = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database, 
                    user,
                    pass
            );
            System.out.println("ini cari data : "+input_cari_data.getText());
//            System.out.println("SELECT * FROM mahasiswa "
//                    + "WHERE ( nama LIKE '%"+input_cari_data.getText()+"%');");
            Statement stt_nim = kon.createStatement();
            String SQL_nim = "SELECT * FROM mahasiswa "
                    + "WHERE ( nama LIKE '%"+input_cari_data.getText()+"%');";
            ResultSet res_nim = stt_nim.executeQuery(SQL_nim);
            Integer jumlah_nim = 0;
            while(res_nim.next()){
                cari_nim = Integer.toString(res_nim.getInt("nim"));
                jumlah_nim = jumlah_nim+1;
            }
            System.out.println("ini jumlah nim : "+jumlah_nim);
            if(jumlah_nim > 1){
                cari_nim = "1012";
            }
            
            

            Statement stt_nomor_mk = kon.createStatement();
            String SQL_nomor_mk = "SELECT * FROM mata_kuliah "
                    + "WHERE ( nama_mk LIKE '%"+input_cari_data.getText()+"%');";
//            System.out.println("SELECT * FROM mata_kuliah "
//                    + "WHERE ( nama_mk LIKE '%"+input_cari_data.getText()+"%');");
            ResultSet res_nomor_mk = stt_nomor_mk.executeQuery(SQL_nomor_mk);
            Integer jumlah_nomor_mk = 0;
            while(res_nomor_mk.next()){
                cari_nomor_mk = Integer.toString(res_nomor_mk.getInt("nomor_mk"));
                jumlah_nomor_mk = jumlah_nomor_mk+1;
            }
            System.out.println("ini jumlah nomor mk : "+jumlah_nomor_mk);
            if(jumlah_nomor_mk > 1){
                cari_nomor_mk = "10";
            }
            
            System.out.println("Ini nim : "+cari_nim+", ini nomor mk : "+cari_nomor_mk);
                    

            Statement stt = kon.createStatement();
            SQL = "SELECT * FROM nilai_mahasiswa "
                    + "WHERE (nim LIKE '%"+cari_nim+"%') OR (nomor_mk LIKE '%"+cari_nomor_mk+"%');";
            if(jumlah_nim == 1 & jumlah_nomor_mk == 0){
                SQL = "SELECT * FROM nilai_mahasiswa "
                    + "WHERE (nim LIKE '%"+cari_nim+"%');";
            } else if(jumlah_nim == 0 & jumlah_nomor_mk == 1){
                SQL = "SELECT * FROM nilai_mahasiswa "
                    + "WHERE (nomor_mk LIKE '%"+cari_nomor_mk+"%');";
            } 
            
            System.out.println("SELECT * FROM nilai_mahasiswa "
                    + "WHERE ( nim LIKE '%"+cari_nim+"%') OR "
                    + "(nomor_mk LIKE '%"+cari_nomor_mk+"%');");
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()) {
                System.out.println(res.getInt("nim"));
                Statement stt_nama = kon.createStatement();
                String SQL_nama = "SELECT * FROM mahasiswa WHERE nim="+res.getInt("nim")+";";
                ResultSet res_nama = stt_nama.executeQuery(SQL_nama);
//                System.out.println(res_nama.next());
                Statement stt_nama_matkul = kon.createStatement();
                String SQL_nama_matkul = "SELECT * FROM mata_kuliah WHERE nomor_mk="+res.getInt("nomor_mk")+";";
                ResultSet res_nama_matkul = stt_nama_matkul.executeQuery(SQL_nama_matkul);
                
//                get data 
                double jumlah_pertemuan = res.getInt("kehadiran");
                double tugas1 = res.getInt("tugas_1");
                double tugas2 = res.getInt("tugas_2");
                double tugas3 = res.getInt("tugas_3");
                double uts = res.getInt("uts");
                double uas = res.getInt("uas");
//                end 
                double nilai_absen = (((jumlah_pertemuan/14)*100*5)/100);
                double nilai_tugas = (((tugas1+tugas2+tugas3)/3)*(0.25));
                double nilai_uts = uts*0.3;
                double nilai_uas = uas*0.4;
                double nilai_akhir = nilai_absen+nilai_tugas+nilai_uts+nilai_uas;
                String index;
                if(nilai_akhir >= 80 & nilai_akhir <= 100){
                    index = "A";
                } else if(nilai_akhir >= 68 & nilai_akhir <= 79){
                    index = "B";
                } else if(nilai_akhir >= 56 & nilai_akhir <= 67){
                    index = "C";
                } else if(nilai_akhir >= 45 & nilai_akhir <= 55){
                    index = "D";
                } else {
                    index = "E";
                }
                String keterangan = null;
                if(index == "A" | index == "B" | index == "C"){
                    keterangan = "Lulus";
                }else if(index == "D" | index == "E"){
                    keterangan = "Tidak Lulus";
                } 
                if(jumlah_pertemuan < 11){
                    keterangan = "Tidak Lulus";
                }
                res_nama.next();
                res_nama_matkul.next();
//                s
                data[0] = res_nama.getString("nama");
                data[1] = res_nama_matkul.getString("nama_mk");
                data[2] = String.format("%.0f",jumlah_pertemuan);
                data[3] = Double.toString(tugas1);
                data[4] = Double.toString(tugas2);
                data[5] = Double.toString(tugas3);
                data[6] = Double.toString(uts);
                data[7] = Double.toString(uas);
                data[8] = String.format("%.1f",nilai_absen);
                data[9] = String.format("%.1f",nilai_tugas);
                data[10] = String.format("%.1f",nilai_uts);
                data[11] = String.format("%.1f",nilai_uas);
                data[12] = String.format("%.1f",nilai_akhir);
                data[13] = index;
                data[14] = keterangan;
                System.out.println(data);
                tableModel.addRow(data);

                res_nama.close();
                stt_nama.close();
                res_nama_matkul.close();
                stt_nama_matkul.close();
            }
            res.close();
            stt.close();
            res_nim.close();
            stt_nim.close();
            res_nomor_mk.close();
            stt_nomor_mk.close();
            kon.close();
            cari_nim = "";
            cari_nomor_mk = "";
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_input_cari_dataKeyReleased

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
            java.util.logging.Logger.getLogger(form_data_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_data_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_data_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_data_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_data_nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_batal;
    private javax.swing.JPanel btn_hapus;
    private javax.swing.JPanel btn_keluar;
    private javax.swing.JLabel btn_mahasiswa;
    private javax.swing.JPanel btn_simpan;
    private javax.swing.JPanel btn_tambah;
    private javax.swing.JPanel btn_ubah;
    private javax.swing.JPanel data_mahasiswa;
    private javax.swing.JPanel data_mata_kuliah;
    private javax.swing.JPanel data_nilai;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon_mahasiswa;
    private javax.swing.JLabel icon_matkul;
    private javax.swing.JLabel icon_nilai;
    private javax.swing.JTextField input_angkatan;
    private javax.swing.JTextField input_cari_data;
    private javax.swing.JTextField input_kehadiran;
    private javax.swing.JTextField input_kode_mk;
    private javax.swing.JComboBox<String> input_nama;
    private javax.swing.JComboBox<String> input_nama_matkul;
    private javax.swing.JTextField input_nim;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Label label1;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_title;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel simulasi_kasus;
    private javax.swing.JPanel simulasi_nilai_akhir;
    private javax.swing.JTable tabel_nilai_mahasiswa;
    private javax.swing.JPanel tentang_pembuat1;
    // End of variables declaration//GEN-END:variables
}
