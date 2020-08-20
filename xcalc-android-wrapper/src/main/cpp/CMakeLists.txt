cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
             native-lib
             # Sets the library as a shared library.
             SHARED
             # Provides a relative path to your source file(s).
             native-lib.cpp
             utils/jstring_utils.h
             utils/jstring_utils.cpp)

find_library( # Sets the name of the path variable.
              log-lib
              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( # Specifies the target library.
                       native-lib
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )

#xcalc
add_library(xcalc SHARED IMPORTED)
set_target_properties(xcalc PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/xcalc/${CMAKE_ANDROID_ARCH_ABI}/libxcalc_core.so)
target_link_libraries(native-lib xcalc)
include_directories(native-lib ${CMAKE_SOURCE_DIR}/libs/xcalc/include)
