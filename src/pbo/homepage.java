/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

import javax.swing.JFrame;

/**
 *
 * @author SaIN
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    public homepage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        tentang_pembuat = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        data_mahasiswa = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        data_mata_kuliah = new javax.swing.JPanel();
        icon2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        data_nilai = new javax.swing.JPanel();
        icon3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Simulasi_nilai_akhir = new javax.swing.JPanel();
        icon4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        simulasi_kasus = new javax.swing.JPanel();
        icon10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        sidebar.setBackground(new java.awt.Color(65, 83, 128));

        tentang_pembuat.setBackground(new java.awt.Color(65, 83, 128));
        tentang_pembuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tentang_pembuat.setPreferredSize(new java.awt.Dimension(175, 43));
        tentang_pembuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tentang_pembuatMouseClicked(evt);
            }
        });

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/people_20px.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tentang Pembuat");

        javax.swing.GroupLayout tentang_pembuatLayout = new javax.swing.GroupLayout(tentang_pembuat);
        tentang_pembuat.setLayout(tentang_pembuatLayout);
        tentang_pembuatLayout.setHorizontalGroup(
            tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tentang_pembuatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        tentang_pembuatLayout.setVerticalGroup(
            tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tentang_pembuatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tentang_pembuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon)
                    .addComponent(jLabel3))
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

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/student_male_20px.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Mahasiswa");

        javax.swing.GroupLayout data_mahasiswaLayout = new javax.swing.GroupLayout(data_mahasiswa);
        data_mahasiswa.setLayout(data_mahasiswaLayout);
        data_mahasiswaLayout.setHorizontalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mahasiswaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon1)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        data_mahasiswaLayout.setVerticalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon1)
                    .addComponent(jLabel4))
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

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/open_book_20px.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Mata Kuliah");

        javax.swing.GroupLayout data_mata_kuliahLayout = new javax.swing.GroupLayout(data_mata_kuliah);
        data_mata_kuliah.setLayout(data_mata_kuliahLayout);
        data_mata_kuliahLayout.setHorizontalGroup(
            data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mata_kuliahLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon2)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        data_mata_kuliahLayout.setVerticalGroup(
            data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mata_kuliahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_mata_kuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon2)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("APLIKASI KEMAHASISWAAN");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 30));

        data_nilai.setBackground(new java.awt.Color(65, 83, 128));
        data_nilai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data_nilai.setPreferredSize(new java.awt.Dimension(175, 43));
        data_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_nilaiMouseClicked(evt);
            }
        });

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/clipboard_list_20px.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data Nilai");

        javax.swing.GroupLayout data_nilaiLayout = new javax.swing.GroupLayout(data_nilai);
        data_nilai.setLayout(data_nilaiLayout);
        data_nilaiLayout.setHorizontalGroup(
            data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_nilaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon3)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        data_nilaiLayout.setVerticalGroup(
            data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_nilaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_nilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon3)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        Simulasi_nilai_akhir.setBackground(new java.awt.Color(65, 83, 128));
        Simulasi_nilai_akhir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Simulasi_nilai_akhir.setPreferredSize(new java.awt.Dimension(175, 43));
        Simulasi_nilai_akhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Simulasi_nilai_akhirMouseClicked(evt);
            }
        });

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/todo_list_20px.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Simulasi Nilai Akhir");

        javax.swing.GroupLayout Simulasi_nilai_akhirLayout = new javax.swing.GroupLayout(Simulasi_nilai_akhir);
        Simulasi_nilai_akhir.setLayout(Simulasi_nilai_akhirLayout);
        Simulasi_nilai_akhirLayout.setHorizontalGroup(
            Simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Simulasi_nilai_akhirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon4)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Simulasi_nilai_akhirLayout.setVerticalGroup(
            Simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Simulasi_nilai_akhirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Simulasi_nilai_akhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon4)
                    .addComponent(jLabel8))
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

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data_nilai, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data_mata_kuliah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(data_mahasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sidebarLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 29, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(Simulasi_nilai_akhir, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(tentang_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addComponent(simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(data_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_mata_kuliah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Simulasi_nilai_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tentang_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/ghina2.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(65, 83, 128));
        jLabel9.setText("10121093 / GHINA NUR AZIZAH");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/aziz2.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(65, 83, 128));
        jLabel12.setText("10121098 / MOHAMMAD AZIZ RIZA");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/salsa2.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 83, 128));
        jLabel14.setText("10121099 / SALSABILA RAMADHAN");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/picture/saffa2.png"))); // NOI18N
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(65, 83, 128));
        jLabel16.setText("10121101 / SAFFANA HELMI NAFISAH");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void data_mata_kuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mata_kuliahMouseClicked
        // TODO add your handling code here:
        form_mata_kuliah utama = new form_mata_kuliah();
        utama.setVisible(true);
        
        this.setVisible(false);
//        text_ubah.setText("Ini Data Mata Kuliah");
    }//GEN-LAST:event_data_mata_kuliahMouseClicked

    private void data_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_mahasiswaMouseClicked
        // TODO add your handling code here:
        form_mahasiswa mahasiswa = new form_mahasiswa();
        mahasiswa.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_mahasiswaMouseClicked

    private void tentang_pembuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentang_pembuatMouseClicked
        // TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_tentang_pembuatMouseClicked

    private void data_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_nilaiMouseClicked
        // TODO add your handling code here:
        form_data_nilai nilai = new form_data_nilai();
        nilai.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_data_nilaiMouseClicked

    private void Simulasi_nilai_akhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Simulasi_nilai_akhirMouseClicked
        // TODO add your handling code here:
        form_simulasi_nilai_akhir nilai_akhir = new form_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_Simulasi_nilai_akhirMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jPanel3.setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);        
    }//GEN-LAST:event_formWindowOpened

    private void simulasi_kasusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulasi_kasusMouseClicked
        // TODO add your handling code here:
        form_transaksi transaksi = new form_transaksi();
        transaksi.setVisible(true);
        
        this.setVisible(false);        
    }//GEN-LAST:event_simulasi_kasusMouseClicked

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Simulasi_nilai_akhir;
    private javax.swing.JPanel data_mahasiswa;
    private javax.swing.JPanel data_mata_kuliah;
    private javax.swing.JPanel data_nilai;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel simulasi_kasus;
    private javax.swing.JPanel tentang_pembuat;
    // End of variables declaration//GEN-END:variables
}
