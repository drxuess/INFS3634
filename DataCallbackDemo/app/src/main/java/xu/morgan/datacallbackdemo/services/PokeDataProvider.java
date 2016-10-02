package xu.morgan.datacallbackdemo.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import xu.morgan.datacallbackdemo.model.PokemonUrl;

/**
 * Created by morganxu on 2/10/2016.
 */
public class PokeDataProvider {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";
    private static RequestQueue requestQueue;

    public PokeDataProvider(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getPokemon(final DataCallback<List<PokemonUrl>> callback) {
        JsonRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<PokemonUrl> pokemonList = new ArrayList<>();
                        try {
                            JSONArray array = response.getJSONArray("results");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                String url = object.getString("url");
                                String name = object.getString("name");
                                PokemonUrl pokemonUrl = new PokemonUrl(name, url);
                                pokemonList.add(pokemonUrl);
                            }
                            callback.onSuccess(pokemonList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", error.toString());
            }
        });
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonRequest);
    }
}
