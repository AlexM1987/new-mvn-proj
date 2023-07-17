package util;

import org.junit.*;

public class ArraysUtilsTest {

    private int[] arr ;

    @BeforeClass
    public static void init(){
        System.out.println("init job");
    }

    @Before
    public void beforeEach(){
        System.out.println("beforeEach job");
        arr = new int[5];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;
        arr[3] = -200;
        arr[4] = 3;
    }


    @AfterClass
    public static void destroy(){
        System.out.println("destroy / clean job");
    }

    @After
    public void afterEach(){
        System.out.println("afterEach job");
    }

    @Test
    public void initialFindMaxTest(){
        System.out.println("initialFindMaxTest start");
        int expected = 3;
        int actual = ArraysUtil.findMax(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayRemovalTest(){
        System.out.println("arrayRemovalTest start");
        arr[1] = 0;
        int expected = 0;
        int actual = arr[1];
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void findMaxFromNullTest(){
        System.out.println("findMaxFromNullTest start");
        ArraysUtil.findMax(null);
    }

    @Test(timeout = 5000)
    public void generateArrayPerformance(){
        int max = 100000;
        System.out.println(max);
        for (int i = 0; i < 10; i++){
            int[] bigArr = ArraysUtil.genRandomArray(max);
            ArraysUtil.printArray(bigArr);
        }
    }



}