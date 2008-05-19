package flapjack.gui.dialog;

import flapjack.data.*;
import flapjack.gui.*;

class NBSelectLMPanel extends javax.swing.JPanel
{
	public NBSelectLMPanel(GTView view, boolean selectLines)
	{
		initComponents();

		if (selectLines)
		{
			RB.setText(label, "gui.dialog.NBSelectLMPanel.lineLabel");

			for (int i = 0; i < view.getLineCount(); i++)
				combo.addItem(view.getLine(i));

			if (view.mouseOverLine != -1)
				combo.setSelectedIndex(view.mouseOverLine);
		}
		else
		{
			RB.setText(label, "gui.dialog.NBSelectLMPanel.markerLabel");

			for (int i = 0; i < view.getMarkerCount(); i++)
				combo.addItem(view.getMarker(i));

			if (view.mouseOverMarker != -1)
				combo.setSelectedIndex(view.mouseOverMarker);
		}
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();

        label.setLabelFor(combo);
        label.setText("Select comparison line:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(combo, 0, 255, Short.MAX_VALUE)
                    .add(label))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(label)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(combo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JComboBox combo;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}