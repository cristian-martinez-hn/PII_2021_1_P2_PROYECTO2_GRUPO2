package Gui.Cliente;

import Recursos.Clases.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frmCliente {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JLabel lblNombre;
    private JLabel lblFechaNacimiento;
    private JTextField textNombre;
    private JTextField textFechaNacimiento;
    private JTextField textId;
    private JLabel lblId;
    private JPanel jpaSuperior;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnRegistrar;
    private JPanel JpaInferior;
    private JTable tblDatos;
    private JScrollPane sclDatos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public frmCliente() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cliente cliente = new Cliente();
                    cliente.setId(Long.parseLong(textId.getText()));
                    cliente.setNombre(textNombre.getText());
                    cliente.setFechaNacimiento(ConvertirFormatoTextoFecha(textFechaNacimiento.getText()));
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
        JFrame frame1 = new JFrame("Cliente");
        frame1.setContentPane(new frmCliente().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
