package dev.arkantrust.model;

public class LinkedList {

    private Node first;

    public void addNode(String id){
        Node person = new Node(id);

        // caso base --> la lista esta vacia
        if(first == null){
            first = person;
        }
        // segundo caso --> la lista no esta vacia
        else {

            if(first.getNext() == null){
                first.setNext(person);
            }
            // caso iterativo --> la lista tiene mas de dos elementos
            else {
                Node current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(person);
            }
        }
    }

    public String printList(){
        String msj = "[ ";
        Node current = first;
        msj += current +" ";
        while (current.getNext() != null){
            current = current.getNext();
            msj += current + " ";
        }
        msj += " ]";
        return msj;
    }

    public Node search(String id){
        Node found = null;
        // caso base
        if(first != null && first.getId().equals(id)){
            found = first;
        }
        // caso iterativo
        else {
            Node current = first;
            boolean isFound = false;

            // recorrer la lista
            while (current != null && !isFound){
                if(current.getId().equals(id)){
                    found = current;
                    isFound = true;
                }
                // actualizar el actual de la lista
                current = current.getNext();
            }
        }
        return found;
    }

    public void remove(String id){
        Node current = first;

        if(first != null && first.getId().equals(id)){
            first = first.getNext();
        }

        while (current != null){
            if(current.getNext() != null && current.getNext().getId().equals(id)){
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }


    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }


}
