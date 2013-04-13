package com.jsfpoc.mbeans;

import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.TreeNode;

public class Station implements TreeNode {

	private boolean expanded = false;
	private Station parent;
	private List<Station> children = new ArrayList<Station>();
	// data:
	private String name;

	public Station(String name) {
		this.parent = null;
		this.name = name;
	}

	public Station(Station parent, String name) {
		this.parent = parent;
		parent.addChildren(this);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return "station";
	}

	// expanded control
	public boolean getExpanded() {
		return this.expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	// implementation of TreeNode itnerface
	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	public int getChildCount() {
		return children.size();
	}

	public TreeNode getParent() {
		return parent;
	}

	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}

	public Enumeration<Station> children() {
		return Iterators.asEnumeration(children.iterator());
	}

	private void addChildren(Station child) {
		children.add(child);
	}
}
