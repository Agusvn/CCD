package Aplicacion;

import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class Focus implements FocusListener{
    private String obligatorioText;
    private Color obligatorioColor;
    private Color normalColor;

    public Focus(String obligatorioText, Color obligatorioColor, Color normalColor) {
        this.obligatorioText = obligatorioText;
        this.obligatorioColor = obligatorioColor;
        this.normalColor = normalColor;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (((JTextField) e.getSource()).getText().equals(obligatorioText)) {
            ((JTextField) e.getSource()).setText("");
            ((JTextField) e.getSource()).setForeground(normalColor);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (((JTextField) e.getSource()).getText().isEmpty()) {
            ((JTextField) e.getSource()).setText(obligatorioText);
            ((JTextField) e.getSource()).setForeground(obligatorioColor);
        }
    }
}
