package com.yallaya.fragments;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.view.TiUIView;

import android.widget.FrameLayout;

public class FragmentFrame extends TiUIView
{
	private static final String LCAT = "FragmentFrame";
	private static final boolean DBG = TiConfig.LOGD;
	
	protected FragmentFrameProxy proxy;
	

	public FragmentFrame(final FragmentFrameProxy proxy)
	{
		super(proxy);
		
		this.proxy = proxy;
	}
	
	public void createFragmentFrame()
	{
		if (DBG) {
			Log.d(LCAT, "Creating a fragment frame");
		}
		
		FrameLayout frame = new FrameLayout(proxy.getActivity());

		setNativeView(frame);
		
	}

	@Override
	public void processProperties(KrollDict d)
	{
		createFragmentFrame();
		
		super.processProperties(d);
	}
}