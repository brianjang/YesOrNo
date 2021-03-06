package org.androidtown.brian.yesorno;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static int BASE_CODE = 1000;
    public static final int REQUEST_CODE_LOGOUT = BASE_CODE + 1;

    public static final String KEY_USER_NAME = "username";

    EditText userName_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        inflateLoginLayout_V1();
        inflateLoginLayout_V2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void inflateLoginLayout_V1() {
        RelativeLayout loginLayout = (RelativeLayout)findViewById(R.id.loginLayout);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.login, loginLayout, true);

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        //TODO intent for question
        Button signupBtn = (Button)findViewById(R.id.signupBtn);


    }

//    private void inflateLoginLayout_V2() {
//        RelativeLayout loginLayout = (RelativeLayout)findViewById(R.id.loginLayout);
//        CustomLayoutinflater loginView = new CustomLayoutinflater(this, loginLayout, R.layout.login);
//        View _view = loginView.getCustomView();
//        Button loginBtn = (Button)_view.findViewById(R.id.loginBtn);
//        Button signupBtn = (Button)_view.findViewById(R.id.signupBtn);
////        EditText userName_ET = (EditText)_view.findViewById(R.id.usernameEntry);
//        userName_ET = (EditText)_view.findViewById(R.id.usernameEntry);
//    }

    private void inflateLoginLayout_V2() {
        RelativeLayout loginLayout = (RelativeLayout)findViewById(R.id.loginLayout);
        CustomLayoutinflater loginView = new CustomLayoutinflater(this, loginLayout, R.layout.login);
        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        Button signupBtn = (Button)findViewById(R.id.signupBtn);
//        EditText userName_ET = (EditText)_view.findViewById(R.id.usernameEntry);
        userName_ET = (EditText)findViewById(R.id.usernameEntry);
    }

    public void onLoginBtnClicked(View v) {
        String username = userName_ET.getText().toString();

        Intent intent = new Intent(getApplicationContext(), Question.class);
        UserData data = new UserData(username); //create parcelable instance
        intent.putExtra(KEY_USER_NAME, data);

        startActivityForResult(intent, REQUEST_CODE_LOGOUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_LOGOUT) { //when user logout button
            Toast toast = Toast.makeText(this, "onActivityResult() requestCode : " + requestCode + ", resultCode : " + resultCode, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
