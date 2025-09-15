# Test
Testing the features of Github
This is my first github repo

These are all the git commands I have used
Git commands to run from terminal of android studio
==========================================================

To clear your android studio terminal (optional)
cls

-Initialize git
git init

To add all files in a folder to your git repo
git add .



To commit all your files to local git repo
git commit -am "First commit"

To remotely connect to our cloud git repo
git remote add origin https://github.com/paarthcodes/Test.git

https://github.com/Mercs-MSA/2025-FTC-20195.git

To confirm if our link to remote repo was successful
git remote -v

To push our code from local to remote repo (create a new branch called master)
git push origin master

Check which branch are you in
git branch

=============================
<==For branches==>
Rename master branch to main
git branch -m master main

Create a new branch and switch the new branch you created
git checkout -b newbranchname

If pushing to a branch instead of main use this command
git push -u origin newbranchname

Switch between branches
git checkout branchname

=============================

Before you start local coding, get the latest from remote git repo
git pull origin main

What changed
git status


After you have made your changes and you want to commit, use these commands
git add .
git commit -m "What did I change in my commit"
git push origin main

