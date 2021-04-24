package com.mycompany.app;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
public class subversion {
	static JComboBox gcombb; //���������� JComboBox
	String file_data;
    public subversion() throws MalformedURLException, IOException {
        final JFrame main_GUI = new JFrame("subversion"); // �������� ������������ ����
        main_GUI.setTitle ("Using subversion for developers");
        main_GUI.setBounds(500,400,400,300);
        main_GUI.setResizable(false); // ������������� ������ ����
        FileDialog fc;

        JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
        main_panel.setLayout(null);
        main_GUI.add(main_panel);
        
        JMenuBar mb = new JMenuBar();
        JMenu open = new JMenu("����");
        mb.add(open);
        main_GUI.setJMenuBar(mb);

        JLabel laba_info = new JLabel("������������ ������ �4"); // ����������� ������ ��� �����������
        laba_info.setBounds(120,0,150,30);
        main_panel.add(laba_info);
        
        BufferedImage fileDir = ImageIO.read(new URL ("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));
        JLabel logo = new JLabel();// ����������� ������ ��� �����������
        logo.setIcon(new ImageIcon(fileDir.getScaledInstance(150, 80, fileDir.SCALE_DEFAULT)));
        	         
        
  
    
        logo.setBounds(115, 25, 170, 75);
        main_panel.add(logo);
        logo.setVisible(false);
        
        String[] itemsa = { //���������� ������� ������
        		"����������� ������� ����� � ������� ������ ����",
        		"����������� ������� ����� � ��������",
        		"����������� ������� ����� � ����� ������� ����",
        		"������������� ������ � �������6"
        		};

        class list implements ActionListener {

            @Override
            // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gcombb) {//�������� ��� ��������� JComboBox
                    main_panel.remove(logo);
                    if (gcombb.getSelectedItem() == "����������� ������� ����� � ������� ������ ����") {

                        main_panel.add(logo); // ��������� Label �� ������
                        logo.setBounds(220, 25, 140, 75); // ��������� ���� � ������ ��������
                        logo.setIcon(new ImageIcon(fileDir)); //������� ��������
                    }
                    if (gcombb.getSelectedItem() == "����������� ������� ����� � ��������") {

                        main_panel.add(logo); // ��������� Label �� ������
                        logo.setBounds(115, 25, 170, 75); // ��������� ���� � ������ ��������
                        logo.setIcon(new ImageIcon(fileDir)); //������� ��������
                    }
                    if (gcombb.getSelectedItem() == "����������� ������� ����� � ����� ������� ����") {

                        main_panel.add(logo); // ��������� Label �� ������
                        logo.setBounds(30, 25, 170, 75); // ��������� ���� � ������ ��������
                        logo.setIcon(new ImageIcon(fileDir)); //������� ��������
                    }
                }
            }
        }


        gcombb = new JComboBox(itemsa); // ����������� �������� JComboBox
        gcombb.setBounds(40, 115, 310, 20); // ������ ������� JComboBox
        ActionListener c = new list(); // �������� ���������
        gcombb.addActionListener(c); // ��������� ��������� � JComboBox
        main_panel.add(gcombb); // ���������� JComboBox �� ������� ������


        JButton button_exit = new JButton("�����"); // ��������� ������
        button_exit.setBounds(280, 200, 100, 40);
        button_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                main_GUI.dispose();
            }
        });


        JButton button_info = new JButton("���������� "); // ���a����� ������
        button_info.setBounds(20, 200, 120, 40);
        button_info.addActionListener(new ActionListener() {

        		public void actionPerformed(ActionEvent e) {
                   if (file_data ==null)
                   {
                       JOptionPane.showMessageDialog(main_panel, "������ ������������ - 19150093 " +
                               "\n����� ��������� - 191500089 - 30.03.2021" +
                               "\n���� ���������� - 19130621 - 30.03.2021", "����������", JOptionPane.PLAIN_MESSAGE);
                   }
                   else{
                       JOptionPane.showMessageDialog(main_panel, "������ ������������ - 19150093 " +
                               "\n����� ��������� - 191500089 " +
                               "\n���� ���������� - 19130621 " +
                               "\n�������� ��������� - 19130012"+"\n\n���������� �� �����:\n"+ file_data, "����������", JOptionPane.PLAIN_MESSAGE);
                   }
               }
           }); //����������� ������

        fc = new FileDialog(main_GUI, "������� ����", FileDialog.LOAD);
        fc.setDirectory("C:\\");
        fc.setFile("*.txt");

        JButton load_file = new JButton("��������� ���� "); // ���a����� ������
        load_file.setBounds(20, 150, 140, 40);

        load_file.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fc.setVisible(true);
                String file = fc.getFile();
                String fn = fc.getDirectory() + fc.getFile();
                String line = null;
                file_data = "";

                if (file == null)
                    System.out.println("�� �������� �����");
                else {
                    System.out.println("�� ������� " + fn);
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "UTF8"))) {


                        while ((line = br.readLine()) != null) {
                            file_data += line + '\n';
                        }

                        JOptionPane.showMessageDialog(main_panel, file_data, "����������", JOptionPane.PLAIN_MESSAGE);

                    } catch (IOException ex) {
                        System.out.println(
                                "Error reading file '"
                                        + fn + "'");
                    }
                }
            }
        });
        JButton button_load = new JButton("��������� ����");
        button_load.setBounds(20, 150, 130, 40);

        button_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(main_GUI);
                fd.setFile("*.txt");
                fd.setVisible(true);

                final String file = fd.getFile();
                final String dir = fd.getDirectory();
                if (dir == null || file == null || file.trim().length() == 0)
                    return;
                File dir1 = new File(dir, file);

                try {
                    FileReader inputFile = new FileReader(dir1.getAbsolutePath());
                    BufferedReader bufferReader = new BufferedReader(inputFile);
                    String line;
                    file_data = new String();
                    while ((line = bufferReader.readLine()) != null) {
                        System.out.println(line);
                        file_data+=line+'\n';

                    }
                    //Close the buffer reader
                    bufferReader.close();
                } catch (Exception exception) {
                    System.out.println("Error while reading file line by line:" + exception.getMessage());
                }


            }
        });
        main_panel.add(button_exit);
        main_panel.add(load_file);


        main_panel.add(button_info);


        JMenuItem picture = new JMenuItem("O��������� ������� �����");

        ActionListener actionListener2 = new ListenerButton(); //������� ���������
        picture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logo.setVisible(true);

            }
        }); // ��������� ��������� � ������
        main_panel.add(picture);

        JTextField input1 = new JTextField("����� ���������");
        input1.setBounds(250, 150, 120, 20);

        input1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input1.setText("");
            }
        });

        JTextField input2 = new JTextField("����� ���. �������");
        input2.setBounds(250, 170, 120, 20);

        input2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input2.setText("");
            }
        });

        JButton button_per = new JButton("��������"); // ��������� ������
        button_per.setBounds(170, 200, 100, 40);
        button_per.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int a, b, res;
                try {
                    a = Integer.parseInt(input1.getText());
                    b = Integer.parseInt(input2.getText());

                    res = (a+b*2)*10;
                    JOptionPane.showMessageDialog(null, "�������� ������������ ����� "+res+"��", "��������: ", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "���� ������ �������� �� �����", "������", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        main_panel.add(input1);
        main_panel.add(input2);
        main_panel.add(button_per);

        JMenuItem download = new JMenuItem("��������� ���� � ������ 6");

        JMenuItem exit = new JMenuItem("�����");
        exit.addActionListener(actionListener2);


        main_GUI.setVisible(true);

        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java


        open.add(picture);
        open.add(download);
        open.add(exit);

    }


    public static void main(String[] args) throws MalformedURLException, IOException { // ���������� �������: http://www.mstu.edu.ru/study/materials/java/
        subversion student = new subversion();

    }

}