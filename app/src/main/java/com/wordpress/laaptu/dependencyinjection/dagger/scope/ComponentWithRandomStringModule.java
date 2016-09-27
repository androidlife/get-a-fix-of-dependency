package com.wordpress.laaptu.dependencyinjection.dagger.scope;

import dagger.Component;

/**
 */
@FirstScope
@Component(modules = {ModuleProvidingRandomString.class})
public interface ComponentWithRandomStringModule {
}
