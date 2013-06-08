package org.go.inq.decoder;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.apache.commons.lang.StringUtils;
/*
 * Created by JFormDesigner on Sat Jun 08 09:38:31 FET 2013
 */



/**
 * @author unknown
 */
public class DecoderForm extends JPanel {
    final JFileChooser fc = new JFileChooser();

    public DecoderForm() {
        initComponents();
    }

    private void selectFileButtonClick(ActionEvent e) {
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(DecoderForm.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            selectFileText.setText(file.getAbsolutePath());

            Decoder decoder = new Decoder(file.getAbsolutePath());
            decryptedTextArea.setText("Please, wait. Analyzing file...");

            DecryptResult decrypted = decoder.decrypt();
            if(StringUtils.isEmpty(decrypted.getText())){
                decryptedTextArea.setText("Error occurred during open file.");
            }
            decryptedTextArea.setText(decrypted.getText());
        } else {
            selectFileText.setText("select file do decrypt");
        }
    }

    private void closeButtonClick(ActionEvent e) {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sed sed
        selectFileButton = new JButton();
        selectFileText = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        decryptedTextArea = new JTextArea();
        closeButton = new JButton();

        //======== this ========

        setLayout(new FormLayout(
            "default, $lcgap, 82dlu, $lcgap, default, $lcgap, 122dlu, $lcgap, 129dlu",
            "7*(default, $lgap), 38dlu, $lgap, default, $lgap, 45dlu, $lgap, 76dlu"));

        //---- selectFileButton ----
        selectFileButton.setText("Select file");
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFileButtonClick(e);
            }
        });
        add(selectFileButton, CC.xywh(3, 5, 2, 1));
        add(selectFileText, CC.xywh(7, 5, 3, 1));

        //---- label2 ----
        label2.setText("Decrypted file content:");
        add(label2, CC.xywh(3, 9, 3, 1));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(decryptedTextArea);
        }
        add(scrollPane1, CC.xywh(3, 11, 7, 9));

        //---- closeButton ----
        closeButton.setText("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButtonClick(e);
            }
        });
        add(closeButton, CC.xy(9, 21));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sed sed
    private JButton selectFileButton;
    private JTextField selectFileText;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea decryptedTextArea;
    private JButton closeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
