Hi!
The project contains automated tests of Wikipedia on Android devices.

Use the following commands to execute tests in different hosts:

1. on local physical mobile device:
  gradle clean test

2. on mobile device emulator:
  gradle clean test -DdeviceHost=emulator
  
3. in BrowserStack:
  gradle clean test -DdeviceHost=browserstack

4. in Selenoid:
   gradle clean test -DdeviceHost=selenoid