package Gui.Abogados;

import Gui.Cliente.frmCliente;
import Recursos.Clases.Abogados;
import Recursos.Clases.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frmAbogados {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel JpaInferior;
    private JLabel LblDomicilio;
    private JLabel LblId;
    private JLabel LblNombre;
    private JLabel LblFechaNacimiento;
    private JTextField textId;
    private JTextField textNombre;
    private JTextField textFechaNacimiento;
    private JTextField textDomicilio;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable TblDatos;
    private JScrollPane SclDatos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public frmAbogados() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Abogados abogado = new Abogados();
                    abogado.setId(Long.parseLong(textId.getText()));
                    abogado.setNombre(textNombre.getText());
                    abogado.setFechaNacimiento(ConvertirFormatoTextoFecha(textFechaNacimiento.getText()));
                    abogado.setDomicilio(textDomicilio.getText());
                    //String respuesta = new ClienteNegocio().Insertar(cliente);
                    JOptionPane.showMessageDialog(null, "Guardado", "exito", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        textFechaNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c>='0')&&(c>='9')||(c== KeyEvent.VK_BACK_SPACE)||(c== KeyEvent.VK_DELETE)||(c== KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese una fecha correcta");
                    e.consume();
                }
            }
        });
    }
    private Date ConvertirFormatoTextoFecha(String textoFecha){
        Date Fecha =  null;
        try {
            Fecha = sdf.parse(textoFecha);
        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        return Fecha;
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Abogado");
        frame1.setContentPane(new frmAbogados().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
