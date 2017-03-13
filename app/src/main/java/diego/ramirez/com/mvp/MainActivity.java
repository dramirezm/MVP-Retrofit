package diego.ramirez.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import diego.ramirez.com.mvp.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
        .replace(R.id.rll_main_container, MainFragment.newInstance(),"MainFragment")
        .commit();
    }
}
