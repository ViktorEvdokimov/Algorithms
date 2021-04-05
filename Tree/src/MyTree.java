import java.util.Stack;

public class MyTree<E extends Comparable<? super E>> implements ThreeForm<E> {
    private int size;
    NodWithParent<E> root;


    @Override
    public void travers(TraversMode mode) {
        switch (mode) {
            case IN_ORDER -> inOrder(root);
            case PRE_ORDER -> preOrder(root);
            case POST_ORDER -> postOrder(root);
            default -> throw new IllegalArgumentException("SWW");
        }

    }

    private void inOrder (NodWithParent<E> nod){
        if(nod!=null){
            inOrder(nod.getLeftChild());
            System.out.print(nod.getData()+" ");
            inOrder(nod.getRightChild());
        }
    }
    private void preOrder (NodWithParent<E> nod){
        if(nod!=null){
            System.out.print(nod.getData()+" ");
            preOrder(nod.getLeftChild());
            preOrder(nod.getRightChild());
        }
    }
    private void postOrder (NodWithParent<E> nod){
        if(nod!=null){
            postOrder(nod.getLeftChild());
            postOrder(nod.getRightChild());
            System.out.print(nod.getData()+" ");
        }
    }

    @Override
    public void add(E value) {
        if(isEmpty()){
            root=new NodWithParent<>(value);
            size++;
            return;
        }
        NodWithParent<E> parent = findParentOfNod(root, value);
        if (value.compareTo(parent.getData())==0) return;
        NodWithParent<E> newNod = new NodWithParent<>(parent, value);
        if (value.compareTo(parent.getData())>0) {
            parent.setRightChild(newNod);
        } else if (value.compareTo(parent.getData())<0) {
            parent.setLeftChild(newNod);
        }
        size++;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) return false;
        else if (size==1){
            if(root.getData().compareTo(value)==0){
                root=null;
                size--;
                return true;
            }
            return false;
        } NodWithParent<E> nod = findParentOfNod(root,value);
        if (value.compareTo(nod.getData())!=0) return false;
        if (nod.getLeftChild()==null && nod.getRightChild()==null) {
            if (value.compareTo(nod.getParent().getData())>0) nod.getParent().setRightChild(null);
            else nod.getParent().setLeftChild(null);
            nod=null;
            size--;
            return true;
        }
        if (nod.getLeftChild()!=null && nod.getRightChild()==null){
            if (value.compareTo(nod.getParent().getData())>0) nod.getParent().setRightChild(nod.getLeftChild());
            else nod.getParent().setLeftChild(nod.getLeftChild());
            nod=null;
            size--;
            return true;
        }
        if (nod.getLeftChild()==null && nod.getRightChild()!=null){
            if (value.compareTo(nod.getParent().getData())>0) nod.getParent().setRightChild(nod.getRightChild());
            else nod.getParent().setLeftChild(nod.getRightChild());
            nod=null;
            size--;
            return true;
        }
        if (nod.getData().compareTo(nod.getParent().getData())>0){
            NodWithParent<E> newNod = nod;
            while (newNod.getLeftChild()!=null){
                newNod=newNod.getLeftChild();
            }
            if (newNod.getRightChild()!=null) {
                newNod.getRightChild().setParent(newNod.getParent());
                newNod.getParent().setLeftChild(newNod.getRightChild());
            }
            nod.setData(newNod.getData());
            newNod=null;
            size--;
        }
        if (nod.getData().compareTo(nod.getParent().getData())<0){
            NodWithParent<E> newNod = nod;
            while (newNod.getRightChild()!=null){
                newNod=newNod.getRightChild();
            }
            if (newNod.getLeftChild()!=null) {
                newNod.getLeftChild().setParent(newNod.getParent());
                newNod.getParent().setRightChild(newNod.getLeftChild());
            }
            nod.setData(newNod.getData());
            newNod=null;
            size--;
        }
        throw new IllegalArgumentException("SWW");
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(E value) {
        return value.compareTo(findParentOfNod(root, value).getData())==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<NodWithParent<E>> stack = new Stack<>();
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = isEmpty();
        while (!isRowEmpty){
            Stack<NodWithParent<E>> localStack = new Stack<>();
            isRowEmpty=true;
            for (int i=0; i<nBlanks;i++) System.out.print(" ");
            while (!stack.isEmpty()){
                NodWithParent<E> temp = stack.pop();
                if (temp!=null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getRightChild()!=null || temp.getLeftChild()!=null) isRowEmpty=false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................");
        }
        System.out.println("Size: "+ size);
    }



    private NodWithParent<E> findParentOfNod (NodWithParent<E> nod, E value){
        if(value.compareTo(nod.getData())==0) return nod;
        else if(value.compareTo(nod.getData())>0) {
            if(nod.getRightChild()==null) return nod;
            else return findParentOfNod(nod.getRightChild(), value);
        }else if(value.compareTo(nod.data)<0) {
            if(nod.getLeftChild()==null) return nod;
            else return findParentOfNod(nod.getLeftChild(), value);
        }
        throw new IllegalArgumentException("SWW");
    }


    private class NodWithParent<E extends Comparable<? super E>>{
        private NodWithParent<E> parent;
        private E data;
        private NodWithParent<E> leftChild;
        private NodWithParent<E> rightChild;

        public void setData(E data) {
            this.data = data;
        }

        public NodWithParent(NodWithParent<E> parent, E data) {
            this.parent = parent;
            this.data = data;
        }

        public NodWithParent(E data) {
            this.data = data;
        }

        public void setParent(NodWithParent<E> parent) {
            this.parent = parent;
        }

        public NodWithParent<E> getParent() {
            return parent;
        }

        public void setLeftChild(NodWithParent<E> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(NodWithParent<E> rightChild) {
            this.rightChild = rightChild;
        }

        public E getData() {
            return data;
        }

        public NodWithParent<E> getLeftChild() {
            return leftChild;
        }

        public NodWithParent<E> getRightChild() {
            return rightChild;
        }
    }
}
