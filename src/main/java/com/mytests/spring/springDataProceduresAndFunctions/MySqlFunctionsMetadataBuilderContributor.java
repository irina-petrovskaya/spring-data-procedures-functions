package com.mytests.spring.springDataProceduresAndFunctions;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MySqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {

  @Override
  public void contribute(MetadataBuilder metadataBuilder) {
    metadataBuilder.applySqlFunction(
        "concat_fields",
        new StandardSQLFunction(
            "concat_fields",
            StandardBasicTypes.STRING)
    );
  }
}