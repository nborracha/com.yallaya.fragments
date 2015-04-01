# Fragments Module

## Description

This Module add Android Fragments support to Appcelerator Titanium apps
(http://developer.android.com/guide/components/fragments.html)

## Requirements

Add this to the &lt;android /&gt; node in tiapp.xml: 

	<android>
	    <tool-api-level>14</tool-api-level>
	</android>

## Accessing the Fragments Module

To access this module from JavaScript, you would do the following (recommended):

	var Fragments = require('com.yallaya.fragments');

The "Fragments" variable is now a reference to the Module object.

## Functions

### createFragmentFrame({ . . . })

Returns a view that can contain fragments.

#### Arguments

parameters[object]: a dictionary object of properties. (same properties and styles as Ti.UI.View)

#### Methods

getUid(); - returns the frame's unique ID

### createFragment({ . . . })

Returns a fragment.

#### Arguments

container[Ti.UI.VIEW] - the main view of the fragment 
tag[String] - a tag name for the fragment
putFragment[Boolean] - Default false; see (http://developer.android.com/reference/android/app/FragmentManager.html#putFragment(android.os.Bundle, java.lang.String, android.app.Fragment)
addToBackStack[Boolean] - Default false; Add the fragment to the back stack.

#### Methods

getAddToBackStack();
getTag();
getContainer();

setAddToBackStack();
setTag();
setContainer();

#### Events

createView - 
destroyView - 
attach - 
create - 
saveInstanceState - 
activityCreated - 
start - 
resume - 
pause - 
stop - 
destroy - 
detach - 


### getFragment(String tag)

see: http://developer.android.com/reference/android/app/FragmentManager.html#getFragment(android.os.Bundle, java.lang.String)

### findFragmentByTag(String tag)

see: http://developer.android.com/reference/android/app/FragmentManager.html#findFragmentByTag(java.lang.String)

### putFragment(Fragment fragment)

see: http://developer.android.com/reference/android/app/FragmentManager.html#putFragment(android.os.Bundle, java.lang.String, android.app.Fragment)

### add(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#add(int, android.app.Fragment, java.lang.String)

### attach(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#attach(android.app.Fragment)

### detach(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#detach(android.app.Fragment)

### remove(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#remove(android.app.Fragment)

### show(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#show(android.app.Fragment)

### hide(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#hide(android.app.Fragment)

### replace(Object arg)

see: http://developer.android.com/reference/android/app/FragmentTransaction.html#replace(int, android.app.Fragment, java.lang.String)

### popBackStack(String name)

see: http://developer.android.com/reference/android/app/FragmentManager.html#popBackStack(java.lang.String, int)


#### Example:

	var Fragments = require('com.yallaya.fragments');
	
	var win = Ti.UI.createWindow({backgroundColor: 'red'});
	
	// create a frame for the fragments (note: you can have several frames with fragments in one window)
	var frame = Fragments.createFragmentFrame({
		backgroundColor: 'yellow',
	    width: Ti.UI.FILL,
		height: Ti.UI.FILL,
		top: 0,
		left: 0
	});
	
	// create the first fragment main view
	var mainFragmentView = Ti.UI.createView({backgroundColor: 'blue'});
		
	// create the first fragment
	var fragment = Fragments.createFragment({
		container: mainFragmentView,
		tag: 'MyFirstFragment',
		putFragment: true,
		addToBackStack: true
	});
	
	// create a button, when clicked we will start a new fragment
	var button = Ti.UI.createButton({title: 'start a new fragment'});
		button.addEventListener('click', function() {
			
			// lets create our second fragment
			var main2FragmentView = Ti.UI.createView({backgroundColor: 'green'});
				main2FragmentView.add(Ti.UI.createLabel({text: 'I am fragment 2!'}));
				
			var secondFragment = Fragments.createFragment({
				container: main2FragmentView,
				tag: 'MySecondFragment',
				putFragment: true,
				addToBackStack: true
			});
			
			// since we already added a fragment to the frame we now need to replace it with the new one
			Fragments.replace({frameId: frame.getUid(), fragment: secondFragment, addToBackStack: true});
			
		});
	
	mainFragmentView.add(button);
	
	// add the fragment only when window has opened
	win.addEventListener('open', function() {
		// since it's the first fragment we need to add it, for the rest we will have to replace
		Fragments.add({frameId: frame.getUid(), fragment: fragment, addToBackStack: true});
	});

	win.add(frame);
	win.open();
	

## Constants

### number TRANSIT_ENTER_MASK
Fragment transaction animation style

### number TRANSIT_EXIT_MASK
Fragment transaction animation style

### number TRANSIT_FRAGMENT_CLOSE
Fragment transaction animation style

### number TRANSIT_FRAGMENT_FADE
Fragment transaction animation style

### number TRANSIT_FRAGMENT_OPEN
Fragment transaction animation style

### number TRANSIT_NONE
Fragment transaction animation style

### number TRANSIT_UNSET
Fragment transaction animation style


## Module History

View the [change log](changelog.html) for this module.

## Feedback and Support

Please direct all questions, feedback, and concerns to [nimrod@yalla-ya.com](mailto:nimrod@yalla-ya.com?subject=Android%20Fragments%20Module).

## Author

Nimrod Kobekowsky | nimrod@yalla-ya.com

## License
Copyright 2015 Nimrod Kobelkowsky, yalla ya!. Please see the LICENSE file included in the distribution for further details.
