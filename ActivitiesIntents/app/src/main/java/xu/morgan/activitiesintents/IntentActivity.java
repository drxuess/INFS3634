package xu.morgan.activitiesintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        textView = (TextView) findViewById(R.id.text_tv);

        String text = getIntent().getExtras().getString(Intent.EXTRA_TEXT);

        textView.setText(text);
    }
}
