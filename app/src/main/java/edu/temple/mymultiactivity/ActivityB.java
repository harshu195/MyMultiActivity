package edu.temple.mymultiactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityB extends ActionBarActivity {

    Button btnA,btnC;
    TextView txtPat;


    static final int actb = 1111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);

        btnA = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnB2);

        View.OnClickListener oc1 = new View.OnClickListener(){
            public void onClick(View v){
                Intent activityBIntent = new Intent(ActivityB.this, ActivityA.class);

                activityBIntent.putExtra("title","Called From B");

                startActivityForResult(activityBIntent,actb);
            }
        };

        btnA.setOnClickListener(oc1);


        View.OnClickListener oc2 = new View.OnClickListener(){
            public void onClick(View v){
                Intent activityCIntent = new Intent(ActivityB.this, ActivityC.class);

                activityCIntent.putExtra("title","Called From B");

                startActivityForResult(activityCIntent,actb);
            }
        };
        btnC.setOnClickListener(oc2);


        ((TextView) findViewById(R.id.txtViewB2)).setText(getIntent().getStringExtra("title"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
