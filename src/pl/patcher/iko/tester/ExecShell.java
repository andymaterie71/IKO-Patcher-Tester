package pl.patcher.iko.tester;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.util.Log;

public class ExecShell {

    private static String LOG_TAG = ExecShell.class.getName();
    public final static String[] check_su_binary = {"/system/xbin/which","su"};


    public ArrayList<String> executeCommand(String[] shellCmd){
        String line = null;
        ArrayList<String> fullResponse = new ArrayList<String>();
        Process localProcess = null;

        try {
            localProcess = Runtime.getRuntime().exec(shellCmd);
        } catch (Exception e) {
            return null;
            //e.printStackTrace();
        }

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(localProcess.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));

        try {
            while ((line = in.readLine()) != null) {
                Log.d(LOG_TAG, "--> Line received: " + line);
                fullResponse.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d(LOG_TAG, "--> Full response was: " + fullResponse);

        return fullResponse;
    }

}