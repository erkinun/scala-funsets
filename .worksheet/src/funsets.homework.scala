package funsets

import funsets.FunSets._

object homework {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 
  println("Welcome to the Scala worksheet");$skip(33); 
  val set3elem = singletonSet(3);System.out.println("""set3elem  : Int => Boolean = """ + $show(set3elem ));$skip(17); val res$0 = 
  
  set3elem(4);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(14); val res$1 = 
  set3elem(3);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(63); 
  
  val threeOrFive = union(singletonSet(3), singletonSet(5));System.out.println("""threeOrFive  : Int => Boolean = """ + $show(threeOrFive ));$skip(16); val res$2 = 
	threeOrFive(5);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(16); val res$3 = 
	threeOrFive(4);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(59); 

	val fiveOrFour = union(singletonSet(4), singletonSet(5));System.out.println("""fiveOrFour  : Int => Boolean = """ + $show(fiveOrFour ));$skip(48); 

	val five = intersect(threeOrFive, fiveOrFour);System.out.println("""five  : Int => Boolean = """ + $show(five ));$skip(10); val res$4 = 

	five(4);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(9); val res$5 = 
	five(5);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(9); val res$6 = 
	five(3);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(9); val res$7 = 
	five(2);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(49); 
	
	val justThree = diff(threeOrFive, fiveOrFour);System.out.println("""justThree  : Int => Boolean = """ + $show(justThree ));$skip(14); val res$8 = 
	justThree(3);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(14); val res$9 = 
	justThree(5);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(14); val res$10 = 
	justThree(4);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(156); 
                                      
  //filter for negative numbers
  val setOfNums = union( union(singletonSet(-1), singletonSet(4)), singletonSet(-5));System.out.println("""setOfNums  : Int => Boolean = """ + $show(setOfNums ));$skip(50); 
  val filteredSet = filter(setOfNums, x => x < 0);System.out.println("""filteredSet  : Int => Boolean = """ + $show(filteredSet ));$skip(21); val res$11 = 
  
  filteredSet(-1);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(18); val res$12 = 
  filteredSet(-2);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(17); val res$13 = 
  filteredSet(3);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(18); val res$14 = 
  filteredSet(-5);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(58); val res$15 = 
  
  //forall
  forall(x => x % 10 == 0, x => x % 5 == 0);System.out.println("""res15: Boolean = """ + $show(res$15));$skip(44); val res$16 = 
  forall(x => x % 10 == 0, x => x % 4 == 0);System.out.println("""res16: Boolean = """ + $show(res$16));$skip(43); val res$17 = 
  forall(x => x % 7 == 0, x => x % 3 == 0);System.out.println("""res17: Boolean = """ + $show(res$17));$skip(44); val res$18 = 
  forall(x => x % 50 == 0, x => x % 3 == 0);System.out.println("""res18: Boolean = """ + $show(res$18));$skip(43); val res$19 = 
  forall(x => x % 4 == 0, x => x % 2 == 0);System.out.println("""res19: Boolean = """ + $show(res$19));$skip(24); 
  
  val res = -999 % 5;System.out.println("""res  : Int = """ + $show(res ));$skip(52); val res$20 = 
  
  //exists
 	exists(x => x > 5, x => x % 7 == 0);System.out.println("""res20: Boolean = """ + $show(res$20));$skip(38); val res$21 = 
 	exists(x => x > 5, x => x < 4 == 0);System.out.println("""res21: Boolean = """ + $show(res$21));$skip(54); 
 	
 	val emptySet:(Int => Boolean) = (x:Int) => false;System.out.println("""emptySet  : Int => Boolean = """ + $show(emptySet ));$skip(14); val res$22 = 
 	emptySet(5);System.out.println("""res22: Boolean = """ + $show(res$22));$skip(53); 
 	
 	val plus5 = map(x => x % 100 == 0, x => x + 10);System.out.println("""plus5  : Int => Boolean = """ + $show(plus5 ));$skip(18); 
  printSet(plus5)}
 	
}
