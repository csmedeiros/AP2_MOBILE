import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class ChatGPTIntegration {

    private val client = OkHttpClient()

    fun sendMessage(message: String, apiKey: String): String? {
        val url = "https://api.openai.com/v1/engines/davinci-codex/completions"
        val requestBody = JSONObject().apply {
            put("prompt", message)
            put("max_tokens", 50) // Defina o número máximo de tokens para a resposta aqui
        }.toString().toRequestBody("application/json".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $apiKey")
            .post(requestBody)
            .build()

        try {
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()
            if (response.isSuccessful && !responseBody.isNullOrBlank()) {
                val jsonResponse = JSONObject(responseBody)
                val completions = jsonResponse.getJSONArray("choices")
                if (completions.length() > 0) {
                    val completion = completions.getJSONObject(0).getString("text")
                    return completion
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}
