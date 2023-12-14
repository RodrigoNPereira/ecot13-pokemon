package br.edu.unifei.ecot13.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.AlolanRaichu;
import br.edu.unifei.ecot13.EggPichu;
import br.edu.unifei.ecot13.Pichu;
import br.edu.unifei.ecot13.Pikachu;
import br.edu.unifei.ecot13.Pokemon;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class pokemonInsertView extends JFrame {
	
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("pokemonPU");
	private EntityManager em = emf.createEntityManager();
	private Pokemon pokemon;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pokemonInsertView frame = new pokemonInsertView();
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
	public pokemonInsertView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(94, 58, 147, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(38, 61, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(38, 92, 46, 14);
		contentPane.add(lblHealth);
		
		JSpinner spnHealth = new JSpinner();
		spnHealth.setBounds(94, 89, 147, 20);
		contentPane.add(spnHealth);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setBounds(38, 120, 46, 14);
		contentPane.add(lblDefense);
		
		JSpinner spnDefense = new JSpinner();
		spnDefense.setBounds(94, 123, 147, 20);
		contentPane.add(spnDefense);
		
		JLabel lblNewLabel = new JLabel("Create Your Pokemon");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(38, 11, 259, 37);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> cobPokemon = new JComboBox<>(new String[]{"EggPichu", "Pichu", "Pikachu", "AlolanRaichu"});
		cobPokemon.setBounds(94, 154, 147, 22);
		contentPane.add(cobPokemon);
		
		JLabel lblPokemon = new JLabel("Pokemon");
		lblPokemon.setBounds(38, 158, 46, 14);
		contentPane.add(lblPokemon);
		
		JButton btnCreatePokemon = new JButton("Create");
		btnCreatePokemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch((String) cobPokemon.getSelectedItem()) {
				case "EggPichu":
					pokemon = new EggPichu(txtName.getText());
					break;
				case "Pichu":
					pokemon = new Pichu(txtName.getText());
					break;
				case "Pikachu":
					pokemon = new Pikachu(txtName.getText());
				case "AlolanRaichu":
					pokemon = new AlolanRaichu(txtName.getText());
				}
				
//				pokemon.setName(txtName.getText());
				pokemon.setHealth((Integer) spnHealth.getValue());
				pokemon.setDefense((Integer) spnDefense.getValue());
				
				em.getTransaction().begin();
				em.persist(pokemon);
				em.getTransaction().commit();
				
			}
		});
		btnCreatePokemon.setBounds(94, 191, 147, 23);
		contentPane.add(btnCreatePokemon);
	}
}
