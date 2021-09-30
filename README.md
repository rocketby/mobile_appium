### Hi there! :raised_hand_with_fingers_splayed:	
### The project contains automated tests of Wikipedia app on Android devices! :vibration_mode:

:woman_technologist: Use the following commands to execute the tests in different hosts:

:heavy_check_mark: on **local physical mobile device**:
```bash
gradle clean test
```
:heavy_check_mark: on **mobile device emulator**:
```bash
gradle clean test -DdeviceHost=emulator
```
:heavy_check_mark: in **BrowserStack**:
```bash
gradle clean test -DdeviceHost=browserstack
```
:heavy_check_mark: in **Selenoid**:
```bash
gradle clean test -DdeviceHost=selenoid
```
