/*******************************************************************************
 * Copyright (c) 2012 Manning
 * See the file license.txt for copying permission.
 ******************************************************************************/
package com.manning.androidhacks.hack005;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private static final String[] TEXTS = {"First", "Second", "Third"};
	private int mTextsPosition = 0;
	private TextSwitcher mTextSwitcher;
	private TextView textview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textview = (TextView) findViewById(R.id.textview);
		// 获得TextSwitch的引用，
		mTextSwitcher = (TextSwitcher) findViewById(R.id.your_textview);
      //指定TextSwitcher的viewFactory
		mTextSwitcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				TextView t = new TextView(MainActivity.this);
				t.setGravity(Gravity.CENTER);
				return t;
			}
		});
		// 设置切入动画效果,使用系统的谈入效果，也可以自定义
		mTextSwitcher.setInAnimation(this, android.R.anim.fade_in);
		// 设置切出动画效果，使用系统的谈出效果，也可以自定义
		mTextSwitcher.setOutAnimation(this, android.R.anim.fade_out);

		onSwitchText(null);
	}
	// 点击效果
	public void onSwitchText(View v) {
		// 设置渐变切换文字
		mTextSwitcher.setText(TEXTS[mTextsPosition]);
		// 设置一般文字切换
		textview.setText(TEXTS[mTextsPosition]);
		//改变文字，待下一次显示
		setNextPosition();
	}

	private void setNextPosition() {
		mTextsPosition = (mTextsPosition + 1) % TEXTS.length;
	}
}
