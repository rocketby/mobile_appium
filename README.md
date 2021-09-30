Hi!
The project contains automated tests of Wikipedia app on Android devices! :vibration_mode:

:woman_technologist: Use the following commands to execute tests in different hosts:

1. on **local physical mobile device**:
```bash
gradle clean test
```
2. on **mobile device emulator**:
```bash
gradle clean test -DdeviceHost=emulator
```
3. in **BrowserStack**:
```bash
gradle clean test -DdeviceHost=browserstack
```
4. in **Selenoid**:
```bash
gradle clean test -DdeviceHost=selenoid
```
