package com.wordpress.laaptu.dependencyinjection.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by laaptu on 6/7/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface HotelAScope {
}
