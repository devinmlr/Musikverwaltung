import javax.swing.event.ListDataListener;
import javax.swing.ListModel;

public class DynArray<T> implements ListModel<T>{

    private Node first;
    private Node current;
    private Node last;
    private int size=0;

    class Node{

        private Node nextNode;
        private T contentObj;

        Node(T contentObj){
            nextNode=null;
            this.contentObj=contentObj;
        }

        public void setNext(Node nextNode){
            this.nextNode=nextNode;
        }

        public Node getNext(){
            return nextNode;
        }

        public void setContentObj(T contentObj){
            this.contentObj=contentObj;
        }

        public T getContentObj(){
            return contentObj;
        }

    }

    DynArray(){
    }
    
    public boolean isEmpty(){
        return first==null;
    }   
    
    public T getItem(int index){
        if (index<size){
            seek(index);
            return current.getContentObj();
        } else {
            return null;
        }
    }

    public void append(T contentObj){
        Node newNode=new Node(contentObj);
        if (last!=null){
            last.setNext(newNode);
            last=newNode;
        } else {
            last=newNode;
            first=newNode;
        }
        size++;
    }
    
    public void insertAt(int index,T contentObj){
        if (index<=0){
            Node newNode=new Node(contentObj);
            newNode.setNext(first);
            first=newNode;
            size++;
        } else if (index>=size){
            append(contentObj);
        } else if (index<size){
            seek(index-1);
            Node newNode=new Node(contentObj);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }
     
    public void setItem(int index,T contentObj){
        if (index>=0 && index<size){
            seek(index);
            current.setContentObj(contentObj);
        }        
    }
    
    public void delete(int index){
        if (index>=0 && index<size){
            if (index==0){
                first=first.getNext();
                if (first==null){
                    last=null;
                }
                size--;
            } else {
                seek(index-1);
                if (current!=null){
                    if (current.getNext()!=null){
                        current.setNext(current.getNext().getNext()); 
                        if (current.getNext()==null){
                            last=current;
                        }
                        size--;
                    } 
                }
            }
        }
        
    }
    
    public int getLength(){
        return size;
    }
    
    private void seek(int index){
        int i=0;
        current=first;
        while (i<index){
            current=current.getNext();
            i++;
        }
    }
    
    public void addListDataListener(ListDataListener l){
        
    }
    
    public T getElementAt(int index){
        return getItem(index);
    }
    
    public int getSize(){
        return size;
    }
    
    public void removeListDataListener(ListDataListener l){
        
    }

}

