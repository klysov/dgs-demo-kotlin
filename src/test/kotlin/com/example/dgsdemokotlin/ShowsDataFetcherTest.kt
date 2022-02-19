package com.example.dgsdemokotlin

import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DgsAutoConfiguration::class, ShowsDataFetcher::class])
class ShowsDataFetcherTest {
    @Autowired
    lateinit var queryExecutor: DgsQueryExecutor

    @Test
    fun shows() {
        val shows = queryExecutor.executeAndExtractJsonPath<List<String>>("query{\n" +
                "  shows(titleFilter: \"Oz\") {\n" +
                "    title\n" +
                "  }\n" +
                "}","data.shows[*].title")
        org.assertj.core.api.Assertions.assertThat(shows).containsOnlyOnce("Ozark")
    }
}