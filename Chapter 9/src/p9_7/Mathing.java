package p9_7;

import java.util.Stack;


public class Mathing {

    public static void main(String[] args) {

        String math = "5 2 + 8 5 * -";
        String[] z = math.split(" ");
        Stack<String> m = new Stack<String>();
        for(int i = 0; i < z.length; i++)
        {
            String y = z[i];
            if (y.equals("+"))
            {
                int b = Integer.parseInt(m.pop());
                int a = Integer.parseInt(m.pop());
                m.push(String.valueOf(a + b));
            }
            else if (y.equals("-"))
            {
                int b = Integer.parseInt(m.pop());
                int a = Integer.parseInt(m.pop());
                m.push(String.valueOf(a - b));
            }
            else if (y.equals("/"))
            {
                int b = Integer.parseInt(m.pop());
                int a = Integer.parseInt(m.pop());
                m.push(String.valueOf(a / b));
            }
            else if (y.equals("*"))
            {
                int b = Integer.parseInt(m.pop());
                int a = Integer.parseInt(m.pop());
                m.push(String.valueOf(a * b));
            }
            else
            {
                m.push(y);
            }
        }
        System.out.println(m.pop());
    }
}