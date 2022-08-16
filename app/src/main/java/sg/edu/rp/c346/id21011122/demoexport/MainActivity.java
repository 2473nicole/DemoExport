package sg.edu.rp.c346.id21011122.demoexport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvExport;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvExport = findViewById(R.id.lvExport);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Export> alExport = new ArrayList<Export>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=f5542e9d-58d5-48dc-b8c6-4ba692318b41&limit=10", new JsonHttpResponseHandler() {

            String area;
            String domestic_exports;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("result");
                    JSONArray jsonArrItems = jsonObject.getJSONArray("records");

                    for(int i = 0; i < jsonArrItems.length(); i++) {
                        JSONObject jsonObjExport = jsonArrItems.getJSONObject(i);


                        area = jsonObjExport.getString("area");
                        domestic_exports = jsonObjExport.getString("domestic_exports");
                        year = jsonObjExport.getString("year");

                        Export export = new Export(area, domestic_exports, year);
                        alExport.add(export);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                ArrayAdapter<Export> adapter = new ArrayAdapter<Export>(MainActivity.this, android.R.layout.simple_list_item_1,alExport );
                lvExport.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume
}