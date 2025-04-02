data class Interview(
    val id: Int,
    val title: String,
    val description: String,
    val type: InterviewType
)

enum class InterviewType {
    TECHNICAL,
    SALES,
    PRODUCT_MANAGER,
    SOFTWARE_ENGINEER,
    PRODUCT_DESIGNER
}