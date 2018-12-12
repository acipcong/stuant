package management.stuant.com.stuant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import management.stuant.com.stuant.views.fragments.HomeFragment;
import management.stuant.com.stuant.views.fragments.MessagesFragment;
import management.stuant.com.stuant.views.fragments.StudentRegistration;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        loadFragment(HomeFragment.newInstance());

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.home:
                                loadFragment(HomeFragment.newInstance());
                                break;
                            case R.id.studentRegistration:
                                loadFragment(StudentRegistration.newInstance());
                                break;
                            case R.id.billing:
                                Toast.makeText(HomeActivity.this, "History", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.programRegistration:
                                loadFragment(StudentRegistration.newInstance());
                                break;
                            case R.id.studentDetails:
                                Toast.makeText(HomeActivity.this, "Will update soon", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.timeTable:
//                                loadFragment(ContactUsFragment.newInstance());
                                break;
                            case R.id.announcements:
                                loadFragment(MessagesFragment.newInstance());
                                break;
                            default:
                                return true;
                        }
                        item.setChecked(true);
                        setTitle(item.getTitle());
                        mDrawer.closeDrawers();
                        return true;
                    }
                }
        );
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    @Override
    public void onClick(View view) {

    }
}
