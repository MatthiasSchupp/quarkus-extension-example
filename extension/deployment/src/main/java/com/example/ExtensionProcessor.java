package com.example;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.hibernate.orm.deployment.AdditionalJpaModelBuildItem;

import java.util.Arrays;
import java.util.List;

public class ExtensionProcessor {

    private static final String FEATURE = "example-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    List<AdditionalJpaModelBuildItem> produceModel() {
        return Arrays.asList(
                new AdditionalJpaModelBuildItem(ExampleEntity.class)
        );
    }

    @BuildStep
    AdditionalBeanBuildItem registerBeans() {
        return AdditionalBeanBuildItem.builder()
                .addBeanClass(ExampleService.class)
                .build();
    }
}
