#include <jni.h>
#include <string>

#include "libs/xcalc/include/xcalc.h"
#include "utils/jstring_utils.h"

namespace  {

constexpr int RADS_VALUE = 0;
constexpr int DEG_VALUE = 1;

xcalc::DegreeMode IntToDegreeMode(int mode) {
    switch(mode) {
        case RADS_VALUE:
            return xcalc::DegreeMode::RADS;
        case DEG_VALUE:
            return xcalc::DegreeMode::DEG;
        default:
            return xcalc::DegreeMode::DEG;
    }
}

} // anonymous namespace

extern "C"
JNIEXPORT jstring JNICALL
Java_st235_com_github_xcalc_1android_1wrapper_XCalcInternal_evaluate(JNIEnv *env, jclass clazz, jint junits, jstring jinput) {
    std::string input = ConvertJStringToString(env, jinput);
    xcalc::DegreeMode mode = IntToDegreeMode(static_cast<int>(junits));
    std::string output = xcalc::evaluate(mode, input);
    return env->NewStringUTF(output.c_str());
}
