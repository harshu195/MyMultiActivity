package edu.temple.mymultiactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityA extends ActionBarActivity {

    Button btnB,btnC;
    TextView txtPat;

    static final int actb = 1111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        btnB = (Button) findViewById(R.id.btnA);
        btnC = (Button) findViewById(R.id.btnA2);

        View.OnClickListener oc1 = new View.OnClickListener(){
            public void onClick(View v){
                Intent activityBIntent = new Intent(ActivityA.this, ActivityB.class);

                activityBIntent.putExtra("title","Called From A");

                startActivityForResult(activityBIntent,actb);
            }
        };

        btnB.setOnClickListener(oc1);


        View.OnClickListener oc2 = new View.OnClickListener(){
            public void onClick(View v){
                Intent activityCIntent = new Intent(ActivityA.this, ActivityC.class);

                activityCIntent.putExtra("title","Called From A");

                startActivityForResult(activityCIntent,actb);
            }
        };
        btnC.setOnClickListener(oc2);

        ((TextView) findViewById(R.id.txtViewA2)).setText(getIntent().getStringExtra("title"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
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
