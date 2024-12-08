/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.DaoCliente;
import model.cliente;
import view.FCadcliente;
import view.FConscliente;
import view.modelcliente;

/**
 *
 * @author aluno
 */
public class ControlerCliente {

    private FCadcliente fcadcliente;
    private FConscliente fconscliente;
    private modelcliente modelcliente;
    private cliente clienteselecionado;
    private DaoCliente daoc;

    public ControlerCliente() throws ParseException {
        fcadcliente = new FCadcliente(null, true);
        fconscliente = new FConscliente(null, true);
        modelcliente = new modelcliente();
        clienteselecionado = null;
        daoc = new DaoCliente();
        inicializarcomponentes();
    }

    public void ConsultarCliente() {
        CarregarClientes();
        fconscliente.setVisible(true);
    }

    public void CarregarClientes() {
        modelcliente.limpar();
        for (cliente c : daoc.listar()) {
            modelcliente.addCliente(c);
        }
    }

    public void inicializarcomponentes() throws ParseException {

        fconscliente.Tbconscliente.setModel(modelcliente);

        fcadcliente.eddatanasc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

        fcadcliente.btgravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GravarCliente();
                } catch (ParseException ex) {
                    Logger.getLogger(ControlerCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        fcadcliente.btcancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancelar();
            }
        });

        fconscliente.bteditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });

        fconscliente.btexcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });

    }

    public void editar() {
        int linhaselecionada = fconscliente.Tbconscliente.getSelectedRow();
        if (linhaselecionada >= 0) {
            clienteselecionado = modelcliente.pegar(linhaselecionada);
            fcadcliente.ednome.setText(clienteselecionado.getNome());
            fcadcliente.edtelefone.setText(clienteselecionado.getTelefone());
            fcadcliente.edcpf.setText(clienteselecionado.getCpf());
            Date dataNascimento = clienteselecionado.getDataNascimento();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = dateFormat.format(dataNascimento);
            fcadcliente.eddatanasc.setText(dataFormatada);
            fconscliente.setVisible(false);
            fcadcliente.setVisible(true);
            fcadcliente.setVisible(false);
            fconscliente.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
    }

    public void excluir() {
        int linhaselecionada = fconscliente.Tbconscliente.getSelectedRow();
        if (linhaselecionada >= 0) {
            if (JOptionPane.showConfirmDialog(null, "confirma a axclusão do registro?", "confirmação", 0) == 0) {
 
                cliente c = modelcliente.pegar(linhaselecionada);
                if (daoc.excluir(c)) {
                    modelcliente.Excluir(linhaselecionada);
                    JOptionPane.showMessageDialog(null, "Excluído!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
    }

    public void GravarCliente() throws ParseException {
        
        if (fcadcliente.ednome.getText().isEmpty() || 
        fcadcliente.edcpf.getText().isEmpty() || 
        fcadcliente.eddatanasc.getText().isEmpty() || 
        fcadcliente.edtelefone.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
        return;
    }
        
        if (clienteselecionado == null) {
            String nome = fcadcliente.ednome.getText();
            String cpf = fcadcliente.edcpf.getText();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(fcadcliente.eddatanasc.getText());
            String telefone = fcadcliente.edtelefone.getText();
            cliente c = new cliente(cpf, nome, data, telefone);

            if (daoc.inserir(c)) {
                JOptionPane.showMessageDialog(null, "Gravado!");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "ERRO):");
                limpar();
            }
        } else {
            String nome = fcadcliente.ednome.getText();
            clienteselecionado.setNome(nome);
            String cpf = fcadcliente.edcpf.getText();
            clienteselecionado.setCpf(cpf);
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(fcadcliente.eddatanasc.getText());
            clienteselecionado.setDataNascimento(data);
            String telefone = fcadcliente.edtelefone.getText();
            clienteselecionado.setTelefone(telefone);

            if (daoc.editar(clienteselecionado)) {
                JOptionPane.showMessageDialog(null, "Editado!");
                limpar();
                fcadcliente.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
    }

    public void limpar() {
        fcadcliente.edcpf.setText("");
        fcadcliente.eddatanasc.setText("");
        fcadcliente.ednome.setText("");
        fcadcliente.edtelefone.setText("");
    }

    public void cadastrarcliente() {
        fcadcliente.setVisible(true);
    }

    public void Cancelar() {
        limpar();
        fcadcliente.setVisible(false);
    }
}
