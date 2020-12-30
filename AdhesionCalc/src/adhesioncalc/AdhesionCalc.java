package adhesioncalc;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author chobus
 */
public class AdhesionCalc {

    AdhesionCalc(){
        JFrame root = new JFrame("BoxLayout Demo");
        root.setLayout(new FlowLayout());
        root.setSize(300,510);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Dimension btnDim = new Dimension(100,25);
        
        JButton btnCalc = new JButton("Расчитать");
        JButton btnDiscard = new JButton("Сбросить");
        JButton btnClose = new JButton("Закрыть");
        
        JTextArea taResultNumberOf = new JTextArea(1,7);
        JTextArea taResultWeight = new JTextArea(1,10);
        
        JLabel jlAdhesion = new JLabel("<ADHESION>");        
        JLabel jlWidth = new JLabel("Ширина:");
        //jlWidth.setMinimumSize(btnDim);
        //jlWidth.setMaximumSize(btnDim);
        JLabel jlLength = new JLabel("Длина:    ");
        //jlLength.setMinimumSize(btnDim);
        //jlLength.setMaximumSize(btnDim);
        JLabel jlDepth = new JLabel("Глубина:");
        //jlDepth.setMinimumSize(btnDim);
        //jlDepth.setMaximumSize(btnDim);
        JLabel jlDensity = new JLabel("Плотность:");
        //jlDensity.setMinimumSize(btnDim);
        //jlDensity.setMaximumSize(btnDim);
        JLabel jlCase = new JLabel("Объём тары:");
        //jlCase.setMinimumSize(btnDim);
        //jlCase.setMaximumSize(btnDim);
        JLabel jlWeight = new JLabel("Расход, кг:   ");
        //jlWeight.setMinimumSize(btnDim);
        //jlWeight.setMaximumSize(btnDim);
        JLabel jlNumberOf = new JLabel("Количество, шт:");
        //jlWidth.setMinimumSize(btnDim);
        //jlWidth.setMaximumSize(btnDim);
        
        JTextField tfWidth = new JTextField(10);
        JTextField tfLength = new JTextField(10);
        JTextField tfDepth = new JTextField(10);
        JTextField tfDensity = new JTextField(8);
        JTextField tfCase = new JTextField(8);
        
        String measureWidth[] = {" m "," cm "," mm "};
        String measureLength[] = {" m "," cm "," mm "};
        String measureDepth[] = {" m "," cm "," mm "};
        String measureDensity[] = {"g/cm2","kg/cm2"};
        String measureCase[] = {" liter ","ml","kg","g"};
        JComboBox cbMeasureWidth = new JComboBox(measureWidth);
        JComboBox cbMeasureLength = new JComboBox(measureLength);
        JComboBox cbMeasureDepth = new JComboBox(measureDepth);
        JComboBox cbMeasureDensity = new JComboBox(measureDensity);
        JComboBox cbMeasureCase = new JComboBox(measureCase);
        
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
        root.add(box1);
        root.add(box2);
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
