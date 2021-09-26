package testCases_TestNG;

import org.testng.annotations.Test;

public class Test_Groups {

    @Test(groups="sanity")
    public void sanityTest1() {
        System.out.println("This is sanity test");
    }

    @Test(groups = { "regression", "sanity"} )
    public void sanity_dbTest2() {
        System.out.println("This is regression test");
    }

    @Test (groups = {"regression", "db"} )
    public void regression_dbTest3() {
        System.out.println("This is regression and db test");
    }
}
