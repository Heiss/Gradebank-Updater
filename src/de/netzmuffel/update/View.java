package de.netzmuffel.update;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	public JButton btnNewButton;
	public JProgressBar progressBar;
	public JLabel lblNewLabel;
	
	public View() {
		this.setTitle("GradeBank - Updater");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		
		btnNewButton = new JButton("Waiting...");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		getContentPane().add(progressBar, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Update is in progress. Please wait.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
