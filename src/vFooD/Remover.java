package vFooD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoSupplier;
import model.Compra;
import model.Produto;
import model.Restaurante;
import model.Usuario;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Remover extends JFrame {
	@SuppressWarnings("rawtypes")
	private JComboBox cbRemoveUser;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRemoveRest;
	@SuppressWarnings({ "unused", "rawtypes" })
	private JComboBox cbRemoveProduto;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRemoveCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remover frame = new Remover();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Remover() {
		setTitle("Remover");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* remover usuario */
		cbRemoveUser = new JComboBox();
		cbRemoveUser.setBounds(213, 113, 174, 20);
		Object[] usuarios = DaoSupplier.getDaoUsuario().findAll().toArray();
		DefaultComboBoxModel modelUser = new DefaultComboBoxModel(usuarios);
		cbRemoveUser.setModel(modelUser);
		contentPane.add(cbRemoveUser);
		JTextPane txtpnRemoverUsuario = new JTextPane();
		txtpnRemoverUsuario.setText("Remover usuario");
		txtpnRemoverUsuario.setBounds(10, 113, 125, 20);
		contentPane.add(txtpnRemoverUsuario);
		JButton btnRemoverUsuario = new JButton("Remover");
		btnRemoverUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = (Usuario) cbRemoveUser.getSelectedItem();
				DaoSupplier.getDaoUsuario().update(user);
				JOptionPane.showMessageDialog(null, "Usuario removido");
				cbRemoveUser.setModel(loadComboUsuarios());
			}
		});
		btnRemoverUsuario.setBounds(459, 112, 89, 23);
		contentPane.add(btnRemoverUsuario);

		/* REMOVER RESTAURANTE */
		JTextPane txtpnRemoverRestaurante = new JTextPane();
		txtpnRemoverRestaurante.setText("Remover restaurante");
		txtpnRemoverRestaurante.setBounds(10, 159, 125, 20);
		contentPane.add(txtpnRemoverRestaurante);
		cbRemoveRest = new JComboBox();
		cbRemoveRest.setBounds(213, 159, 174, 20);
		cbRemoveRest.setModel(loadComboRestaurantes());
		contentPane.add(cbRemoveRest);
		JButton btnRemoverRestaurante = new JButton("Remover");
		btnRemoverRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Restaurante rest = (Restaurante) cbRemoveRest.getSelectedItem();
				DaoSupplier.getDaoRestaurante().update(rest);
				JOptionPane.showMessageDialog(null, "Restaurante removido");
				cbRemoveRest.setModel(loadComboRestaurantes());
			}
		});
		btnRemoverRestaurante.setBounds(459, 158, 89, 23);
		contentPane.add(btnRemoverRestaurante);

		// produto
		JComboBox cbRemoveProduto = new JComboBox();
		cbRemoveProduto.setBounds(213, 31, 174, 20);
		cbRemoveProduto.setModel(loadComboProdutos());
		contentPane.add(cbRemoveProduto);
		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = (Produto) cbRemoveProduto.getSelectedItem();
				DaoSupplier.getDaoProduto().update(produto);
				JOptionPane.showMessageDialog(null, "Produto removido");
				cbRemoveProduto.setModel(loadComboProdutos());
			}
		});
		btnRemoverProduto.setBounds(459, 30, 89, 23);
		contentPane.add(btnRemoverProduto);
		JTextPane txtpnRemoverProduto = new JTextPane();
		txtpnRemoverProduto.setText("Remover produto");
		txtpnRemoverProduto.setBounds(10, 31, 107, 20);
		contentPane.add(txtpnRemoverProduto);

		// compra
		JTextPane txtpnRemoverCompra = new JTextPane();
		txtpnRemoverCompra.setText("Remover compra");
		txtpnRemoverCompra.setBounds(10, 76, 125, 20);
		contentPane.add(txtpnRemoverCompra);
		JButton btnRemoveCompra = new JButton("Remover");

		btnRemoveCompra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Compra compra = (Compra) cbRemoveCompra.getSelectedItem();
				DaoSupplier.getDaoCompra().update(compra);
				JOptionPane.showMessageDialog(null, "Compra removida");
				cbRemoveCompra.setModel(loadComboCompras());
			}
		});

		btnRemoveCompra.setBounds(459, 73, 89, 23);
		contentPane.add(btnRemoveCompra);
		cbRemoveCompra = new JComboBox();
		cbRemoveCompra.setBounds(213, 76, 174, 20);
		cbRemoveCompra.setModel(loadComboCompras());
		contentPane.add(cbRemoveCompra);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel loadComboCompras() {
		Object[] compras = DaoSupplier.getDaoCompra().findAll().toArray();
		DefaultComboBoxModel model = new DefaultComboBoxModel(compras);
		return model;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel loadComboProdutos() {
		Object[] produtos = DaoSupplier.getDaoProduto().findAll().toArray();
		DefaultComboBoxModel modelProd = new DefaultComboBoxModel(produtos);
		return modelProd;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel loadComboRestaurantes() {
		Object[] restaurantes = DaoSupplier.getDaoRestaurante().findAll().toArray();
		DefaultComboBoxModel modelRest = new DefaultComboBoxModel(restaurantes);
		return modelRest;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel loadComboUsuarios() {
		Object[] usuarios = DaoSupplier.getDaoUsuario().findAll().toArray();
		DefaultComboBoxModel modelUser = new DefaultComboBoxModel(usuarios);
		return modelUser;
	}
}
