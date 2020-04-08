package com.company;

import com.company.gui.app_model.PatientRegister;
import javax.swing.*;

/**<b>Aplikacja do obsługi pacjentów</b>
 * aplikacja służy do przechowywania i obsługi rejestru pacjentów oraz ich badań.
 * Dane są przechowywane w postaci instancji klasy <code>PatientRegister</code>,
 * a ich obsługa realizowana jest przez klasę <code>AppView</code>.
 * @author Janek Grzegorek
 * @author Witek Synowiec
 * @since 14*/

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //default
        }
        PatientRegister register = new PatientRegister();
        Runnable thread = () -> {
            com.company.gui.app_view.AppView app = new com.company.gui.app_view.AppView(register);
            app.setVisible(true);
        };
        SwingUtilities.invokeLater(thread);

    }
}
