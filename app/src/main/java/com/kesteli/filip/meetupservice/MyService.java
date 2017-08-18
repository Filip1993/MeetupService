package com.kesteli.filip.meetupservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    //FLAG da me ne moze netko vise puta zvati
    private boolean serviceOn = false; //false po defaultu

    /**
     * Default constructor
     */
    public MyService() {
    }

    /**
     * Return the communication channel to the service.
     * May return null if clients can not bind to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Called by the system every time a client explicitly
     * starts the service by calling Context.startService,
     * providing the arguments it supplied
     * and a unique integer token representing the start request.
     * Do not call this method directly.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //da li sam startan?
        if (!serviceOn) {
            //service ima context kao handler...
            Toast.makeText(MyService.this, "Simple Service Started", Toast.LENGTH_SHORT).show();
            serviceOn = true; //postavi zastavicu na true da se zna da je service startan
        } else {
            Toast.makeText(MyService.this, "Simple Service already started", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }

    /**
     * Called by the system to notify a Service that it is no longer used and is being removed.
     */
    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "Obicni Service Stopped", Toast.LENGTH_SHORT).show();
        //ne treba postavljati flag jer se objekt makne s heap-a
        super.onDestroy(); //ne moramo nuzno tako postaviti
        //onDestroy ce sve pocistiti, a onda ce se i on pocistiti
    }
}

