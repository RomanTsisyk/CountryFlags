package romantsisyk.github.io.di;

import dagger.Component;
import romantsisyk.github.io.model.CountriesService;
import romantsisyk.github.io.viewmodel.ListViewModel;

@Component(modules = {ApiModule.class})

public interface ApiComponent {

    void inject(CountriesService service);

    void inject(ListViewModel listViewModel);

}
