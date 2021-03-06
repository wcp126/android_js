package com.example.android_js;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class ProgressLayoutView extends RelativeLayout {

	private ProgressBar progressBar = null;

	private Context context;
	private int progressLayoutRef = 0;
	private int progressBarRef = 0;

	public ProgressLayoutView(Context context) {
		super(context);
		this.context = context;
		initView();
	}

	public ProgressLayoutView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		initView();
	}

	public ProgressLayoutView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		initView();
	}

	private void initView() {
		setVisibility(View.GONE);
		setOnClickListener(null);

		progressBar = new ProgressBar(context);
		RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		rllp.addRule(RelativeLayout.CENTER_IN_PARENT);

		addView(progressBar, rllp);

	}
	
	

	public int getProgressLayoutRef() {
		return progressLayoutRef;
	}

	public void increaseProgressRef() {
		progressLayoutRef++;
		progressBarRef++;
		checkProgress();
	}

	public void decreaseProgressRef() {
		progressLayoutRef--;
		progressLayoutRef = Math.max(0, progressLayoutRef);
		progressBarRef--;
		progressBarRef = Math.max(0, progressBarRef);
		checkProgress();
	}

	public void increaseProgressLayoutRef() {
		progressLayoutRef++;
		checkProgress();
	}

	public void decreaseProgressLayoutRef() {
		progressLayoutRef--;
		progressLayoutRef = Math.max(0, progressLayoutRef);
		checkProgress();
	}

	private void checkProgress() {
		if (progressLayoutRef > 0) {
			if (getVisibility() == View.GONE) {
				setVisibility(View.VISIBLE);
			}
			if (progressBarRef > 0) {
				if (progressBar.getVisibility() == View.GONE) {
					progressBar.setVisibility(View.VISIBLE);
				}
			} else {
				if (progressBar.getVisibility() == View.VISIBLE) {
					progressBar.setVisibility(View.GONE);
				}
			}
		} else {
			if (getVisibility() == View.VISIBLE) {
				setVisibility(View.GONE);
			}
		}
	}

	
}