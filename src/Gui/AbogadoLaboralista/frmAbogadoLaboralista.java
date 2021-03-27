package Gui.AbogadoLaboralista;

import Gui.Abogados.frmAbogados;
import Recursos.Clases.Abogados;
import Recursos.Clases.Laboralistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;

public class frmAbogadoLaboralista {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JRadioButton rbtDespidos;
    private JRadioButton rbtAccidentesDeTrabajo;
    private JRadioButton rbtImpago;
    private JRadioButton rbtAcosoLaboralMobbing;
    private JRadioButton rbtNegociacionConveniosColectivos;
    private JRadioButton rbtAsesoramientoDerechoLaboral;
    private JTextArea txaLista;
    private JButton btnRegistrar;

    public frmAbogadoLaboralista() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Laboralistas abogadolaboralista = new Laboralistas();
                    abogadolaboralista.setDespidos(rbtDespidos.getText());
                    abogadolaboralista.setAccidentesDeTrabajo(rbtAccidentesDeTrabajo.getText());
                    abogadolaboralista.setImpago(rbtImpago.getText());
                    abogadolaboralista.setAcosoLaboralMobbing(rbtAcosoLaboralMobbing.getText());
                    abogadolaboralista.setNegociacionConveniosColectivos(rbtNegociacionConveniosColectivos.getText());
                    abogadolaboralista.setAsesoramientoDerechoLaboral(rbtAsesoramientoDerechoLaboral.getText());
                    //String respuesta = new ClienteNegocio().Insertar(cliente);
                    JOptionPane.showMessageDialog(null, "Guardado", "exito", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("AbogadoLaboralista");
        frame1.setContentPane(new frmAbogadoLaboralista().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
