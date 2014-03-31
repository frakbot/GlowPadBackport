package net.frakbot.glowpadbackportsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import net.frakbot.glowpadbackport.GlowPadView;

public class SampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button toggleBtn = (Button) findViewById(R.id.btn_toggle_padmult);
        final GlowPadView glowPad = (GlowPadView) findViewById(R.id.incomingCallWidget);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currMult = glowPad.getPointsMultiplier();
                final int[] mults = {1, 2, 3, 4, 6, 8, 10, 12, 16, 20, 32};

                int multIndex = 0;
                for (int i = 0; i < mults.length; i++) {
                    if (mults[i] == currMult) {
                        multIndex = i;
                    }
                }

                multIndex++;
                if (multIndex >= mults.length) {
                    multIndex = 0;
                }

                glowPad.setPointsMultiplier(mults[multIndex]);

                Toast.makeText(SampleActivity.this, "Multi: " + mults[multIndex], Toast.LENGTH_SHORT).show();

                glowPad.ping();
            }
        });

        glowPad.setOnTriggerListener(new GlowPadView.OnTriggerListener() {
            @Override
            public void onGrabbed(View v, int handle) {
                // Do nothing
            }

            @Override
            public void onReleased(View v, int handle) {
                // Do nothing
            }

            @Override
            public void onTrigger(View v, int target) {
                Toast.makeText(SampleActivity.this, "Target triggered! ID=" + target, Toast.LENGTH_SHORT).show();
                glowPad.reset(true);
            }

            @Override
            public void onGrabbedStateChange(View v, int handle) {
                // Do nothing
            }

            @Override
            public void onFinishFinalAnimation() {
                // Do nothing
            }
        });
    }
}
