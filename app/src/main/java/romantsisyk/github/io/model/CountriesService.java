package romantsisyk.github.io.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import romantsisyk.github.io.di.DaggerApiComponent;

public class CountriesService {


    static CountriesService instance;

    @Inject
    public CountriesApi api;

    private CountriesService() {
        DaggerApiComponent.create().inject(this);
    }

    public static  CountriesService getInstance() {
        if (instance == null) instance = new CountriesService();
        return instance;
    }

    public Single<List<CountryModel>> getCountries(){
        return api.getCountries();
    }
}
