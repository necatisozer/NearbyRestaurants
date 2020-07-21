#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_necatisozer_nearbyrestaurants_nativelib_ApiKeysModule_getBaseUrl(
    JNIEnv *env,
    jobject /* this */) {
  std::string base_url = "https://maps.googleapis.com/maps/api/place/";
  return env->NewStringUTF(base_url.c_str());
}
