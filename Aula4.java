import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Aula4 extends JFrame {

    JList Lista;
    String times[] = {"Corinthians", "Internacional", "Gremio", "São Paulo", "Santos", "Flamengo", "Vasco"};
    JButton exibir;
    JLabel rotulo, texto;
    JComboBox Lista2;
    String esporte[] = {"Futebol", "Basquete"};

    public Aula4() {

        super("Esportes");
        setSize(600, 450);
        setResizable(false);
        setLayout(null);
        Container tela = getContentPane();


        Lista = new JList(times);
        Lista2 = new JComboBox(esporte);
        texto = new JLabel("Escolha o time que deseja torcer e em qual esporte:");
        rotulo = new JLabel("");
        exibir = new JButton("Torcer");

        Lista.setVisibleRowCount(5);
        Lista2.setMaximumRowCount(5);


        JScrollPane painelRolagem = new JScrollPane(Lista);
        Lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        texto.setBounds(40, 10, 500, 100);
        painelRolagem.setBounds(40, 80, 150, 100);
        rotulo.setBounds(40, 250, 500, 30);
        Lista2.setBounds(40, 200, 200, 30);

        exibir.setBounds(250, 300, 100, 30);


        exibir.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        rotulo.setText("O time escolhido foi " + Lista.getSelectedValue().toString() + " e o esporte " + Lista2.getSelectedItem());

                    }

                }
        );


        tela.add(texto);

        tela.add(Lista2);
        tela.add(painelRolagem);
        tela.add(exibir);
        tela.add(rotulo);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        Aula4 app = new Aula4();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}
