package e.wolfsoft1.liberty_ui_kit;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.Hello1Adapter;
import adapter.HelloAdapter;
import me.relex.circleindicator.CircleIndicator;

public class SignUp1 extends AppCompatActivity {

    private ViewPager v1;
    private Hello1Adapter a;
    private CircleIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);


        v1 = (ViewPager)findViewById(R.id.v1);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        a = new Hello1Adapter(getSupportFragmentManager());
        v1.setAdapter(a);
        indicator.setViewPager(v1);
        a.registerDataSetObserver(indicator.getDataSetObserver());
    }
}
