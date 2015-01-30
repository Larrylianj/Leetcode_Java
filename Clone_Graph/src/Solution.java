import java.util.ArrayList;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n11 = new UndirectedGraphNode(-1);
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
//		n11.neighbors.add(n11);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n2);
		Solution s = new Solution();
		UndirectedGraphNode root = s.cloneGraph(n11);
		int i = root.label;
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null){return null;}
		
	    // create a new Node with the same label put it as the last neighbor for the original node
		ArrayList<Integer> table = new ArrayList<Integer>();
	    UndirectedGraphNode cur = node;
	    UndirectedGraphNode rslt = null;
	    Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
	    s.push(node);
	    while(!s.isEmpty()){
	    	cur = s.pop();
	    	if(!table.contains(cur.label)){
	    		table.add(cur.label);
	    		for(int i = 0;i < cur.neighbors.size();i++){
	    			if(!table.contains(cur.neighbors.get(i).label)){
	    				s.push(cur.neighbors.get(i));
	    			}
	    		}
	    		UndirectedGraphNode newNode = new UndirectedGraphNode(cur.label);
	    		cur.neighbors.add(newNode);
	    	}
	    }
	    
	    // assign relationship for the new nodes
	    UndirectedGraphNode temp = null;
	    table.clear();
	    s.push(node);
	    while(!s.isEmpty()){
	    	cur = s.pop();
	    	if(!table.contains(cur.label)){
	    		table.add(cur.label);
	    		for(int i = 0;i < cur.neighbors.size()-1;i++){
	    			temp = cur.neighbors.get(i);
	    			cur.neighbors.get(cur.neighbors.size()-1).neighbors.add(temp.neighbors.get(temp.neighbors.size()-1));
	    			s.push(temp);
	    		}
	    	}
	    }
	    
	    rslt = node.neighbors.get(node.neighbors.size()-1);
	    
	    // delete the relationship between original nodes and new nodes
	    table.clear();
	    s.push(node);
	    while(!s.isEmpty()){
	    	cur = s.pop();
	    	if(!table.contains(cur.label)){
	    		table.add(cur.label);
	    		cur.neighbors.remove(cur.neighbors.size() - 1);
	    		for(int i = 0;i < cur.neighbors.size();i++){
	    			s.push(cur.neighbors.get(i));
	    		}
	    	}
	    }
	    
	    return rslt;
	}
    
    // O(n) Space method
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
//        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
//        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//        if(node==null){return null;}
//        // BFS, give every node a clone, put relationship into a map
//        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
//        map.put(node,newHead);
//        queue.add(node);
//        while(!queue.isEmpty()){
//            UndirectedGraphNode temp = queue.poll();
//            for(int i = 0;i < temp.neighbors.size();i++){
//                if(!map.containsKey(temp.neighbors.get(i))){
//                    queue.add(temp.neighbors.get(i));
//                    UndirectedGraphNode newNode = new UndirectedGraphNode(temp.neighbors.get(i).label);
//                    map.put(temp.neighbors.get(i),newNode);
//                }
//            }
//        }
//        // according to the map, construct new graph
//        queue.add(node);
//        set.add(node);
//        while(!queue.isEmpty()){
//            UndirectedGraphNode temp = queue.poll();
//            if(!map.containsKey(temp)){return null;}
//            UndirectedGraphNode clone = map.get(temp);
//            for(int i = 0;i < temp.neighbors.size();i++){
//                if(!map.containsKey(temp.neighbors.get(i))){return null;}
//                clone.neighbors.add(map.get(temp.neighbors.get(i)));
//                if(!set.contains(temp.neighbors.get(i))){
//                    set.add(temp.neighbors.get(i));
//                    queue.add(temp.neighbors.get(i));
//                }
//            }
//        }
//        return map.containsKey(node)?map.get(node):null;
//    }

}
