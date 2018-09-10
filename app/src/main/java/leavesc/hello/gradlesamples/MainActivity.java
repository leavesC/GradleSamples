package leavesc.hello.gradlesamples;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuilder sb = new StringBuilder();
        sb.append("ApplicationId: ");
        sb.append(getApplicationInfo().packageName);
        sb.append("\n");
        sb.append("ApplicationName: ");
        sb.append(getString(getApplicationInfo().labelRes));
        sb.append("\n");
        sb.append("ChannelId: ");
        sb.append(BuildConfig.channelId);
        sb.append("\n");
        sb.append("BuildTime: ");
        sb.append(BuildConfig.build_time);
        sb.append("\n");
        sb.append("BuildUser: ");
        sb.append(getString(R.string.build_host));
        sb.append("\n");
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String appKey = appInfo.metaData.getString("APP_KEY");
            sb.append("AppKey: ");
            sb.append(appKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        TextView tv_appInfo = findViewById(R.id.tv_appInfo);
        tv_appInfo.setText(sb);
        ImageView iv_log = findViewById(R.id.iv_log);
        iv_log.setImageResource(getApplicationInfo().icon);
    }
}
