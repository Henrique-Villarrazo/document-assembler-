package br.com.villarrazo.documentassembler.tree;

import java.util.ArrayList;

import br.com.villarrazo.documentassembler.node.Node;

public class Leaf extends Node {

	private String text;

	public Leaf(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getClasse() {
		return 0;
	}

	public int getAltura() {
		return 0;
	}

	public ArrayList<Node> getSubNos() {
		return null;
	}
}