#! /bin/bash
#This script is provided as-is. See MAC-INSTALL.md for more information.
cd ~
xcode-select --install
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
brew install git
brew cask install google-chrome
brew cask install java
brew install maven
brew cask install eclipse-ide
mkdir Projects
cd Projects
git clone https://github.com/dougnoel/sentinel.example.git
cd sentinel.example
cp conf/sentinel.mac.example.yml conf/sentinel.yml
mvn test