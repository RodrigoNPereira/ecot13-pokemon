package br.edu.unifei.ecot13.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.AlolanRaichu;
import br.edu.unifei.ecot13.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pokemonDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("pokemonPU");
	private EntityManager em = emf.createEntityManager();
	private Pokemon pokemon;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pokemonDelete frame = new pokemonDelete();
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
	public pokemonDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(46, 70, 51, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblTitle = new JLabel("Delete Your Pokemon");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(46, 15, 262, 31);
		contentPane.add(lblTitle);
		
		JLabel lblPokemon = new JLabel("Pokemon");
		lblPokemon.setBounds(530, 18, 43, 14);
		contentPane.add(lblPokemon);
		
		JSpinner spnCodigo = new JSpinner();
		spnCodigo.setBounds(102, 67, 67, 20);
		contentPane.add(spnCodigo);
	
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 103, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setColumns(10);
		txtName.setBounds(102, 100, 159, 20);
		contentPane.add(txtName);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(46, 134, 46, 14);
		contentPane.add(lblHealth);
		
		JSpinner spnHealth = new JSpinner();
		spnHealth.setBounds(102, 131, 159, 20);
		contentPane.add(spnHealth);
		spnHealth.setEnabled(false);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setBounds(46, 162, 46, 14);
		contentPane.add(lblDefense);
		
		JSpinner spnDefense = new JSpinner();
		spnDefense.setBounds(102, 165, 159, 20);
		contentPane.add(spnDefense);
		spnDefense.setEnabled(false);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				em.getTransaction().begin();
				em.remove(pokemon);
				em.getTransaction().commit();	
			}
			
		});
		btnDelete.setBounds(139, 195, 85, 21);
		contentPane.add(btnDelete);
		
		
		JButton btnFind = new JButton("Find");
		btnFind.setLocation(179, 67);
		btnFind.setSize(82, 21);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokemon = em.find(Pokemon.class,
						(Integer) spnCodigo.getValue());
				if(pokemon!=null) {
					spnCodigo.setEnabled(false);
					btnFind.setEnabled(false);
					txtName.setText(pokemon.getName());
					spnHealth.setValue(pokemon.getHealth());
					spnDefense.setValue(pokemon.getDefense());
				}else {
					JOptionPane.showMessageDialog(null, "Not a valid code");
				}
			}
		});
		btnFind.setBounds(176, 67, 85, 21);
		contentPane.add(btnFind);
	}
}
