public class ListTest
{

    public static void main(String[] args)
    {

        Integer[] values = {1, 2, 3, 4, 5, 6, 7};
        SinglyList<Integer> lista;
        lista = new SinglyList(values);
        SinglyList<Integer> listb;
        listb = new SinglyList(lista);
        System.out.println("The second one is " + lista.get(2));
        lista.set(2, 10);
        System.out.println("After set,the second one is " + lista.get(2));
        System.out.println("The size of lista is " + lista.size());
        System.out.println("Remove the " + lista.remove(3) + " one");
        System.out.println("lista:" + lista.toString());
        System.out.println("Insert " + lista.insert(3, 20));
        System.out.println("lista:" + lista.toString());
        System.out.println("Remove " + lista.remove(10, 1));
        System.out.println("lista:" + lista.toString());
        System.out.println("Insert " + lista.insert(2, 10));
        System.out.println("lista:" + lista.toString());
        if (lista.equals(listb))
            System.out.println("lista = listb");
        else
            System.out.println("lista != listb");
        //listb.reverse();
        //System.out.println("Reverse listb "+listb.toString());

    }
}
