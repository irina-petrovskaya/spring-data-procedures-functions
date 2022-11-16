package com.mytests.spring.springDataProceduresAndFunctions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *
 * <p>Created by irina on 11/14/2022.</p>
 * <p>Project: spring-data-procedures-functions</p>
 * *
 */
public interface PersonRepository extends CrudRepository<PersonEntity,Integer> {

    @Query("select concat_fields(p.firstName, p.lastName, :delimiter) from PersonEntity p")
    List<String> useFunctionInSelectClauseNamedParam(@Param("delimiter") String str);

    @Query("select concat_fields(p.firstName, p.lastName, ?1) from PersonEntity p")
    List<String> useFunctionInSelectClauseIndexedParam(String str);

    @Query("select p from PersonEntity p where p.address like '%'||concat_fields(:country,:city,:delimiter)||'%'")
    List<PersonEntity> useFunctionInWhereClause(@Param("country") String s1, @Param("city") String s2, @Param("delimiter") String s3);

    @Query("select p from PersonEntity p where p.address != function('concat_fields',:country, :city,:delimiter)")
    List<PersonEntity> useFunctionDiffSyntax(@Param("country") String s1, @Param("city") String s2, @Param("delimiter") String s3);
}
