package com.example.videoscan;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends Activity {
	private VideoView mVideoView;
	private MediaController mController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		Bundle bundle = getIntent().getExtras();
		String strUrl = bundle.getString("url");

		mVideoView = (VideoView) findViewById(R.id.vv_scan);
		// 实例化MediaController
		mController = new MediaController(this);
		File file = new File(strUrl);
		if (file.exists()) {
			mVideoView.setVideoPath(file.getAbsolutePath());
			mVideoView.setMediaController(mController);
			mController.setMediaPlayer(mVideoView);
			// 自动开始
			mVideoView.start();

			mController.setPrevNextListeners(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(VideoActivity.this, "下一个", 0).show();
				}
			}, new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(VideoActivity.this, "上一个", 0).show();
				}
			});
		}
	}
}
