package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	public int angka_rnd;
	private EditText tebakAngka;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		tebakAngka = findViewById(R.id.number_input);
		btn = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random rand = new Random();
		int n = rand.nextInt(50);
		angka_rnd = n+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String strInput = tebakAngka.toString();
		int input = Integer.parseInt(strInput);

		if(input<angka_rnd){
			Toast.makeText(this, "Nilai Terlalu kecil", Toast.LENGTH_SHORT).show();
		}
		else if(input>angka_rnd){
			Toast.makeText(this, "Nilai Terlalu Besar", Toast.LENGTH_SHORT).show();

		}
		else
		{
			Toast.makeText(this, "Tebakan Benar", Toast.LENGTH_SHORT).show();
			btn.setEnabled(false);
			tebakAngka.setEnabled(false);
		}
	}



	public void handleReset(View view) {
		// TODO: Reset tampilan
		btn.setEnabled(true);
		tebakAngka.setEnabled(true);
		initRandomNumber();
	}
}
