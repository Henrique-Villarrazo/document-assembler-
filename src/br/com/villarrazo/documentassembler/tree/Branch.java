package br.com.villarrazo.documentassembler.tree;

import java.util.ArrayList;

import br.com.villarrazo.documentassembler.node.Node;

public class Branch extends Node {

	private final ArrayList<Node> subNodes = new ArrayList<>();

	public String getText() {
		return null;
	}

	public void addNode(Node filho) {

		filho.setNivel(this.getNivel() + 1);
		subNodes.add(filho);
	}

	public void removeNode(Node filho) {

		subNodes.remove(filho);
	}

	public int getClasse() {
		int classe = 0;

		for (Node subNo : subNodes) {
			classe++;
			classe += subNo.getClasse();
		}
		return classe;
	}

	public int getAltura() {

		int alturaBase = this.getNivel();
		int maxAltura = alturaBase;

		for (Node node : subNodes) {

			if (node.getNivel() > maxAltura) {
				maxAltura = node.getNivel();
				node.getAltura();
			}
		}
		return (maxAltura - alturaBase);
	}

	public ArrayList<Node> getSubNos() {
		return this.subNodes;
	}

}