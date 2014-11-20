package com.leebrimelow.maps;

//import com.leebrimelow.map.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements LocationListener {
	private static LatLng current_Location;
	private static GoogleMap map;
	private final LatLng LOCATION_NYC = new LatLng(40.7143528, -74.00597309999999);
	private final Context context = this;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a handle to the Map Fragment
        map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

       //Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        Internet();
        GPS_Enable();
        
        Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);
		locationManager.requestLocationUpdates(provider, 400, 1, this);
		Location location = locationManager.getLastKnownLocation(provider);
		if(location != null){
			double lat = (double) (location.getLatitude());
			double lng = (double) (location.getLongitude());
			current_Location = new LatLng(lat, lng);
		}
		else {
			current_Location = LOCATION_NYC;
		}
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(current_Location,18);
		map.animateCamera(update);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	Circle circle = map.addCircle(new CircleOptions()
	.center(current_Location)
	.radius(400));






public boolean connected() {
	ConnectivityManager cm =
			(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

	NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
	boolean isConnected = activeNetwork != null &&
			activeNetwork.isConnectedOrConnecting();
	return isConnected;
}

public void Internet() {
	

		
	}


        

        

        //map.addMarker(new MarkerOptions()
                //.title("Sydney")
                //.snippet("The most populous city in Australia."));
                //.position(sydney));
    

	private void GPS_Enable() {
		// TODO Auto-generated method stub
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		@SuppressWarnings("unused")
		boolean enabled = locationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);

		
		
	}
	
		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}}

	