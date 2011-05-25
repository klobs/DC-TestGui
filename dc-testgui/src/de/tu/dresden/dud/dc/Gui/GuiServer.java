/**
 * This software is GPLv2. 
 * Take a look at the LICENSE file for more info.
 */
package de.tu.dresden.dud.dc.Gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import de.tu.dresden.dud.dc.Connection;
import de.tu.dresden.dud.dc.KeyExchangeManager;
import de.tu.dresden.dud.dc.Server;
import de.tu.dresden.dud.dc.WorkCycle.WorkCycleManager;

import java.util.Observable;
import java.util.Observer;
/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GuiServer extends javax.swing.JPanel implements Observer{

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	private static final long serialVersionUID = 3L;
	private DefaultComboBoxModel outputListModel;
	private JButton toggleServerButton;
	private AbstractAction actionToggleServer;
	private JRadioButton jRadioButtonTickSleep10ms;
	private JScrollPane jScrollPane2;
	private JTable tableActiveParts;
	private JScrollPane jScrollPane1;
	private JTable tablePassiveParts;
	private JRadioButton jRadioButtonTimeout3000;
	private JRadioButton jRadioButtonTimeout1000;
	private JRadioButton jRadioButtonTimeout0;
	private JPanel jPanelTimeout;
	private JRadioButton jRadioButtonTickSleep5s;
	private JPanel jPanel3;
	private JRadioButton jRadioButtonTickSleep20s;
	private JRadioButton jRadioButtonTickSleep1s;
	private JPanel jPanelSleepTicks;
	private JRadioButton jRadioButtonTickSleep0;
	private JPanel jPanel1;
	private JCheckBox jCheckBoxVariableMessageLength;
	private JComboBox jComboBoxKeG;
	private JComboBox jComboBoxKeX;

	private ButtonGroup buttonGroupTick = new ButtonGroup();
	private ButtonGroup buttonGroupTimeout = new ButtonGroup();
	
	private Server assocServer = null;
	
	private ActionListener actionTickButton = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			assocServer.getWorkCycleManager().setTickPause(getTickTimer());
		}
	};

	private ActionListener actionTimeoutButton = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			assocServer.getWorkCycleManager()
			.setPacketTimeout(getSocketTimeout());
		}
	};

	
	
	public GuiServer() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			Component com[] = null;
			GroupLayout thisLayout = new GroupLayout((JComponent)this);
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(885, 525));
			{
				toggleServerButton = new JButton();
				toggleServerButton.setText("Start Server");
				toggleServerButton.setAction(getActionStartServer());
				toggleServerButton.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						if (e.getKeyChar() == KeyEvent.VK_ENTER) getActionStartServer().actionPerformed(null);

					}
				});
				
				buttonGroupTick.add(getJRadioButtonTickSleep0());
				buttonGroupTick.add(getJRadioButtonTickSleep10ms());
				buttonGroupTick.add(getJRadioButtonTickSleep1s());
				buttonGroupTick.add(getJRadioButtonTickSleep5s());
				buttonGroupTick.add(getJRadioButtonTickSleep20s());

				getJRadioButtonTickSleep0().addActionListener(actionTickButton);
				getJRadioButtonTickSleep10ms().addActionListener(actionTickButton);
				getJRadioButtonTickSleep1s().addActionListener(actionTickButton);
				getJRadioButtonTickSleep5s().addActionListener(actionTickButton);
				getJRadioButtonTickSleep20s().addActionListener(actionTickButton);
				
				buttonGroupTimeout.add(getJRadioButtonTimeout0());
				buttonGroupTimeout.add(getJRadioButtonTimeout1s());
				buttonGroupTimeout.add(getJRadioButtonTimeout3s());
				

				getJRadioButtonTimeout0().addActionListener(actionTimeoutButton);
				getJRadioButtonTimeout1s().addActionListener(actionTimeoutButton);
				getJRadioButtonTimeout3s().addActionListener(actionTimeoutButton);
				
				 
				com = getJPanelTickSleep().getComponents();
				
				for (int a = 0; a < com.length; a++) {
					com[a].setEnabled(false);
				}

				com = getJPanelTimeout().getComponents();
				
				for (int a = 0; a < com.length; a++) {
					com[a].setEnabled(false);
				}
				
			}
				thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap(12, 12)
					.addComponent(getJPanel1(), GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(toggleServerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(getJPanel3(), GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(thisLayout.createParallelGroup()
					    .addComponent(getJScrollPane1(), GroupLayout.Alignment.LEADING, 0, 217, Short.MAX_VALUE)
					    .addComponent(getJScrollPane2(), GroupLayout.Alignment.LEADING, 0, 217, Short.MAX_VALUE))
					.addContainerGap(12, 12));
				thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addContainerGap(12, 12)
					.addGroup(thisLayout.createParallelGroup()
					    .addComponent(getJPanel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE)
					    .addComponent(toggleServerButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE)
					    .addComponent(getJPanel3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE)
					    .addGroup(thisLayout.createSequentialGroup()
					        .addComponent(getJScrollPane1(), 0, 250, Short.MAX_VALUE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(getJScrollPane2(), 0, 259, Short.MAX_VALUE)
					        .addGap(346)))
					.addContainerGap(12, 12));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private AbstractAction getActionStartServer() {
		if(actionToggleServer == null) {
			actionToggleServer = new AbstractAction("Start Server", null) {
				private static final long serialVersionUID = 10L;

				public void actionPerformed(ActionEvent evt) {
					assocServer = new Server(Connection.DEFAULTPORT,
							getKeyGenerationMethod(), getKeyExchangeMethod(),
							getVariableMessageLengthsFeature());
					
					new Thread(assocServer, "Server").start();
					
					Component[] com = getJPanel1().getComponents();
					
					for (int a = 0; a < com.length; a++) {
					     com[a].setEnabled(false);
					}
					
					com = getJPanelTickSleep().getComponents();

					for (int a = 0; a < com.length; a++) {
					     com[a].setEnabled(true);
					}
					
					com = getJPanelTimeout().getComponents();
					
					for (int a = 0; a < com.length; a++) {
						com[a].setEnabled(true);
					}
					
					getTableActiveParts().setModel(
							new GuiParticipantActiveParticipantListModel(assocServer.getParticipantManager()));
					getTableActiveParts().getColumnModel().getColumn(0).setHeaderValue(new String("Key"));
					getTableActiveParts().getColumnModel().getColumn(1).setHeaderValue(new String("Name"));
					getTableActiveParts().getColumnModel().getColumn(2).setHeaderValue(new String("Fingerprint"));
					
					getTablePassiveParts().setModel(
							new GuiParticipantPassiveParticipantListModel(assocServer.getParticipantManager()));
					getTablePassiveParts().getColumnModel().getColumn(0).setHeaderValue(new String("Key"));
					getTablePassiveParts().getColumnModel().getColumn(1).setHeaderValue(new String("Name"));
					getTablePassiveParts().getColumnModel().getColumn(2).setHeaderValue(new String("Fingerprint"));
					
					
					
					this.setEnabled(false);
				}
			};
		}
		return actionToggleServer;
	}

	@Override
	public void update(Observable o, Object arg) {
		outputListModel.addElement(arg);
	}
	
	private JComboBox getJComboBoxKeX() {
		if(jComboBoxKeX == null) {
			ComboBoxModel jComboBoxKeXModel = 
				new DefaultComboBoxModel(
						new String[] { "Fully automatic key exchange", "Manual key exchange"});
			jComboBoxKeX = new JComboBox();
			jComboBoxKeX.setModel(jComboBoxKeXModel);
		}
		return jComboBoxKeX;
	}
	
	private JComboBox getJComboBoxKeG() {
		if(jComboBoxKeG == null) {
			ComboBoxModel jComboBoxKeGModel = 
				new DefaultComboBoxModel(
						new String[] { "Null keys", "Normal DC-Keys", "Fail-Stop during work cycles", "Probabilistic-Fail-Stop during work cycle"});
			jComboBoxKeG = new JComboBox();
			jComboBoxKeG.setModel(jComboBoxKeGModel);
		}
		return jComboBoxKeG;
	}
	
	private JCheckBox getJCheckBoxVariableMessageLength() {
		if(jCheckBoxVariableMessageLength == null) {
			jCheckBoxVariableMessageLength = new JCheckBox();
			jCheckBoxVariableMessageLength.setText("Allow variable sized messages");
			jCheckBoxVariableMessageLength.setSelected(true);
		}
		return jCheckBoxVariableMessageLength;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.setBorder(BorderFactory.createTitledBorder("Adjust before you start"));
			jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
				.addComponent(getJComboBoxKeX(), GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJComboBoxKeG(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJCheckBoxVariableMessageLength(), GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(121, Short.MAX_VALUE));
			jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJComboBoxKeX(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJComboBoxKeG(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJCheckBoxVariableMessageLength(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(196, 196));
		}
		return jPanel1;
	}
	
	private JPanel getJPanelTickSleep() {
		if(jPanelSleepTicks == null) {
			jPanelSleepTicks = new JPanel();
			GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanelSleepTicks);
			jPanelSleepTicks.setLayout(jPanel2Layout);
			jPanelSleepTicks.setBorder(BorderFactory.createTitledBorder(null, "Sleep during ticks", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
				    .addComponent(getJRadioButtonTickSleep5s(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				    .addGap(0, 22, Short.MAX_VALUE))
				.addComponent(getJRadioButtonTickSleep0(), GroupLayout.Alignment.LEADING, 0, 145, Short.MAX_VALUE)
				.addComponent(getJRadioButtonTickSleep1s(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
				.addComponent(getJRadioButtonTickSleep20s(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
				.addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
				    .addComponent(getJRadioButtonTickSleep10ms(), GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
				    .addGap(0, 20, Short.MAX_VALUE)));
			jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
				.addComponent(getJRadioButtonTickSleep0(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJRadioButtonTickSleep10ms(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addComponent(getJRadioButtonTickSleep1s(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				.addComponent(getJRadioButtonTickSleep5s(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJRadioButtonTickSleep20s(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return jPanelSleepTicks;
	}
	
	private JRadioButton getJRadioButtonTickSleep0() {
		if(jRadioButtonTickSleep0 == null) {
			jRadioButtonTickSleep0 = new JRadioButton();
			jRadioButtonTickSleep0.setText("0 sec");
		}
		return jRadioButtonTickSleep0;
	}

	private JRadioButton getJRadioButtonTickSleep1s() {
		if(jRadioButtonTickSleep1s == null) {
			jRadioButtonTickSleep1s = new JRadioButton();
			jRadioButtonTickSleep1s.setText("1 sec");
			jRadioButtonTickSleep1s.setSelected(true);
		}
		return jRadioButtonTickSleep1s;
	}
	
	private JRadioButton getJRadioButtonTickSleep20s() {
		if(jRadioButtonTickSleep20s == null) {
			jRadioButtonTickSleep20s = new JRadioButton();
			jRadioButtonTickSleep20s.setText("20 sec");
		}
		return jRadioButtonTickSleep20s;
	}
	
	private JRadioButton getJRadioButtonTickSleep5s() {
		if(jRadioButtonTickSleep5s == null) {
			jRadioButtonTickSleep5s = new JRadioButton();
			jRadioButtonTickSleep5s.setText("5 sec");
		}
		return jRadioButtonTickSleep5s;
	}

	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			GroupLayout jPanel3Layout = new GroupLayout((JComponent)jPanel3);
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.setBorder(BorderFactory.createTitledBorder("Adjust while running"));
			jPanel3.setEnabled(true);
			jPanel3Layout.setHorizontalGroup(jPanel3Layout.createSequentialGroup()
				.addComponent(getJPanelTickSleep(), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJPanelTimeout(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(528, Short.MAX_VALUE));
			jPanel3Layout.setVerticalGroup(jPanel3Layout.createSequentialGroup()
				.addGroup(jPanel3Layout.createParallelGroup()
				    .addComponent(getJPanelTickSleep(), GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE)
				    .addComponent(getJPanelTimeout(), GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE))
				.addContainerGap());
		}
		return jPanel3;
	}
	
	private short getKeyGenerationMethod(){
		return (short) getJComboBoxKeG().getSelectedIndex();
	}
	
	private short getKeyExchangeMethod(){
		if (getJComboBoxKeX().getSelectedIndex() == 0)
			return KeyExchangeManager.KEX_FULLY_AUTOMATIC;
		if (getJComboBoxKeX().getSelectedIndex() == 1)
			return KeyExchangeManager.KEX_MANUAL;

		return KeyExchangeManager.KEX_MANUAL;
	}

	private int getSocketTimeout(){
		if (jRadioButtonTimeout0.isSelected()) return 0;
		if (jRadioButtonTimeout1000.isSelected()) return 1000;
		if (jRadioButtonTimeout3000.isSelected()) return 3000;
		return 0;
	}

	private int getTickTimer(){
		if (jRadioButtonTickSleep0.isSelected()) return 0;
		if (jRadioButtonTickSleep10ms.isSelected()) return 10;
		if (jRadioButtonTickSleep1s.isSelected()) return 1000;
		if (jRadioButtonTickSleep5s.isSelected()) return 5000;
		if (jRadioButtonTickSleep20s.isSelected()) return 20000;
		return 1000;
	}
	
	private short getVariableMessageLengthsFeature(){
		if (getJCheckBoxVariableMessageLength().isSelected())
			return WorkCycleManager.MESSAGE_LENGTHS_VARIABLE;
		else return WorkCycleManager.MESSAGE_LENGTHS_FIXED;
	}
	
	private JPanel getJPanelTimeout() {
		if(jPanelTimeout == null) {
			jPanelTimeout = new JPanel();
			jPanelTimeout.setBorder(BorderFactory.createTitledBorder(null, "Timeout for sockets", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			jPanelTimeout.add(getJRadioButtonTimeout0());
			jPanelTimeout.add(getJRadioButtonTimeout1s());
			jPanelTimeout.add(getJRadioButtonTimeout3s());
		}
		return jPanelTimeout;
	}
	
	private JRadioButton getJRadioButtonTimeout0() {
		if(jRadioButtonTimeout0 == null) {
			jRadioButtonTimeout0 = new JRadioButton();
			GroupLayout jRadioButtonTimeout0Layout = new GroupLayout((JComponent)jRadioButtonTimeout0);
			jRadioButtonTimeout0.setLayout(null);
			jRadioButtonTimeout0.setText("No timeout");
			jRadioButtonTimeout0.setPreferredSize(new java.awt.Dimension(156, 23));
			jRadioButtonTimeout0.setSelected(true);
			jRadioButtonTimeout0Layout.setVerticalGroup(jRadioButtonTimeout0Layout.createParallelGroup());
			jRadioButtonTimeout0Layout.setHorizontalGroup(jRadioButtonTimeout0Layout.createParallelGroup());
		}
		return jRadioButtonTimeout0;
	}
	
	private JRadioButton getJRadioButtonTimeout1s() {
		if(jRadioButtonTimeout1000 == null) {
			jRadioButtonTimeout1000 = new JRadioButton();
			GroupLayout jRadioButton1Layout = new GroupLayout((JComponent)jRadioButtonTimeout1000);
			jRadioButtonTimeout1000.setText("1 sec");
			jRadioButtonTimeout1000.setLayout(null);
			jRadioButtonTimeout1000.setPreferredSize(new java.awt.Dimension(156, 23));
			jRadioButton1Layout.setVerticalGroup(jRadioButton1Layout.createParallelGroup());
			jRadioButton1Layout.setHorizontalGroup(jRadioButton1Layout.createParallelGroup());
		}
		return jRadioButtonTimeout1000;
	}
	
	private JRadioButton getJRadioButtonTimeout3s() {
		if(jRadioButtonTimeout3000 == null) {
			jRadioButtonTimeout3000 = new JRadioButton();
			jRadioButtonTimeout3000.setText("3 sec");
			jRadioButtonTimeout3000.setLayout(null);
			jRadioButtonTimeout3000.setPreferredSize(new java.awt.Dimension(156,23));
		}
		return jRadioButtonTimeout3000;
	}
	
	private JTable getTablePassiveParts() {
		if(tablePassiveParts == null) {
			tablePassiveParts = new JTable();
			tablePassiveParts
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tablePassiveParts;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTablePassiveParts());
		}
		return jScrollPane1;
	}
	
	private JTable getTableActiveParts() {
		if(tableActiveParts == null) {
			tableActiveParts = new JTable();
			tableActiveParts
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableActiveParts;
	}
	
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getTableActiveParts());
		}
		return jScrollPane2;
	}
	
	private JRadioButton getJRadioButtonTickSleep10ms() {
		if(jRadioButtonTickSleep10ms == null) {
			jRadioButtonTickSleep10ms = new JRadioButton();
			jRadioButtonTickSleep10ms.setText("10 ms");
		}
		return jRadioButtonTickSleep10ms;
	}
}
