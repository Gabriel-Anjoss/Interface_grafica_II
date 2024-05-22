import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Aula6 extends JFrame {
    JButton Cadastrar, Ver, Sair;
    JLabel Texto, Nome, Estado, Sexo, Rodape;
    String nome = "", sexo = "";
    String estadoSelecionado;

    public Aula6() {
        super("Aula 6");
        setSize(600, 300);
        setResizable(false);
        setLayout(null);
        Container tela = getContentPane();

        Nome = new JLabel();
        Estado = new JLabel();
        Sexo = new JLabel();
        Rodape = new JLabel("Desenvolvido por Gabriel Anjos do 2º DS-AMS");
        Rodape.setHorizontalAlignment(SwingConstants.CENTER);
        Rodape.setForeground(Color.GRAY);

        Cadastrar = new JButton("Cadastrar");
        Ver = new JButton("Ver Perfil");
        Sair = new JButton("Sair");
        Texto = new JLabel("Os Dados Cadastrados foram: ");

        Nome.setBounds(100, 50, 400, 30);
        Estado.setBounds(100, 100, 400, 20);
        Sexo.setBounds(100, 150, 200, 10);
        Texto.setBounds(150, 10, 400, 20);
        Rodape.setBounds(-10, 200, 600, 20);

        Cadastrar.setBounds(180, 80, 200, 20);
        Ver.setBounds(180, 120, 200, 20);
        Sair.setBounds(180, 160, 200, 20);

        Sair.addActionListener((ActionEvent e) -> {
            int seles = JOptionPane.showOptionDialog(null, "Deseja mesmo fechar a janela?", "Fechar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Sim", "Não"}, "Não");
            if (seles == JOptionPane.YES_OPTION)
                System.exit(0);
        });

        Cadastrar.addActionListener((ActionEvent e) -> {
            if (validarNome() && validarSexo()) {
                Object estados[] = {"Amazonas", "Pará", "Maranhão", "Piauí", "Ceará", "Rio Grande do Norte", "Paraíba", "Pernambuco", "Alagoas",
                        "Sergipe", "Bahia", "Minas Gerais", "Espírito Santo", "Rio de Janeiro", "São Paulo", "Paraná", "Santa Catarina", "Rio Grande do Sul",
                        "Mato Grosso", "Mato Grosso do Sul", "Goiás", "Distrito Federal"};
                estadoSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione seu Estado", "Enquete", JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

                Sexo.setText("O Sexo cadastrado foi: " + sexo.toUpperCase());

                Estado.setText("O Estado Cadastrado foi: " + estadoSelecionado);

                exibirDadosCadastrados();
            }
        });

        Ver.addActionListener((ActionEvent e) -> {
            if (nome.isEmpty() || estadoSelecionado == null || sexo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, faça o cadastro primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                exibirDadosCadastrados();
            }
        });

        tela.add(Nome);
        tela.add(Sexo);
        tela.add(Estado);
        tela.add(Texto);
        tela.add(Rodape);

        Nome.setVisible(false);
        Sexo.setVisible(false);
        Estado.setVisible(false);
        Texto.setVisible(false);

        tela.add(Ver);
        tela.add(Cadastrar);
        tela.add(Sair);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean validarNome() {
        nome = JOptionPane.showInputDialog("Escreva seu nome completo: ");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ficar em branco. Por favor, insira seu nome completo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarSexo() {
        do {
            sexo = JOptionPane.showInputDialog("Entre com seu Sexo(M/F): ");
            if (sexo == null || sexo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo sexo não pode ficar em branco. Por favor, digite 'M' para masculino ou 'F' para feminino.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
                JOptionPane.showMessageDialog(null, "Dado inválido no campo sexo. Por favor, digite 'M' para masculino ou 'F' para feminino.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                return true;
            }
        } while (true);
    }

    private void exibirDadosCadastrados() {
        JFrame frame = new JFrame("Perfil");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 1));

        JLabel lblNome = new JLabel("Nome: " + nome);
        JLabel lblSexo = new JLabel("Sexo: " + sexo.toUpperCase());
        JLabel lblEstado = new JLabel("Estado: " + estadoSelecionado);
        

        frame.add(lblNome);
        frame.add(lblSexo);
        frame.add(lblEstado);
        

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Aula6 app = new Aula6();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
