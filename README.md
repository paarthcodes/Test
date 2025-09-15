# Test
Testing the features of GitHub
This is my first GitHub repo

These are all the git commands I have used
Git commands to run from the terminal of Android Studio
==========================================================
<==General Commands==>

To clear your Android Studio terminal - 
cls

Initialize git - 
git init

To add all files in a folder to your git repo - 
git add .


To commit all your files to the local git repo - 
git commit -am "The changes that you made"

To remotely connect to our cloud git repo - 
git remote add origin githublink

example - 
git remote add origin https://github.com/Mercs-MSA/2025-FTC-20195.git

To confirm if our link to the remote repo was successful - 
git remote -v

To push our code from local to remote repo (you can either create a new branch or ) - 
git push origin branchname

Check which branch you are in - 
git branch

=======================================
<==For branches==>

Rename oldbranchname to main - 
git branch -m oldbranchname main

Create a new branch and switch to the new branch you created - 
git checkout -b newbranchname

If pushing to a branch instead of main, use this command - 
git push -u origin newbranchname

Switch between branches - 
git checkout branchname

==============================

Before you start local coding, get the latest from the remote git repo - 
git pull origin main

What changed - 
git status


After you have made your changes and you want to commit, use these commands in order - 
git add .
git commit -m "What did I change in my commit"
git push origin main
