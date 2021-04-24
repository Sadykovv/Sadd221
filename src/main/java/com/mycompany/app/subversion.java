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
	static JComboBox gcombb; //добавление JComboBox
	String file_data;
    public subversion() throws MalformedURLException, IOException {
        final JFrame main_GUI = new JFrame("subversion"); // создание графического окна
        main_GUI.setTitle ("Using subversion for developers");
        main_GUI.setBounds(500,400,400,300);
        main_GUI.setResizable(false); // фиксированный размер окна
        FileDialog fc;

        JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
        main_panel.setLayout(null);
        main_GUI.add(main_panel);
        
        JMenuBar mb = new JMenuBar();
        JMenu open = new JMenu("Меню");
        mb.add(open);
        main_GUI.setJMenuBar(mb);

        JLabel laba_info = new JLabel("Лабораторная работа №4"); // Отображение текста или изображения
        laba_info.setBounds(120,0,150,30);
        main_panel.add(laba_info);
        
        BufferedImage fileDir = ImageIO.read(new URL ("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));
        JLabel logo = new JLabel();// Отображение текста или изображения
        logo.setIcon(new ImageIcon(fileDir.getScaledInstance(150, 80, fileDir.SCALE_DEFAULT)));
        	         
        
  
    
        logo.setBounds(115, 25, 170, 75);
        main_panel.add(logo);
        logo.setVisible(false);
        
        String[] itemsa = { //добавление массива данных
        		"Переместить логотип УГАТУ в верхний правый угол",
        		"Переместить логотип УГАТУ в середину",
        		"Переместить логотип УГАТУ в левый верхний угол",
        		"Отсортировать данные в проекте6"
        		};

        class list implements ActionListener {

            @Override
            // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gcombb) {//проверка при изменении JComboBox
                    main_panel.remove(logo);
                    if (gcombb.getSelectedItem() == "Переместить логотип УГАТУ в верхний правый угол") {

                        main_panel.add(logo); // Вставляем Label на панель
                        logo.setBounds(220, 25, 140, 75); // Положение окна и размер логотипа
                        logo.setIcon(new ImageIcon(fileDir)); //Вставка логотипа
                    }
                    if (gcombb.getSelectedItem() == "Переместить логотип УГАТУ в середину") {

                        main_panel.add(logo); // Вставляем Label на панель
                        logo.setBounds(115, 25, 170, 75); // Положение окна и размер логотипа
                        logo.setIcon(new ImageIcon(fileDir)); //Вставка логотипа
                    }
                    if (gcombb.getSelectedItem() == "Переместить логотип УГАТУ в левый верхний угол") {

                        main_panel.add(logo); // Вставляем Label на панель
                        logo.setBounds(30, 25, 170, 75); // Положение окна и размер логотипа
                        logo.setIcon(new ImageIcon(fileDir)); //Вставка логотипа
                    }
                }
            }
        }


        gcombb = new JComboBox(itemsa); // присваиваем значения JComboBox
        gcombb.setBounds(40, 115, 310, 20); // задаем размеры JComboBox
        ActionListener c = new list(); // создание слушателя
        gcombb.addActionListener(c); // добавляем слушатель к JComboBox
        main_panel.add(gcombb); // добавление JComboBox на главную панель


        JButton button_exit = new JButton("Выход"); // добавляем кнопку
        button_exit.setBounds(280, 200, 100, 40);
        button_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                main_GUI.dispose();
            }
        });


        JButton button_info = new JButton("Информация "); // добaвляем кнопку
        button_info.setBounds(20, 200, 120, 40);
        button_info.addActionListener(new ActionListener() {

        		public void actionPerformed(ActionEvent e) {
                   if (file_data ==null)
                   {
                       JOptionPane.showMessageDialog(main_panel, "Алишер Абдувалиевич - 19150093 " +
                               "\nДиана Артемовна - 191500089 - 30.03.2021" +
                               "\nИлья Дмитриевич - 19130621 - 30.03.2021", "Информация", JOptionPane.PLAIN_MESSAGE);
                   }
                   else{
                       JOptionPane.showMessageDialog(main_panel, "Алишер Абдувалиевич - 19150093 " +
                               "\nДиана Артемовна - 191500089 " +
                               "\nИлья Дмитриевич - 19130621 " +
                               "\nКристина Ринатовна - 19130012"+"\n\nИнформация из файла:\n"+ file_data, "Информация", JOptionPane.PLAIN_MESSAGE);
                   }
               }
           }); //отображение текста

        fc = new FileDialog(main_GUI, "Выбрать файл", FileDialog.LOAD);
        fc.setDirectory("C:\\");
        fc.setFile("*.txt");

        JButton load_file = new JButton("Загрузить файл "); // добaвляем кнопку
        load_file.setBounds(20, 150, 140, 40);

        load_file.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fc.setVisible(true);
                String file = fc.getFile();
                String fn = fc.getDirectory() + fc.getFile();
                String line = null;
                file_data = "";

                if (file == null)
                    System.out.println("Вы отменили выбор");
                else {
                    System.out.println("Вы выбрали " + fn);
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fn), "UTF8"))) {


                        while ((line = br.readLine()) != null) {
                            file_data += line + '\n';
                        }

                        JOptionPane.showMessageDialog(main_panel, file_data, "Информация", JOptionPane.PLAIN_MESSAGE);

                    } catch (IOException ex) {
                        System.out.println(
                                "Error reading file '"
                                        + fn + "'");
                    }
                }
            }
        });
        JButton button_load = new JButton("Загрузить файл");
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


        JMenuItem picture = new JMenuItem("Oтобразить логотип УГАТУ");

        ActionListener actionListener2 = new ListenerButton(); //создаем слушатель
        picture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logo.setVisible(true);

            }
        }); // добавляем слушатель к кнопке
        main_panel.add(picture);

        JTextField input1 = new JTextField("длина основания");
        input1.setBounds(250, 150, 120, 20);

        input1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input1.setText("");
            }
        });

        JTextField input2 = new JTextField("длина бок. стороны");
        input2.setBounds(250, 170, 120, 20);

        input2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input2.setText("");
            }
        });

        JButton button_per = new JButton("Периметр"); // добавляем кнопку
        button_per.setBounds(170, 200, 100, 40);
        button_per.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int a, b, res;
                try {
                    a = Integer.parseInt(input1.getText());
                    b = Integer.parseInt(input2.getText());

                    res = (a+b*2)*10;
                    JOptionPane.showMessageDialog(null, "Периметр треугольника равен "+res+"мм", "Периметр: ", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ввод должен состоять из чисел", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        main_panel.add(input1);
        main_panel.add(input2);
        main_panel.add(button_per);

        JMenuItem download = new JMenuItem("Загрузить файл в проект 6");

        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(actionListener2);


        main_GUI.setVisible(true);

        main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java


        open.add(picture);
        open.add(download);
        open.add(exit);

    }


    public static void main(String[] args) throws MalformedURLException, IOException { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
        subversion student = new subversion();

    }

}