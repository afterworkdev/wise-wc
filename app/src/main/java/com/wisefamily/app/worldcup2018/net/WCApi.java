package com.wisefamily.app.worldcup2018.net;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wisepjh on 2018. 4. 27..
 */

public class WCApi {

    private static String DOMAIN = "wisefamily.cafe24.com";
    private static String PROTOCOL = "http";

//    public static String PATH_API_INIT= "/api/lotto/init";
    public static String PATH_API_BASE_INFO = "/api/worldcup/group-info";
    public static String PATH_API_ROUND = "/api/worldcup/group-info";
    public static String PATH_API_KNOCKOUT = "/api/worldcup/round-16";

    private static String getApiUrl(String protocol, String path) {
        return String.format("%s://%s%s", protocol, DOMAIN, path);
    }

    public static void roundInfo(Context ctx, final Map<String, String> queryParams,
                                 Response.Listener<String> listener,
                                 Response.ErrorListener errorListener) {

        String url = getApiUrl(PROTOCOL, PATH_API_ROUND);
        StringRequest request = new StringRequest(Request.Method.GET, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>(queryParams);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleyRequestQueue.getInstance(ctx).getRequestQueue().add(request);
    }

    public static void knockoutInfo(Context ctx, final Map<String, String> queryParams,
                                 Response.Listener<String> listener,
                                 Response.ErrorListener errorListener) {

        String url = getApiUrl(PROTOCOL, PATH_API_KNOCKOUT);
        StringRequest request = new StringRequest(Request.Method.GET, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>(queryParams);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleyRequestQueue.getInstance(ctx).getRequestQueue().add(request);
    }


    public static void exec(Context ctx, String urlPath, final Map<String, String> queryParams,
                            Response.Listener<String> listener,
                            Response.ErrorListener errorListener) {

        String url = getApiUrl(PROTOCOL, urlPath);
        StringRequest request = new StringRequest(Request.Method.GET, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>(queryParams);
                return  params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleyRequestQueue.getInstance(ctx).getRequestQueue().add(request);
    }

}
