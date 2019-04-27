package vFooD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class Menu extends JFrame {
	// private static Scanner scan = new Scanner(System.in);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("vFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar frame = new Cadastrar();
				frame.setVisible(true);
			}
		});
		btnCadastro.setBounds(10, 156, 104, 23);
		contentPane.add(btnCadastro);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprar frame = new Comprar();
				frame.setVisible(true);
			}
		});
		btnComprar.setBounds(320, 156, 104, 23);
		contentPane.add(btnComprar);

		JButton btnRelatrios = new JButton("Relat\u00F3rios");
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio frame = new Relatorio();
				frame.setVisible(true);

			}
		});
		btnRelatrios.setBounds(320, 215, 104, 23);
		contentPane.add(btnRelatrios);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remover frame = new Remover();
				frame.setVisible(true);
			}
		});
		btnRemover.setBounds(10, 215, 104, 23);
		contentPane.add(btnRemover);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alex.Freitas\\Documents\\vFood\\vFooD\\logo.png"));
		lblNewLabel.setBounds(54, 11, 310, 134);
		contentPane.add(lblNewLabel);
	}
}
