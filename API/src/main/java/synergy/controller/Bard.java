package synergy.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.python.util.PythonInterpreter;

public class Bard {
	
	public static void main(String[] args) throws Exception {
		
//		System.setProperty("python.cachedir.skip", "true");
//		PythonInterpreter interpreter = new PythonInterpreter();
////		interpreter.execfile("bard_api.py");
////		interpreter.exec("search_bard('탄탄한 하체 만드는 필수 운동 5가지')");
//		
//		
//		interpreter = new PythonInterpreter();
//        interpreter.exec("from java.lang import System");
//        interpreter.exec("import sys");
//        interpreter.exec("import os");
//        
//        interpreter.exec("sys.path.append('C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\Lib\\site-packages')");
//        
//        interpreter.exec("import bardapi");
//        
//        interpreter.exec("os.environ['_BARD_API_KEY']=\""");
//        interpreter.exec("input_text = '탄탄한 하체 만드는 필수 하체운동 5가지. 탄탄한 하체를 만들기 위해 꼭 해야하는 하체운동 5가지 제가 즐겨하고 좋아하는 필수 다리 루틴만 뽑아서 구성해봤습니다.'");
//        interpreter.exec("input_tailInfo = '라는 텍스트에서 어떤 운동부위에 관한 설명인지 다음중 하나를 골라 번호만 말해줘, 1번:등, 2번:가슴, 3번:하체, 4번:어깨, 5번:팔'");
//        interpreter.exec("input_text += input_tailInfo");
//        interpreter.exec("response = bardapi.core.Bard().get_answer(input_text)");
//        interpreter.exec("print(response['content'])");
//        
	}
}
            




