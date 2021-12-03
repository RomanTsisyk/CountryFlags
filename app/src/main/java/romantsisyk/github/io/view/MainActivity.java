package romantsisyk.github.io.view;

import static io.reactivex.internal.util.NotificationLite.isError;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import romantsisyk.github.io.R;
import romantsisyk.github.io.model.CountryModel;
import romantsisyk.github.io.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.countriesList)
    RecyclerView countriesList;

    @BindView(R.id.list_error)
    TextView listError;

    @BindView(R.id.loading_view)
    ProgressBar loadingView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout refreshLayout;


    private ListViewModel viewModel;
    private CountryListAdapter adapter = new CountryListAdapter(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.refresh();
        countriesList.setLayoutManager(new LinearLayoutManager(this));
        countriesList.setAdapter(adapter);

        observeViewModel();

    }

    private void observeViewModel() {
        viewModel.countries.observe(this, countryModels -> {
            if (countryModels != null) {
                countriesList.setVisibility(View.VISIBLE);
                adapter.updateCountries(countryModels);
            }
        });

        viewModel.countryLoadError.observe(this, isError -> {
           if (isError != null){
               listError.setVisibility( isError ? View.VISIBLE : View.GONE);
           }
        });

        viewModel.loading.observe(this, isLoading -> {
           if (isLoading != null){
               listError.setVisibility( isLoading ? View.VISIBLE : View.GONE);
               if (isLoading) {
                   listError.setVisibility( View.GONE );
                   countriesList.setVisibility( View.GONE );
               }
           }
        });

    }
}