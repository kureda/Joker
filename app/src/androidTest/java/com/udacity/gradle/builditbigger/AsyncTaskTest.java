package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase {

    public static final int TIMEOUT = 20; //how long to wait for reply from server
    public static final String SERVER_NOT_RESPONDING = "Server not responding";
    public static final String SERVER_RETURNED_NULL = "Server returned null";
    public static final String SERVER_RETURNED_EMPTY_STRING = "Server returned empty String";
    EndpointsAsyncTask task;
    String joke = null;

    public void setUp() throws Exception {
        super.setUp();
        task = new EndpointsAsyncTask(null) { //context not used, so can set it to null
            @Override
            protected void onPostExecute(String joke) {
                //Don't launch intent
            }
        };
    }

    public void testBackend() {
        try {
            task.execute();
            joke = task.get(TIMEOUT, TimeUnit.SECONDS);
            assertNotNull(SERVER_RETURNED_NULL, joke);
            assertTrue(SERVER_RETURNED_EMPTY_STRING, joke.length() > 0);

        } catch (Exception e) {
            fail(SERVER_NOT_RESPONDING);
        }
    }
}
