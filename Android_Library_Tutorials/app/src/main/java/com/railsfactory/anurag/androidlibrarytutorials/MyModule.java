package com.railsfactory.anurag.androidlibrarytutorials;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class MyModule {

  @Provides
  @Singleton
  Motor provideMotor() {
    return new Motor();
  }

  @Provides
  @Singleton
  Vehicle provideVehicle() {
    return new Vehicle(new Motor());
  }
}