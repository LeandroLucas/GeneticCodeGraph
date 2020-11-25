package gc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import gc.Main;

/**
 * 
 * @author <a href="mailto:leandro.lucas_@hotmail.com">Leandro Lucas Santos</a>
 */
public class Menu extends javax.swing.JPanel {

	private static final long serialVersionUID = -3007970003551205177L;
	
	private JButton btMoreInterval;
	private JButton btMinusInterval;
	
	public Menu() {
		initComponents();
	}

	private void initComponents() {

		setMaximumSize(new Dimension(10000, 100));
		setMinimumSize(new Dimension(1280, 100));

		btMoreInterval = new JButton();
		btMinusInterval = new JButton();

		btMoreInterval.setBackground(Color.GRAY);
		btMoreInterval.setText("Interval ++");
		btMoreInterval.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btMoreInterval.setMinimumSize(new Dimension(100, 100));
		btMoreInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btMoreIntervalPerformed(evt);
			}
		});

		btMinusInterval.setBackground(Color.GRAY);
		btMinusInterval.setText("Interval --");
		btMinusInterval.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btMinusInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btMinusIntervalActionPerformed(evt);
			}
		});

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.add(btMoreInterval, BorderLayout.BEFORE_FIRST_LINE);
		this.add(btMinusInterval, BorderLayout.AFTER_LAST_LINE);
	}

	private void btMoreIntervalPerformed(ActionEvent evt) {
		Main.interval+= 0.5;
	}

	private void btMinusIntervalActionPerformed(ActionEvent evt) {
		if(Main.interval > 0.5) {
			Main.interval-= 0.5;
		}
	}

}
