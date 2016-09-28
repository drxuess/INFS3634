package xu.morgan.activitiesintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import xu.morgan.activitiesintents.model.CustomClass;

public class ParcelableActivity extends AppCompatActivity {

    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        tvObject = (TextView) findViewById(R.id.object_tv);
        CustomClass customObject = getIntent().getExtras().getParcelable(CustomClass.CUSTOM_CLASS);
        tvObject.setText(customObject.getSampleField() + " " +customObject.getSampleString());
    }
}
