/**
 *
 * @author wei
 */
package hhxiee-comicdownload;

import downloadhhpic.DownloadPic;
import web.Webdownload;
import scanandparse.ScanHHPic;
import scanandparse.ParseName;
import java.io.*;
import javax.swing.*;
import java.util.regex.*;
import java.util.*;
import scanandparse.ScanVol;


public class ComicDownloadUI extends javax.swing.JDialog {

    /**
     * Creates new form ComicDownloadUI
     */
    
    List<String> picList;                                                               //全局变量：图片网址列表，每使用一次Scan函数就更新一次
    List<String> volList;
    String selectPath;
    String comicName;
    boolean isVol;
    
    public ComicDownloadUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        selectPath=System.getProperty("user.dir") + "\\Download";
        fieSavePath.setText(selectPath);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGet = new javax.swing.JButton();
        fieGetURL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lisPicListUrl = new javax.swing.JList();
        btnStart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaContent = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        fieSavePath = new javax.swing.JTextField();
        butOpenPath = new javax.swing.JButton();
        labSavePath = new javax.swing.JLabel();
        rbuChooseName = new javax.swing.JRadioButton();
        fieSaveFileName = new javax.swing.JTextField();
        rbuChooseAuto = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("汗汗漫画图片下载器Beta by huxizhijian");

        btnGet.setText("解析网址");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });

        fieGetURL.setText("http://www.hhxiee.cc/xiee/18168/25.htm?s=9");

        jLabel1.setText("漫画地址：");

        jScrollPane1.setViewportView(lisPicListUrl);

        btnStart.setText("请先解析网址");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        areaContent.setEditable(false);
        areaContent.setColumns(20);
        areaContent.setRows(5);
        jScrollPane2.setViewportView(areaContent);

        jLabel2.setText("目前网站仅支持http://www.hhxiee.cc和http://www.hhmanhua.net，地址支持目录页和单卷地址，选择自动漫画名为代码");

        fieSavePath.setToolTipText("");

        butOpenPath.setText("打开目录选择");
        butOpenPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOpenPathActionPerformed(evt);
            }
        });

        labSavePath.setText("保存目录：");

        buttonGroup1.add(rbuChooseName);
        rbuChooseName.setSelected(true);
        rbuChooseName.setText("保存漫画名");

        buttonGroup1.add(rbuChooseAuto);
        rbuChooseAuto.setText("自动");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labSavePath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butOpenPath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbuChooseName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieSaveFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbuChooseAuto)
                        .addGap(11, 11, 11)
                        .addComponent(btnGet, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fieGetURL))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieGetURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieSaveFileName)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labSavePath)
                        .addComponent(rbuChooseName)
                        .addComponent(rbuChooseAuto)
                        .addComponent(butOpenPath)
                        .addComponent(fieSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // 按钮：获取图片网址
        String url = fieGetURL.getText();
        if (url.matches("(.*)s=(.*)")){
            isVol = false;
         new Thread(()->{
            String contents = Webdownload.startDownload(url,"GB2312");
            picList = ScanHHPic.scanPicInPage(url,contents);                
            DefaultListModel defaultListModel = new DefaultListModel();
            List<String> picName=ParseName.ParseHHFileName(contents);  
                for (int i=0;i<picList.size();i++){
                    defaultListModel.add(i, picList.get(i)); 
                }
            SwingUtilities.invokeLater(()->{                                              //更新容器内容
                lisPicListUrl.setModel(defaultListModel);
                areaContent.setText("漫画名："+picName.get(0)+"\n");
                if (picName.size() > 2)
                    areaContent.append("目前："+picName.get(1)+"  "+"来自："+picName.get(2).substring(0,4)+"\n");
                else if (picName.size() == 2)
                    areaContent.append("来自："+picName.get(1).substring(0,4)+"\n");
                areaContent.append("软件嗅探到该集/卷共有"+picList.size()+"页"+ "\n");
                fieSaveFileName.setText(picName.get(0));
                comicName = picName.get(0);
                btnStart.setText("下载本集/卷");
                }); 
            }).start(); 
        }   else {
            isVol = true;
          new Thread(()->{
            String contents = Webdownload.startDownload(url,"GB2312");
            volList = ScanVol.scanVolInPage(url,contents); 
            String[] volname1 = volList.get(0).split(":");
            String[] comicName = volname1[0].split(" ");
            DefaultListModel defaultListModel = new DefaultListModel();
                for (int i=0;i<volList.size();i++){
                    defaultListModel.add(i, volList.get(i)); 
                }
            SwingUtilities.invokeLater(()->{                                              //更新容器内容
                lisPicListUrl.setModel(defaultListModel);
                areaContent.setText("漫画名：");
                areaContent.append(comicName[0]+"\n");
                areaContent.append("软件嗅探到该漫画共有"+volList.size()+"集/卷"+ "\n");
                btnStart.setText("下载全集");
                fieSaveFileName.setText(comicName[0]);
                }); 
            }).start();                 
        }

    }                                      

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        selectPath = fieSavePath.getText();
        if (isVol == false){
        new Thread(()->{
            download();
            SwingUtilities.invokeLater(()->{ 
                areaContent.append("该集/卷下载结束！"+"\n");
                areaContent.append("保存于："+selectPath+"\n");
            });
        }).start();
        } else if (isVol == true){
            new Thread(()->{
            downloadAllVol();
            }).start();
        } else {
            JOptionPane.showMessageDialog(null,"请先进行解析!", "错误！", JOptionPane.WARNING_MESSAGE);
        }
    }                                        
