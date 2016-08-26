
public class BST<E extends Comparable<E>> extends AbstractTree<E>{
	protected TreeNode<E> root;
	protected int size = 0;
	
	private class TreeNode<E>{
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;
		
		public TreeNode(E e){
			element = e;
		}
	}
	
	public BST(E[] objects){
		for(E element : objects){
			insert(element);
		}
	}
	
	
	@Override
	public boolean search(E e) {
		TreeNode<E> current = root;
		while(current != null){
			if(e.compareTo(current.element)<0){
				current=current.left;
			}
			else if(e.compareTo(current.element)>0){
				current=current.right;
			}
			else
				return true;
		}
		return false;
	}

	@Override
	public boolean insert(E e) {
		if(root == null){
			root=createNewNode(e);
		}
		else{
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current != null){
				if(e.compareTo(current.element)<0){
					parent = current;
					current = current.left;
				}
				if(e.compareTo(current.element)>0){
					parent = current;
					current = current.right;
				}
				else
					return false;
			}
			
			if(e.compareTo(parent.element)<0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}
		return false;
	}
	
	protected TreeNode<E> createNewNode(E e){
		return new TreeNode<E>(e);
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
