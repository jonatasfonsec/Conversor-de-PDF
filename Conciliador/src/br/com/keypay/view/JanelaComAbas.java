package br.com.keypay.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JanelaComAbas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8987248908031078563L;

	JanelaComAbas() {

		super(new GridLayout(1,1));

		JTabbedPane painelComAbas = new JTabbedPane();

		Component painel1 = makeTextPanel("");
		painelComAbas.addTab("TOTAL", null, painel1, "Não faz nada");
		painelComAbas.setMnemonicAt(0, KeyEvent.VK_1);

		Component painel2 = makeTextPanel("");
		painelComAbas.addTab("SLC", null, painel2, "Não faz nada");
		painelComAbas.setMnemonicAt(1, KeyEvent.VK_2);

		Component painel3 = makeTextPanel("");
		painelComAbas.addTab("LDL", null, painel3, "Não faz nada");
		painelComAbas.setMnemonicAt(2, KeyEvent.VK_3);

		Component painel4 = makeTextPanel("");
		painelComAbas.addTab("Aba 4", null, painel4, "Não faz nada");
		painelComAbas.setMnemonicAt(3, KeyEvent.VK_4);
		
		
	      //Add the tabbed pane to this panel.
        add(painelComAbas);
         
        //The following line enables to use scrolling tabs.
        painelComAbas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}

	private JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1,1));
		panel.add(filler);
		return panel;
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TabbedPaneDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JanelaComAbas(), BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

}
