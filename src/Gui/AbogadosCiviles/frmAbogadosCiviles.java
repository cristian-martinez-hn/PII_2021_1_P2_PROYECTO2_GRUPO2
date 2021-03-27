package Gui.AbogadosCiviles;

import Gui.AbogadoLaboralista.frmAbogadoLaboralista;
import Recursos.Clases.Civiles;
import Recursos.Clases.Laboralistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAbogadosCiviles {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JRadioButton rbtManutenciones;
    private JRadioButton rbtIncapacitaciones;
    private JRadioButton rbtHerenciasSucesiones;
    private JRadioButton rbtReclamoDeudas;
    private JTextArea txaLista;
    private JButton btnRegistrar;

    public frmAbogadosCiviles() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Civiles abogadosciviles = new Civiles();
                    abogadosciviles.setManutenciones(rbtManutenciones.getText());
                    abogadosciviles.setIncapacitaciones(rbtIncapacitaciones.getText());
                    abogadosciviles.setHerenciasSucesiones(rbtHerenciasSucesiones.getText());
                    abogadosciviles.setReclamoDeudas(rbtReclamoDeudas.getText());
                    //String respuesta = new ClienteNegocio().Insertar(cliente);
                    JOptionPane.showMessageDialog(null, "Guardado", "exito", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("AbogadosCiviles");
        frame1.setContentPane(new frmAbogadosCiviles().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
