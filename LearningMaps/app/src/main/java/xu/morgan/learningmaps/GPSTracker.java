package xu.morgan.learningmaps;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;


/**
 * Created by morganxu on 3/10/2016.
 */
public class GPSTracker implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;

    public GPSTracker(Activity parentActivity){
        googleApiClient = new GoogleApiClient.Builder(parentActivity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("DEBUG", "Connected to Play Services");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("DEBUG", "Disconnected to Play Services");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("DEBUG", "Failed to connect to Play Services " + connectionResult.getErrorMessage());
    }
}
