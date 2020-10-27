import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JSON

const val baseUrl = "https://api.spotify.com/v1/"
const val token = "BQAm0_chWWAhljgmZhloQruyFYdvZ2XssGEbFwHstjJwNGBWSgtQoxK074knsRB5NlpNqHiu7cbWer21bwy1PjEZx5Xja-JOmiqUB0P5VYvDUkOfKn6Zk3z8KAsIvDfPBd606CvYYX5hqajrGaeHRVkLC7UFPPD7EBZWfL5G_B_pK_phRO1qRpWfY8hTYhp9_do"

class SpotifyApi() {
    val client =HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(JSON.nonstrict)
        }
    }

    suspend fun getCategories() : CategoriesResponse{
        return client.get<CategoriesResponse> {
            url("${baseUrl}browse/categories?country=IN&limit=5&offset=0")
            headers {
                append("Accept", "application/json")
//                append("Content-Type", "application/json")
                append("Authorization", "Bearer $token")
            }
            accept(ContentType.Application.Json)
        }
    }

}