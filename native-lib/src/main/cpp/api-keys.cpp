#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_necatisozer_nearbyrestaurants_nativelib_ApiKeysProvider_getPlacesApiKey(
        JNIEnv* env,
        jobject /* this */) {
    std::string places_api_key = "AIzaSyBDKR8COabQ96Y42RNgrIfIICsAV1JHbjs";
    return env->NewStringUTF(places_api_key.c_str());
}
