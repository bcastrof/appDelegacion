/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author bcastrof
 */
class ButtonsPanel extends JPanel {

    public final List<JButton> buttons = new ArrayList<>();

    public ButtonsPanel (){
        super(new FlowLayout(FlowLayout.LEFT));
        setOpaque(false);
        String option;
        for (Actions a : Actions.values()) {
            JButton b = new JButton(a.toString());
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            b.setText("");
            b.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white));

            if (a.toString().equalsIgnoreCase("print")) {
                b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save-icon.png")));

            } else {
                b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Search-icon (1).png")));
            }

            add(b);
            buttons.add(b);
        }
    }

  

    //refesco botones
    protected void updateButtons(Object value) {
        if (value instanceof EnumSet) {
            EnumSet ea = (EnumSet) value;
            removeAll();
            if (ea.contains(Actions.UPDATE)) {
                add(buttons.get(0));
            }
            if (ea.contains(Actions.DELETE)) {
                add(buttons.get(1));
            }
        }
    }
}
//render

class ButtonsRenderer implements TableCellRenderer {

    private final ButtonsPanel panel;

    ButtonsRenderer(String name) {
        this.panel = new ButtonsPanel();
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        panel.updateButtons(value);
        return panel;
    }
}
//accion boton print

class UpdateAction extends AbstractAction {

    private final JTable table;

    public UpdateAction(JTable table) {
        super(Actions.UPDATE.toString());

        this.table = table;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 2);

        String opcion = table.getName();

        switch (opcion) {
            case "tUsuarios": {
                JOptionPane.showMessageDialog(table, "Printing: " + o);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(table, "default: " + o);
            }
        }
    }
}

//acccion boton editar
class DeleteAction extends AbstractAction {

    private final JTable table;

    public DeleteAction(JTable table) {
        super(Actions.DELETE.toString());
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 0);
        String opcion = table.getName();

        switch (opcion) {
            case "tUsuarios": {
                JOptionPane.showMessageDialog(table, "Editing: " + o);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(table, "default: " + o);
            }
        }
    }
}

class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {

    private final ButtonsPanel panel;
    private final JTable table;
    private Object o;

    private class EditingStopHandler extends MouseAdapter implements ActionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            Object o = e.getSource();
            if (o instanceof TableCellEditor) {
                actionPerformed(null);
            } else if (o instanceof JButton) {
                ButtonModel m = ((JButton) e.getComponent()).getModel();
                if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    panel.setBackground(table.getBackground());
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(() -> {
                fireEditingStopped();
            });
        }
    }

    public ButtonsEditor(JTable table) {
        super();
        this.panel = new ButtonsPanel();
        this.table = table;
        panel.buttons.get(0).setAction(new UpdateAction(table));
        panel.buttons.get(1).setAction(new DeleteAction(table));
        panel.buttons.get(0).setText("");
        panel.buttons.get(1).setText("");
        panel.buttons.get(1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Search-icon (1).png")));
        panel.buttons.get(1).setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white));
        panel.buttons.get(0).setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white));
        panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save-icon.png")));
        EditingStopHandler handler = new EditingStopHandler();
        panel.buttons.stream().map((b) -> {
            b.addMouseListener(handler);
            return b;
        }).forEachOrdered((b) -> {
            b.addActionListener(handler);
        });
        panel.addMouseListener(handler);
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        panel.setBackground(table.getSelectionBackground());
        panel.updateButtons(value);
        o = value;
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return o;
    }
}
