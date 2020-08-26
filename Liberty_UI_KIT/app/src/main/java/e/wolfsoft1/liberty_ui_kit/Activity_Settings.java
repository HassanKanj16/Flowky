package e.wolfsoft1.liberty_ui_kit;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Settings extends AppCompatActivity {

    Dialog slideDialog;
    TextView market;

    // private Fragment nameOfYourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__settings);

        market = findViewById(R.id.market);

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideDialog = new Dialog(Activity_Settings.this, R.style.CustomDialogAnimation);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
                window.setGravity(Gravity.BOTTOM);

                window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                slideDialog.setContentView(R.layout.fragmentbottomsheet);


                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.70);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();

            }

        });
    }
}