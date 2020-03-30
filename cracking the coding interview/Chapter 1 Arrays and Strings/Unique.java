

private class Node{
	private int val;
	private Node next;
}


public void dedup(Node n){
	if(n==null) return ;

	HashSet<Integer> nodes=new HashSet<Integer>();
	Node prev=null;

	while(n!=null){
		if(nodes.contains(n.val)){
			prev.next=n.next;
		}
		else{
			nondes.add(n.val);
			prev=n;
		}
		n=n.next();
	}
}