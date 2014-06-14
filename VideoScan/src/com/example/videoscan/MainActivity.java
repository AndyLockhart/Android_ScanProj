package com.example.videoscan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	// ɨ����������
	private final static int SCANNIN_GREQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �����ť��ת����ά��ɨ����棬�����õ���startActivityForResult��ת
		// ɨ������֮������ý���
		Button btnScan = (Button) findViewById(R.id.btn_Scan);
		btnScan.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			Intent intent = new Intent();
				intent.setClass(MainActivity.this, ScanActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			}
		});
	}

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
		case SCANNIN_GREQUEST_CODE:
			if(resultCode == RESULT_OK){
				Bundle bundle = data.getExtras();
				String strUrl = bundle.getString("result");
				startVideo(strUrl);
				this.finish();
			}
			break;
		}
    }
	
	private void startVideo(String strUrl)
	{
		Intent it = new Intent(MainActivity.this,  VideoActivity.class);
		Bundle bundle=new Bundle();
		bundle.putString("url", strUrl);
		it.putExtras(bundle); 
		startActivity(it); 		
	}
}