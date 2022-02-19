package com.example.dgsdemokotlin

import com.netflix.dgs.codgen.generated.types.Review
import com.netflix.dgs.codgen.generated.types.Show
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import java.util.stream.Collectors

@DgsComponent
class ShowsDataFetcher {

    private val showData = listOf<Show>(
        Show.newBuilder()
            .title("Stranger Things")
            .reviews(
                listOf(Review.newBuilder().starScore(5).build())
            )
            .build(),
        Show.newBuilder()
            .title("Ozark")
            .reviews(
                listOf(Review.newBuilder().starScore(5).build())
            )
            .build()
    )

    @DgsQuery
    fun shows(@InputArgument titleFilter: String): List<Show> {
        return showData.stream()
            .filter { s -> s.title.startsWith(titleFilter) }
            .collect(Collectors.toList())
    }
}
