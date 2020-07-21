#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_necatisozer_nearbyrestaurants_nativelib_ApiKeysModule_getPlacesApiKey(
    JNIEnv *env,
    jobject /* this */) {
  std::string places_api_key = "YOUR_API_KEY";
  return env->NewStringUTF(places_api_key.c_str());
}
