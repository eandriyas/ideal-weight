package com.idealweight;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity {
	// deklarasi variabel yang akan digunakan
	final Context context = this;
	double hitungan;
	Button hitung;
	EditText tinggi, berat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// memanggil view untuk activity
		setContentView(R.layout.fragment_start);
		// memanggil semua input menggunakan id
		tinggi = (EditText) findViewById(R.id.inputTinggi);
		berat = (EditText) findViewById(R.id.inputBerat);
		hitung = (Button) findViewById(R.id.btnHitung);
		// memberikan action ketika button hitung ditekan/klik
		hitung.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// deklarasi pembuatan alert
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				// membuat title dari alert
				alertDialogBuilder.setTitle("Kondisi tubuh anda");
				// deklarasi variable yang akan digunakan untuk perhitungan dan
				// merubahnya menjadi string
				double tingginya = Double.parseDouble(tinggi.getText()
						.toString());
				double beratnya = Double
						.parseDouble(berat.getText().toString());
				// rumus untuk menghitung berat tubuh ideal menggunakan metode
				// index tubuh
				double kuadrat = tingginya * tingginya;
				hitungan = (beratnya / kuadrat);
				// percabangan untuk cek hasil yang menampilkannya pada alert
				if (hitungan <= 17) {
					alertDialogBuilder.setMessage("Anda sangat kurus");
				} else if (hitungan >= 17.1 && hitungan <= 18.3) {
					alertDialogBuilder
							.setMessage("kategori berat badan tinggi ringan");
				} else if (hitungan >= 18.4 && hitungan <= 21) {
					alertDialogBuilder.setMessage("Berat badan normal");
				} else if (hitungan >= 21.1 && hitungan <= 27) {
					alertDialogBuilder
							.setMessage("Kelebihan berat badan kategori ringan");
				} else if (hitungan >= 27.1 && hitungan <= 30) {
					alertDialogBuilder
							.setMessage("kelebihan berat badan kategori sedang");
				} else if (hitungan >= 30.1) {
					alertDialogBuilder
							.setMessage("kelebihan berat badan kategori berat/kegemukan");
				}

				// membuat alert dialog
				alertDialogBuilder
				// membuat tombol ok
						.setCancelable(false).setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// if this button is clicked, close
										// current activity
									}
								});
				// membuat dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// menampilkan dialog
				alertDialog.show();

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_start,
					container, false);
			return rootView;
		}
	}

}
