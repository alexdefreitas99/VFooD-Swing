package vFooD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.DaoSupplier;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Restaurante;
import model.Usuario;
import model.Categoria;
import model.Perfil;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Cadastrar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnCadastroProdutos;
	private JTextField txtNome;
	private JTextField textProdutoCategoria;
	private JTextField textRestauranteNome;
	private JTextField textRestauranteEmail;
	private JTextField textRestauranteTelefone;
	private JTextField textRestauranteHorarioAbertura;
	private JTextField textRestauranteTmpEntrega;
	private JTextField textRestauranteDesc;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPerfils;
	private JTextField textHorarioFechamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
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
	public Cadastrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alex.Freitas\\Downloads\\Downloads novo\\ifood.jpg"));
		setTitle("Janela de cadastros");
		setBounds(100, 100, 619, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Usu\u00E1rios", null, panel, null);
		panel.setLayout(null);

		JLabel txtpnNome = new JLabel();
		txtpnNome.setBackground(Color.WHITE);
		txtpnNome.setText("Nome:");
		txtpnNome.setBounds(10, 87, 37, 20);
		panel.add(txtpnNome);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					salvarUsuario(txtNome.getText());
				}
			}
		});
		txtNome.setToolTipText("Digite o nome aqui");
		txtNome.setBounds(124, 87, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel txtpnPerfil = new JLabel();
		txtpnPerfil.setText("Selecione o perfil do usu\u00E1rio:");
		txtpnPerfil.setBounds(10, 208, 243, 20);
		panel.add(txtpnPerfil);

		JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarUsuario(txtNome.getText());
			}
		});
		btnCadastrarUsuario.setBounds(384, 86, 139, 23);
		panel.add(btnCadastrarUsuario);

		JLabel txtpnAdmin = new JLabel();
		txtpnAdmin.setText("1 - admin");
		txtpnAdmin.setBounds(53, 160, 71, -23);
		panel.add(txtpnAdmin);

		cbPerfils = new JComboBox();
		cbPerfils.setBounds(10, 296, 243, 20);

		Object[] items = DaoSupplier.getDaoPerfil().findAll().toArray();
		DefaultComboBoxModel model = new DefaultComboBoxModel(items);
		cbPerfils.setModel(model);
		panel.add(cbPerfils);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Categorias de Produtos", null, panel_1, null);
		panel_1.setLayout(null);

		textProdutoCategoria = new JTextField();
		textProdutoCategoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					salvarCategoria(textProdutoCategoria.getText());
				}
			}
		});
		textProdutoCategoria.setBounds(112, 74, 86, 20);
		panel_1.add(textProdutoCategoria);
		textProdutoCategoria.setColumns(10);

		JLabel txtpnNome_1 = new JLabel();
		txtpnNome_1.setText("Nome:");
		txtpnNome_1.setBounds(10, 74, 47, 20);
		panel_1.add(txtpnNome_1);

		JButton btnCadastrarCategoria = new JButton("Cadastrar");
		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarCategoria(textProdutoCategoria.getText());
			}
		});
		btnCadastrarCategoria.setBounds(429, 73, 118, 23);
		panel_1.add(btnCadastrarCategoria);

		JButton btnListarTipos = new JButton("Listar tipos");
		btnListarTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, DaoSupplier.getDaoCategoria().findAll().toArray());
			}
		});
		btnListarTipos.setBounds(112, 252, 106, 23);
		panel_1.add(btnListarTipos);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Restaurantes", null, panel_2, null);
		panel_2.setLayout(null);

		btnCadastroProdutos = new JButton("Cadastro Produtos");
		btnCadastroProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto frame = new CadastrarProduto();
				frame.setVisible(true);
			}
		});

		btnCadastroProdutos.setBounds(404, 284, 174, 23);
		panel_2.add(btnCadastroProdutos);

		JLabel txtpnNome_2 = new JLabel();
		txtpnNome_2.setText("Nome:");
		txtpnNome_2.setBounds(10, 42, 53, 20);
		panel_2.add(txtpnNome_2);

		JLabel txtpnTelefone = new JLabel();
		txtpnTelefone.setText("Telefone:");
		txtpnTelefone.setBounds(10, 157, 53, 20);
		panel_2.add(txtpnTelefone);

		JLabel txtpnDescrio = new JLabel();
		txtpnDescrio.setText("Descri\u00E7\u00E3o");
		txtpnDescrio.setBounds(404, 11, 174, 20);
		panel_2.add(txtpnDescrio);

		JLabel txtpnTempoBaseDe = new JLabel();
		txtpnTempoBaseDe.setText("Tempo base de entrega:");
		txtpnTempoBaseDe.setBounds(10, 284, 174, 23);
		panel_2.add(txtpnTempoBaseDe);

		JLabel txtpnEmail = new JLabel();
		txtpnEmail.setText("Email:");
		txtpnEmail.setBounds(10, 94, 53, 20);
		panel_2.add(txtpnEmail);

		textRestauranteNome = new JTextField();
		textRestauranteNome.setToolTipText("Digite o nome");
		textRestauranteNome.setBounds(249, 42, 86, 20);
		panel_2.add(textRestauranteNome);
		textRestauranteNome.setColumns(10);

		textRestauranteEmail = new JTextField();
		textRestauranteEmail.setToolTipText("Digite o email");
		textRestauranteEmail.setBounds(249, 94, 86, 20);
		panel_2.add(textRestauranteEmail);
		textRestauranteEmail.setColumns(10);

		textRestauranteTelefone = new JTextField();
		textRestauranteTelefone.setToolTipText("Digite o telefone");
		textRestauranteTelefone.setBounds(249, 157, 86, 20);
		panel_2.add(textRestauranteTelefone);
		textRestauranteTelefone.setColumns(10);

		textRestauranteHorarioAbertura = new JTextField();
		textRestauranteHorarioAbertura.setToolTipText("Horario de abertura");
		textRestauranteHorarioAbertura.setBounds(249, 213, 86, 20);
		panel_2.add(textRestauranteHorarioAbertura);
		textRestauranteHorarioAbertura.setColumns(10);

		textRestauranteTmpEntrega = new JTextField();
		textRestauranteTmpEntrega.setToolTipText("Digite o tempo base de entrega");
		textRestauranteTmpEntrega.setBounds(249, 285, 86, 20);
		panel_2.add(textRestauranteTmpEntrega);
		textRestauranteTmpEntrega.setColumns(10);

		textRestauranteDesc = new JTextField();
		textRestauranteDesc.setBounds(404, 53, 174, 124);
		panel_2.add(textRestauranteDesc);
		textRestauranteDesc.setColumns(10);

		JButton btnCadastrarRest = new JButton("Cadastrar Restaurante");
		btnCadastrarRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarRestaurante(textRestauranteNome.getText(), textRestauranteDesc.getText(),
						textRestauranteEmail.getText(), textRestauranteHorarioAbertura.getText(),
						textHorarioFechamento.getText(), textRestauranteTelefone.getText(),
						textRestauranteTmpEntrega.getText());
			}
		});
		btnCadastrarRest.setBounds(404, 212, 174, 23);
		panel_2.add(btnCadastrarRest);

		JLabel lblHorarioDeFechamento = new JLabel();
		lblHorarioDeFechamento.setText("Horario de fechamento");
		lblHorarioDeFechamento.setBounds(10, 241, 204, 32);
		panel_2.add(lblHorarioDeFechamento);

		textHorarioFechamento = new JTextField();
		textHorarioFechamento.setToolTipText("Horario de abertura");
		textHorarioFechamento.setColumns(10);
		textHorarioFechamento.setBounds(249, 244, 86, 20);
		panel_2.add(textHorarioFechamento);

		JLabel lblHorarioDeAbertura = new JLabel("Horario de abertura");
		lblHorarioDeAbertura.setBounds(10, 216, 126, 14);
		panel_2.add(lblHorarioDeAbertura);
	}

	/* Funções */

	public void salvarUsuario(String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setPerfil((Perfil) cbPerfils.getSelectedItem());
		DaoSupplier.getDaoUsuario().insert(usuario);
		JOptionPane.showMessageDialog(this, "Usuario cadastrado");
	}

	public void salvarCategoria(String nome) {
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		DaoSupplier.getDaoCategoria().insert(categoria);
		JOptionPane.showMessageDialog(this, "Categoria adicionada");
	}

	public void salvarRestaurante(String nome, String desc, String email, String horarioAbertura,
			String horarioFechamento, String telefone, String tmpEntrega) {
		Restaurante restaurante = new Restaurante();
		restaurante.setNome(nome);
		restaurante.setDescricao(desc);
		restaurante.setEmail(email);
		restaurante.setHorarioAbertura(horarioAbertura);
		restaurante.setHorarioFechamento(horarioFechamento);
		restaurante.setTelefone(telefone);
		restaurante.setTempoEntrega(tmpEntrega);
		DaoSupplier.getDaoRestaurante().insert(restaurante);
		JOptionPane.showMessageDialog(this, "Restaurante cadastrado");
	}
}
