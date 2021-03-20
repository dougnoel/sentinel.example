#WIN-INSTALL.md 1.0.3
**NOTE:** These instructions are provided AS IS. You may log tickets to improve the efficacy of the instructions, but there is no support for the instructions. They are being provided to help users who are not developers install development tools. If you are having difficulty installing any of these tools, please refer to the makers of these tools:
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
8. Set the JAVA\_HOME variable. [Click here for instructions.](https://www.codejava.net/java-core/how-to-set-java-home-environment-variable-on-windows-10)
9. Download Maven
10. Extract Maven to C:\Program Files\Maven
11. Set the MAVEN\_HOME variable.
12. Add %JAVA\_HOME%\bin;%MAVEN\_HOME%\bin to the PATH variable.
13. Install [Eclipse SE](https://www.eclipse.org/).
14. Open Eclipse and tell it to use a version later than 1.8 by default. [Instructions Here.](https://www.eclipse.org/eclipse/news/4.10/jdt.php#:~:text=Java%E2%84%A2%2011%20Support,-Eclipse%20support%20for&text=A%20Java%2011%20JRE%20is,using%20the%20project's%20context%20menu.) If you already imported the project, you will need to update the project settings by following [these instructions](https://www.baeldung.com/eclipse-change-java-version) as well.
14. Open **File Explorer** and create a new folder called **Projects** in your home directory.
15. Right-click the **Projects** folder and select **Open Git Bash here**. Click on the window that opens.
16. Type `git clone https://github.com/dougnoel/sentinel.example.git` and hit ENTER.
17. Type `cd sentinel.example` and hit ENTER.
18. Type `cp conf/sentinel.windows.example.yml conf/sentinel.yml` and hit ENTER.
19. Type `mvn test` and hit ENTER.

If Internet Explorer pops up and the tests run successfully, you are ready to move to Section 1.3.