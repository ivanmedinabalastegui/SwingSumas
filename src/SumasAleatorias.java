import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SumasAleatorias {
    int intentos, aciertos, errores, Suma = 0;
    JFrame Ventana;
    JLabel Etiqueta1, Etiqueta2, Etiqueta3, Etiqueta4, Etiqueta5, Etiqueta6;
    JTextField valor1, valor2, resultado;
    JButton boton1, boton2, boton3;

    public SumasAleatorias() {
        Ventana = new JFrame();
        Etiqueta1 = new JLabel("Número 1: ");
        Etiqueta1.setBounds(30, 12, 65, 30);
        Ventana.add(Etiqueta1);
        Etiqueta2 = new JLabel("Número 2: ");
        Etiqueta2.setBounds(198, 12, 65, 30);
        Ventana.add(Etiqueta2);
        Etiqueta3 = new JLabel("Resultado: ");
        Etiqueta3.setBounds(373, 12, 65, 30);
        Ventana.add(Etiqueta3);

        valor1 = new JTextField();
        valor1.setBounds(93, 15, 100, 25);
        valor1.setHorizontalAlignment(JTextField.RIGHT);
        Ventana.add(valor1);
        valor2 = new JTextField();
        valor2.setBounds(261, 15, 100, 25);
        valor2.setHorizontalAlignment(JTextField.RIGHT);
        Ventana.add(valor2);
        resultado = new JTextField();
        resultado.setBounds(446, 15, 100, 25);
        resultado.setHorizontalAlignment(JTextField.RIGHT);
        Ventana.add(resultado);

        boton1 = new JButton("Generar");
        boton1.setBounds(135, 70, 90, 30);
        boton1.addActionListener(this::actionPerformed);
        Ventana.add(boton1);
        boton2 = new JButton("Verificar");
        boton2.setBounds(245, 70, 90, 30);
        boton2.addActionListener(this::actionPerformed);
        Ventana.add(boton2);
        boton3 = new JButton("Salir");
        boton3.setBounds(355, 70, 70, 30);
        boton3.addActionListener(this::actionPerformed);
        Ventana.add(boton3);

        Etiqueta4 = new JLabel("Intentos:        " + intentos);
        Etiqueta4.setBounds(130, 125, 100, 30);
        Ventana.add(Etiqueta4);
        Etiqueta5 = new JLabel("Acertados:       " + aciertos);
        Etiqueta5.setBounds(230, 125, 100, 30);
        Ventana.add(Etiqueta5);
        Etiqueta6 = new JLabel("Fallados:        " + errores);
        Etiqueta6.setBounds(335, 125, 100, 30);
        Ventana.add(Etiqueta6);
        Ventana.setTitle("Adivina el resultado de la suma");
        Ventana.setSize(600, 250);
        Ventana.setLayout(null);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("pinguino.jpg");
        Ventana.setIconImage(icono);
        Ventana.setBounds(806, 310, 590, 205);
        Ventana.setDefaultCloseOperation(3);
        Ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boton1) {
            Random Aleatorio = new Random();
            int PNum = Aleatorio.nextInt(1000);
            int SNum = Aleatorio.nextInt(1000);
            Suma = PNum + SNum;
            String PNum2= String.valueOf(PNum);
            String SNum2= String.valueOf(SNum);
            valor1.setText(PNum2);
            valor2.setText(SNum2);
        } else if(e.getSource() == boton2){
            String cadena;
            cadena = JOptionPane.showInputDialog("Teclea tu resultado");
            resultado.setText(cadena);
            if(Integer.parseInt(cadena) == Suma){
                intentos++;
                aciertos++;
                Etiqueta4.setText("Intentos:        " + intentos);
                Etiqueta5.setText("Acertados:       " + aciertos);
            } else if(Integer.parseInt(cadena) != Suma) {
                intentos++;
                errores++;
                Etiqueta4.setText("Intentos:        " + intentos);
                Etiqueta6.setText("Fallados:        " + errores);
            }
        } else if(e.getSource() == boton3){
            Ventana.dispose();
        }
    }
}
