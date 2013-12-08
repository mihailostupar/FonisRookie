package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMIKalkulatorGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPol;
	private JLabel lblTezina;
	private JLabel lblVisina;
	private JTextField txtTezina;
	private JTextField txtVisina;
	private JRadioButton rdbtnMuski;
	private JRadioButton rdbtnZenski;
	private JButton btnIzracunajBmi;
	private JLabel lblRezultat;
	private JLabel lblObjasnjenje;
	private JLabel lblKg;
	private JLabel lblCm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIKalkulatorGUI frame = new BMIKalkulatorGUI();
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
	public BMIKalkulatorGUI() {
		setTitle("BMI kalkulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPol());
		contentPane.add(getLblTezina());
		contentPane.add(getLblVisina());
		contentPane.add(getTxtTezina());
		contentPane.add(getTxtVisina());
		contentPane.add(getRdbtnMuski());
		contentPane.add(getRdbtnZenski());
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMuski);
		group.add(rdbtnZenski);
		contentPane.add(getBtnIzracunajBmi());
		contentPane.add(getLblRezultat());
		contentPane.add(getLblObjasnjenje());
		contentPane.add(getLblKg());
		contentPane.add(getLblCm());
	}
	private JLabel getLblPol() {
		if (lblPol == null) {
			lblPol = new JLabel("Pol");
			lblPol.setBounds(68, 47, 46, 14);
		}
		return lblPol;
	}
	private JLabel getLblTezina() {
		if (lblTezina == null) {
			lblTezina = new JLabel("Tezina");
			lblTezina.setBounds(68, 86, 46, 14);
		}
		return lblTezina;
	}
	private JLabel getLblVisina() {
		if (lblVisina == null) {
			lblVisina = new JLabel("Visina");
			lblVisina.setBounds(68, 114, 46, 14);
		}
		return lblVisina;
	}
	private JTextField getTxtTezina() {
		if (txtTezina == null) {
			txtTezina = new JTextField();
			txtTezina.setBounds(146, 83, 86, 20);
			txtTezina.setColumns(10);
		}
		return txtTezina;
	}
	private JTextField getTxtVisina() {
		if (txtVisina == null) {
			txtVisina = new JTextField();
			txtVisina.setBounds(146, 111, 86, 20);
			txtVisina.setColumns(10);
		}
		return txtVisina;
	}
	private JRadioButton getRdbtnMuski() {
		if (rdbtnMuski == null) {
			rdbtnMuski = new JRadioButton("Muski");
			rdbtnMuski.setBounds(146, 43, 65, 23);
		}
		return rdbtnMuski;
	}
	private JRadioButton getRdbtnZenski() {
		if (rdbtnZenski == null) {
			rdbtnZenski = new JRadioButton("Zenski");
			rdbtnZenski.setBounds(210, 43, 109, 23);
		}
		return rdbtnZenski;
	}
	private JButton getBtnIzracunajBmi() {
		if (btnIzracunajBmi == null) {
			btnIzracunajBmi = new JButton("Izracunaj BMI");
			btnIzracunajBmi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					double tezina = 100;
					double visina = 100;
					boolean znak = false;
					
					try {
						tezina = Double.parseDouble(txtTezina.getText());
						visina = Double.parseDouble(txtVisina.getText());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Morate uneti visinu i tezinu kao broj. Proverite unos.");
						znak = true;
					}
					
					
					char pol;
					if (rdbtnMuski.isSelected())
						pol = 'M';
					else if (rdbtnZenski.isSelected())
						pol = 'Z';
					else
						pol = 'N';
					
					BMIKalkulator bmi = new BMIKalkulator(visina, tezina, pol);
					String rezultat = bmi.rezultat();
					String objasnjenje = null;
					if (pol == 'N' || znak == true)
						objasnjenje = "Potrebno je da oznacite pol i pravilno unesete parametre kako biste dobili objasnjenje.";
					else
						objasnjenje = bmi.objasnjenje(pol);
					lblRezultat.setText(rezultat);
					lblObjasnjenje.setText(objasnjenje);
					
				}
			});
			btnIzracunajBmi.setBounds(84, 155, 127, 23);
		}
		return btnIzracunajBmi;
	}
	private JLabel getLblRezultat() {
		if (lblRezultat == null) {
			lblRezultat = new JLabel("");
			lblRezultat.setBounds(30, 204, 375, 14);
		}
		return lblRezultat;
	}
	private JLabel getLblObjasnjenje() {
		if (lblObjasnjenje == null) {
			lblObjasnjenje = new JLabel("");
			lblObjasnjenje.setBounds(30, 229, 511, 43);
		}
		return lblObjasnjenje;
	}
	private JLabel getLblKg() {
		if (lblKg == null) {
			lblKg = new JLabel("kg");
			lblKg.setBounds(242, 86, 46, 14);
		}
		return lblKg;
	}
	private JLabel getLblCm() {
		if (lblCm == null) {
			lblCm = new JLabel("cm");
			lblCm.setBounds(242, 114, 46, 14);
		}
		return lblCm;
	}
}
