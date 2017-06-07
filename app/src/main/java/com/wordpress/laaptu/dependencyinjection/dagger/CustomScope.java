package com.wordpress.laaptu.dependencyinjection.dagger;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by laaptu on 6/7/17.
 */
@Scope
@Retention(RUNTIME)
public @interface CustomScope {
}
