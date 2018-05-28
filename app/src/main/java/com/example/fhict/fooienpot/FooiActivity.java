package com.example.fhict.fooienpot;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import volley.AppController;
import volley.BetterStringRequest;

/**
 * Created by fhict on 16/11/2017.
 */

public class FooiActivity extends Activity {
//public class FooiActivity extends AppCompatActivity {


    private static final String TAG = "VOLLEY";
    public Fooi fooi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String txtTitle = getIntent().getStringExtra("selectedName");
        this.setTitle(txtTitle);
        fooi = new Fooi("","","");
        setContentView(R.layout.activity_fooi);
        ((RadioGroup) findViewById(R.id.toggleTipGroup)).setOnCheckedChangeListener(ToggleListener);
        ((RadioGroup) findViewById(R.id.toggleDepartmentGroup)).setOnCheckedChangeListener(ToggleListener);
    }

    public Fooi getFooi(){
        return this.fooi;
    }

    public void onClickTip(View view) {
        ((RadioGroup)view.getParent()).check(view.getId());

        fooi.setAmount(String.valueOf(view.getTag().toString()));
    }

    static final RadioGroup.OnCheckedChangeListener ToggleListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(final RadioGroup radioGroup, final int i) {
            for (int j = 0; j < radioGroup.getChildCount(); j++) {
                final ToggleButton view = (ToggleButton) radioGroup.getChildAt(j);
                view.setChecked(view.getId() == i);
            }
        }
    };



    public void onClickDepartment(View view) {
        ((RadioGroup)view.getParent()).check(view.getId());
        fooi.setDepartment(String.valueOf(view.getTag().toString()));
    }

    public void onClickPay(View view) {
        if(fooi.getAmount().isEmpty() || fooi.getDepartment().isEmpty()) {
            Toast.makeText(this, R.string.pls_select_a_tip_or_department, Toast.LENGTH_SHORT).show();
        } else{
            EditText et = (EditText) findViewById(R.id.textComment);
            this.fooi.setComment(String.valueOf(et.getText()));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.summary)
                    .setMessage(getString(R.string.tip) + " " + this.fooi.getAmount() + "\n" +getString(R.string.department2) + " " +this.fooi.getDepartment() + "\n" +getString(R.string.comment) + " " + this.fooi.getComment())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            saveTip();
                            dialog.cancel();

                        }
                    })
                    .setCancelable(false)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    public void saveTip() {
        String tag_save = "save_tip";
        String url = getString(R.string.url) + "/tip";

        BetterStringRequest stringRequest = new BetterStringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("amount", fooi.getAmount());
                params.put("department", fooi.getDepartment());
                params.put("comment", fooi.getComment());
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest, tag_save);
    }
}
