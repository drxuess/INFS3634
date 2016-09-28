package xu.morgan.activitiesintents.model;

import android.graphics.drawable.Drawable;

import xu.morgan.activitiesintents.R;

/**
 * Created by morganxu on 21/08/2016.
 */
public class ListItemA {
    private String text;
    private String subText;

    public ListItemA(String text, String subText) {
        this.text = text;
        this.subText = subText;
    }

    public String getText() {
        return text;
    }

    public String getSubText() {
        return subText;
    }
}
