package pl.patcher.iko.tester;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public class Root {

	private Context mCtx;

	public Root(Context context) {
		mCtx = context;

	}

	public boolean isDeviceRooted() {
		if (checkRootMethod1() || checkRootMethod2() || checkRootMethod3()
				|| checkRootMethod4() || checkRootMethod5()
				|| checkRootMethod6() || checkRootMethod7()
				|| checkRootMethod8()) {
			return true;
		}

		return false;
	}

	public boolean checkRootMethod1() {
		String buildTags = android.os.Build.TAGS;

		if (buildTags != null && buildTags.contains("test-keys")) {
			return true;
		}
		return false;
	}

	public List<Sensor> getListForMethod2() {
		SensorManager manager = (SensorManager) mCtx.getSystemService("sensor");
		return manager.getSensorList(-1);
	}

	public boolean checkRootMethod2() {
		return getListForMethod2().isEmpty();
	}

	public ArrayList<String> getListForMethod3() {
		return new ExecShell().executeCommand(ExecShell.check_su_binary);

	}

	public boolean checkRootMethod3() {
		ArrayList<String> array_list = getListForMethod3();
		if ((array_list == null) || (array_list.isEmpty())) {
			return false;
		}
		return true;
	}

	public boolean checkRootMethod4() {
		return Build.MODEL.toLowerCase().endsWith("_sdk");
	}

	public boolean checkRootMethod5() {
		return (Build.BRAND == null)
				|| ("generic".equals(Build.BRAND.toLowerCase()));
	}

	public String getStringForMethod6() {
		return Secure.getString(mCtx.getContentResolver(), Secure.ANDROID_ID);
	}

	public boolean checkRootMethod6() {
		return getStringForMethod6().equalsIgnoreCase("9774D56D682E549C");
	}

	public String getStringForMethod7() {
		TelephonyManager manager = (TelephonyManager) mCtx
				.getSystemService("phone");
		return manager.getNetworkOperatorName();
	}

	public boolean checkRootMethod7() {
		return getStringForMethod7().equals("Android");
	}

	public boolean checkRootMethod8() {
		return Debug.isDebuggerConnected();
	}

}
