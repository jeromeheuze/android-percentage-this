package net.nebulastudio.percentthis.percentthis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageInput;
    EditText numberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //link variables to UI
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageInput = (EditText) findViewById(R.id.percentageInput);
        numberInput = (EditText) findViewById(R.id.numberInput);

        //create BTN and override click event - calcBtn
        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float percentage = Float.parseFloat(percentageInput.getText().toString());
                float dec = percentage / 100;
                float total = dec * Float.parseFloat(numberInput.getText().toString());
                String totalOuput = String.format(Locale.US, "%.02f", total);
                totalTextView.setText(totalOuput);
            }
        });

        //create BTN and override click event - clearBtn
        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                percentageInput.setText("");
                numberInput.setText("");
                totalTextView.setText("");
                //focus back to top input field
                percentageInput.requestFocus();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
