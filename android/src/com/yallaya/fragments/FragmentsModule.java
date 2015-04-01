/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.yallaya.fragments;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.TiProperties;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

@Kroll.topLevel("Fragments") @Kroll.module(name="Fragments", id="com.yallaya.fragments")
//@Kroll.module(parentModule=TitaniumModule.class)
public class FragmentsModule extends KrollModule implements OnLifecycleEvent
{
	
	// Standard Debugging variables
	private static final String LCAT = "FragmentsModule";
	private static final boolean DBG = TiConfig.LOGD;
	
	protected static HashMap<String, Object> savedFragments = new HashMap<String, Object>();
	
	public static AtomicInteger idGenerator = new AtomicInteger(213123);
	
	
	public FragmentsModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		
	}
	
	@Override
	public void onStart(Activity activity)
	{
		super.onStart(activity);
	}
	@Override
	public void onResume(Activity activity)
	{
		super.onResume(activity);
	}
	@Override
	public void onPause(Activity activity)
	{
		super.onPause(activity);
	}
	@Override
	public void onStop(Activity activity)
	{
		super.onStop(activity);
	}
	@Override
	public void onDestroy(Activity activity)
	{
		super.onDestroy(activity);
	}
	
	public static void setTransactionProperties(HashMap options, FragmentTransaction ft)
	{
		if (!options.containsKey("fragment")) {
			return;
		}
		
		FragmentProxy frg = (FragmentProxy)options.get("fragment");
		
		if (frg.getAddToBackStack()) {
			
			String backStackName = frg.getTag();

			ft.addToBackStack(backStackName);
		
		}
		if (options.containsKey("transition")) {
			ft.setTransition(TiConvert.toInt(options.get("transition")));
		}
		
	}
	
	public static FragmentManager getFragmentManager()
	{
		FragmentActivity act = (FragmentActivity)TiApplication.getAppCurrentActivity();
		FragmentManager fm = act.getSupportFragmentManager();
		return fm;
	}
	
	public static FragmentTransaction getTransaction(HashMap options)
	{
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		setTransactionProperties(options, ft);
		
		return ft;
	}
	
	// Methods

	/*
	 * 	Finds a fragment that was previously added to a frame and was identified by the given tag.
	 * 	Note: it won't find fragments that where created with createFragment but where not added to a frame.
	 */
	@Kroll.method
	public FragmentProxy getFragment(String tagValue)
	{
		return s_getFragment(tagValue);
	}
	
	@Kroll.method
	public static FragmentProxy s_getFragment(String tagValue)
	{
		if (tagValue == null) {
			Log.w(LCAT, "getFragment has no tag");
			return null;
		}
		if (!savedFragments.containsKey(tagValue)) {
			return null;
		}
		return (FragmentProxy)savedFragments.get(tagValue);
	}
	
	@Kroll.method
	public FragmentProxy findFragmentByTag(String tagValue)
	{
		return s_findFragmentByTag(tagValue);
	}
	
	public static FragmentProxy s_findFragmentByTag(String tagValue)
	{
		TiFragment frg;
		try
		{
			frg = (TiFragment)getFragmentManager().findFragmentByTag(tagValue);
			Log.d(LCAT, "found this fragment " + frg.toString());
			
		} catch (Exception ex) {
			
			throw new RuntimeException ("problem with getting fragment by tag " + ex.getMessage());
			
		}
		
		return frg.proxy;
	}
	
	@Kroll.method
	public void putFragment(FragmentProxy proxy)
	{
		s_putFragment(proxy);
	}
	
	public static void s_putFragment(FragmentProxy proxy)
	{
		String frgTag = proxy.getTag();
		if (frgTag == null) {
			Log.w(LCAT, "Fragment has no tag");
			return;
		}
		
		savedFragments.put(frgTag, proxy);
	}
	
	/*
	 * 	Add a fragment to a frame.
	 */
	@Kroll.method
	public void add(Object arg)
	{
		
		s_add(arg);
	}
	
	public static void s_add(Object arg)
	{
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment") || !options.containsKey("frameId")) {
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		int frameId = TiConvert.toInt(options.get("frameId"));
		
		TiFragment frg = proxy.fragment;
		
		if (frg.isAdded()) {
			return;
		}

		FragmentTransaction ft = getTransaction(options);
		ft.add(frameId, frg, proxy.getTag());
		ft.commitAllowingStateLoss();
	}
	
	/*
	 * 	Re-attach a fragment after it had previously been deatched from the frame with detach
	 */
	@Kroll.method
	public void attach(Object arg)
	{
		s_attach(arg);
	}
	
	public static void s_attach(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment")) {
			Log.w(LCAT, "attach called without the fragment arrgument");
			return;
		}
		if (!options.containsKey("frameId")) {
			Log.w(LCAT, "attach called without the frameId arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		Fragment frg = proxy.fragment;
		
		/*
		if (!frg.isDetached()) {
			Log.w(LCAT, "attach called but fragment hasn't been detached");
			return;
		}
		*/
		
		Log.d(LCAT, "attching fragment");

		FragmentTransaction ft = getTransaction(options);
		ft.attach(frg);
		ft.commit();
	}
	
	/*
	 * 	Detach the given fragment from the frame.
	 */
	@Kroll.method
	public void detach(Object arg)
	{
		s_detach(arg);
	}
	
	public static void s_detach(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment")) {
			Log.w(LCAT, "detach called without the fragment arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		Fragment frg = proxy.fragment;
		
		if (frg.isDetached()) {
			Log.w(LCAT, "fragment has already been detached");
			return;
		}
		
		FragmentTransaction ft = getTransaction(options);
		ft.detach(frg);
		ft.commit();
	}
	
	/*
	 * 	Remove an existing fragment.
	 */
	@Kroll.method
	public void remove(Object arg)
	{
		s_remove(arg);
	}
	
	public static void s_remove(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment")) {
			Log.w(LCAT, "remove called without the fragment arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		Fragment frg = proxy.fragment;
		if (!frg.isAdded()) {
			return;
		}
		
		FragmentTransaction ft = getTransaction(options);
		ft.remove(frg);
		ft.commit();
		
	}
	
	/*
	 * 	Shows a previously hidden fragment.
	 */
	@Kroll.method
	public void show(Object arg)
	{
		s_show(arg);
	}
	
	public static void s_show(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment")) {
			Log.w(LCAT, "show called without the fragment arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		Fragment frg = proxy.fragment;
		
		if (frg.isVisible()) {
			return;
		}

		FragmentTransaction ft = getTransaction(options);
		ft.show(frg);
		ft.commit();
	}
	
	/*
	 * 	Hides an existing fragment.
	 */
	@Kroll.method
	public void hide(Object arg)
	{
		s_hide(arg);
	}
	
	public static void s_hide(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment")) {
			Log.w(LCAT, "hide called without the fragment arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		Fragment frg = proxy.fragment;
		if (frg.isHidden()) {
			Log.w(LCAT, "fragment is already hidden");
			return;
		}

		FragmentTransaction ft = getTransaction(options);
		ft.hide(frg);
		ft.commit();
	}

	/*
	 * 	Replace the frame's current fragment with a new one.
	 */
	@Kroll.method
	public void replace(Object arg)
	{
		s_replace(arg);
	}
	
	public static void s_replace(Object arg)
	{
		
		HashMap<String, Object> options = (HashMap) arg;

		if (!options.containsKey("fragment") || !options.containsKey("frameId")) {
			Log.w(LCAT, "replace called without the fragment/frameId arrgument");
			return;
		}
		
		FragmentProxy proxy = (FragmentProxy)options.get("fragment");
		int frameId = TiConvert.toInt(options.get("frameId"));

		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = getTransaction(options);
		
		Fragment curFrg = (Fragment)fm.findFragmentById(frameId);
		
		if (curFrg == null) {
			Log.w(LCAT, "replace called but frame doesn't have fragment added to it");
			return;
		}

		Fragment newFrg;
		try {
			newFrg = proxy.fragment;
		} catch (Exception ex) {
			throw new RuntimeException ("error with getting the new fragment " + ex.getMessage());
		}
		try {
			ft.replace(frameId, newFrg, proxy.getTag());
			ft.commit();
		} catch (Exception ex) {
			throw new RuntimeException ("error replacing the fragments " + ex.getMessage());
		}
		Log.d(LCAT, "Replacing frame with id " + frameId + " with " + newFrg.getTag());
		
	}
	
	/*
	 * 	returning to one of the previous fragments on the backStack based on the tag string
	 */
	@Kroll.method
	public void popBackStack(String name)
	{
		s_popBackStack(name);
	}
	
	public static void s_popBackStack(String name)
	{

		if (name.isEmpty()) {
			name = null;
		}

		
		final FragmentActivity act = (FragmentActivity)TiApplication.getAppCurrentActivity();
		final FragmentManager fm = act.getSupportFragmentManager();
		
		final String tag = name;

		act.runOnUiThread(new Runnable() {
	         public void run() {
	        	try {
	        		fm.popBackStackImmediate(tag, 1);
	 			} catch (Exception ex) {
	 				throw new RuntimeException ("popBackStack exception: " + ex.getMessage());
	 			}
	         }
	    });
		
	}
	
	// Transition Properties
	@Kroll.method @Kroll.getProperty
	public int TRANSIT_ENTER_MASK() {
		return FragmentTransaction.TRANSIT_ENTER_MASK;
	}
	
	@Kroll.method @Kroll.getProperty
	public int TRANSIT_EXIT_MASK() {
		return FragmentTransaction.TRANSIT_EXIT_MASK;
	}
	
	@Kroll.method @Kroll.getProperty
	public int TRANSIT_FRAGMENT_CLOSE() {
		return FragmentTransaction.TRANSIT_FRAGMENT_CLOSE;
	}

	@Kroll.method @Kroll.getProperty
	public int TRANSIT_FRAGMENT_FADE() {
		return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
	}
	
	@Kroll.method @Kroll.getProperty
	public int TRANSIT_FRAGMENT_OPEN() {
		return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
	}
	
	@Kroll.method @Kroll.getProperty
	public int TRANSIT_NONE() {
		return FragmentTransaction.TRANSIT_UNSET;
	}

	@Kroll.method @Kroll.getProperty
	public int TRANSIT_UNSET() {
		return FragmentTransaction.TRANSIT_UNSET;
	}

}

