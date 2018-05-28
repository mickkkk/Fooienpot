package com.example.fhict.fooienpot;

import android.test.ActivityUnitTestCase;
import android.content.Intent;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by fhict on 29/11/2017.
 */

public class FooiActivityTest extends ActivityUnitTestCase<FooiActivity> {
    FooiActivity activity;
    private RadioGroup radioGroupTip;
    private RadioGroup radioGroupDepartment;
    private Button buttonPay;
    private Button button5;
    private Button button10;
    private Button button15;
    private Button buttonService;
    private Button buttonKitchen;
    private Button buttonBoth;
    private EditText commentText;
    private Fooi fooi;
    String title = "title";


    public FooiActivityTest() {
        super(FooiActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
/*
        //String title = "title";
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);
*/

        /*

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                startActivity(intent, null, null);
            }
        });

         */
/*
        activity = getActivity();
        radioGroupTip = activity.findViewById(R.id.toggleTipGroup);
        radioGroupDepartment = activity.findViewById(R.id.toggleDepartmentGroup);
        commentText = activity.findViewById(R.id.textComment);
        button5 = activity.findViewById(R.id.btnFooi5);
        button10 = activity.findViewById(R.id.btnFooi10);
        button15 = activity.findViewById(R.id.btnFooi15);
        buttonService = activity.findViewById(R.id.btnBediening);
        buttonKitchen = activity.findViewById(R.id.btnKeuken);
        buttonBoth = activity.findViewById(R.id.btnBeide);
        buttonPay = activity.findViewById(R.id.btnBetaal);
        */
    }

    @SmallTest
    @UiThreadTest
    public void testAmount5() throws Throwable {

        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        button5 = activity.findViewById(R.id.btnFooi5);
        button5.callOnClick();
        fooi = activity.getFooi();
        String result = fooi.getAmount();

        assertEquals("5", result);
    }

    @SmallTest
    @UiThreadTest
    public void testAmount10() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        button10 = activity.findViewById(R.id.btnFooi10);
        button10.callOnClick();
        fooi = activity.getFooi();
        String result = fooi.getAmount();

        assertEquals("10", result);
    }

    @SmallTest
    @UiThreadTest
    public void testAmount15() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        button15 = activity.findViewById(R.id.btnFooi15);
        button15.callOnClick();
        fooi = activity.getFooi();
        String result = fooi.getAmount();

        assertEquals("15", result);
    }

    @SmallTest
    @UiThreadTest
    public void testService() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        buttonService = activity.findViewById(R.id.btnBediening);
        buttonService.callOnClick();
        fooi = activity.getFooi();
        String result = fooi.getDepartment();

        assertEquals("Service", result);
    }

    @SmallTest
    @UiThreadTest
    public void testKitchen() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        buttonKitchen = activity.findViewById(R.id.btnKeuken);
        buttonKitchen.callOnClick();
        fooi = activity.getFooi();
        String result = fooi.getDepartment();

        assertEquals("Kitchen", result);
    }

    @SmallTest
    @UiThreadTest
    public void testBoth() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        buttonBoth = activity.findViewById(R.id.btnBeide);

        buttonBoth.callOnClick();

        fooi = activity.getFooi();

        String result = fooi.getDepartment();

        assertEquals("Both", result);
    }
/*
    @SmallTest
    @UiThreadTest
    public void testComment() throws Throwable {
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                FooiActivity.class);
        intent.putExtra("selectedName",title);
        startActivity(intent,null,null);

        activity = getActivity();
        //radioGroupTip = activity.findViewById(R.id.toggleTipGroup);
        //radioGroupDepartment = activity.findViewById(R.id.toggleDepartmentGroup);
        commentText = activity.findViewById(R.id.textComment);
        //button5 = activity.findViewById(R.id.btnFooi5);
        //button10 = activity.findViewById(R.id.btnFooi10);
        button15 = activity.findViewById(R.id.btnFooi15);
        //buttonService = activity.findViewById(R.id.btnBediening);
        //buttonKitchen = activity.findViewById(R.id.btnKeuken);
        buttonBoth = activity.findViewById(R.id.btnBeide);
        buttonPay = activity.findViewById(R.id.btnBetaal);

        button15.callOnClick();
        buttonBoth.callOnClick();
        commentText.setText("Bla");

        buttonPay.callOnClick();

        fooi = activity.getFooi();

        String result = fooi.getComment();

        assertEquals("Bla", result);
    }
*/
}
