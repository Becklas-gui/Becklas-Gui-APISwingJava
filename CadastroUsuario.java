import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import javax.swing.ButtonGroup;

public class CadastroUsuario {

    public static void main (String[] args){
        
        int[] id = new int[2];
        id[0] = 0;
        
        JFrame CadastroDeUsuario = new JFrame("Cadastro de Usuário");
        CadastroDeUsuario.setSize(1200,1000);
        CadastroDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel que agrupa todos os elementos
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        //adiciona o painel dentro do JFrame
        CadastroDeUsuario.add(painel);
        painel.setLayout(null);

        //Título do cadastro de nome 
        JLabel NomeTexto = new JLabel("Digite seu nome:      ");

        JTextField NomeCampo = new JTextField();
        painel.add(NomeTexto);
        painel.add(NomeCampo);


        //posição na tela e tamanho
        NomeTexto.setBounds(333,50,500,100);
        NomeCampo.setBounds(333, 120,500,50);

        //Título do campo de email
        JLabel EmailTexto = new JLabel("Digite seu email:        ");
        JTextField EmailCampo = new JTextField();
        painel.add(EmailTexto);
        painel.add(EmailCampo);


        //posição na tela e tamanho dnv
        EmailTexto.setBounds(333,150,500,100);
        EmailCampo.setBounds(333,220,500,50);

        //Título do campo de idade
        JLabel IdadeTexto = new JLabel("Digite sua idade:        ");
        JFormattedTextField CampoIdade = new JFormattedTextField();

        //máscara para permitir apenas números
        MaskFormatter mascaraIdade = null;
        try {
            //a máscara de idade é feita com #, que permite apenas números, e o # é repetido 3 vezes para permitir idades de até 3 digitos, pelo que eu entendi
        
            mascaraIdade = new MaskFormatter("###");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //instala a máscara no campo de idade
        mascaraIdade.install(CampoIdade);
        CampoIdade.setText("");
        painel.add(IdadeTexto);
        painel.add(CampoIdade);
        //posição deles na tela e tamanho deles
        IdadeTexto.setBounds(333,250,500,100);
        CampoIdade.setBounds(333,320,500,50);

        //seleção de gênero
        JLabel TextoGenero = new JLabel("Insira o seu gênero:     ");
        JRadioButton opMasculino = new JRadioButton("Masculino");
        JRadioButton opFeminino = new JRadioButton("Feminino");
        ButtonGroup opGenero = new ButtonGroup();
        opGenero.add(opMasculino);
        opGenero.add(opFeminino);
        TextoGenero.setBounds(333,350,150,100);
        opMasculino.setBounds(463,375, 100, 50);
        opFeminino.setBounds(573,375, 100, 50);

        painel.add(TextoGenero);
        painel.add(opMasculino);
        painel.add(opFeminino);

        //Criação do array de usuários, que vai armazenar os dados dos usuários cadastrados
        Usuario[] usuario = new Usuario[10];
        usuario[0] = new Usuario(id[0], "null", "null", "null", 0);

        //botão de cadastrar usuário
        JButton botaoCadastrar = new JButton("Cadastrar usuário");
        botaoCadastrar.setBounds(333,450, 225, 70);
        
        botaoCadastrar.addActionListener(cadastrarUsuario -> {
            if(id[0]<10){

            String generoEscolhido;

            if((NomeCampo.getText().trim().equals(""))||((!opFeminino.isSelected())&&(!opMasculino.isSelected()))||(EmailCampo.getText().trim().equals(""))||(CampoIdade.getText().trim().equals(""))){
                JOptionPane.showMessageDialog(null, "Algo deu errado! Verifique se algum um dos campos de informação está incompleto!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                //verifica se o usuário escolheu um gênero, e atribui o valor da variável generoEscolhido de acordo com a escolha
                if(opFeminino.isSelected()){
                    generoEscolhido = "Feminino";
                }else{
                    generoEscolhido = "Masculino";
                };
                usuario[id[0]] = new Usuario(id[0], NomeCampo.getText().trim(), generoEscolhido, EmailCampo.getText().trim(), Integer.parseInt(CampoIdade.getText().trim()));
                JOptionPane.showMessageDialog(null, "Usuário cadastrado! \nNome: " + usuario[id[0]].getnome() + "\nGênero: " + usuario[id[0]].getgenero() + "\nEmail: " + usuario[id[0]].getemail() + "\nIdade: " + usuario[id[0]].getidade());
                
                id[0] = id[0] + 1;
                };
            }else{
         JOptionPane.showMessageDialog(null, "Tem um limite máximo de 10 contas nesse projeto, respeite ele", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        });
        painel.add(botaoCadastrar);

        //botão para limpar os campos de cadastro
        JButton botaoApagar = new JButton("Limpar dados inseridos");
        botaoApagar.setBounds(608,450, 225, 70);
        botaoApagar.addActionListener(limparCampos -> {

            NomeCampo.setText("");
            EmailCampo.setText("");
            CampoIdade.setText("");
            opGenero.clearSelection();
        });
        painel.add(botaoApagar);

        CadastroDeUsuario.setVisible(true);
    }
}