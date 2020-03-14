package org.techtown.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.techtown.project.Login.LoginActivity;
import org.techtown.project.Login.Person;
import org.techtown.project.Login.SubActivity;
import org.techtown.project.PagerSlidingTabStrip.ViewPagerActivity;
import org.techtown.project.RecyclerViewActivity.RecyclerViewActivity;
import org.techtown.project.fragment.FragmentActivity;

public class MainActivity extends AppCompatActivity {

    Button intent_btn;
    Button login_btn;
    EditText emailText;
    EditText passText;
    Button fragment_btn;
    TextView tvData;
    Button request_btn;
    Button viewPager_btn;
    Button recyclerview_btn;
    Button foldingcell_btn;

    private static final String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = (Button)findViewById(R.id.login_btn);
        fragment_btn = (Button)findViewById(R.id.fragment);
        emailText = (EditText)findViewById(R.id.emailText1);
        passText = (EditText)findViewById(R.id.passText1);
        tvData = (TextView)findViewById(R.id.tvData);
        request_btn = (Button)findViewById(R.id.request_btn);
        viewPager_btn = (Button)findViewById(R.id.viewpager_btn);
        recyclerview_btn = (Button)findViewById(R.id.recyclerview_btn);
        foldingcell_btn = (Button)findViewById(R.id.foldingcell_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Person person = new Person(emailText.getText().toString(),  passText.getText().toString(), "이세현");
                intent.putExtra("사용자", person);
                startActivity(intent);
            }
        });

        intent_btn = findViewById(R.id.intent_btn);
        intent_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);

            }
        });

        viewPager_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        recyclerview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        foldingcell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoldingCellActivity.class);
                startActivity(intent);
            }
        });

       /* request_btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                new JSONTask().execute("http://192.168.25.16:3000/post");//AsyncTask 시작시킴

            }

        });*/

    }
    /*public class JSONTask extends AsyncTask<String, String, String> {

        @Override

        protected String doInBackground(String… urls) {

            try {

                //JSONObject를 만들고 key value 형식으로 값을 저장해준다.

                JSONObject jsonObject = new JSONObject();

                jsonObject.accumulate("user_id", "androidTest");

                jsonObject.accumulate("name", "yun");

                HttpURLConnection con = null;

                BufferedReader reader = null;

                try{

                    //URL url = new URL(“http://192.168.25.16:3000/users“);

                    URL url = new URL(urls[0]);

                    //연결을 함

                    con = (HttpURLConnection) url.openConnection();

                    con.setRequestMethod("POST");//POST방식으로 보냄

                    con.setRequestProperty("Cache-Control", "no-cache");//캐시 설정

                    con.setRequestProperty("Content-Typ", "application/json");//application JSON 형식으로 전송

                    con.setRequestProperty("Accept", "text/html");//서버에 response 데이터를 html로 받음

                    con.setDoOutput(true);//Outstream으로 post 데이터를 넘겨주겠다는 의미

                    con.setDoInput(true);//Inputstream으로 서버로부터 응답을 받겠다는 의미

                    con.connect();

                    //서버로 보내기위해서 스트림 만듬

                    OutputStream outStream = con.getOutputStream();

                    //버퍼를 생성하고 넣음

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));

                    writer.write(jsonObject.toString());

                    writer.flush();

                    writer.close();//버퍼를 받아줌

                    //서버로 부터 데이터를 받음

                    InputStream stream = con.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();

                    String line = "";

                    while((line = reader.readLine()) != null){

                        buffer.append(line);

                    }

                    return buffer.toString();//서버로 부터 받은 값을 리턴해줌 아마 OK!!가 들어올것임

                } catch (MalformedURLException e){

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();

                } finally {

                    if(con != null){

                        con.disconnect();

                    }

                    try {

                        if(reader != null){

                            reader.close();//버퍼를 닫아줌

                        }

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

            return null;

        }

        @Override

        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            tvData.setText(result);//서버로 부터 받은 값을 출력해주는 부

        }

    }*/

}