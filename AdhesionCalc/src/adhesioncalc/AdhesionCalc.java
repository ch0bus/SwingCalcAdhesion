package adhesioncalc;
import adhesioncalc.calculator.Calc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author chobus
 */
public class AdhesionCalc {
    
    double width;
    double length;
    double depth;
    double density;
    double caseVolume;
    double resultWeight;
    double resultTotal;
    String measureValueWidth="мм";
    String measureValueLength="м";
    String measureValueDepth="мм";
    String measureValueDensity="г/см3";
    String measureValueCase="г";
    
    AdhesionCalc(){
        JFrame root = new JFrame("Adhesion Calculator");
        root.setLayout(new FlowLayout());
        root.setSize(300,530);
        root.setResizable(false);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea taResultNumberOf = new JTextArea(1,7);
        taResultNumberOf.setEditable(false);
        JTextArea taResultWeight = new JTextArea(1,10);
        taResultWeight.setEditable(false);        
        
        JLabel jlAdhesion = new JLabel("<ADHESION>");
        jlAdhesion.setFont(new Font("Laksaman", Font.BOLD, 20));
        jlAdhesion.setForeground(new Color(50, 100, 50));
        jlAdhesion.setBackground(new Color(250, 0, 0));
        //Border border = BorderFactory.createLineBorder(Color.ORANGE);
        //jlAdhesion.setBorder(border);
        
        JLabel jlWidth = new JLabel("Ширина:");
        JLabel jlLength = new JLabel("Длина:    ");
        JLabel jlDepth = new JLabel("Глубина:");
        JLabel jlDensity = new JLabel("Плотность:");
        JLabel jlCase = new JLabel("Объём тары:");
        JLabel jlWeight = new JLabel("Расход, кг:   ");
        JLabel jlNumberOf = new JLabel("Количество, шт:");
        
        JTextField tfWidth = new JTextField(10);
        tfWidth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                width = Double.parseDouble(tfWidth.getText());
            }
        });
        JTextField tfLength = new JTextField(10);
        tfLength.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                length = Double.parseDouble(tfLength.getText());
            }
        });
        JTextField tfDepth = new JTextField(10);
        tfDepth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                depth = Double.parseDouble(tfDepth.getText());
            }
        });
        JTextField tfDensity = new JTextField(8);
        tfDensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                density = Double.parseDouble(tfDensity.getText());
            }
        });
        JTextField tfCase = new JTextField(8);
        tfCase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                caseVolume = Double.parseDouble(tfCase.getText());
            }
        });
        
        String measureWidth[] = {"мм","см","м"};
        String measureLength[] = {"м","см","мм"};
        String measureDepth[] = {"мм","см","м"};
        String measureDensity[] = {"г/см3","кг/см3"};
        String measureCase[] = {"г", "кг", "мл","л"};
        
        JComboBox cbMeasureWidth = new JComboBox(measureWidth);
        cbMeasureWidth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                measureValueWidth = (String) cbMeasureWidth.getSelectedItem();
            }
        });
        JComboBox cbMeasureLength = new JComboBox(measureLength);
        cbMeasureLength.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                measureValueLength = (String) cbMeasureLength.getSelectedItem();               
            }
        });
        JComboBox cbMeasureDepth = new JComboBox(measureDepth);
        cbMeasureDepth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                measureValueDepth = (String) cbMeasureDepth.getSelectedItem();
            }
        });
        JComboBox cbMeasureDensity = new JComboBox(measureDensity);
        cbMeasureDensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                measureValueDensity = (String) cbMeasureDensity.getSelectedItem();
            }
        });
        JComboBox cbMeasureCase = new JComboBox(measureCase);
        cbMeasureCase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                measureValueCase = (String) cbMeasureCase.getSelectedItem();
            }
        });
        
        JButton btnCalc = new JButton("Расчитать");
        btnCalc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                Calc cal = new Calc(
                        measureValueWidth, measureValueLength, measureValueDepth, measureValueDensity, measureValueCase,
                        width,length,depth,density,caseVolume);
                
                taResultNumberOf.setText(""+cal.totalNumberOf());                           
                taResultWeight.setText(""+cal.totalWeight());                           
            }
        });
        JButton btnDiscard = new JButton("Сбросить");
        btnDiscard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                width=0.0;
                length=0.0;
                depth=0.0;
                density=0.0;
                caseVolume=0.0;
                resultWeight=0.0;
                resultTotal=0.0;
                tfWidth.setText("");
                tfLength.setText("");
                tfDepth.setText("");
                tfDensity.setText("");
                tfCase.setText("");
                taResultNumberOf.setText("");
                taResultWeight.setText("");
            }
        });
        JButton btnClose = new JButton(" Закрыть ");
        btnClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int response = JOptionPane.showConfirmDialog(root, "Закрыть приложение?", "Выход", JOptionPane.YES_NO_OPTION);
                if(response==JOptionPane.YES_OPTION)
                    //root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    System.exit(0);
            }
        });
        
        Box box0 = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        Box box4 = Box.createHorizontalBox();
        Box box5 = Box.createHorizontalBox();
        Box box6 = Box.createVerticalBox();
        Box box7 = Box.createHorizontalBox();
        Box box8 = Box.createHorizontalBox();
        Box box9 = Box.createHorizontalBox();
        box0.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box7.setBorder(BorderFactory.createEmptyBorder(10, 10, 1, 10));
        box8.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
        box9.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        box0.add(jlAdhesion);
        
        box1.add(jlWidth);
        box1.add(Box.createRigidArea( new Dimension(5, 0) ));
        box1.add(cbMeasureWidth);
        box1.add(Box.createRigidArea( new Dimension(5, 0) ));
        box1.add(tfWidth);
        
        box2.add(jlLength);
        box2.add(Box.createRigidArea( new Dimension(5, 0) ));
        box2.add(cbMeasureLength);
        box2.add(Box.createRigidArea( new Dimension(5, 0) ));
        box2.add(tfLength);
        
        box3.add(jlDepth);
        box3.add(Box.createRigidArea( new Dimension(5, 0) ));
        box3.add(cbMeasureDepth);
        box3.add(Box.createRigidArea( new Dimension(5, 0) ));
        box3.add(tfDepth);
        
        box4.add(jlDensity);
        box4.add(Box.createRigidArea( new Dimension(5, 0) ));
        box4.add(cbMeasureDensity);
        box4.add(Box.createRigidArea( new Dimension(5, 0) ));
        box4.add(tfDensity);
        
        box5.add(jlCase);
        box5.add(Box.createRigidArea( new Dimension(5, 0) ));
        box5.add(cbMeasureCase);
        box5.add(Box.createRigidArea( new Dimension(5, 0) ));
        box5.add(tfCase);
        
        box6.add(btnCalc);
        box6.add(Box.createRigidArea( new Dimension(0, 5) ));
        
        box7.add(jlNumberOf);
        box7.add(Box.createRigidArea( new Dimension(5, 0) ));
        box7.add(taResultNumberOf);
        
        box8.add(jlWeight);
        box8.add(Box.createRigidArea( new Dimension(5, 0) ));
        box8.add(taResultWeight);
        
        box9.add(btnDiscard);
        box9.add(Box.createRigidArea( new Dimension(30, 0) ));
        box9.add(btnClose);
        
        root.add(box0);
        root.add(box2);
        root.add(box1);
        root.add(box3);
        root.add(box4);
        root.add(box5);
        root.add(box6);
        root.add(box7);
        root.add(box8);
        root.add(box9);
        root.setVisible(true);        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new AdhesionCalc();
            }
        });
    }
    
}
