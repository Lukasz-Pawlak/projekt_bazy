package edu.pwr.db.view;

import edu.pwr.db.model.Login;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AdminPanel extends JPanel {
    private final AppWindow appWindow;
    private final JButton doBackup, restoreFromBackup;

    public AdminPanel(AppWindow appWindow) {
        this.appWindow = appWindow;
        doBackup = new JButton("make backup");
        restoreFromBackup = new JButton("restore from backup");

        setLayout(new GridBagLayout());
        var gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = gc.weightx = 1;

        add(doBackup, gc);

        gc.gridx++;
        add(restoreFromBackup, gc);
        
        doBackup.addActionListener(e -> backup());
        restoreFromBackup.addActionListener(e -> restore());
    }

    private void backup() {
        try {
            String dbName = "Shop";
            String dbUser = Login.getUsername();
            String dbPass = Login.getPassword();

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("select backup target directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            String path;

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                path = chooser.getCurrentDirectory().toString();
            } else {
                JOptionPane.showMessageDialog(appWindow,
                        "backup aborted", "info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String folderPath = path + "\\backup";
            File f1 = new File(folderPath);
            f1.mkdir();

            String savePath = "\"" + path + "\\backup\\" + "backup.sql\"";
            String executeCmd = "mysqldump -u" + dbUser +
                    " -p" + dbPass + " --database " + dbName + " -r " + savePath;
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                JOptionPane.showMessageDialog(appWindow,
                        "backup done", "info", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(appWindow,
                        "backup failure", "info", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }

    private void restore() {

    }
/*
    public static String getData(String host, String port, String user, String password, String db,String table) throws Exception {

        //an "C:/xampp/mysql/bin/mysqldump" ---- location ito han mysqldump

        Process run = Runtime.getRuntime().exec(
                "C:/xampp/mysql/bin/mysqldump --host="  + host + " --port=" + port +
                        " --user=" + user + " --password=" + password +
                        " --compact --databases --add-drop-table --complete-insert --extended-insert " +
                        "--skip-comments --skip-triggers "+ db+" --tables "+table);

        InputStream in = run.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer temp = new StringBuffer();
        int count;
        char[] cbuf = new char[BUFFER];

        while ((count = br.read(cbuf, 0, BUFFER)) != -1)
            temp.append(cbuf, 0, count);

        br.close();
        in.close();

        return temp.toString();
    }*/
}
