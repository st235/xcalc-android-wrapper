#ifndef XCALC_ANDROID_JSTRING_UTILS_H
#define XCALC_ANDROID_JSTRING_UTILS_H

#include <jni.h>
#include <string>


std::string ConvertJStringToString(JNIEnv *env, jstring jStr);

#endif //XCALC_ANDROID_JSTRING_UTILS_H
