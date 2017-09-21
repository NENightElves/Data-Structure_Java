class Node<T>
{

    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    public Node()
    {

        this(null, null);
    }

    public String toString()
    {

        return this.data.toString();
    }
}

public class SinglyList<T> extends Object
{

    public Node<T> head;

    public SinglyList()
    {

        this.head = new Node<T>();
    }

    public SinglyList(T[] values)
    {

        this();
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++)
        {
            rear.next = new Node<T>(values[i], null);
            rear = rear.next;
        }
    }

    public SinglyList(SinglyList<T> list)
    {

        this();
        Node<T> rear = this.head;
        for (Node<T> p = list.head.next; p != null; p = p.next)
        {
            rear.next = new Node<T>(p.data, null);
            rear = rear.next;
        }
    }

    public boolean isEmpty()
    {

        return this.head.next == null;
    }

    public T get(int i)
    {

        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        return (i >= 0 && p != null) ? p.data : null;
    }

    public void set(int i, T x)
    {

        if (x == null)
            throw new NullPointerException("x == null");
        Node<T> p = this.head.next;
        int j = 0;
        while (p != null && j != i)
        {
            p = p.next;
            j++;
        }
        p.data = x;
    }

    public int size()
    {

        Node<T> p = this.head.next;
        int size = 0;
        while (p.next != null)
        {
            p = p.next;
            size++;
        }
        return size;
    }

    public String toString()
    {

        String str = this.getClass().getName() + "(";
        for (Node<T> p = this.head.next; p != null; p = p.next)
        {
            str += p.data.toString();
            if (p.next != null)
                str += ",";
        }
        return str + ")";
    }

    public Node<T> insert(int i, T x)
    {

        if (x == null)
            throw new NullPointerException("x == null");
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++)
            front = front.next;
        front.next = new Node<T>(x, front.next);
        return front.next;
    }

    public Node<T> insert(T x)
    {

        return insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i)
    {

        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++)
            front = front.next;
        if (i >= 0 && front.next != null)
        {
            T old = front.next.data;
            front.next = front.next.next;
            return old;
        }
        return null;
    }

    public T remove(T key, int n)
    {

        Node<T> front = this.head;
        while (front.next != null && !key.equals(front.next.data))
            front = front.next;
        if (front.next != null)
        {
            T old = front.next.data;
            front.next = front.next.next;
            return old;
        }
        return null;
    }

    public void clear()
    {

        this.head.next = null;
    }

    public boolean equals(SinglyList<T> list)
    {
        Node<T> p = this.head.next;
        Node<T> q = list.head.next;
        while (p.data == q.data)
        {
            p = p.next;
            q = q.next;
        }
        if (p == null)
            return true;
        else
            return false;
    }

    public void replaceAll(SinglyList<T> pattern, SinglyList<T> list)
    {
        Node<T> p, q, pt, i;
        SinglyList<T> tmp;
        p = this.head;
        pt = this.head;
        q = pattern.head;
        p = p.next;
        q = q.next;
        while (p != null)
        {
            while ((p != null) && (q != null) && (p.data.equals(q.data)))
            {
                p = p.next;
                q = q.next;
            }
            if (q == null)
            {
                tmp = new SinglyList(list);
                i = list.head;
                pt.next = i.next;
                while (i.next != null)
                    i = i.next;
                i.next = p;
                q = pattern.head.next;
                pt = i;
                list = tmp;
            } else
            {
                q = pattern.head.next;
                pt = pt.next;
                p = pt.next;
            }
        }
    }

    /*public void reverse(){

        Node<T> front = this.head;
        Node<T> p = this.head.next;
        Node<T> succ = p.next;
        while (p!=null){
            p.next = front;
            p = succ;
            succ = succ.next;
            front = p;
        }
        head = front;
    }*/

}
