package com.home.assertion;

import com.home.base.BaseTest;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;


public class MySoftAssert extends SoftAssert {

    @Override
    public void onAssertFailure(IAssert<?> a, AssertionError ex) {
        BaseTest.takeScreenshot();
    }
    

}
