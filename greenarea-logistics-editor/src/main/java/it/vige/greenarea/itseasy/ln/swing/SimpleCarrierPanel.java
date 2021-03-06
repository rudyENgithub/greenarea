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

import java.awt.Color;
import java.awt.Dialog;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import it.vige.greenarea.I18N.I18N;
import it.vige.greenarea.costmodels.ConstantCost;
import it.vige.greenarea.ln.model.LNNode;
import it.vige.greenarea.ln.model.LNSimpleCarrier;

public class SimpleCarrierPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6012386510249906348L;
	private LNSimpleCarrier carrier = new LNSimpleCarrier("XXX");;
	private mxCell editingCell;
	private mxGraphComponent graphComponent;

	/** Creates new form TestTabPanel */
	public SimpleCarrierPanel(mxGraphComponent graphComponent, Dialog parent) {
		this.graphComponent = graphComponent;
		initComponents();
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
		dialogMessage = new javax.swing.JLabel();
		okButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		saveDataButton = new javax.swing.JButton();
		resetValuesButton = new javax.swing.JButton();
		biDirectionalCheckBox = new javax.swing.JCheckBox();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		sourceNodeNameField = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		targetNodeNameField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		costField = new javax.swing.JTextField();
		costErrorField = new javax.swing.JTextField();

		saveConfirmDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		saveConfirmDialog.setAlwaysOnTop(true);
		saveConfirmDialog.setResizable(false);

		dialogMessage.setText(I18N.getString("ConfirmSaveMessage"));

		okButton.setText(I18N.getString("OK"));
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		cancelButton.setText(I18N.getString("Cancel"));
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout saveConfirmDialogLayout = new javax.swing.GroupLayout(
				saveConfirmDialog.getContentPane());
		saveConfirmDialog.getContentPane().setLayout(saveConfirmDialogLayout);
		saveConfirmDialogLayout.setHorizontalGroup(saveConfirmDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(saveConfirmDialogLayout.createSequentialGroup().addContainerGap()
						.addGroup(saveConfirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(dialogMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										saveConfirmDialogLayout.createSequentialGroup().addComponent(cancelButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(okButton)))
						.addContainerGap()));
		saveConfirmDialogLayout.setVerticalGroup(saveConfirmDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(saveConfirmDialogLayout.createSequentialGroup().addContainerGap().addComponent(dialogMessage)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
						.addGroup(
								saveConfirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(okButton).addComponent(cancelButton))
						.addContainerGap()));

		saveDataButton.setText(I18N.getString("Save"));
		saveDataButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveDataButtonActionPerformed(evt);
			}
		});

		resetValuesButton.setText(I18N.getString("RESET"));
		resetValuesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetValuesButtonActionPerformed(evt);
			}
		});

		biDirectionalCheckBox.setText(I18N.getString("BiDirectional"));
		biDirectionalCheckBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		biDirectionalCheckBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				biDirectionalCheckBoxActionPerformed(evt);
			}
		});

		jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jPanel1.setForeground(new java.awt.Color(102, 102, 102));
		jPanel1.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N

		jLabel2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(102, 102, 102));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText(I18N.getString("SourceNode").concat(": "));
		jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

		sourceNodeNameField.setEditable(false);
		sourceNodeNameField.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
		sourceNodeNameField.setForeground(new java.awt.Color(102, 102, 102));
		sourceNodeNameField.setText("jTextField1");
		sourceNodeNameField.setAutoscrolls(false);
		sourceNodeNameField.setBorder(null);
		sourceNodeNameField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
		sourceNodeNameField.setEnabled(false);
		sourceNodeNameField.setFocusable(false);

		jLabel7.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(102, 102, 102));
		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel7.setText(I18N.getString("TargetNode").concat(": "));
		jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

		targetNodeNameField.setEditable(false);
		targetNodeNameField.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
		targetNodeNameField.setForeground(new java.awt.Color(102, 102, 102));
		targetNodeNameField.setText("jTextField1");
		targetNodeNameField.setBorder(null);
		targetNodeNameField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
		targetNodeNameField.setEnabled(false);
		targetNodeNameField.setFocusable(false);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 124,
												Short.MAX_VALUE)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(targetNodeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27))
								.addGroup(
										jPanel1Layout.createSequentialGroup()
												.addComponent(sourceNodeNameField,
														javax.swing.GroupLayout.PREFERRED_SIZE, 174,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(sourceNodeNameField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(targetNodeNameField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)));

		jLabel1.setText(I18N.getString("cost"));

		costField.setText("jTextField1");
		costField.setInputVerifier(new CostFieldVerifier());
		costField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				costFieldActionPerformed(evt);
			}
		});

		costErrorField.setEditable(false);
		costErrorField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		costErrorField.setForeground(new java.awt.Color(255, 0, 0));
		costErrorField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		costErrorField.setText("jTextField1");
		costErrorField.setAutoscrolls(false);
		costErrorField.setBorder(null);
		costErrorField.setFocusable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup().addGap(124, 124, 124)
										.addComponent(biDirectionalCheckBox))
						.addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(costErrorField, javax.swing.GroupLayout.DEFAULT_SIZE, 208,
												Short.MAX_VALUE))
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(resetValuesButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(saveDataButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(60, 60, 60)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(costErrorField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(26, 26, 26).addComponent(biDirectionalCheckBox).addGap(18, 18, 18)
				.addComponent(resetValuesButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(saveDataButton).addContainerGap(59, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void saveDataButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveDataButtonActionPerformed
		doConfirmDialog();
	}// GEN-LAST:event_saveDataButtonActionPerformed

	private void doConfirmDialog() {
		saveConfirmDialog.setSize(347, 101);
		saveConfirmDialog.setVisible(true);
		this.setEnabled(false);
	}

	private void resetValuesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resetValuesButtonActionPerformed
		displayData(carrier);
		disableButton(saveDataButton);
		disableButton(resetValuesButton);
	}// GEN-LAST:event_resetValuesButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		// carrier.loadElement((Element) editingCell.getValue());
		carrier = (LNSimpleCarrier) editingCell.getValue();
		saveData(carrier);
		graphComponent.labelChanged(editingCell, carrier, evt);
		saveConfirmDialog.setVisible(false);
		this.setEnabled(true);
		disableButton(saveDataButton);
		disableButton(resetValuesButton);
	}// GEN-LAST:event_okButtonActionPerformed

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		saveConfirmDialog.setVisible(false);
		this.setEnabled(true);
	}// GEN-LAST:event_cancelButtonActionPerformed

	private void biDirectionalCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_biDirectionalCheckBoxActionPerformed
		enableButton(saveDataButton);
		enableButton(resetValuesButton);
	}// GEN-LAST:event_biDirectionalCheckBoxActionPerformed

	private void costFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_costFieldActionPerformed
		enableButton(saveDataButton);
		enableButton(resetValuesButton);
	}// GEN-LAST:event_costFieldActionPerformed

	private void disableButton(JButton b) {
		b.setEnabled(false);
		b.setForeground(Color.gray);
	}

	private void enableButton(JButton b) {
		b.setEnabled(true);
		b.setForeground(Color.black);
	}

	private void displayData(LNSimpleCarrier carrier) {
		sourceNodeNameField.setText(carrier.getFromNodeName());
		targetNodeNameField.setText(carrier.getToNodeName());
		biDirectionalCheckBox.setSelected(carrier.isBiDirectional());
		costField.setText(Double.toString(((ConstantCost) carrier.getCostFunction()).getKcost()));
	}

	private void saveData(LNSimpleCarrier carrier) {
		carrier.setBiDirectional(biDirectionalCheckBox.isSelected());
		((ConstantCost) carrier.getCostFunction()).setKcost(Double.parseDouble(costField.getText()));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JCheckBox biDirectionalCheckBox;
	private javax.swing.JButton cancelButton;
	private javax.swing.JTextField costErrorField;
	private javax.swing.JTextField costField;
	private javax.swing.JLabel dialogMessage;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton okButton;
	private javax.swing.JButton resetValuesButton;
	private javax.swing.JDialog saveConfirmDialog;
	private javax.swing.JButton saveDataButton;
	private javax.swing.JTextField sourceNodeNameField;
	private javax.swing.JTextField targetNodeNameField;

	// End of variables declaration//GEN-END:variables

	void startEditing(Object cell) {
		editingCell = (mxCell) cell;
		// carrier.loadElement((Element) editingCell.getValue());
		carrier = (LNSimpleCarrier) editingCell.getValue();
		mxCell source = (mxCell) editingCell.getSource();
		mxCell target = (mxCell) editingCell.getTarget();
		carrier.setFromNodeName(source != null ? ((LNNode) source.getValue()).getName() : I18N.getString("UNDEFINED"));
		carrier.setToNodeName(target != null ? ((LNNode) target.getValue()).getName() : I18N.getString("UNDEFINED"));
		displayData(carrier);
		disableButton(saveDataButton);
		disableButton(resetValuesButton);
		costErrorField.setText("");
	}

	private class CostFieldVerifier extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {
			String name = ((JTextField) input).getText();
			boolean result;
			try {
				Long.parseLong(name);
				result = true;
				costField.setText(costField.getText().concat("."));
			} catch (Exception ex) {
				try {
					Double.parseDouble(name);
					result = true;
				} catch (Exception ex1) {
					result = false;
				}
			}

			if (!result) {
				costErrorField.setText(errorMessage);
				costField.setForeground(Color.red);
				disableButton(saveDataButton);
			} else {
				costErrorField.setText("");
				costField.setForeground(Color.black);
				enableButton(saveDataButton);
			}
			return result;
		}
	}

	private static String errorMessage = I18N.getString("InvalidNumberError");
}
