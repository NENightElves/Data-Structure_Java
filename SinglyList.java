import java.awt.Font;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.xml.soap.Node;

public class Node<T>
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

    public SinglyList()                                                         //锟斤拷锟届方锟斤拷
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

    public boolean isEmpty()
    {
        return this.head.next == null;
    }

    public T get(int i)                                                          //锟斤拷取
    {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        return (i > 0 && p != null) ? p.data : null;
    }

    public void set(int i, T x)
    {
        if (x == null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i + "");//抛出序号越界异常
    }

    public int size()                                      //返回顺序表元素个数，O(1)
    {
        return this.n;
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

    public Node<T> insert(int i, T x)                                             //锟斤拷锟斤拷
    {
        if (x == null)
            throw new NullPointerException("x==null");
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++)
            front = front.next;
        front.next = new Node<T>(x, front.next);
        return front.next;
    }

    public Node<T> insert(T x)
    {
        return Insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i)                                                       //删锟斤拷
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

    public void clear()
    {
        this.head.next = null;
    }

    public int search(T key)
    {
        for (int i = 0; i < this.n; i++)
        {
            if (key.equals(this.element[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(T key)
    {
        return this.search(key) != -1;
    }

    public boolean isDifferent()
    {
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < i; j++)
                if (this.element[j].equals(this.element[i]))
                    return false;
        return true;
    }

    public T remove(T key)
    {
        return this.remove(this.search(key));
    }
}

