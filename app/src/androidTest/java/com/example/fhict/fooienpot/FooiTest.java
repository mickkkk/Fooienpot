package com.example.fhict.fooienpot;

import android.test.AndroidTestCase;
import com.example.fhict.fooienpot.Fooi;


/**
 * Created by fhict on 30/11/2017.
 */

public class FooiTest extends AndroidTestCase {
    Fooi fooi;
    String Amount;
    String Department;
    String Comment;

    @Override
    protected void setUp() throws Exception {
        Amount = "";
        Department = "";
        Comment = "";
        fooi = new Fooi(Amount,Department,Comment);

        super.setUp();
    }

    public void testGetAmount() {
        fooi.setAmount("Eerste set");
        fooi.setAmount("500");
        String result = fooi.getAmount();

        assertEquals("500",result);
    }

    public void testGetDepartment() {
        fooi.setDepartment("Eerste set");
        fooi.setDepartment("Kitchen");
        String result = fooi.getDepartment();

        assertEquals("Kitchen",result);
    }

    public void testGetComment() {
        fooi.setComment("Eerste set");
        fooi.setComment("Bla");
        String result = fooi.getComment();

        assertEquals("Bla",result);
    }


}
