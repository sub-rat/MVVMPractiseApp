package np.com.percoid.mvvmsampleapp.di;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import np.com.percoid.mvvmsampleapp.service.repository.GitHubService;
import np.com.percoid.mvvmsampleapp.viewmodel.ProjectViewModelFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Subrat on 12/26/2017.
 */

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    @Singleton @Provides
    GitHubService provideGitHubService(){
        return new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GitHubService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent){
        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }
}
