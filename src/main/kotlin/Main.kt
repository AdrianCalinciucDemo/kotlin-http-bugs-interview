import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val json = fetchUsers()
    println("Fetched JSON:\n$json")

    val names = extractNames(json)
    println("Extracted ${names.size} names")
    for (i in 0..names.size) {
        println("User: ${names[i]}")
    }
}

fun fetchUsers(): String {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://jsonplaceholder.typicode.com/users")
        .build()

    val response = client.newCall(request).execute()
    return response.body!!.string()
}

fun extractNames(json: String): List<String> {
    val results = mutableListOf<String>()
    val users = json.split("{")
    for (user in users) {
        if (user.contains("name")) {
            val parts = user.split(",")
            val namePart = parts[1].split(":")[1]
            results.add(namePart.replace("\"", ""))
        }
    }
    return results
}
