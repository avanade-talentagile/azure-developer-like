package com.example.form;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @EnableCosmosRepositories(basePackages = "com.example.form.repository")
public class AzureCosmosDbConfiguration /*extends AbstractCosmosConfiguration */{


    // @Value("${spring.cloud.azure.cosmos.endpoint}")
    // private String uri;

    // @Value("${spring.cloud.azure.cosmos.key}")
    // private String key;

    // @Value("${spring.cloud.azure.cosmos.database}")
    // private String dbName;

    // private CosmosKeyCredential cosmosKeyCredential;

    // @Bean
    // public CosmosDBConfig getConfig() {
    //     this.cosmosKeyCredential = new CosmosKeyCredential(key);
    //     CosmosDBConfig cosmosdbConfig = CosmosDBConfig.builder(uri, this.cosmosKeyCredential, dbName)
    //         .build();
    //     return cosmosdbConfig;
    // }
}
