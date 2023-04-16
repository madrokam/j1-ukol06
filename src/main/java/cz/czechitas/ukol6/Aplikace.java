package cz.czechitas.ukol6;

import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    //Nasledujici zakomentovane radky jsou pro pripad pouziti TextFieldu
    //private JTextField husyField;
    //private JTextField kraliciField;
    private JLabel husyLabel;
    private JTextField hlavyField;
    private JLabel hlavyLabel;
    private JTextField nohyField;
    private JLabel nohyLabel;
    private JLabel kraliciLabel;
    private JButton vypocitatButton;
    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        //Nasledujici zakomentovane radky jsou pro pripad pouziti TextFieldu
        //husyField = new JTextField();
        //husyLabel.setLabelFor(husyField);
        //husyField.setHorizontalAlignment(JTextField.TRAILING);

        //Maximalni hodnota neni umyslne stanovena
        SpinnerModel valueHusy = new SpinnerNumberModel(0,0,null,1);
        husySpinner = new JSpinner(valueHusy);
        husyLabel = new JLabel("Husy:");
        husyLabel.setDisplayedMnemonic('H');
        add(husyLabel);
        add(husySpinner);

        //Nasledujici zakomentovane radky jsou pro pripad pouziti TextFieldu
        //kraliciField = new JTextField();
        //kraliciLabel.setLabelFor(kraliciField);
        //kraliciField.setHorizontalAlignment(JTextField.TRAILING);

        //Maximalni hodnota neni umyslne stanovena
        SpinnerModel valueKralici = new SpinnerNumberModel(0,0,null,1);
        kraliciSpinner = new JSpinner(valueKralici);
        kraliciLabel = new JLabel("Králíci:");
        kraliciLabel.setDisplayedMnemonic('K');
        add(kraliciLabel);
        add(kraliciSpinner);

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"center, span");

        hlavyField = new JTextField();
        hlavyLabel = new JLabel("Počet hlav:");
        hlavyLabel.setDisplayedMnemonic('H');
        hlavyLabel.setLabelFor(hlavyField);
        hlavyField.setHorizontalAlignment(JTextField.TRAILING);
        hlavyField.setEditable(false);
        add(hlavyLabel);
        add(hlavyField);

        nohyField = new JTextField();
        nohyLabel = new JLabel("Počet nohou:");
        nohyLabel.setDisplayedMnemonic('K');
        nohyLabel.setLabelFor(nohyField);
        nohyField.setHorizontalAlignment(JTextField.TRAILING);
        nohyField.setEditable(false);
        add(nohyLabel);
        add(nohyField);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);

    }



    private void handleVypocitat(ActionEvent actionEvent) {
        //Nasledujici zakomentovane radky jsou pro pripad pouziti TextFieldu
        //String husy = husyField.getText();
        //String kralici = kraliciField.getText();
        //int pocetHus = Integer.parseInt(husy);
        //int pocetKraliku = Integer.parseInt(kralici);

        //Neplatné hodnoty zadané do JTextFieldu nejsou řešeny
        int pocetHus = (Integer) husySpinner.getValue();
        int pocetKraliku = (Integer) kraliciSpinner.getValue();

        final int pocetNohouHusa=2;
        final int pocetNohouKralik=4;

        int pocetHlav=pocetHus+pocetKraliku;
        int pocetNohou=pocetHus*pocetNohouHusa+pocetKraliku*pocetNohouKralik;

        hlavyField.setText(Integer.toString(pocetHlav));
        nohyField.setText(Integer.toString(pocetNohou));
    }
}
