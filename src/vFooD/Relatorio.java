package vFooD;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.DaoSupplier;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Relatorio extends JFrame {
	private JTextField textField;
	@SuppressWarnings("unused")
	private String teste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public Relatorio() {
		setTitle("Relatorio");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 232);
		getContentPane().setLayout(null);

		JButton btnListarRest = new JButton("Listar quantas vezes o restaurante foi escolhido");
		btnListarRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"O restaurante foi escolhido " +
						DaoSupplier.getDaoCompra().countById((Integer.parseInt(textField.getText()))) + " vezes");
			}
		});
		btnListarRest.setBounds(162, 80, 340, 23);
		getContentPane().add(btnListarRest);

		JButton btnListarProd = new JButton("Produtos mais consumidos");
		btnListarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				for (Produto produto : DaoSupplier.getDaoCompra().countByIdProd()) {
					msg += produto.getNome() + "\n";
				}

				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnListarProd.setBounds(80, 140, 340, 23);
		getContentPane().add(btnListarProd);
		Object[] items = DaoSupplier.getDaoRestaurante().findAll().toArray();
		DefaultComboBoxModel model = new DefaultComboBoxModel(items);

		JButton btnListarRestaurantes = new JButton("Listar restaurantes");
		btnListarRestaurantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, DaoSupplier.getDaoRestaurante().findAll().toArray());
			}
		});
		btnListarRestaurantes.setBounds(162, 24, 151, 23);
		getContentPane().add(btnListarRestaurantes);

		textField = new JTextField();
		textField.setBounds(55, 81, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 84, 60, 14);
		getContentPane().add(lblId);
	}
}
