package br.com.villarrazo.documentassembler.traversal;

import br.com.villarrazo.documentassembler.node.Node;
import br.com.villarrazo.documentassembler.tree.Branch;
import br.com.villarrazo.documentassembler.tree.Leaf;

public class OrdemDeTransversal extends Transversal {
	public void assemble(Node root) {

		if (root instanceof Leaf) {

			this.setText(root.getText() + " ");

		} else if (root instanceof Branch) {

			for (Node subNode : root.getSubNos()) {
				assemble(subNode);
			}
		}
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text += text;
	}

}
