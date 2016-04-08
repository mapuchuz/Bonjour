package com.example.bonjour;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigueListFragment extends ListFragment{



/**
 * The serialization (saved instance state) Bundle key representing the
 * activated item position. Only used on tablets.
 */
private static final String STATE_ACTIVATED_POSITION = "activated_position";
 
/**
 * The current activated item position. Only used on tablets.
 */
private int mActivatedPosition = ListView.INVALID_POSITION;






/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
public NavigueListFragment() {
}

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.drawer_list_item,  R.id.text1);
	// TODO: replace with a real list adapter.
	adapter.add("SecondActivity");
	adapter.add("ThirdActivity");
	setListAdapter(adapter);
}

@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
	super.onViewCreated(view, savedInstanceState);

	// Restore the previously serialized activated item position.
	if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
		setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
	}
}
  
@Override
public void onListItemClick(ListView listView, View view, int position, long id) {
	super.onListItemClick(listView, view, position, id);

	if(	listView.getAdapter().getItem(position).toString().equals("SecondActivity") ) {
		Intent intent;
		intent = new Intent(getActivity(), SecondActivity.class);
		startActivity(intent);
	}
	if(	listView.getAdapter().getItem(position).toString().equals("ThirdActivity") ) {
		Intent intent;
		intent = new Intent(getActivity(), ThirdActivity.class);
		startActivity(intent);
	}
 
}

@Override
public void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);
	if (mActivatedPosition != ListView.INVALID_POSITION) {
		// Serialize and persist the activated item position.
		outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
	}
}

/**
 * Turns on activate-on-click mode. When this mode is on, list items will be
 * given the 'activated' state when touched.
 */
public void setActivateOnItemClick(boolean activateOnItemClick) {
	// When setting CHOICE_MODE_SINGLE, ListView will automatically
	// give items the 'activated' state when touched.
	getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
}

private void setActivatedPosition(int position) {
	if (position == ListView.INVALID_POSITION) {
		getListView().setItemChecked(mActivatedPosition, false);
	} else {
		getListView().setItemChecked(position, true);
	}

	mActivatedPosition = position;
}

}

