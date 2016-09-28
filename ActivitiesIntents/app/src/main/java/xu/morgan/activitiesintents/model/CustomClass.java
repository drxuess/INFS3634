package xu.morgan.activitiesintents.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by morganxu on 18/08/2016.
 */
public class CustomClass implements Parcelable {
    public static final String CUSTOM_CLASS = "xu.morgan.activitiesintents.CustomClass";

    private int sampleField;
    private String sampleString;

    //Normal Constructor for none parcel use
    public CustomClass(int sampleField, String sampleString) {
        this.sampleField = sampleField;
        this.sampleString = sampleString;
    }

    public int getSampleField() {
        return sampleField;
    }

    public String getSampleString() {
        return sampleString;
    }

    //Constructor for re-creating object from parcel
    public CustomClass(Parcel in){
        readFromParcel(in);
    }

    //Parcelable Overrides
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sampleString);
        dest.writeInt(sampleField);
    }

    private void readFromParcel(Parcel in){
        //REMEMBER TO READ IN THE SAME ORDER YOU WRITE THE STRINGS!!!!
        sampleString = in.readString();
        sampleField = in.readInt();
    }


    //THIS INTERFACE NEEDS TO BE IMPLEMENTED AND CALLED CREATOR used to create your class from parcelable
    public static final Parcelable.Creator<CustomClass> CREATOR
            = new Parcelable.Creator<CustomClass>() {

        public CustomClass createFromParcel(Parcel in) {
            return new CustomClass(in);
        }

        public CustomClass[] newArray(int size) {
            return new CustomClass[size];
        }
    };


}
