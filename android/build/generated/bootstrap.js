/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("com.yallaya.fragments.FragmentsModule")["Fragments"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "Fragments";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "Fragments", "Fragments", "createFragmentFrame");
	addInvocationAPI(module, "Fragments", "Fragments", "createFragment");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"Fragment": {
				get: function() {
					var Fragment = lazyGet(this, "com.yallaya.fragments.FragmentProxy", "Fragment", "Fragment");
					return Fragment;
				},
				configurable: true
			},
			"FragmentFrame": {
				get: function() {
					var FragmentFrame = lazyGet(this, "com.yallaya.fragments.FragmentFrameProxy", "FragmentFrame", "FragmentFrame");
					return FragmentFrame;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createFragmentFrame = function() {
			return new module.FragmentFrame(arguments);
		}
		module.constructor.prototype.createFragment = function() {
			return new module.Fragment(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
