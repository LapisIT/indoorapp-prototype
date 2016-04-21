package au.com.spatialvision.plugin;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.util.Log;
import android.widget.Toast;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.resources.IALatLng;
import com.indooratlas.android.sdk.resources.IALocationListenerSupport;


public class IndoorAtlas extends CordovaPlugin {
  public static String TAG = "IndoorAtlas";

  private IALocationManager mIALocationManager;

  /**
   * Sets the context of the Command. This can then be used to do things like
   * get file paths associated with the Activity.
   *
   * @param cordova The context of the main Activity.
   * @param webView The associated CordovaWebView.
   */
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Log.i(TAG, "initializing location manager");

    Context context=this.cordova.getActivity().getApplicationContext();

    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        //Context context = cordova.getActivity().getApplicationContext();
        //Intent intent = new Intent(context, MyNewActivityGap.class);
        //cordova.getActivity().startActivity(intent);
      }
    });

    Log.i(TAG, "initialized location manager");
  }


  @Override
  public boolean execute(
    String action, 
    JSONArray args, 
    CallbackContext callbackContext
  ) throws JSONException {
    Log.i(TAG, "execute");

    if ("echo".equals(action)) {
      echo(args.getString(0) + "...", callbackContext);
      return true;
    }
    
    return false;
  }

  private void echo(
    String msg, 
    CallbackContext callbackContext
  ) {
    Log.i(TAG, "echo");
    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    } else {
      Toast.makeText(
        webView.getContext(), 
        msg, 
        Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mIALocationManager.destroy();
  }

}
