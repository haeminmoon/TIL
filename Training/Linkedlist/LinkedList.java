class MyLinkedList {
    
    private Node header;
    private int size;
    
    public MyLinkedList(){
        
        header = new Node(null);
        size = 0;
    }
    
    // �ܼ� ���� ����Ʈ ���
    private class Node{
        
        private Object data;
        private Node nextNode;
        
        Node(Object data){
            
            this.data = data;
            this.nextNode = null;
        }
        
    }
    
    // index ��ġ�� ��� �����͸� ��ȯ�Ѵ�.
    public Object get(int index){
        return getNode(index).data;
    }
    
    // index ��ġ�� ��带 ��ȯ�Ѵ�.
    private Node getNode(int index){
        
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }
        
        Node node = header.nextNode;
        for(int i =0; i < index; i++){
            node = node.nextNode;
        }
        
        return node;
    }
    
    // ù��° ����� �����͸� ��ȯ�Ѵ�.
    public Object getFirst(){
        return get(0);
    }
    
    // �ش� �������� ��� ��ġ index�� ��ȯ�Ѵ�.
    public int getNodeIndex(Object obj){
        
        if(size<=0){
            return -1;
        }
        
        int index=0;
        Node node = header.nextNode;
        Object nodeData = node.data;
        
        // header���� ���� ���������� nodeData�� ���� ���Ѵ�.
        while(!obj.equals(nodeData)){
            node = node.nextNode;
            
            if(node==null){
                return -1;
            }
            
            nodeData = node.data;
            index++;
        }
        
        return index;
    }
    
    // data�� ����Ʈ�� ù��°�� �����Ѵ�.
    public void addFirst(Object data){
        
        Node newNode = new Node(data);
        newNode.nextNode = header.nextNode;
        header.nextNode = newNode;
        size++;
        
    }
    
    // index ��ġ�� data�� �����Ѵ�.
    public void add(int index, Object data){
        
        if(index==0){
            addFirst(data);
            return;
        }
        
        Node previous = getNode(index-1);
        Node next = previous.nextNode;
        
        Node newNode = new Node(data);
        previous.nextNode = newNode;
        newNode.nextNode = next;
        size++;
    }
    
    // ����Ʈ�� �������� data �� �����Ѵ�.
    public void addLast(Object data){
        add(size, data);
    }
    
    // ����Ʈ�� �������� data�� �����Ѵ�.
    public void add(Object data){
        addLast(data);
    }
    
    // ù��° ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object removeFirst(){
        
        Node firstNode = getNode(0);
        header.nextNode = firstNode.nextNode;
        size--;
        return firstNode.data;
        
    }
    
    // index ��ġ�� ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object remove(int index){
        
        if(index<0 || index>=size){
            
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
        
        }else if(index ==0){
            
            return removeFirst();
        
        }
        
        Node previous = getNode(index-1);
        Node removeNode = previous.nextNode;
        Node next = removeNode.nextNode;
        previous.nextNode = next;
        size--;
        
        return removeNode.data;
    }
    
    // ����Ʈ���� data�� ���� ��带 �����ϰ� ���ſ��θ� ��ȯ�Ѵ�.
    public boolean remove(Object data){
        
        int nodeIndex = getNodeIndex(data);
        
        if(nodeIndex == -1){
            return false;
        }else{
            remove(nodeIndex);
            return true;
        }
    }
    
    // ����Ʈ�� ������ ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
    public Object removeLast(){
        return remove(size-1);
    }
    
    // ����Ʈ�� ũ�⸦ ��ȯ�Ѵ�.
    public int size(){
        return size;
    }
    
    // ����Ʈ�� ������ String���� ��ȯ
    public String toString(){
        
        StringBuffer result = new StringBuffer("[");
        Node node = header.nextNode;
        
        if(node!=null){
            result.append(node.data);
            node = node.nextNode;
            
            while(node != null){
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        
        result.append("]");
        return result.toString();
    }

}

public class LinkedList {
    
    public static void main(String[] args){
        
        MyLinkedList list = new MyLinkedList();
        
        list.add(100);
        list.add(200);
        list.add(400);
        list.add(500);
        System.out.println(list);
        
        list.add(2, 300);
        list.addFirst(50);
        System.out.println(list);
        
        System.out.println(list.get(4));
        
        list.remove(2);
        list.remove(new Integer(400));
        System.out.println(list);
        
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        
        System.out.println("ũ�� " + list.size());
        
    }

}
