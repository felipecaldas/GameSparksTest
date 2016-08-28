package gamespark.test.fcaldas.gamesparkstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gamesparks.sdk.GSEventConsumer;
import com.gamesparks.sdk.android.GSAndroidPlatform;
import com.gamesparks.sdk.api.GSData;
import com.gamesparks.sdk.api.autogen.GSResponseBuilder;
import com.gamesparks.sdk.api.autogen.GSTypes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GSAndroidPlatform.initialise(this, "w301757h5GJE", "WoLrCtZU3ivv8FPz1Lz2UpXb7psmwEif", false, true);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        GSAndroidPlatform.gs().stop();
        GSAndroidPlatform.gs().start();
    }

    public void match(View v) {
        GSAndroidPlatform.gs().getRequestBuilder().createMatchmakingRequest()
                .setAction(null)
                .setMatchGroup(null)
                .setMatchShortCode("SIMPLE_MCH")
                .setSkill(1)
                .send(new GSEventConsumer<GSResponseBuilder.MatchmakingResponse>() {
                    @Override
                    public void onEvent(GSResponseBuilder.MatchmakingResponse response) {
                        GSData scriptData = response.getScriptData();
                        Log.d("Test", scriptData.toString());
                    }
                });
    }

    public void loginFelipe(View v) {
        GSAndroidPlatform.gs().getRequestBuilder().createAuthenticationRequest()
                .setPassword("pwd")
                .setUserName("felipe")
                .send(new GSEventConsumer<GSResponseBuilder.AuthenticationResponse>() {
                    @Override
                    public void onEvent(GSResponseBuilder.AuthenticationResponse response) {
                        String authToken = response.getAuthToken();
                        String displayName = response.getDisplayName();
                        Boolean newPlayer = response.getNewPlayer();
                        GSData scriptData = response.getScriptData();
                        GSTypes.Player switchSummary = response.getSwitchSummary();
                        String userId = response.getUserId();
                    }
                });
    }
    public void loginGemma(View v) {
        GSAndroidPlatform.gs().getRequestBuilder().createAuthenticationRequest()
                .setPassword("pwd")
                .setUserName("gemma")
                .send(new GSEventConsumer<GSResponseBuilder.AuthenticationResponse>() {
                    @Override
                    public void onEvent(GSResponseBuilder.AuthenticationResponse response) {
                        String authToken = response.getAuthToken();
                        String displayName = response.getDisplayName();
                        Boolean newPlayer = response.getNewPlayer();
                        GSData scriptData = response.getScriptData();
                        GSTypes.Player switchSummary = response.getSwitchSummary();
                        String userId = response.getUserId();
                    }
                });
    }

}
