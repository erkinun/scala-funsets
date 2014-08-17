package funsets

import funsets.FunSets._

object homework {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val set3elem = singletonSet(3)                  //> set3elem  : Int => Boolean = <function1>
  
  set3elem(4)                                     //> res0: Boolean = false
  set3elem(3)                                     //> res1: Boolean = true
  
  val threeOrFive = union(singletonSet(3), singletonSet(5))
                                                  //> threeOrFive  : Int => Boolean = <function1>
	threeOrFive(5)                            //> res2: Boolean = true
	threeOrFive(4)                            //> res3: Boolean = false

	val fiveOrFour = union(singletonSet(4), singletonSet(5))
                                                  //> fiveOrFour  : Int => Boolean = <function1>

	val five = intersect(threeOrFive, fiveOrFour)
                                                  //> five  : Int => Boolean = <function1>

	five(4)                                   //> res4: Boolean = false
	five(5)                                   //> res5: Boolean = true
	five(3)                                   //> res6: Boolean = false
	five(2)                                   //> res7: Boolean = false
	
	val justThree = diff(threeOrFive, fiveOrFour)
                                                  //> justThree  : Int => Boolean = <function1>
	justThree(3)                              //> res8: Boolean = true
	justThree(5)                              //> res9: Boolean = false
	justThree(4)                              //> res10: Boolean = false
                                      
  //filter for negative numbers
  val setOfNums = union( union(singletonSet(-1), singletonSet(4)), singletonSet(-5))
                                                  //> setOfNums  : Int => Boolean = <function1>
  val filteredSet = filter(setOfNums, x => x < 0) //> filteredSet  : Int => Boolean = <function1>
  
  filteredSet(-1)                                 //> res11: Boolean = true
  filteredSet(-2)                                 //> res12: Boolean = false
  filteredSet(3)                                  //> res13: Boolean = false
  filteredSet(-5)                                 //> res14: Boolean = true
  
  //forall
  forall(x => x % 10 == 0, x => x % 5 == 0)       //> res15: Boolean = true
  forall(x => x % 10 == 0, x => x % 4 == 0)       //> res16: Boolean = false
  forall(x => x % 7 == 0, x => x % 3 == 0)        //> res17: Boolean = false
  forall(x => x % 50 == 0, x => x % 3 == 0)       //> res18: Boolean = false
  forall(x => x % 4 == 0, x => x % 2 == 0)        //> res19: Boolean = true
  
  val res = -999 % 5                              //> res  : Int = -4
  
  //exists
 	exists(x => x > 5, x => x % 7 == 0)       //> res20: Boolean = true
 	exists(x => x > 5, x => x < 4 == 0)       //> res21: Boolean = false
 	
 	val emptySet:(Int => Boolean) = (x:Int) => false
                                                  //> emptySet  : Int => Boolean = <function1>
 	emptySet(5)                               //> res22: Boolean = false
 	
 	val plus5 = map(x => x % 100 == 0, x => x + 10)
                                                  //> plus5  : Int => Boolean = <function1>
  printSet(plus5)                                 //> {-990,-890,-790,-690,-590,-490,-390,-290,-190,-90,10,110,210,310,410,510,61
                                                  //| 0,710,810,910}
 	
}