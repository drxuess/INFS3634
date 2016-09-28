package xu.morgan.activitiesintents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import xu.morgan.activitiesintents.model.CustomClass;

public class MainActivity extends AppCompatActivity {

    private Button btnLinearLayout;
    private Button btnRelativeLayout;
    private Button btnListView;
    private Button btnIntentExtra;
    private Button btnIntentFilter;
    private Button btnExtIntentFilter;
    private Button btnParcelableIntent;
    private Button btnCustomListView;
    public static final String CUSTOM_INTENT_FILTER = "xu.morgan.activitiesintents.CUSTOMINTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linear Layout
        btnLinearLayout = (Button) findViewById(R.id.linear_layout_btn);
        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        //Relative Layout
        btnRelativeLayout = (Button) findViewById(R.id.relative_layout_btn);
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        //ListView
        btnListView = (Button) findViewById(R.id.list_view_btn);
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivity(intent);
            }
        });

        //Explicit Intent putExtra
        btnIntentExtra = (Button) findViewById(R.id.intent_extras_btn);
        btnIntentExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IntentActivity.class);
                EditText editText = (EditText) findViewById(R.id.intent_extras_et);
                intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                startActivity(intent);
            }
        });

        //Internal Intent Filter
        btnIntentFilter = (Button) findViewById(R.id.intent_filter_btn);
        btnIntentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUSTOM_INTENT_FILTER);
                startActivity(intent);
            }
        });

        //External Intent Filter
        btnExtIntentFilter = (Button) findViewById(R.id.ext_intent_filter_btn);
        btnExtIntentFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                //Specify that the action for the intent is to send/share something
                sendIntent.setAction(Intent.ACTION_SEND);

                //Share some text
                sendIntent.putExtra(Intent.EXTRA_TEXT, "New Message!");
                sendIntent.setType("text/plain");

                PackageManager packageManager = getPackageManager();

                //Check if Android has the app/activity required
                List activities = packageManager.queryIntentActivities(sendIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);

                if(activities.size() > 0){
                    //Use a app chooser instead of default app
                    Intent chooser = Intent.createChooser(sendIntent, "Share via");
                    startActivity(chooser);

                } else{
                    Toast.makeText(v.getContext(),
                            "Sorry, there is no Android App capable of sending a message",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Parcelable Intent
        btnParcelableIntent = (Button) findViewById(R.id.intent_parceable_btn);
        btnParcelableIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomClass customObject = new CustomClass(9, "Hello Cruel World!");
                Intent intent = new Intent(v.getContext(), ParcelableActivity.class);
                intent.putExtra(CustomClass.CUSTOM_CLASS, customObject);
                startActivity(intent);
            }
        });

        //Custom List View
        btnCustomListView = (Button) findViewById(R.id.custom_list_view_btn);
        btnCustomListView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CustomListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
