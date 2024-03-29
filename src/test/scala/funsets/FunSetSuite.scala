package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 3 === 4)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(singletonSet(100), 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  trait ErkinSets{
    val three = singletonSet(3)
    val four = singletonSet(4)
    val elemFive = singletonSet(5)

    val threeOrFive = union(three, elemFive)
    val fiveOrFour = union(four, elemFive)

  }
  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("testing intersect"){
    new ErkinSets{
    	
    	val five = intersect(threeOrFive, fiveOrFour)
    	
    	assert( !five(4), "does not contain 4")                                  
    	assert( five(5), "contains 5")                                   
    	assert( !five(3), "does not contain 3");
    	assert( !five(2), "does not contain 2");
    }
  }
  
  test("testing diff"){
    new ErkinSets{
    	val justThree = diff(threeOrFive, fiveOrFour)

    	assert(justThree(3), "just three")                              
    	assert(!justThree(5), "no five")                              
    	assert(!justThree(4), "also no four")
    }
  }
  
  test("testing filter"){
	  new ErkinSets{
		  val setOfNums = union( union(singletonSet(-1), singletonSet(4)), singletonSet(-5))

		  val filteredSet = filter(setOfNums, x => x < 0) 

		  assert(filteredSet(-1), "contains -1")                                 
		  assert(!filteredSet(-2), "doesnt contaion -2")                                  
		  assert(!filteredSet(3), "doesnt contaion 3")                                  
		  assert(filteredSet(-5), "contains -5")  
	  }
  }
  
  test("testing forall"){
    new ErkinSets{
    	assert( forall(x => x % 10 == 0, x => x % 5 == 0), "every number divided by 10 also divided by 5")
    	assert( !forall(x => x % 10 == 0, x => x % 4 == 0), "divided by 10 doesnt mean divided by 4")
    	assert( !forall(x => x % 7 == 0, x => x % 3 == 0), "divided by 7 doesnt mean divided by 3")
       	assert( forall(x => x % 4 == 0, x => x % 2 == 0), "divided by 4 means divided by 2") 
    }
  }
  
  test("testing exists"){
    new ErkinSets{
    	assert( exists(x => x > 5, x => x % 7 == 0), "there are numbers bigger than 5 and divided by 7")
    	assert( !exists(x => x > 5, x => x < 4 == 0), "there arent any number both bigger than 5 and smaller than 4")

    }
  }
  
  test("testing map"){
    new ErkinSets{
      val plus10 = map(x => x % 100 == 0, x => x + 10)
      
      assert( contains(plus10, 10), "10 is included")
      assert( !contains(plus10, 100), "100 is not!")
      assert( contains(plus10, 110), "110 is!")
    }
  }
}
