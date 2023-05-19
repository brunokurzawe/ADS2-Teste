import model.Cliente;
import model.Produto;
import model.Venda;
import repository.ClienteDAO;
import repository.ProdutoDAO;
import repository.VendaDAO;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        chamaMenuPrincipal();
    }

    private static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao) {
            case 0: //Cadastros
                chamaMenuCadastros();
                break;
            case 1: //Processos

                break;
            case 2: //Relatorios
                JOptionPane.showMessageDialog(null, ClienteDAO.buscaTodos());
                JOptionPane.showMessageDialog(null, VendaDAO.buscaTodos());
                chamaMenuPrincipal();
                break;
            case 3: //SAIR

                break;
        }
    }

    private static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Cliente", "Produto", "Venda", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Pessoa
                cadastroDeCliente();
                break;
            case 1: //Produtos
                cadastroDeProduto();
                break;
            case 2: //Seguro
                chamaCadastroVenda();
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    private static void cadastroDeCliente() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente");
        String email = JOptionPane.showInputDialog(null, "Digite o email do cliente");
        Cliente cliente = new Cliente(nome, cpf, email);
        ClienteDAO.salvar(cliente);
        chamaMenuPrincipal();
    }

    private static void cadastroDeProduto() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto");
        Double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do produto"));
        Produto produto = new Produto(nome, valorUnitario);
        ProdutoDAO.salvar(produto);
        chamaMenuPrincipal();
    }

    private static void chamaCadastroVenda() {
        LocalDate dataVenda = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");

        try {
            dataVenda = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
        }

        Object[] selectionValues = ClienteDAO.findClientesInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente da venda?",
                "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cliente> clientes = ClienteDAO.buscarPorNome((String) selection);


        Object[] selectionValuesProdutos = ProdutoDAO.findprodutosInArray();
        String initialSelectionSeguradora = (String) selectionValuesProdutos[0];
        Object selectionSeguradora = JOptionPane.showInputDialog(null, "Selecione o produto da venda?",
                "VendasApp", JOptionPane.QUESTION_MESSAGE, null, selectionValuesProdutos, initialSelectionSeguradora);
        List<Produto> produtos = ProdutoDAO.buscarPorNome((String) selectionSeguradora);

        Venda venda = new Venda(produtos.get(0), clientes.get(0), dataVenda);

        VendaDAO.salvar(venda);

    }

}