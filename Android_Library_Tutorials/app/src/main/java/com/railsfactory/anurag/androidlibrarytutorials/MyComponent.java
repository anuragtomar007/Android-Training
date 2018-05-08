package com.railsfactory.anurag.androidlibrarytutorials;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MyModule.class})
interface MyComponent {
  Vehicle provideVehicle();

  void inject(MainActivity main);
}