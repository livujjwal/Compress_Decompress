package GUI;

import compress_decompress.compressor;
import compress_decompress.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class AppFrame extends JFrame implements ActionListener
{

    JButton CompressButton;
    JButton DecompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CompressButton = new JButton("Select file to compress");
        CompressButton.setBounds(200,200, 200, 20);
        CompressButton.addActionListener(this);

        DecompressButton = new JButton("Select file to decompress");
        DecompressButton.setBounds(600,200, 200, 20);
        DecompressButton.addActionListener(this);

        this.add(CompressButton);
        this.add(DecompressButton);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.yellow);
        this.setSize(1000,600);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==CompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==DecompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
