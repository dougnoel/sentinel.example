#WIN-INSTALL.md 1.0.3
**NOTE:** These instructions are provided AS IS. You may log tickets to improve the efficacy of the instructions or script, but there is no support for the instructions. They are being provided to help users who are not developers install development tools. If you are having difficulty installing any of these tools, please refer to the makers of these tools:
- [Git](https://git-scm.com/)
- [Chrome](https://www.google.com/chrome/)
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](http://maven.apache.org/)
- [Eclipse](https://www.eclipse.org/)

The steps below will take you through manual installation of all the tools you need to use Sentinel on Windows 10: Git, Chrome, Java, Maven and Eclipse. It assumes that no development tools have been installed on your machine. If some of these have been installed, you can skip the steps you do not need.

1. Ensure you are admin on your machine.
2. Go to the [Git Download Page](https://git-scm.com/downloads) and download the Git installer for windows.
3. Run the Git installer. Accept all the default options.
4. Go to the [Google Chrome](https://www.google.com/chrome/) web page and click the Download button.
5. Run ChromeSetup.exe installer. Accept all the default options.
6. Download the JDK
7. Install the JDK
8. Set the JAVA\_HOME variable.
9. Download Maven
10. Extract Maven to C:\Program Files\Maven
11. Set the MAVEN\_HOME variable.
12. Add %JAVA\_HOME%\bin;%MAVEN\_HOME%\bin to the PATH variable.
13. Install Eclipse.