import kotlinx.serialization.Serializable

@Serializable
data class IconsItem(//@SerializedName("width")
    val width: Int? = 0,
    //@SerializedName("url")
    val url: String? = "",
    //@SerializedName("height")
    val height: Int? = 0)

@Serializable
data class Categories(//@SerializedName("next")
    val next: String? = "",
    //@SerializedName("total")
    val total: Int? = 0,
    //@SerializedName("offset")
    val offset: Int? = 0,
    //@SerializedName("previous")
    val previous: String? = null,
    //@SerializedName("limit")
    val limit: Int? = 0,
    //@SerializedName("href")
    val href: String? = "",
    //@SerializedName("items")
    val items: List<CategoryItem>?)

@Serializable
data class CategoryItem(//@SerializedName("name")
    val name: String? = "",
    //@SerializedName("href")
    val href: String? = "",
    //@SerializedName("id")
    val id: String? = "",
    //@SerializedName("icons")
    val icons: List<IconsItem>?)

@Serializable
data class CategoriesResponse(//@SerializedName("categories")
    val categories: Categories?)