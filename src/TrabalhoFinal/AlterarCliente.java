package TrabalhoFinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import TrabalhoFinal.Cliente;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class AlterarCliente extends JFrame {

	private JLabel jlbCodigo = new JLabel("Codigo");
	private JLabel jlbNome = new JLabel("Nome");
	private JLabel jlbCpf = new JLabel("Cpf");
	private JLabel jlbRg = new JLabel("Rg");
	private JLabel jlbEndereco = new JLabel("Rua");
	private JLabel jlbNumero = new JLabel("Numero");
	private JLabel jlbCidade = new JLabel("Cidade");
	private JLabel JlbEstado = new JLabel("UF");
	private JLabel jlbTelefone = new JLabel("Telefone");
	private JLabel jlbEmail = new JLabel("Email");
	private JLabel jlbObs = new JLabel("Obs:");
	private JTextField jtfCodigo = new JTextField();
	private JTextField jtfNome = new JTextField();
	private JTextField jtfCpf = new JTextField();
	private JTextField jtfRg = new JTextField();
	private JTextField jtfEndereco = new JTextField();
	private JTextField jtfNumero = new JTextField();
	private JTextField jtfCidade = new JTextField();
	private JTextField jtfTelefone = new JTextField();
	private JTextField jtfEmail = new JTextField();
	private JTextField jtfObs = new JTextField();
	private JButton jbtAlterar = new JButton("Alterar");
	private JButton jbtFechar = new JButton("Fechar");
	private JComboBox<UF> jcbEstado = new JComboBox<UF>();
	int opcao = 0, aux = 1, posicao = 0;
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco.db4o");
	ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);

	private void posicionaObjeto(JComponent obj, int x, int y, int w, int h) {
		obj.setBounds(x, y, w, h);
		getContentPane().add(obj);
	}

	public void setValor1(int a) {
		jtfObs.setText(String.valueOf(a));
		jtfObs.setVisible(false);
		for (Integer i = 0; i < clientes.size(); i++) {

			if (i.equals(a)) {
				jtfCodigo.setText(String.valueOf(clientes.get(i).getCodigo()));
				jtfNome.setText(clientes.get(i).getNome());
				jtfCidade.setText(clientes.get(i).getEndereco().getCidade());
				jtfCpf.setText(String.valueOf(clientes.get(i).getCpf()));
				jtfEmail.setText(clientes.get(i).getEmail());
				jtfEndereco.setText(clientes.get(i).getEndereco().getRua());
				jcbEstado.setSelectedItem(clientes.get(i).getEndereco().getUf());
				jtfNumero.setText(String.valueOf(clientes.get(i).getEndereco().getNumero()));
				jtfRg.setText(String.valueOf(clientes.get(i).getRg()));
				jtfTelefone.setText(String.valueOf(clientes.get(i).getTelefone()));
			}
		}

	}

	AlterarCliente() {
		setTitle("Financeiro");
		setLayout(null);

		posicionaObjeto(jlbCodigo, 100, 10, 80, 25);
		posicionaObjeto(jtfCodigo, 150, 10, 170, 25);
		posicionaObjeto(jlbNome, 105, 40, 80, 25);
		posicionaObjeto(jtfNome, 150, 40, 170, 25);
		posicionaObjeto(jlbCpf, 120, 70, 80, 25);
		posicionaObjeto(jtfCpf, 150, 70, 170, 25);
		posicionaObjeto(jlbRg, 125, 100, 80, 25);
		posicionaObjeto(jtfRg, 150, 100, 170, 25);
		posicionaObjeto(jlbEndereco, 120, 130, 80, 25);
		posicionaObjeto(jtfEndereco, 150, 130, 170, 25);
		posicionaObjeto(jlbNumero, 100, 160, 80, 25);
		posicionaObjeto(jtfNumero, 150, 160, 170, 25);
		posicionaObjeto(jlbCidade, 105, 190, 80, 25);
		posicionaObjeto(jtfCidade, 150, 190, 170, 25);
		posicionaObjeto(JlbEstado, 130, 220, 80, 25);
		posicionaObjeto(jcbEstado, 150, 220, 170, 25);
		posicionaObjeto(jlbTelefone, 95, 250, 80, 25);
		posicionaObjeto(jtfTelefone, 150, 250, 170, 25);
		posicionaObjeto(jlbEmail, 110, 290, 80, 25);
		posicionaObjeto(jtfEmail, 150, 290, 170, 25);
		posicionaObjeto(jbtAlterar, 40, 330, 120, 40);
		posicionaObjeto(jbtFechar, 220, 340, 100, 25);
		jcbEstado.addItem(UF.AC);
		jcbEstado.addItem(UF.AL);
		jcbEstado.addItem(UF.AM);
		jcbEstado.addItem(UF.AP);
		jcbEstado.addItem(UF.BA);
		jcbEstado.addItem(UF.CE);
		jcbEstado.addItem(UF.DF);
		jcbEstado.addItem(UF.ES);
		jcbEstado.addItem(UF.GO);
		jcbEstado.addItem(UF.MA);
		jcbEstado.addItem(UF.MG);
		jcbEstado.addItem(UF.MS);
		jcbEstado.addItem(UF.MT);
		jcbEstado.addItem(UF.PA);
		jcbEstado.addItem(UF.PB);
		jcbEstado.addItem(UF.PE);
		jcbEstado.addItem(UF.PI);
		jcbEstado.addItem(UF.PR);
		jcbEstado.addItem(UF.RJ);
		jcbEstado.addItem(UF.RN);
		jcbEstado.addItem(UF.RO);
		jcbEstado.addItem(UF.RR);
		jcbEstado.addItem(UF.RS);
		jcbEstado.addItem(UF.SC);
		jcbEstado.addItem(UF.SE);
		jcbEstado.addItem(UF.SP);
		jcbEstado.addItem(UF.TO);

		jbtAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
				Endereco endereco = new Endereco();
				Cliente cliente = new Cliente();
				cliente = clientes.get(Integer.valueOf(jtfObs.getText()));
				cliente.setCodigo(Integer.parseInt(jtfCodigo.getText()));
				cliente.setNome(jtfNome.getText());
				cliente.setCpf(Long.parseLong(jtfCpf.getText()));
				cliente.setEmail(jtfEmail.getText());
				cliente.setRg(Long.parseLong(jtfRg.getText()));
				cliente.setTelefone(Long.parseLong(jtfTelefone.getText()));
				endereco.setRua(jtfEndereco.getText());
				endereco.setNumero(Integer.parseInt(jtfNumero.getText()));
				endereco.setCidade(jtfCidade.getText());
				endereco.setUf((UF) jcbEstado.getSelectedItem());
				cliente.setEndereco(endereco);
				bancoDeDados.store(cliente);
				bancoDeDados.close();
				JOptionPane.showMessageDialog(null, "Altera��o realizada com sucesso");
				dispose();
				new CadastrarCliente();
			}
		});
		jbtFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
				new CadastrarCliente();

			}
		});
		setSize(410, 410);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		setVisible(true);

	}

}
