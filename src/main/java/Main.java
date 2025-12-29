import java.util.*;
public class Main
{





    public static Queue<String> copyQueue(Queue<String> q) 
    {
        Queue<String> copy = new Queue<>();
        Queue<String> temp = new Queue<>();
        while (!q.isEmpty()) {
            String val = q.remove(); 
            copy.insert(val);             
            temp.insert(val);
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return copy;
    }
     public static Queue<Integer> cq(Queue<Integer> q) 
    {
        Queue<Integer> copy = new Queue<>();
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            Integer val = q.remove(); 
            copy.insert(val);             
            temp.insert(val);
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return copy;
    }

    
public static boolean strinq(Queue<String> q, String target) {
    Queue<String> temp = copyQueue(q) ;

    boolean found = false;
    while (!temp.isEmpty()) {
        String current = temp.remove(); 
        
        if (current.equals(target)) { 
            found = true;
        }
        
    }



    return found;
}

    public static Queue<Integer> ex1(Queue<String> q) 
    {
    Queue<Integer> result = new Queue<>();
    
    if (q.isEmpty()) 
    {
        return result;
    }
        String current = q.remove(); // שליפת האיבר הראשון
        int count = 1;
        while (!q.isEmpty()) 
        {
            String next = q.remove();
            if (next == current) 
            {
                count++;
             } 
                else 
                {
                result.insert(count); // סיימנו רצף, נשמור את הגודל שלו
                current = next;    // נתחיל לעקוב אחרי תו חדש
                count = 1;         // איפוס המונה לרצף החדש
                }
        }
    result.insert(count); // הוספת הרצף האחרון שנותר
    return result;
    }
    
    
        public static boolean ex2(Queue<String> q) 
    {
        Queue<String> temp = copyQueue(q) ;
        while(!temp.isEmpty())
        {
            String cur = temp.remove() ;
            if (strinq(temp,cur))
            {
                return true;
            }
        }
        return false;
    }
    

    
    public static Queue<String> ex3(Queue<String> q) 
    {
        Queue<String> temp = copyQueue(q);
        Queue<String> q1 = copyQueue(q);
        System.out.println("--"+ex2(temp));
                    System.out.println("temp"+temp);

        while(ex2(temp))
        {
            String cur1 = temp.remove();
            
            System.out.println("cur1"+cur1);
            while (!temp.isEmpty())
            {
                String cur2=temp.remove() ;
                {
                    if(cur1!=cur2)
                    {
                        q1.insert(cur2);
                    }
                }
            }
            temp = copyQueue(q1) ;
        }
        return temp;
    }
    
    
    public static void ex4(Queue<Integer> q) 
    {
    Queue<Integer> tempQ = new Queue<Integer>(); 
    Queue<Integer> sortedQ = new Queue<Integer>(); 

    while (!q.isEmpty()) {
        int min = q.remove();
        tempQ.insert(min);

        while (!q.isEmpty()) {
            int current = q.remove();
            if (current < min) {
                min = current;
            }
            tempQ.insert(current);
        }
        boolean removedMin = false;
        while (!tempQ.isEmpty()) {
            int val = tempQ.remove();
            if (val == min && !removedMin) {
                removedMin = true;
            } else {
                q.insert(val);
            }
        }
        sortedQ.insert(min);
    }
    while (!sortedQ.isEmpty()) {
        q.insert(sortedQ.remove());
    }
    System.out.println(q);
    }
    
    
    public static Queue<Integer> ex5(Queue<Integer> q3, Queue<Integer> q4)
    {
        Queue<Integer> q1 = cq(q3);
        Queue<Integer> q2 = cq(q4);
        Queue<Integer> mergedQ = new Queue<Integer>();
        while (!q1.isEmpty() && !q2.isEmpty()) 
        {
            if (q1.head() < q2.head()) 
            {
                mergedQ.insert(q1.remove());
            } 
            else
            {
            mergedQ.insert(q2.remove());
            }
        }
        while (!q1.isEmpty()) 
        {
            mergedQ.insert(q1.remove());
        }
        while (!q2.isEmpty()) 
        {
            mergedQ.insert(q2.remove());
        }
        return mergedQ;
    }
    
    
    
    public static int ex6(Queue<Integer> q) 
    {
        Queue<Integer> tempQ = new Queue<Integer>();
        int maxSum = 0, maxLen = 0;
        int currentSum = 0, currentLen = 0;
        while (!q.isEmpty()) 
        {
            int val = q.remove();
            tempQ.insert(val);
            if (val % 2 == 0)
            { 
                currentLen++;
                currentSum += 1;
            } 
            else
            { 
                if (currentLen > maxLen) 
                {
                    maxLen = currentLen;
                    maxSum = currentSum;
                }
                currentLen = 0;
                currentSum = 0;
            }
        }
        if (currentLen > maxLen) 
        {
            maxSum = currentSum;
        }
        while (!tempQ.isEmpty()) 
        {
            q.insert(tempQ.remove());
        }
    return maxSum;
    }
    
    
    

 Scanner reader=new Scanner(System.in);
public static void main(String[] args)
{
   	    
Queue<String> q = new Queue<>();
q.insert("w");
q.insert("b");
q.insert("a");
q.insert("g");
q.insert("g");
Queue<Integer> q2 = new Queue<>();
q2.insert(3);
q2.insert(9);
q2.insert(3);
q2.insert(2);
q2.insert(2);
q2.insert(6);
q2.insert(4);
q2.insert(2);
q2.insert(7);
q2.insert(13);

Queue<Integer> q3 = new Queue<>();
q3.insert(1);
q3.insert(2);
q3.insert(2);
q3.insert(7);
q3.insert(13);
System.out.println(q);
  ex4(q2);
System.out.println(ex5(q2,q3));
System.out.println(q2);
System.out.println(ex6(q2));


}
}
