package sr.unasat.country.myfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loadFragment(new FirstFragment());
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.fragment1) {
            loadFragment(new FirstFragment());
            return true;
        } else if (id == R.id.about_us) {
            Intent intent = new Intent(this,AboutUs.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectFragment(View view) {
        if (view == findViewById(R.id.fragOneButton)) {
            loadFragment(new FirstFragment());
        } else if (view == findViewById(R.id.fragTwoButton)) {
            loadFragment(new SecondFragment());
        }else if (view == findViewById(R.id.fragThreeButton)) {
            loadFragment(new ThirdFragment());
        }

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}