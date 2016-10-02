package xu.morgan.datacallbackdemo.services;

/**
 * Created by morganxu on 2/10/2016.
 */
public interface DataCallback<T> {
    void onSuccess(T result);

    void onFailure(String error);
}
