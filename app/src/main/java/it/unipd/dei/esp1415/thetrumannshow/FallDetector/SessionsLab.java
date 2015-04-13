package it.unipd.dei.esp1415.thetrumannshow.FallDetector;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Enrico Naletto
 * Singleton class to manage the list of sessions and the currently active session.
 */
public class SessionsLab {
    private static SimpleDateFormat mDateFormatter;
    private static SessionsLab sSessionsLab;
    private Context mAppContext;
    private ArrayList<Session> mSessionsList;
    private Session mRunningSession;

    private SessionsLab(Context appContext) {
        mAppContext = appContext;
        mDateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm",
                java.util.Locale.getDefault()
        );
        mSessionsList = new ArrayList<Session>();
    }

    public static SessionsLab get(Context c) {
        if (sSessionsLab == null) {
            sSessionsLab = new SessionsLab(c.getApplicationContext());
        }
        return sSessionsLab;
    }

    public void createNewRunningSession(Session session) {
        mRunningSession = session;
    }

    public ArrayList<Session> getSessions() {
        return mSessionsList;
    }

    public Session getRunningSession() {
        return mRunningSession;
    }

    public SimpleDateFormat getDateFormat() {
        return mDateFormatter;
    }

    public void stopCurrentlyRunningSession() {
        mRunningSession = null;
    }

}
