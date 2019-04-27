package vFooD;

import java.awt.EventQueue;
import model.Compra;
import model.Produto;
import model.Restaurante;
import model.Usuario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoSupplier;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Comprar extends JFrame {

	@SuppressWarnings("rawtypes")
	private JComboBox cbProduto;
	@SuppressWarnings("rawtypes")
	private JComboBox cbComprador;

	private JPanel contentPane;
	private Compra compra = new Compra();
	private JButton btnFinalizarCompra;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRestaurantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comprar frame = new Comprar();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Comprar() {
		setTitle("Comprar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbProduto = new JComboBox();
		cbProduto.setBounds(251, 109, 148, 20);

		Object[] items = {};
		DefaultComboBoxModel model = new DefaultComboBoxModel(items);
		cbProduto.setModel(model);

		cbRestaurantes = new JComboBox();
		cbRestaurantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProdutos();
			}
		});
		cbRestaurantes.setBounds(251, 78, 148, 20);
		contentPane.add(cbRestaurantes);

		items = DaoSupplier.getDaoRestaurante().findAll().toArray();
		DefaultComboBoxModel modelRest = new DefaultComboBoxModel(items);
		cbRestaurantes.setModel(modelRest);

		contentPane.add(cbProduto);
		JLabel txtpnEscolhaOProduto = new JLabel();
		txtpnEscolhaOProduto.setBounds(20, 109, 112, 20);
		txtpnEscolhaOProduto.setText("Escolha o produto:");
		contentPane.add(txtpnEscolhaOProduto);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprarProduto();
			}
		});
		btnAdicionar.setBounds(310, 140, 89, 23);
		contentPane.add(btnAdicionar);

		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarCompra();
			}
		});
		btnFinalizarCompra.setBounds(251, 216, 148, 23);
		contentPane.add(btnFinalizarCompra);

		JLabel lblSelecionarRestaurante = new JLabel("Selecionar Restaurante");
		lblSelecionarRestaurante.setBounds(20, 81, 135, 14);
		contentPane.add(lblSelecionarRestaurante);

		cbComprador = new JComboBox();
		cbComprador.setBounds(251, 47, 148, 20);
		Object[] comprador = DaoSupplier.getDaoUsuario().findAll().toArray();
		DefaultComboBoxModel modelComprador = new DefaultComboBoxModel(comprador);
		cbComprador.setModel(modelComprador);
		contentPane.add(cbComprador);

		JLabel lblSelecionarComprador = new JLabel("Selecionar Comprador");
		lblSelecionarComprador.setBounds(20, 50, 112, 14);
		contentPane.add(lblSelecionarComprador);
	}
	private void finalizarCompra() {
		if (compra.getProdutos().size() > 0) {
			compra.setIdUsuario((Usuario) cbComprador.getSelectedItem());
			compra.setIdRestaurante((Restaurante) cbRestaurantes.getSelectedItem());
			DaoSupplier.getDaoCompra().insert(compra);
			JOptionPane.showMessageDialog(this, "Compra finalizada" + compra.getValorTotal());
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Nenhum Produto Selecionado");
		}
	}
	@SuppressWarnings("unchecked")
	private void loadProdutos() {
		Restaurante rest = (Restaurante) cbRestaurantes.getSelectedItem();
		rest = DaoSupplier.getDaoRestaurante().findById(rest.getId());
		Object[] items = rest.getProdutos().toArray();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel model = new DefaultComboBoxModel(items);
		cbProduto.setModel(model);
		compra.getProdutos().clear();
	}
	private void comprarProduto() {
		compra.getProdutos().add((Produto) cbProduto.getSelectedItem());
		JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho");
	}
}
