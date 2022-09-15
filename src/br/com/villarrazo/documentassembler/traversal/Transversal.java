package br.com.villarrazo.documentassembler.traversal;

import br.com.villarrazo.documentassembler.node.Node;

public abstract class Transversal {
	    
	protected String text = "";

	public abstract void assemble(Node root);

	public abstract String getText();
	public abstract void setText(String text);

}

