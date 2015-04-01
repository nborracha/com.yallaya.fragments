package com.yallaya.fragments;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiC;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.support.v4.app.Fragment;

public class TiFragment extends Fragment
{
	
	private static final String LCAT = "TiFragment";
	private static final boolean DBG = TiConfig.LOGD;
	protected View mainView = null;
	protected ViewGroup frame = null;
	protected FragmentProxy proxy;
	
	public static TiFragment newInstance(FragmentProxy proxy) {
		Log.d(LCAT, "new fragment instance called");
		
		TiFragment frg = new TiFragment();
		frg.proxy = proxy;
		if (proxy.container != null) {
			frg.mainView = proxy.container.getOrCreateView().getOuterView();
		}
		
		return frg;
	}
	
	public KrollDict getEventData() 
	{
		KrollDict data = new KrollDict();
		data.put(TiC.EVENT_PROPERTY_SOURCE, proxy);
		return data;
	}
	
	public void fireEvent(String eventName) {
		
		if (proxy != null && proxy.hasListeners(eventName)) {
			//Log.d(LCAT, "firing destroyView event on fragment");
			proxy.fireEvent(eventName, getEventData());
		}
		
	}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		fireEvent("createView");
		
		return this.mainView;
	}
	
	@Override
	public void onDestroyView()
	{
		super.onDestroyView();

		if (this.mainView != null) {
			((ViewGroup)this.mainView.getParent()).removeView(this.mainView);
		}
		
		fireEvent("destroyView");
		
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		
		fireEvent("attach");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		fireEvent("create");
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		
		fireEvent("saveInstanceState");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		fireEvent("activityCreated");
	}
	
	@Override
	public void onStart()
	{
		super.onStart();
		
		fireEvent("start");
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
		fireEvent("resume");
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		
		fireEvent("pause");
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		
		fireEvent("stop");
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		
		fireEvent("destroy");
	}
	
	@Override
	public void onDetach()
	{
		super.onDetach();
		
		fireEvent("detach");
	}
	
}