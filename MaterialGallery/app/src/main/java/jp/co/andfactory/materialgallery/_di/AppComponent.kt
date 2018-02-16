package jp.co.andfactory.materialgallery._di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.co.andfactory.materialgallery.MyApplication
import jp.co.andfactory.materialgallery.presentation.gallery.GalleryActivityModule
import jp.co.andfactory.materialgallery.presentation.gallery.PhotoDialogFragmentModule
import jp.co.andfactory.materialgallery.presentation.gallery.photo.PhotoActivityModule
import javax.inject.Singleton

/**
 * Created by watanabe on 2017/12/24.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        InfraModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        GalleryActivityModule::class,
        PhotoDialogFragmentModule::class,
        PhotoActivityModule::class
))
interface AppComponent : AndroidInjector<MyApplication>{

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>() {

        internal abstract fun appModule(appModule: AppModule)
        internal abstract fun infraModule(infraModule: InfraModule)
        internal abstract fun repositoryModule(infraModule: RepositoryModule)
        internal abstract fun useCaseModule(infraModule: UseCaseModule)

        override fun seedInstance(instance: MyApplication) {
            appModule(AppModule(instance))
            infraModule(InfraModule())
            repositoryModule(RepositoryModule())
            useCaseModule(UseCaseModule())
        }
    }
}