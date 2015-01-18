/******************************************************************************
 * Vige, Home of Professional Open Source Copyright 2010, Vige, and           *
 * individual contributors by the @authors tag. See the copyright.txt in the  *
 * distribution for a full listing of individual contributors.                *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You may obtain    *
 * a copy of the License at http://www.apache.org/licenses/LICENSE-2.0        *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/
package it.vige.greenarea.itseasy.ln.swing;

import it.vige.greenarea.I18N.I18N;

public class SaveConfirmDialog extends java.awt.Dialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8662557082414827691L;
	private boolean ok;
	private SaveConfirmHandlerInterface eventHandler;;
	private java.awt.Frame parent;

	public void setEventHandler(SaveConfirmHandlerInterface eventHandler) {
		this.eventHandler = eventHandler;
	}

	public boolean isOk() {
		return ok;
	}

	/** Creates new form SaveConfirmDialog */
	public SaveConfirmDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.parent = parent;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		saveConfirmDialog = new javax.swing.JDialog();
		okButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		ConfirmMessageArea = new javax.swing.JTextArea();

		saveConfirmDialog
				.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		saveConfirmDialog.setAlwaysOnTop(true);
		saveConfirmDialog.setResizable(false);

		javax.swing.GroupLayout saveConfirmDialogLayout = new javax.swing.GroupLayout(
				saveConfirmDialog.getContentPane());
		saveConfirmDialog.getContentPane().setLayout(saveConfirmDialogLayout);
		saveConfirmDialogLayout.setHorizontalGroup(saveConfirmDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		saveConfirmDialogLayout.setVerticalGroup(saveConfirmDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				closeDialog(evt);
			}
		});
		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				formComponentShown(evt);
			}
		});

		okButton.setText(I18N.getString("OK"));
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		cancelButton.setText(I18N.getString("Cancel"));
		cancelButton.setMaximumSize(new java.awt.Dimension(50, 25));
		cancelButton.setMinimumSize(new java.awt.Dimension(50, 25));
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		ConfirmMessageArea.setBackground(new java.awt.Color(240, 240, 240));
		ConfirmMessageArea.setColumns(20);
		ConfirmMessageArea.setEditable(false);
		ConfirmMessageArea.setRows(5);
		ConfirmMessageArea.setText(I18N.getString("ConfirmSaveMessage"));
		ConfirmMessageArea.setAutoscrolls(false);
		ConfirmMessageArea.setBorder(null);
		ConfirmMessageArea.setFocusable(false);
		jScrollPane1.setViewportView(ConfirmMessageArea);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(10, 10,
																		10)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		320,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(90, 90,
																		90)
																.addComponent(
																		cancelButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		110,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(9, 9, 9)
																.addComponent(
																		okButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		120,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(10, 10, 10)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										150,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														cancelButton,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(okButton))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_closeDialog

	}// GEN-LAST:event_closeDialog

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		if (eventHandler != null)
			eventHandler.confirmEvent(false);
		this.dispose();
	}// GEN-LAST:event_cancelButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		if (eventHandler != null)
			eventHandler.confirmEvent(true);
		this.dispose();
	}// GEN-LAST:event_okButtonActionPerformed

	private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
		ok = false;
		this.setLocation(parent.getLocation());
		this.setSize(400, 265);
		this.setVisible(true);
	}// GEN-LAST:event_formComponentShown

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextArea ConfirmMessageArea;
	private javax.swing.JButton cancelButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton okButton;
	private javax.swing.JDialog saveConfirmDialog;
	// End of variables declaration//GEN-END:variables
}