//package synergy.controller;
//
//import java.util.*;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonPrimitive;
//
//import okhttp3.*;
//
//public class Bard {
//
//    private static final Set<String> ALLOWED_LANGUAGES = new HashSet<>(Arrays.asList("en", "ko", "ja", "english", "korean", "japanese"));
//    private static final String BARD_API_KEY = "..";
//    private static final String BARD_API_LANG = "en";
//
//    private final OkHttpClient httpClient;
//    private final Gson gson;
//    private String conversationId;
//    private String responseId;
//    private String choiceId;
//
//    public Bard() {
//        this.httpClient = new OkHttpClient();
//        this.gson = new Gson();
//        this.conversationId = "";
//        this.responseId = "";
//        this.choiceId = "";
//    }
//
//    private String getSnim0e() throws Exception {
//        String bardToken = BARD_API_KEY;
//        if (bardToken == null || !bardToken.endsWith(".")) {
//            throw new Exception("__Secure-1PSID value must end with a single dot. Enter correct __Secure-1PSID value.");
//        }
//        Request request = new Request.Builder()
//                .url("https://bard.google.com/")
//                .addHeader("Cookie", "__Secure-1PSID=" + bardToken)
//                .build();
//        try (Response response = httpClient.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new Exception("Response code not 200. Response Status is " + response.code());
//            }
//            String responseBody = response.body().string();
//            String snim0e = findValue(responseBody, "SNlM0e\":\"(.*?)\"");
//            if (snim0e == null) {
//                throw new Exception("SNlM0e value not found in response. Check __Secure-1PSID value.");
//            }
//            return snim0e;
//        }
//    }
//
//    private String findValue(String input, String pattern) {
//        java.util.regex.Pattern regexPattern = java.util.regex.Pattern.compile(pattern);
//        java.util.regex.Matcher matcher = regexPattern.matcher(input);
//        if (matcher.find()) {
//            return matcher.group(1);
//        }
//        return null;
//    }
//
//    private String translate(String text, String targetLanguage) {
//        // Implement your translation logic here
//        return text;
//    }
//
//    public JsonObject getAnswer(String inputText) throws Exception {
//        String snim0e = getSnim0e();
//        String language = BARD_API_LANG;
//        if (language != null && !ALLOWED_LANGUAGES.contains(language.toLowerCase())) {
//            inputText = translate(inputText, "en");
//        }
////        JsonArray inputTextArray = new JsonArray();
////        inputTextArray.add(new JsonPrimitive(inputText));
////        JsonArray inputTextStruct = new JsonArray();
////        inputTextStruct.add(inputTextArray);
////        
////        JsonArray inputTextStruct = new JsonArray();
////        inputTextStruct.add(new JsonArray(Collections.singletonList(new JsonPrimitive(inputText))));
////        inputTextStruct.add(null);
////        inputTextStruct.add(Arrays.asList(conversationId, responseId, choiceId));
//        
//        JsonArray inputTextArray = new JsonArray();
//        inputTextArray.add(inputText);
////        inputTextStruct.add("");
////        inputTextStruct.add();
//
//        JsonArray input_null = new JsonArray();
//        input_null.add("");
//        
//        JsonArray input_parameters = new JsonArray();
//        input_parameters.add(conversationId);
//        input_parameters.add(responseId);
//        input_parameters.add(choiceId);
//        
//        JsonArray input_final = new JsonArray();
//        input_final.add(inputTextArray);
//        input_final.add(input_null);
//        input_final.add(input_parameters);
//        
//        
//        
//        JsonObject requestData = new JsonObject();
//        requestData.add("input", null);
//        requestData.add("conversationState", input_final);
////        requestData.add("conversationState", new JsonArray(Collections.singletonList(input_final)));
//        
//        
//        JsonObject request = new JsonObject();
//        request.add("1", null);
//        request.add("2", requestData);
//
//        JsonObject postData = new JsonObject();
//        postData.add("f.req", new JsonPrimitive(request.toString()));
//        postData.add("at", new JsonPrimitive(snim0e));
//
////        String url = "https://bard.google.com/_/BardChatUi/data/assistant.lamda.BardFrontendService/StreamGenerate";
//        String url = "https://bard.google.com/BardChatUi/data/assistant.lamda.BardFrontendService/StreamGenerate";
//
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), gson.toJson(postData));
//
//        Request request_bi = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .addHeader("Host", "bard.google.com")
//                .addHeader("X-Same-Domain", "1")
//                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
//                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
//                .addHeader("Origin", "https://bard.google.com")
//                .addHeader("Referer", "https://bard.google.com/")
//                .build();
//
//        System.out.println(request_bi);
//        try (Response response = httpClient.newCall(request_bi).execute()) {
//            if (!response.isSuccessful()) {
////            	System.out.println(response.body().toString());
////            	System.out.println(response.body().string());
////            	System.out.println(response.body().string());
//                throw new Exception("Response Error: " + response.body().string());
//            }
//            String responseBody = response.body().string();
//            JsonArray responseArray = JsonParser.parseString(responseBody).getAsJsonArray();
//            JsonObject responseJson = responseArray.get(0).getAsJsonObject().get("2").getAsJsonObject();
//
//            JsonObject parsedAnswer = gson.fromJson(responseJson.toString(), JsonObject.class);
//            if (language != null && !ALLOWED_LANGUAGES.contains(language.toLowerCase())) {
//                parsedAnswer.getAsJsonArray("1").get(0).getAsJsonArray().set(0, new JsonPrimitive(translate(parsedAnswer.getAsJsonArray("1").get(0).getAsJsonArray().get(0).getAsString(), language)));
//                JsonArray choicesArray = parsedAnswer.getAsJsonArray("4");
//                JsonArray translatedChoices = new JsonArray();
//                for (int i = 0; i < choicesArray.size(); i++) {
//                    JsonObject choiceObject = choicesArray.get(i).getAsJsonObject();
//                    String choiceContent = choiceObject.getAsJsonArray("1").get(0).getAsString();
//                    choiceObject.getAsJsonArray("1").set(0, new JsonPrimitive(translate(choiceContent, language)));
//                    translatedChoices.add(choiceObject);
//                }
//                parsedAnswer.add("4", translatedChoices);
//            }
//
//            JsonObject bardAnswer = new JsonObject();
//            bardAnswer.add("content", parsedAnswer.getAsJsonArray("1").get(0));
//            bardAnswer.add("conversation_id", parsedAnswer.getAsJsonArray("2").get(0));
//            bardAnswer.add("response_id", parsedAnswer.getAsJsonArray("2").get(1));
//            bardAnswer.add("factualityQueries", parsedAnswer.getAsJsonArray("3"));
//            bardAnswer.add("textQuery", parsedAnswer.getAsJsonArray("2").get(0));
//            JsonArray choicesArray = parsedAnswer.getAsJsonArray("4");
//            JsonArray choices = new JsonArray();
//            for (int i = 0; i < choicesArray.size(); i++) {
//                JsonObject choiceObject = choicesArray.get(i).getAsJsonObject();
//                JsonObject choice = new JsonObject();
//                choice.add("id", choiceObject.get("0"));
//                choice.add("content", choiceObject.get("1"));
//                choices.add(choice);
//            }
//            bardAnswer.add("choices", choices);
//
//            conversationId = bardAnswer.get("conversation_id").getAsString();
//            responseId = bardAnswer.get("response_id").getAsString();
//            choiceId = bardAnswer.getAsJsonArray("choices").get(0).getAsJsonObject().get("id").getAsString();
//
//            return bardAnswer;
//        }
//    }
//
//    public static void main(String[] args) {
//        Bard bard = new Bard();
//        String inputText = "Hello";
//        try {
//            JsonObject response = bard.getAnswer(inputText);
//            JsonArray choices = response.getAsJsonArray("choices");
//            for (int i = 0; i < choices.size(); i++) {
//                JsonObject choice = choices.get(i).getAsJsonObject();
//                System.out.println("Choice " + (i + 1) + ":");
//                System.out.println(choice.get("content").getAsString());
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//
////package synergy.controller;
////
////import java.util.*;
////import java.io.IOException;
////import java.util.regex.Pattern;
////
////import javax.security.auth.message.callback.PrivateKeyCallback.Request;
////import javax.servlet.http.Cookie;
////
////import org.springframework.web.servlet.function.ServerRequest.Headers;
////
////import ch.qos.logback.core.boolex.Matcher;
////import io.swagger.models.Response;
////import io.swagger.v3.oas.annotations.parameters.RequestBody;
////import okhttp3.*;
////import okhttp3.CookieJar;
////import okhttp3.HttpUrl;
////import okhttp3.OkHttpClient;
////import okhttp3.Credentials;
////
////import org.json.JSONArray;
////import org.json.JSONException;
////import org.json.JSONObject;
////import org.json.JSONString;
////
////public class Bard {
////	
////	private String token;
////	private int timeout;
////	private Map<String, String> proxies;
////	private int reqId;
////	private String conversationId;
////	private String responseId;
////	private String choiceId;
////	private OkHttpClient client;
////	private String snim0e;
////
////	public Bard(String token, int timeout, Map<String, String> proxies) {
////	    this.token = token;
////	    this.timeout = timeout;
////	    this.proxies = proxies;
////	    this.reqId = new Random().nextInt(10000);
////	    this.conversationId = "";
////	    this.responseId = "";
////	    this.choiceId = "";
////	    this.client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
////	        @Override
////	        public void saveFromResponse(HttpUrl httpUrl, List<okhttp3.Cookie> list) {
////	        }
////
////	        @Override
////	        public List<okhttp3.Cookie> loadForRequest(HttpUrl httpUrl) {
////	            if (token != null) {
////	                return Collections.singletonList(new okhttp3.Cookie.Builder().name("__Secure-1PSID").value(token).build());
////	            }
////	            return Collections.emptyList();
////	        }
////	    }).build();
////	    this.snim0e = getSNlM0e();
////	}
////	
////	private String getSNlM0e() {
////	    if (this.token == null || !this.token.endsWith(".")) {
////	        throw new IllegalArgumentException("__Secure-1PSID value must end with a single dot. Enter correct __Secure-1PSID value.");
////	    }
////	    
//////	    OkHttpClient.Builder
////	    okhttp3.Request request = new okhttp3.Request.Builder()
////	        .url("https://bard.google.com/")
////	        .headers(okhttp3.Headers.of(HEADERS))
////	        .build();
////
////	    try (okhttp3.Response response = client.newCall(request).execute()) {
////	        if (!response.isSuccessful()) {
////	            throw new IOException("Response code not 200. Response Status is " + response.code());
////	        }
////
////	        String responseBody = response.body().string();
////	        java.util.regex.Matcher matcher = Pattern.compile("SNlM0e\":\"(.*?)\"").matcher(responseBody);
////	        if (!matcher.find()) {
////	            throw new RuntimeException("SNlM0e value not found in response. Check __Secure-1PSID value.");
////	        }
////
////	        return matcher.group(1);
////	    } catch (IOException e) {
////	        throw new RuntimeException("Error occurred while fetching SNlM0e value: " + e.getMessage());
////	    }
////	}
////
////	public JSONObject getAnswer(String inputText) {
////	    try {
////	        String inputTextStruct = "[[\"" + inputText + "\"],null,[\"" + conversationId + "\",\"" + responseId + "\",\"" + choiceId + "\"]]";
////
////	        JSONObject data = new JSONObject()
////	            .put("f.req", new JSONArray().put(JSONObject.NULL).put(inputTextStruct))
////	            .put("at", snim0e);
////
////	        RequestBody requestBody = RequestBody.create(data.toString(), MEDIA_TYPE_JSON);
////
////	        okhttp3.Request request = new okhttp3.Request.Builder()
////	            .url(BARD_URL)
////	            .headers(Headers.of(HEADERS))
////	            .post(requestBody)
////	            .build();
////
////	        try (Response response = client.newCall(request).execute()) {
////	            if (!response.isSuccessful()) {
////	                throw new IOException("Response code not 200. Response Status is " + response.code());
////	            }
////
////	            String responseBody = response.body().string();
////	            JSONArray parsedAnswer = new JSONArray(new JSONArray(responseBody).getJSONArray(0).getString(2));
////
////	            if (parsedAnswer.isEmpty()) {
////	                return new JSONObject().put("content", "Response Error: " + responseBody);
////	            }
////
////	            JSONObject bardAnswer = new JSONObject();
////	            bardAnswer.put("content", parsedAnswer.getJSONArray(0).getString(0));
////	            bardAnswer.put("conversation_id", parsedAnswer.getJSONArray(1).getString(0));
////	            bardAnswer.put("response_id", parsedAnswer.getJSONArray(1).getString(1));
////	            bardAnswer.put("factualityQueries", parsedAnswer.getJSONArray(3));
////	            bardAnswer.put("textQuery", parsedAnswer.getJSONArray(2).optString(0, ""));
////
////	            JSONArray choicesArray = new JSONArray();
////	            JSONArray parsedChoices = parsedAnswer.getJSONArray(4);
////	            for (int i = 0; i < parsedChoices.length(); i++) {
////	                JSONArray choice = parsedChoices.getJSONArray(i);
////	                JSONObject choiceObject = new JSONObject();
////	                choiceObject.put("id", choice.getString(0));
////	                choiceObject.put("content", choice.getString(1));
////	                choicesArray.put(choiceObject);
////	            }
////	            bardAnswer.put("choices", choicesArray);
////
////	            this.conversationId = bardAnswer.getString("conversation_id");
////	            this.responseId = bardAnswer.getString("response_id");
////	            this.choiceId = bardAnswer.getJSONArray("choices").getJSONObject(0).getString("id");
////	            this.reqId += 100000;
////
////	            return bardAnswer;
////	        }
////	    } catch (IOException e) {
////	        throw new RuntimeException("Error occurred while fetching Bard answer: " + e.getMessage());
////	    }
////	}
////	
////	
////}