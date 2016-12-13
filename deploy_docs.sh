#!/bin/bash

set -o errexit -o nounset

if [ "$TRAVIS_BRANCH" != "master" ]
then
  echo "This commit was made against the $TRAVIS_BRANCH and not the master! No deploy!"
  exit 0
fi

rev=$(git rev-parse --short HEAD)

mkdir docs
cd docs

git init
git config user.name "Christian Günther"
git config user.email "chr.gue@gmail.com"

git remote add upstream "https://$GITHUB_TOKEN@github.com/chrgue/try-nashorn.git"
git fetch upstream
git reset upstream/gh-pages

echo "bar" > CNAME

git add -A .
git commit -m "rebuild pages at ${rev}"
git push -q upstream HEAD:gh-pages