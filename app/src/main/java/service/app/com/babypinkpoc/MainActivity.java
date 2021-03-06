package service.app.com.babypinkpoc;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import service.app.com.babypinkpoc.view.ProductListFragment;

public class MainActivity extends AppCompatActivity implements counterlistner{
    private Toolbar toolbar;
    private TextView mtextViewCounter;



    private RelativeLayout mBadgeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mtextViewCounter =(TextView)findViewById(R.id.counter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Toast.makeText(getApplicationContext(), "MAinactivyt", Toast.LENGTH_SHORT).show();
        android.support.v4.app.FragmentManager manager = ((AppCompatActivity)this).getSupportFragmentManager();

        ProductListFragment productListFragment = new ProductListFragment();
        manager.beginTransaction().replace(R.id.container,productListFragment).commit();

        //getFragmentManager().beginTransaction().add(R.id.container, productListFragment).commit();

    }
    public void showToolbar(){

        if (toolbar != null) {
           getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().show();
        }
    }

    /**
     * get the Default toolbar instance
     *
     * @return default instance of the toolbar (Action bar)
     */
    protected Toolbar getToolBar() {
        return this.toolbar;
    }


    public void hideToolbar(){
        if(toolbar!=null){
            getSupportActionBar().hide();
        }
    }

    @Override
    public void updateCounter(int value) {
        mtextViewCounter.setText(String.valueOf(value));
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu_cart, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
////        switch (id) {
////            case R.id.action_settings:
////                // do stuff, like showing settings fragment
////                return true;
////        }
//
//        return super.onOptionsItemSelected(item); // important line
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu_cart, menu);
//        RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.badge).getActionView();
//        //mCounter = (TextView) badgeLayout.findViewById(R.id.counter);
//        return true;
//    }
//
//      @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu_cart, menu);
//        MenuItem item = menu.findItem(R.id.badge);
//        MenuItemCompat.setActionView(item, R.layout.menu_cart_layout);
//       // mBadgeLayout = (RelativeLayout) menu.findItem(R.id.badge).getActionView();
//       mBadgeLayout = (RelativeLayout)   MenuItemCompat.getActionView(item);
//
//        //mBadgeLayout  = (RelativeLayout) MenuItemCompat.getActionView(item);
//
//        TextView tv = (TextView) mBadgeLayout.findViewById(R.id.counter);
//        tv.setText("12");
//        return true;
//
//    }



//    @Override
//    public boolean onPrepareOptionsMenu(final Menu menu) {
//
//        getMenuInflater().inflate(R.menu.main_menu_cart, menu);
//        mBadgeLayout = (RelativeLayout) menu.findItem(R.id.menu_cart).getActionView();
//       // mBadgeLayout.setClickable(true);
//        //TextView c = (TextView) mBadgeLayout.findViewById(R.id.counter);
//        // Handle visibility of cart counter view.
//        //updateBadgeCount(mItemsInCart);
//
//        return true;
//    }
}