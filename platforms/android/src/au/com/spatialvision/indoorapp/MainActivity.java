/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package au.com.spatialvision.indoorapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.resources.IALocationListenerSupport;

import org.apache.cordova.*;

public class MainActivity extends CordovaActivity
{
    public static String TAG = "IndoorAtlasActivity";
    private IALocationManager mIALocationManager;

    private IALocationListener mLocationListener = new IALocationListenerSupport() {
        @Override
        public void onLocationChanged(IALocation location) {
            String msg = "location is: " + location.getLatitude() + "," + location.getLongitude();
            Log.d(TAG, msg);

//            Toast.makeText(
//                    webView.getContext(),
//                    msg,
//                    Toast.LENGTH_LONG
//            ).show();

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        //mIALocationManager = IALocationManager.create(this);
        //mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mLocationListener);

        runOnUiThread(new Runnable() {
          @Override
          public void run() {

          }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIALocationManager.destroy();
    }
}
