package romantsisyk.github.io.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import romantsisyk.github.io.model.CountryModel;

public class ListViewModel extends ViewModel {

    public MutableLiveData<List<CountryModel>> countries = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> countryLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
    
    
    public void refresh(){
        fetchCountries();
    }

    private void fetchCountries() {
        CountryModel country1 = new CountryModel("country1", "capital1", "");
        CountryModel country2 = new CountryModel("country2", "capital2", "");
        CountryModel country3 = new CountryModel("country3", "capital3", "");
        CountryModel country4 = new CountryModel("country4", "capital4", "");

        List<CountryModel> list = new ArrayList<>();
        list.add(country1);
        list.add(country2);
        list.add(country3);
        list.add(country4);

        countries.setValue(list);
        countryLoadError.setValue(false);
        loading.setValue(false);
    }
}
