# MAC-INSTALL.md 1.0.3
**NOTE:** These instructions and the accompanying installation script are provided AS IS. You may log tickets to improve the efficacy of the instructions or script, but there is no support for the script. They are being provided to help users who are not developers install development tools. If you are having difficulty installing any of these tools, please refer to the makers of these tools:
- [Xcode](https://developer.apple.com/xcode/)
- [Homebrew](https://brew.sh/)
- [Git](https://git-scm.com/)
- [Chrome](https://www.google.com/chrome/)
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](http://maven.apache.org/)
- [Eclipse](https://www.eclipse.org/)

**It is recommended you install all of these automatically by copying the mac-install.command file in this directory to your computer and double-clicking on it in Finder.** It can also be run in the terminal by typing `./mac-install.command` and hitting ENTER.

The steps below will take you through manual installation of all the tools you need to use Sentinel on a Mac: X-Code Developer Tools, Homebrew, Git, Chrome, Java, Maven and Eclipse. It assumes that no development tools have been installed on your machine. If some of these have been installed, you can skip the steps you do not need.

1. Ensure you are admin on your machine.
2. Open up a terminal window.
3. Type `cd ~` and hit ENTER.
4. Type `xcode-select --install` and hit ENTER. When asked if you want to install the developer tools, say Yes and go through the installation.
5. Paste the following line and hit Enter: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"`
6. Type `brew install git` and hit ENTER.
7. Type `brew cask install google-chrome` and hit ENTER.
8. Type `brew cask install java` and hit ENTER.
9. Type `brew install maven` and hit ENTER.
10. Type `brew cask install eclipse-ide` and hit ENTER.
11. Type `mkdir Projects` and hit ENTER.
12. Type `cd Projects` and hit ENTER.
13. Type `git clone https://github.com/dougnoel/sentinel.example.git` and hit ENTER.
14. Type `cd sentinel` and hit ENTER.
15. Type `cp conf/sentinel.mac.example.yml conf/sentinel.yml` and hit ENTER.
16. Type `mvn test` and hit ENTER.