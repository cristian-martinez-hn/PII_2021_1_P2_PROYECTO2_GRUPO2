package Gui.Casos;

import Recursos.Clases.Casos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmCasos {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JRadioButton rbtAbogadoLaboralista;
    private JRadioButton rbtAbogadoFamiliar;
    private JRadioButton rbtAbogadoPenalista;
    private JRadioButton rbtAbogadoCiviles;
    private JRadioButton rbtAbogadoAdministrativo;
    private JTextArea txaLista;
    private JButton btnRegistrar;

    public frmCasos() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Casos casos = new Casos();
                    casos.setAbogadoLaboralista(rbtAbogadoLaboralista.getText());
                    casos.setAbogadoFamiliar(rbtAbogadoFamiliar.getText());
                    casos.setAbogadoPenalista(rbtAbogadoPenalista.getText());
                    casos.setAbogadoCiviles(rbtAbogadoCiviles.getText());
                    casos.setAbogadoAdministrativo(rbtAbogadoAdministrativo.getText());
                    //String respuesta = new CasosNegocio().Insertar(casos);
                    JOptionPane.showMessageDialog(null, "Guardado", "exito", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Casos");
        frame1.setContentPane(new frmCasos().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
