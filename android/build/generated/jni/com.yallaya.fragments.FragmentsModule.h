/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

		namespace com {
		namespace yallaya {
		namespace fragments {


class FragmentsModule : public titanium::Proxy
{
public:
	explicit FragmentsModule(jobject javaObject);

	static void bindProxy(v8::Handle<v8::Object> exports);
	static v8::Handle<v8::FunctionTemplate> getProxyTemplate();
	static void dispose();

	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;
	static jclass javaClass;

private:
	// Methods -----------------------------------------------------------
	static v8::Handle<v8::Value> detach(const v8::Arguments&);
	static v8::Handle<v8::Value> s_getFragment(const v8::Arguments&);
	static v8::Handle<v8::Value> remove(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_FRAGMENT_OPEN(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_EXIT_MASK(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_ENTER_MASK(const v8::Arguments&);
	static v8::Handle<v8::Value> show(const v8::Arguments&);
	static v8::Handle<v8::Value> getFragment(const v8::Arguments&);
	static v8::Handle<v8::Value> add(const v8::Arguments&);
	static v8::Handle<v8::Value> popBackStack(const v8::Arguments&);
	static v8::Handle<v8::Value> findFragmentByTag(const v8::Arguments&);
	static v8::Handle<v8::Value> replace(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_FRAGMENT_CLOSE(const v8::Arguments&);
	static v8::Handle<v8::Value> hide(const v8::Arguments&);
	static v8::Handle<v8::Value> attach(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_NONE(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_UNSET(const v8::Arguments&);
	static v8::Handle<v8::Value> TRANSIT_FRAGMENT_FADE(const v8::Arguments&);
	static v8::Handle<v8::Value> putFragment(const v8::Arguments&);

	// Dynamic property accessors ----------------------------------------
	static v8::Handle<v8::Value> getter_TRANSIT_FRAGMENT_CLOSE(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_FRAGMENT_OPEN(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_EXIT_MASK(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_ENTER_MASK(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_NONE(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_UNSET(v8::Local<v8::String> property, const v8::AccessorInfo& info);
	static v8::Handle<v8::Value> getter_TRANSIT_FRAGMENT_FADE(v8::Local<v8::String> property, const v8::AccessorInfo& info);

};

		} // fragments
		} // yallaya
		} // com
