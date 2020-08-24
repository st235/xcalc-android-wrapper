# XCalc Android Wrapper

[ ![Download](https://api.bintray.com/packages/st235/maven/XCalcAndroid/images/download.svg) ](https://bintray.com/st235/maven/XCalcAndroid/_latestVersion)

Android wrapper written in Kotlin for [xcalc](https://github.com/st235/xcalc-core) arithmetic expressions processor

## Download

- Maven

```text
<dependency>
  <groupId>com.github.st235</groupId>
  <artifactId>xcalc-android-wrapper</artifactId>
  <version>X.X</version>
  <type>pom</type>
</dependency>
```

- Gradle

```text
implementation 'com.github.st235:xcalc-android-wrapper:X.X'
```

- Ivy

```text
<dependency org='com.github.st235' name='xcalc-android-wrapper' rev='X.X'>
  <artifact name='xcalc-android-wrapper' ext='pom' ></artifact>
</dependency>
```

P.S.: Check out latest version code in badge at the top of this page.

## Usage

```kotlin
        val calc = XCalc(angleUnits = AngleUnits.DEG)
        val result = calc.evaluate("expression goes here")
        
        if (result.calculationStatus == CalculationStatus.OK) {
            Log.d("XCalc", result.output)
        } else {
            Log.e("XCalc", result.calculationStatus.name)
        }
```

## Screen

<img src="https://raw.githubusercontent.com/st235/xcalc-android-wrapper/master/images/sample.jpeg" width="270" height="480">

### License

```text
MIT License

Copyright (c) 2020 Alexander Dadukin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