private void download(){
            String filePath = selectPath;                                        //获取目录
            if (rbuChooseName.isSelected()){
                filePath = filePath + "\\" + fieSaveFileName.getText();
               for (int i = 0; i < picList.size();i++){
                String[] autoName = picList.get(i).substring(47).split("/");
                String[] page = autoName[3].split("\\.");
                boolean complete = DownloadPic.Download(picList.get(i), autoName[2],autoName[3], filePath);
                SwingUtilities.invokeLater(()->{ 
                    if (complete == true)
                        areaContent.append("第"+ page[0]+"页.....................下载完成！"+"\n");
                    else{
                        areaContent.append("第"+ page[0]+"页.....................下载失败，暂停下载！"+"\n");
                        return;
                    }
                });
                }
            }   else {                
                String[] Name = picList.get(0).substring(47).split("/");
                filePath = filePath + "\\" + Name[1];
                for (int i = 0; i < picList.size();i++){
                String[] autoName = picList.get(i).substring(47).split("/");
                String[] page = autoName[3].split("\\.");
                boolean complete = DownloadPic.Download(picList.get(i), autoName[2],autoName[3], filePath);
                 SwingUtilities.invokeLater(()->{ 
                    if (complete == true)
                        areaContent.append("第"+ page[0]+"页.....................下载完成！"+"\n");
                    else{
                        areaContent.append("第"+ page[0]+"页.....................下载失败，暂停下载！"+"\n");
                        return;
                    }
                });
                }
            }
}

private void downloadAllVol(){
    for (int i = 0; i < volList.size();i++){
        String[] volurl = volList.get(i).split(":");
        String url = "http:"+ volurl[2];
        if (url.matches("(.*)s=(.*)")){

            String contents = Webdownload.startDownload(url,"GB2312");
            picList = ScanHHPic.scanPicInPage(url,contents);                

            List<String> picName=ParseName.ParseHHFileName(contents);  

            SwingUtilities.invokeLater(()->{                                              //更新容器内容

                areaContent.append("漫画名："+picName.get(0)+"\n");
                if (picName.size() > 2)
                    areaContent.append("目前："+picName.get(1)+"  "+"来自："+picName.get(2).substring(0,4)+"\n");
                else if (picName.size() == 2)
                    areaContent.append("来自："+picName.get(1).substring(0,4)+"\n");
                areaContent.append("软件嗅探到该集/卷共有"+picList.size()+"页"+ "\n");
                }); 
            download();
            SwingUtilities.invokeLater(()->{ 
                areaContent.append("该集/卷下载结束！"+"\n");
                areaContent.append("保存于："+selectPath+"\n");
            });

        }
    }
}
    
    
    private void butOpenPathActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//设置只能选择目录
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            selectPath =chooser.getSelectedFile().getPath() ;
            fieSavePath.setText(selectPath);
            chooser.hide();
        }
    }                                           

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
            java.util.logging.Logger.getLogger(ComicDownloadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComicDownloadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComicDownloadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComicDownloadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComicDownloadUI dialog = new ComicDownloadUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea areaContent;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton butOpenPath;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fieGetURL;
    private javax.swing.JTextField fieSaveFileName;
    private javax.swing.JTextField fieSavePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labSavePath;
    private javax.swing.JList lisPicListUrl;
    private javax.swing.JRadioButton rbuChooseAuto;
    private javax.swing.JRadioButton rbuChooseName;
    // End of variables declaration                   
}
