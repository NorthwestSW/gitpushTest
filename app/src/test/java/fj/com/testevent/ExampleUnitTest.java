package fj.com.testevent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
             test(60,75);
    }

   public void  test(int a,int b){
          System.out.print(a & b );
          System.out.print("\\n" );
          System.out.print(a | b );
          System.out.print("\\n" );
          System.out.print(a ^ b );
   }
}