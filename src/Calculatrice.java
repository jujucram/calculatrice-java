import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice extends JFrame implements ActionListener {
    JTextField ecran;
    double num1, num2, resultat;
    char operateur;

    public Calculatrice() {
        setTitle("Calculatrice Java");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ecran = new JTextField();
        ecran.setEditable(false);
        ecran.setFont(new Font("Arial", Font.BOLD, 30));
        add(ecran, BorderLayout.NORTH);

        JPanel panneau = new JPanel();
        panneau.setLayout(new GridLayout(4, 4, 10, 10));

        String[] boutons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String txt : boutons) {
            JButton bouton = new JButton(txt);
            bouton.setFont(new Font("Arial", Font.BOLD, 20));
            bouton.addActionListener(this);
            panneau.add(bouton);
        }

        add(panneau, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            ecran.setText(ecran.getText() + cmd);
        } else if (cmd.equals("C")) {
            ecran.setText("");
            num1 = num2 = resultat = 0;
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(ecran.getText());
            switch (operateur) {
                case '+': resultat = num1 + num2; break;
                case '-': resultat = num1 - num2; break;
                case '*': resultat = num1 * num2; break;
                case '/':
                    if (num2 != 0) {
                        resultat = num1 / num2;
                    } else {
                        ecran.setText("Erreur");
                        return;
                    }
                    break;
            }
            ecran.setText(String.valueOf(resultat));
        } else {
            num1 = Double.parseDouble(ecran.getText());
            operateur = cmd.charAt(0);
            ecran.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculatrice();
    }
}
