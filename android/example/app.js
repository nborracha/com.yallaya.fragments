// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


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