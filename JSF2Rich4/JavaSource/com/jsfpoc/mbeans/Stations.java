package com.jsfpoc.mbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.swing.tree.TreeNode;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;

@ManagedBean
@ApplicationScoped
public class Stations {

	private String[] names = { "Hall & Oates - Kiss On My List",
			"David Bowie - Let's Dance", "Lyn Collins - Think (About It)",
			"Kim Carnes - Bette Davis Eyes",
			"KC & the Sunshine Band - Give It Up" };
	//
	private List<TreeNode> rootTreeNodes = new ArrayList<TreeNode>();
	private Collection<Object> selectionRowKeys = new ArrayList<Object>();
	private TreeNode selectedTreeNode = null;

	public Stations() {

		for (int i = 0; i < 3; i++) {
			Station directory = new Station("Directory " + i);
			rootTreeNodes.add(directory);
			for (int j = 0; j < names.length; j++) {
				Station child = new Station(directory, names[j]);
			}
		}
	}

	public List<TreeNode> getRootNodes() {
		return rootTreeNodes;
	}

	public Collection<Object> getSelection() {
		return selectionRowKeys;
	}

	public void setSelection(Collection<Object> selection) {
		/**
		 * this is not explicitely called by framework, obviously the element is
		 * added to the collection retrieved by getSelection()
		 */
		this.selectionRowKeys = selection;
	}

	public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
		// considering only single selection
		List<Object> selection = new ArrayList<Object>(
				selectionChangeEvent.getNewSelection());
		Object currentSelectionKey = selection.get(0);
		UITree tree = (UITree) selectionChangeEvent.getSource();

		Object storedKey = tree.getRowKey();
		tree.setRowKey(currentSelectionKey);
		selectedTreeNode = (TreeNode) tree.getRowData();
		tree.setRowKey(storedKey);
	}
}
