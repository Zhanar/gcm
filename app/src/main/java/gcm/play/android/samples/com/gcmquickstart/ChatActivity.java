package gcm.play.android.samples.com.gcmquickstart;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ChatActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        lv = (ListView)findViewById(R.id.messages);
        adapter = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);

        EditText edit = (EditText)findViewById(R.id.message);
        final String msg = edit.getText().toString();
        Button btn = (Button)findViewById(R.id.send);
        Log.v("before press ", msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("check msg empty", msg);
            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v("check msg empty", msg);
//                if (!msg.isEmpty()) {
//                    Log.v("check msg not empty", msg);
//                    try {
//                        //String msgBody = "{\\r\\n  \\\"to\\\": \\\"\\/topics\\/darkhan.kbtu.kz.chatapp\\\",\\r\\n  \\\"notification\\\" : {\\r\\n      \\\"body\\\" : \\\"" + msg + "\\\",\\r\\n      \\\"title\\\" : \\\"InApp Message\\\",\\r\\n      \\\"icon\\\" : \\\"myicon\\\"\\r\\n    }\\r\\n}";
//                        JSONObject data = new JSONObject();
//                        JSONObject notify = new JSONObject();
//                        data.put("to", "/topics/global");
//                        notify.put("body", msg);
//                        notify.put("title", "App Message");
//                        data.put("notification", notify);
//                        // Create connection to send GCM Message request.
//                        URL url = new URL("https://fcm.googleapis.com/fcm/send");
//                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                        conn.setRequestProperty("Authorization", "key=AIzaSyAY5Cb69TFe14Wy23evafPf7o6l7U9FGjw");
//                        conn.setRequestProperty("Content-Type", "application/json");
//                        conn.setRequestMethod("POST");
//                        conn.setDoOutput(true);
//                        // Send GCM message content.
//                        OutputStream outputStream = conn.getOutputStream();
//                        outputStream.write(data.toString().getBytes());
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                        while (reader.ready()) {
//                            System.out.println(reader.readLine());
//                        }
//                        reader.close();
//                        outputStream.close();
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    } catch (ProtocolException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });




    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String msg = intent.getStringExtra("msg");
        Log.v("recieve", msg);

        adapter.add(msg);
        adapter.notifyDataSetChanged();
        //adapter.add(new Message(msg[0], msg[1]));
    }
}
