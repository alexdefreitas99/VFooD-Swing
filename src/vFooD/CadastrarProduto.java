package vFooD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.DaoSupplier;
import model.Categoria;
import model.Produto;
import model.Restaurante;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class CadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textProdutoNome;
	private JTextField textProdutoPreco;
	private JTextField textProdutoPreparo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbCategoria;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRestaurante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProduto frame = new CadastrarProduto();
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
	public CadastrarProduto() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Produtos do Restaurante");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel txtpnNome = new JLabel();
		txtpnNome.setText("Nome:");
		txtpnNome.setBounds(10, 11, 93, 20);
		contentPane.add(txtpnNome);

		JLabel txtpnPreo = new JLabel();
		txtpnPreo.setText("Pre\u00E7o:");
		txtpnPreo.setBounds(10, 42, 93, 20);
		contentPane.add(txtpnPreo);

		JLabel txtpnTempoDePreparo = new JLabel();
		txtpnTempoDePreparo.setText("Tempo de preparo:");
		txtpnTempoDePreparo.setBounds(10, 73, 110, 20);
		contentPane.add(txtpnTempoDePreparo);

		JLabel txtpnId = new JLabel();
		txtpnId.setText("Restaurante:");
		txtpnId.setBounds(10, 167, 93, 20);
		contentPane.add(txtpnId);

		JLabel txtpnCategoria = new JLabel();
		txtpnCategoria.setText("Categoria:");
		txtpnCategoria.setBounds(10, 123, 93, 20);
		contentPane.add(txtpnCategoria);

		textProdutoNome = new JTextField();
		textProdutoNome.setBounds(283, 11, 86, 20);
		contentPane.add(textProdutoNome);
		textProdutoNome.setColumns(10);

		textProdutoPreco = new JTextField();
		textProdutoPreco.setColumns(10);
		textProdutoPreco.setBounds(283, 42, 86, 20);
		contentPane.add(textProdutoPreco);

		textProdutoPreparo = new JTextField();
		textProdutoPreparo.setColumns(10);
		textProdutoPreparo.setBounds(283, 73, 86, 20);
		contentPane.add(textProdutoPreparo);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarProduto(textProdutoNome.getText(), Double.parseDouble(textProdutoPreco.getText()),
						Double.parseDouble(textProdutoPreparo.getText()));
			}
		});
		btnCadastrarProduto.setBounds(254, 230, 147, 23);
		contentPane.add(btnCadastrarProduto);

		cbCategoria = new JComboBox();
		cbCategoria.setBounds(254, 123, 147, 20);

		Object[] items = DaoSupplier.getDaoCategoria().findAll().toArray();
		DefaultComboBoxModel model = new DefaultComboBoxModel(items);
		cbCategoria.setModel(model);
		contentPane.add(cbCategoria);

		cbRestaurante = new JComboBox();
		cbRestaurante.setBounds(254, 167, 147, 20);
		Object[] rest = DaoSupplier.getDaoRestaurante().findAll().toArray();
		DefaultComboBoxModel modelRest = new DefaultComboBoxModel(rest);
		cbRestaurante.setModel(modelRest);
		contentPane.add(cbRestaurante);

	}

	public void salvarProduto(String nome, Double preco, Double preparo) {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setTempoPreparo(preparo);
		produto.setRestaurante((Restaurante) cbRestaurante.getSelectedItem());
		produto.setCategoria((Categoria) cbCategoria.getSelectedItem());

		DaoSupplier.getDaoProduto().insert(produto);
		JOptionPane.showMessageDialog(this, "Produto Cadastrado");
	}
}
