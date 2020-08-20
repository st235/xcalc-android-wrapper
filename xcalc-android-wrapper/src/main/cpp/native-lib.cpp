#include <jni.h>
#include <string>

#include "libs/xcalc/include/xcalc.h"
#include "utils/jstring_utils.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_st235_com_github_xcalc_1android_1wrapper_XCalcInternal_evaluate(JNIEnv *env, jclass clazz,
                                                                     jstring jinput) {
    std::string input = ConvertJStringToString(env, jinput);
    std::string output = xcalc::evaluate(input);
    return env->NewStringUTF(output.c_str());
}
