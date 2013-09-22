package pl.patcher.iko.tester;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final int Color_red = Color.parseColor("#CC0000");
	private static final int Color_green = Color.parseColor("#669900");
	
	private LinearLayout mLinearLayout;
	private LayoutInflater mInflater;
	private Root mRoot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLinearLayout = (LinearLayout) findViewById(R.id.ll);
		mInflater = LayoutInflater.from(this);
		
		mRoot = new Root(this);
		
		boolean result = mRoot.isDeviceRooted();
		AddMyView("Stan", 		result, 					(!result?"Zdrowy":"Chory"),true				);
		AddMyView("Tags",   	mRoot.checkRootMethod1(), 	android.os.Build.TAGS						);
		AddMyView("Sensor",  	mRoot.checkRootMethod2(), 	"" + mRoot.getListForMethod2().size()		);
		AddMyView("Exec su", 	mRoot.checkRootMethod3(), 	mRoot.getListForMethod3().toString()		);
		AddMyView("Model",  	mRoot.checkRootMethod4(), 	android.os.Build.MODEL						);
		AddMyView("Brand",		mRoot.checkRootMethod5(), 	android.os.Build.BRAND						);
		AddMyView("AndroidID", 	mRoot.checkRootMethod6(), 	mRoot.getStringForMethod6()					);
		AddMyView("Operator", 	mRoot.checkRootMethod7(), 	mRoot.getStringForMethod7()					);
		AddMyView("Debugger", 	mRoot.checkRootMethod8(), 	(mRoot.checkRootMethod8() ? "Tak" : "Nie")	);
	}

	private void AddMyView(String Key, boolean Value, String Info) {
		AddMyView(Key, Value, Info, false);
	}

	private void AddMyView(String Key, boolean Value, String Info,
			boolean forceColor) {
		RelativeLayout row = (RelativeLayout) mInflater.inflate(
				R.layout.list_element, null);

		TextView tvKey = (TextView) row.findViewById(R.id.key);
		ImageView ivIcon = (ImageView) row.findViewById(R.id.icon);
		TextView tvInfo = (TextView) row.findViewById(R.id.info);

		tvKey.setText(Key != null ? Key : "");
		tvInfo.setText(Info != null ? Info : "");
		if (Value) {
			ivIcon.setVisibility(View.VISIBLE);
			row.setBackgroundColor(Color_red);
			//row.setBackgroundColor(Color.RED);
		}else if(forceColor){
			row.setBackgroundColor(Color_green);
			//row.setBackgroundColor(Color.GREEN);
			
		}

		mLinearLayout.addView(row);
	}

}
