import java.util.*;
// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode t01 = new TreeLinkNode(1);
		TreeLinkNode t02 = new TreeLinkNode(2);
		TreeLinkNode t03 = new TreeLinkNode(3);
		TreeLinkNode t04 = new TreeLinkNode(4);
		TreeLinkNode t05 = new TreeLinkNode(5);
		TreeLinkNode t06 = new TreeLinkNode(6);
		TreeLinkNode t07 = new TreeLinkNode(7);
		t01.left =t02;
		t01.right = t03;
		t02.left = t04;
		t02.right = t05;
		//t03.left = t06;
		t03.right = t07;
		Solution s = new Solution();
		s.connect(t01);
	}
	
	// I
//	public void connect(TreeLinkNode root) {
//        if(root == null){return;}
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//        ArrayList<TreeLinkNode> array = new ArrayList<TreeLinkNode>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeLinkNode temp = queue.poll();
//            array.add(temp);
//            if(temp.left != null){
//                queue.add(temp.left);
//                queue.add(temp.right);
//            }
//        }
//        for(int i = 0;i < array.size();i++){
//        	System.out.println((int)Math.ceil(Math.log(i+2)/Math.log(2)%1.0));
//            if( ((int)Math.ceil(Math.log(i+2)/Math.log(2)%1.0)) != 0 )
//                array.get(i).next = array.get(i+1);
//        }
//    }
	
	// II
	public void connect(TreeLinkNode root) {
	      if(root == null){return;}
	      
	      // bfs
	      Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	      HashMap<TreeLinkNode, Integer> map = new HashMap<TreeLinkNode, Integer>();
	      queue.add(root);
	      map.put(root,0);
	      while(!queue.isEmpty()){
	    	  TreeLinkNode temp = queue.poll();
	    	  int layer = map.get(temp);
	    	  if(!queue.isEmpty()){
	    		  TreeLinkNode next = queue.peek();
	    		  if(map.get(next) == layer){
	    			  temp.next = next;
	    		  }
	    	  }
	    	  if(temp.left != null){
	    		  map.put(temp.left, layer+1);
	    		  queue.add(temp.left);
	    	  }
	    	  if(temp.right != null){
	    		  map.put(temp.right, layer+1);
	    		  queue.add(temp.right);
	    	  }
	      }
	      return;
	}
    
    // II constant space
    public void connect(TreeLinkNode root) {
        if(root == null){return;}
        
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = nextAvailableNode(root);
        }else if(root.left != null && root.right == null){
            root.left.next = nextAvailableNode(root);
        }else if(root.right != null && root.left == null){
            root.right.next = nextAvailableNode(root);
        }
        connect(root.right);
        connect(root.left);
        
	}
	
	private TreeLinkNode nextAvailableNode(TreeLinkNode father){
	    while(father.next != null){
	        father = father.next;
	        if(father.left != null)
	            return father.left;
	        if(father.right != null)
	            return father.right;
	    }
	    return null;
	}
	      
//	public void connect(TreeLinkNode root) {
//      if(root == null){return;}
//      Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//      Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
//      ArrayList<TreeLinkNode> array = new ArrayList<TreeLinkNode>();
//      HashMap<TreeLinkNode, Integer> map = new HashMap<TreeLinkNode, Integer>();
//      stack.add(root);
//      map.put(root, 0);
//      int max_layer = 0;
//      while(!stack.isEmpty()){
//    	  TreeLinkNode temp = stack.pop();
//    	  int layer = map.get(temp);
//    	  if(layer > max_layer){max_layer = layer;}
//    	  if(temp.left != null){
//    		  stack.add(temp.left);
//    		  map.put(temp.left, layer+1);
//    	  }
//    	  if(temp.right != null){
//    		  stack.add(temp.right);
//    		  map.put(temp.right, layer+1);
//    	  }
//      }
//      
//      // initialize array
//      for(int i = 0;i < (int)(Math.pow(2, max_layer+1))-1;i++){
//    	  array.add(null);
//      }
//      
//      // put nodes into array
//      traverse(root, array, 0);
//
//      for(int i = 0;i < array.size();i++){
//    	  if( ((int)Math.ceil(Math.log(i+2)/Math.log(2)%1.0)) != 0 ){
//    		  if(array.get(i) != null){
//    			  int layer = map.get(array.get(i));
//    			  if(array.get(i+1) != null){
//    				  array.get(i).next = array.get(i+1);
//    			  }else{
//    				  int j = i+1;
//    				  while(array.get(j) == null){
//    					  if(j >= Math.pow(2, layer+1)-2){break;}
//    					  j++;
//    				  }
//    				  if(j <= Math.pow(2, layer+1)-1  ){
//    					  array.get(i).next = array.get(j);
//    				  }
//    			  }
//    		  }
//    	  }
//      }
//      
//    }
//	
//	private void traverse(TreeLinkNode cur, ArrayList<TreeLinkNode> arr, int index){
//		if(cur != null){
//			arr.set(index, cur);
//			traverse(cur.left, arr, 2*index+1);
//			traverse(cur.right, arr, 2*index+2);
//		}	
//	}
}


