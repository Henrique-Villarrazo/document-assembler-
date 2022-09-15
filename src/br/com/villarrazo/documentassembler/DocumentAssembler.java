package br.com.villarrazo.documentassembler;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import br.com.villarrazo.documentassembler.traversal.OrdemDeTransversal;
import br.com.villarrazo.documentassembler.traversal.Transversal;
import br.com.villarrazo.documentassembler.tree.Branch;
import br.com.villarrazo.documentassembler.tree.Leaf;

public class DocumentAssembler {

	private Branch base;
	private Transversal transversalMetodo;
	private String outputFileName;

	public DocumentAssembler(Branch base, Transversal chosenTransversalMetodo, String outputFileName) {
		this.base = base;
		this.transversalMetodo = chosenTransversalMetodo;
		this.outputFileName = outputFileName;
	}

	public static void main(String[] args) throws Exception {

		Branch base = new Branch();
		Branch branch1 = new Branch();
		Branch branch2 = new Branch();

		base.addNode(new Leaf("Texto"));
		base.addNode(branch1);

		branch1.addNode(new Leaf("exemplo"));
		branch1.addNode(new Leaf("para"));
		branch1.addNode(branch2);

		branch2.addNode(new Leaf("criação"));
		branch2.addNode(new Leaf("de documento"));

		DocumentAssembler var = new DocumentAssembler(base, new OrdemDeTransversal(), "document.txt");
		var.txtAssemble();
	}

	public void consoleAssembler() {

		transversalMetodo.assemble(this.base);
		System.out.println(transversalMetodo.getText());
	}

	public void txtAssemble() { 

		transversalMetodo.assemble(this.base);
		FileWriter saida = null;

		try { 
			FileOutputStream apagarConteudoDoDocumento = new FileOutputStream(this.getOutputFileName());

			saida = new FileWriter(this.getOutputFileName(), true);
			saida.write(this.transversalMetodo.getText());
			saida.write("\nLog: " + java.time.LocalDate.now() + "" + java.time.LocalTime.now());
			saida.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void getOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
}
