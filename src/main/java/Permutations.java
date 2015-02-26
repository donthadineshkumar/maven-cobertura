

import java.util.ArrayList;
import java.util.List;

public class Permutations {

 /*
  * You will get n! (factorial) - permutations from this
  * 
  * Just like this Example: abc (3! = 6 permutations) 
  * [abc acb bac bca cab cbc]
  * 
  */
 static String str = "abcdf";
 static char[] ch = str.toCharArray();
 static List s1 = new ArrayList<>();
 static List s2 = new ArrayList<>();

 public static void main(String[] args) {

  // s1 - list stores initial character from the string
  s1.add(String.valueOf(ch[0]));

  // recursive loop - char by char
  for (int k = 1; k < ch.length; k++) {

   // adds char at index 0 for all elements of previous iteration
   appendBefore(s1, ch[k]);
   
   // adds char at last index for all elements of previous iteration
   appendAfter(s1, ch[k]);
   
   /*adds char middle positions like a^b^C - if prev list stores
    * elements whose size() is 3 - then it would have 2 positions fill
    * say d is next char - d should be filled in _^_^_ _ positions are
    * previous permutations for 3 chars a,b,c(i.e 6 permutations
    */
   appendMiddle(s1, ch[k], k);
   
   /*for every iteration first clear s1 - to copy s2, which contains
   previous permutations*/
   s1.clear();
   
   /* now copy s2 to s1- then clear s2
   - this way finally s2 contains all the permutations*/
   for (int x = 0; x < s2.size(); x++) {
    s1.add(s2.get(x));
   }
   //shows how it is building - all iterations
   System.out.println(s1);
   s2.clear();
  }
  System.out.println("Total Permutations for given string "+str+" are "+s1.size());
 }

 private static void appendMiddle(List str, char ch, int positions) {
  for (int pos = 1; pos <= positions - 1; pos++) {
   for (int i = 0; i < str.size(); i++) {
    s2.add(str.get(i).toString().substring(0, pos) 
    + String.valueOf(ch)
    + str.get(i).toString().substring(pos, str.get(i).toString().length()));

   }
  }
 }

 private static void appendBefore(List str, char ch) {
  for (int i = 0; i < str.size(); i++) {
   s2.add(String.valueOf(ch) + str.get(i));
  }
 }

 private static void appendAfter(List str, char ch) {
  for (int i = 0; i < str.size(); i++) {
   s2.add(str.get(i) + String.valueOf(ch));
  }
 }

} 