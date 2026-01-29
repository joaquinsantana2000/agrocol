package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.Modelo.Formulario;
import com.Modelo.Usuario;

import Controllers.FormularioController;
import Controllers.UsuarioController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmListadoFormDeExperto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JComboBox<Usuario>  comboBox;

	/**
	 * Create the frame.
	 */
	public FrmListadoFormDeExperto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Listado de actividades de usuarios expertos");
		setVisible(true);
		setBounds(100, 100, 879, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaRol.class.getResource("/Img/Logo_SL.png")));

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// cargarListadoActividadesCampo();
			}
		});
		comboBox.setBounds(323, 129, 184, 22);
		contentPane.add(comboBox);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 843, 477);
		contentPane.add(scrollPane);
		setResizable(false);
		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Listado de Actividades de Campo de usuario experto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(179, 82, 498, 36);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(FrmListadoFormDeExperto.class.getResource("/Img/FondoGenerico.png")));
		lblNewLabel_1.setBounds(0, 0, 863, 645);
		contentPane.add(lblNewLabel_1);

		for (Usuario objUser : UsuarioController.listarExpertos()) {
			comboBox.addItem(objUser);
		}

		cargarListadoActividadesCampo();
	}

	private void cargarListadoActividadesCampo() {

		DefaultTableModel modelo = new DefaultTableModel();

		final String[] columnNames = { "id Formulario", "Nombre", "Resumen", "Equipamiento", "Metodo Muestreo",
				"Tipo Muestreo", "Usuario", "Departamento", "Localidad", "Zona" };

		for (int column = 0; column < columnNames.length; column++) {
			modelo.addColumn(columnNames[column]);
		}

		Object[] fila = new Object[columnNames.length];

		
		if (comboBox.getSelectedItem() != null) {
			Usuario user = (Usuario) comboBox.getSelectedItem();
			for (Formulario objForm : FormularioController.ListadoDeUsuarioExperto(user)) {
				fila[0] = objForm.getIdForm();
				fila[1] = objForm.getNombre();
				fila[2] = objForm.getResumen();
				fila[3] = objForm.getEquipamiento().getNombre();
				fila[4] = objForm.getMetodoMuestreo().getNombre();
				fila[5] = objForm.getTipoMuestreo().getNombre();
				fila[6] = objForm.getUsuario().getNombre();
				fila[7] = objForm.getZona().getLocalidad().getDepartamento().getNombre();
				fila[8] = objForm.getZona().getLocalidad().getNombre();
				fila[9] = objForm.getZona().getNombre();
				modelo.addRow(fila);
			}
		}

		table.setModel(modelo);
	}
}
