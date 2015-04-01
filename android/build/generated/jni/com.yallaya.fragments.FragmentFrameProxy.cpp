/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "com.yallaya.fragments.FragmentFrameProxy.h"

#include "AndroidUtil.h"
#include "EventEmitter.h"
#include "JNIUtil.h"
#include "JSException.h"
#include "Proxy.h"
#include "ProxyFactory.h"
#include "TypeConverter.h"
#include "V8Util.h"


#include "org.appcelerator.titanium.proxy.TiViewProxy.h"

#define TAG "FragmentFrameProxy"

using namespace v8;

		namespace com {
		namespace yallaya {
		namespace fragments {
			namespace fragments {


Persistent<FunctionTemplate> FragmentFrameProxy::proxyTemplate = Persistent<FunctionTemplate>();
jclass FragmentFrameProxy::javaClass = NULL;

FragmentFrameProxy::FragmentFrameProxy(jobject javaObject) : titanium::Proxy(javaObject)
{
}

void FragmentFrameProxy::bindProxy(Handle<Object> exports)
{
	if (proxyTemplate.IsEmpty()) {
		getProxyTemplate();
	}

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("FragmentFrame");

	Local<Function> proxyConstructor = proxyTemplate->GetFunction();
	exports->Set(nameSymbol, proxyConstructor);
}

void FragmentFrameProxy::dispose()
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Dispose();
		proxyTemplate = Persistent<FunctionTemplate>();
	}

	titanium::TiViewProxy::dispose();
}

Handle<FunctionTemplate> FragmentFrameProxy::getProxyTemplate()
{
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate;
	}

	LOGD(TAG, "GetProxyTemplate");

	javaClass = titanium::JNIUtil::findClass("com/yallaya/fragments/FragmentFrameProxy");
	HandleScope scope;

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("FragmentFrame");

	Handle<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(
		titanium::TiViewProxy::getProxyTemplate()
, javaClass, nameSymbol);

	proxyTemplate = Persistent<FunctionTemplate>::New(t);
	proxyTemplate->Set(titanium::Proxy::inheritSymbol,
		FunctionTemplate::New(titanium::Proxy::inherit<FragmentFrameProxy>)->GetFunction());

	titanium::ProxyFactory::registerProxyPair(javaClass, *proxyTemplate, true);

	// Method bindings --------------------------------------------------------
	DEFINE_PROTOTYPE_METHOD(proxyTemplate, "getUid", FragmentFrameProxy::getUid);

	Local<ObjectTemplate> prototypeTemplate = proxyTemplate->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = proxyTemplate->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------

	// Dynamic properties -----------------------------------------------------
	instanceTemplate->SetAccessor(String::NewSymbol("uid"),
			FragmentFrameProxy::getter_uid
			, titanium::Proxy::onPropertyChanged
		, Handle<Value>(), DEFAULT);

	// Accessors --------------------------------------------------------------

	return proxyTemplate;
}

// Methods --------------------------------------------------------------------
Handle<Value> FragmentFrameProxy::getUid(const Arguments& args)
{
	LOGD(TAG, "getUid()");
	HandleScope scope;

	JNIEnv *env = titanium::JNIScope::getEnv();
	if (!env) {
		return titanium::JSException::GetJNIEnvironmentError();
	}
	static jmethodID methodID = NULL;
	if (!methodID) {
		methodID = env->GetMethodID(FragmentFrameProxy::javaClass, "getUid", "()I");
		if (!methodID) {
			const char *error = "Couldn't find proxy method 'getUid' with signature '()I'";
			LOGE(TAG, error);
				return titanium::JSException::Error(error);
		}
	}

	titanium::Proxy* proxy = titanium::Proxy::unwrap(args.Holder());

	jvalue* jArguments = 0;

	jobject javaProxy = proxy->getJavaObject();
	jint jResult = (jint)env->CallIntMethodA(javaProxy, methodID, jArguments);



	if (!JavaObject::useGlobalRefs) {
		env->DeleteLocalRef(javaProxy);
	}



	if (env->ExceptionCheck()) {
		Handle<Value> jsException = titanium::JSException::fromJavaException();
		env->ExceptionClear();
		return jsException;
	}


	Handle<Number> v8Result = titanium::TypeConverter::javaIntToJsNumber(env, jResult);



	return v8Result;

}

// Dynamic property accessors -------------------------------------------------

Handle<Value> FragmentFrameProxy::getter_uid(Local<String> property, const AccessorInfo& info)
{
	LOGD(TAG, "get uid");
	HandleScope scope;

	JNIEnv *env = titanium::JNIScope::getEnv();
	if (!env) {
		return titanium::JSException::GetJNIEnvironmentError();
	}
	static jmethodID methodID = NULL;
	if (!methodID) {
		methodID = env->GetMethodID(FragmentFrameProxy::javaClass, "getUid", "()I");
		if (!methodID) {
			const char *error = "Couldn't find proxy method 'getUid' with signature '()I'";
			LOGE(TAG, error);
				return titanium::JSException::Error(error);
		}
	}

	titanium::Proxy* proxy = titanium::Proxy::unwrap(info.Holder());

	if (!proxy) {
		return Undefined();
	}

	jvalue* jArguments = 0;

	jobject javaProxy = proxy->getJavaObject();
	jint jResult = (jint)env->CallIntMethodA(javaProxy, methodID, jArguments);



	if (!JavaObject::useGlobalRefs) {
		env->DeleteLocalRef(javaProxy);
	}



	if (env->ExceptionCheck()) {
		Handle<Value> jsException = titanium::JSException::fromJavaException();
		env->ExceptionClear();
		return jsException;
	}


	Handle<Number> v8Result = titanium::TypeConverter::javaIntToJsNumber(env, jResult);



	return v8Result;

}




			} // namespace fragments
		} // fragments
		} // yallaya
		} // com
