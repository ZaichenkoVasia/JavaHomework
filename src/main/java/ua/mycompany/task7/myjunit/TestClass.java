package ua.mycompany.task7.myjunit;

public class TestClass {
    @BeforeClass
    public static void beforeClassOne() {
        System.out.println("BeforeClass1");
    }

    @BeforeClass
    public static void befareClassTwo() {
        System.out.println("BeforeClass2");
    }

    @Before
    public static void beforeTestOne() {
        System.out.println("BeforeTest1");
    }

    @Before
    public static void befareTestTwo() {
        System.out.println("BeforeTest2");
    }


    @Test
    public void shouldReturnResult1() {
        System.out.println("Test1");
    }

    @Test
    public void shouldReturnResult2() {
        System.out.println("Test2");
    }

    @After
    public static void afterTestOne() {
        System.out.println("AfterTest1");
    }

    @After
    public static void afterTestTwo() {
        System.out.println("AfterTest2");
    }

    @AfterClass
    public static void afterClassOne() {
        System.out.println("AfterClass1");
    }

    @AfterClass
    public static void afterClassTwo() {
        System.out.println("AfterClass2");
    }

}
